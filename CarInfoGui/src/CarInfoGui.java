import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import sun.swing.table.DefaultTableCellHeaderRenderer;

public class CarInfoGui extends JFrame {
	// * --------------------------------- 변수 선언 및 패널 선언
	// ----------------------------* //

	private JButton btn = new JButton(); // 버튼 선언
	private JLabel[] label = new JLabel[12]; // 12개의 DB정보 받아오기 위함
	private JTextField[] text = new JTextField[12];
	private JTable table;
	private JScrollPane jp = new JScrollPane();
	private JPanel p[] = new JPanel[6]; // 2개씩 묶은 텍스트박스들의 패널
	static JLabel infL = new JLabel(); // info 라벨
	static JLabel imgL = new JLabel(); // 이미지를 쓸 라벨
	static JLabel imgL2 = new JLabel();
	private JPanel imgp = new JPanel(); // 이미지 담을 패널
	private JLabel LogL = new JLabel(); // 로고 라벨
	private JPanel pdb1 = new JPanel(); // DB 정보(1)들 패널
	private JPanel pdb2 = new JPanel(); // DB 정보(1)들 패널

	private JPanel pdb = new JPanel(); // pdb1 pdb2 다 담을 패널
	Container cp;

	private String[][] data = new String[20][14];
	private String[] col = { "     이름     ", "  주민번호   ", "     주소     ", "  전화번호   ", "  차량번호 ", "     차종     ",
			"  면허번호   ", "  면허발급일  ", " 면허만료일 ", "  과거이력   ", "  면허상태   ", "   수배상태   " };
	private String[] col2 = { "이름", "주민번호", "주소", "전화번호" };

	private String[] words = null;
	private String[][] words2 = new String[20][14];
	private String Img_url = null;

	int count = 0;

	// * ------------------------- 전체 클래스 객체 작성-------------------------- * //

	public CarInfoGui() {

		// * ---------------- test.txt에 저장된 DB 1줄을 문자열로 분리 -------------------*
		// //

		File inFile = new File("C:/test", "DBinfo.txt");

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(inFile));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				line = line.replaceAll(" ", "");
				line = line.replaceAll("\\(", "");
				line = line.replaceAll("\\(", "");
				line = line.replaceAll("\\)", "");
				line = line.replaceAll("\\'", "");

				words = line.split(",");

				for (int i = 0; i < 14; i++)
					words2[count][i] = words[i];
				count++;

				for (String t : words) {
					System.out.println(t);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
		}

		pdb1.setLayout(new GridLayout(3, 1)); // 텍스트박스 패널을 3행 1열
		pdb2.setLayout(new GridLayout(3, 1));
		pdb.add(pdb1);
		pdb.add(pdb2);
		pdb.setLayout(new GridLayout(1, 2)); // 텍스트박스 전체 패널 1행 2열

		// *----------------버튼,로고 및 상단바 꾸미기--------------------------* //

		URL lgURL = getClass().getResource("cb.png");
		ImageIcon lgicon = new ImageIcon(lgURL);
		LogL = new JLabel("자동차 번호판 인식 시스템ver.1.0", lgicon, JLabel.CENTER);

		URL btURL = getClass().getResource("search.png");
		btn = new JButton(new ImageIcon(btURL));
		btn.setLayout(null);
		btn.setBounds(100, 200, 126, 31);

		btn.setBackground(Color.red);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);

		btn.addActionListener(action);
		URL iconURL = CarInfoGui.class.getClassLoader().getResource("Car-icon.png");
		ImageIcon img = new ImageIcon(iconURL);
		this.setIconImage(img.getImage());
		this.setTitle("차량 소유자 조회 시스템");

		// *-----------------------상세정보 초기화------------------------------------*
		// //

		for (int i = 0; i < 12; i++) {
			label[i] = new JLabel(col[i]);
		}
		for (int i = 0; i < 12; i++) {
			text[i] = new JTextField(15);
		}
		for (int i = 0; i < 6; i++) {
			p[i] = new JPanel(); // 라벨,텍스트를 묶어서 담을 패널배열 생성
		}

		int j = -1;
		for (int i = 0; i < 12; i++) {

			if (i % 2 == 0) { // 패널 1개당 label,text가 2개 씩 담김
				j++;
			}
			p[j].add(label[i]);
			p[j].add(text[i]);
		}

		pdb1.add(p[0]);
		pdb1.add(p[1]);
		pdb1.add(p[2]);
		pdb2.add(p[3]);
		pdb2.add(p[4]);
		pdb2.add(p[5]);

		// *----------테이블을 받아온 DB 정보와 col2 배열로 생성 후, 정렬--------------* //

		table = new JTable(data, col2);
		table.setMinimumSize(new Dimension(1100, 200));
		DefaultTableCellRenderer dterCenter = new DefaultTableCellRenderer();
		dterCenter.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer dterRight = new DefaultTableCellRenderer();
		dterRight.setHorizontalAlignment(JLabel.RIGHT);

		DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
		thr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();

		table.getColumn("이름").setPreferredWidth(30);
		table.getColumn("이름").setCellRenderer(dterCenter);

		table.getColumn("주민번호").setPreferredWidth(80);
		table.getColumn("주민번호").setCellRenderer(dterCenter);

		table.getColumn("주소").setPreferredWidth(200);
		table.getColumn("주소").setCellRenderer(dterCenter);

		table.getColumn("전화번호").setPreferredWidth(80);
		table.getColumn("전화번호").setCellRenderer(dterCenter);

		// *---------------------Img패널 경계 설정 및 이미지 추가---------------------* //

		TitledBorder tborder;
		tborder = new TitledBorder(new LineBorder(Color.BLACK, 3), "[Info]");
		tborder.setTitlePosition(TitledBorder.CENTER);
		tborder.setTitleJustification(TitledBorder.CENTER);
		imgp.setBorder(tborder);
		imgp.setPreferredSize(new Dimension(1200, 450));
		imgp.add(imgL);
		imgp.add(imgL2);

		jp = new JScrollPane(table); // 테이블을 Scroll화
		// jp.setLayout(null);
		jp.setPreferredSize(new Dimension(600, 200));
		jp.setMinimumSize(new Dimension(900, 200));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jp.addMouseListener(new MouseAdapter() {
		});

		// * --------------------------------전체 패널들 담기
		// ----------------------------------------* //

		cp = this.getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 10)); // Flowlayout으로
																	// 좌->우 순차

		cp.add(imgp); // 이미지 패널 생성
		cp.add(pdb); // 텍스트 박스 패널
		cp.add(jp); // table 추가
		cp.add(btn); // 버튼 패널
		cp.add(LogL); // 버전로고 패널

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0, 0, 500, 500);
		showTable(); // 테이블 생성
		setVisible(true);

	}

	// *--------------------Table을 호출하기 위한 메소드---------------------------* //

	public void showTable() {
		table.removeAll();
		this.setSize(1300, 800);

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 14; j++) {
				data[i][j] = "";
			}
		}
		for (int i = 0; i < count; i++)
			for (int k = 0; k < 14; k++) {
				data[i][k] = words2[i][k];
			}

		table.repaint();
	}

	ActionBtn action = new ActionBtn();

	// * -----------------------버튼 클릭 이벤트 발생 클래스---------------------- * //

	class ActionBtn extends Exception implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn) {
				imgp.removeAll();
				int row = table.getSelectedRow();

				// *------------------텍스트 필드에 선택한 데이터 출력----------------------*
				// //

				for (int i = 0; i < 12; i++) {
					text[i].setText(data[row][i]);
				}
				JOptionPane.showMessageDialog(null, "사용자를 조회합니다.", "사용자 조회", JOptionPane.QUESTION_MESSAGE);

				// * ------------------------차사진 및 소유주 사진 이미지 패널에
				// 띄우기-----------------------------------* //

				BufferedImage image; // URL을 불러오기위해 버퍼이미지 선언

				try {
					Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
					URL url = new URL(data[row][12]); // 원본 이미지를 불러옵니다.
					image = ImageIO.read(url);

					String dir = "c:/test/recog_img/";
					String temp;
					temp = dir + data[row][4] + ".jpg";

					InputStream in = new BufferedInputStream(new FileInputStream(temp)); // imgPath가
																							// 원래
																							// 변수
					System.out.println(in);
					Image image2 = ImageIO.read(in);

					// *----------------재조회시 이미지 라벨 추가 및
					// 중복방지-------------------* //

					imgL = new JLabel(new ImageIcon(image));
					imgL2 = new JLabel(new ImageIcon(image2));
					imgL.setBorder(BorderFactory.createCompoundBorder(border, new EmptyBorder(0, 0, 0, 0)));
					imgL.setPreferredSize(new Dimension(300, 400));
					imgL2.setPreferredSize(new Dimension(533, 400));

					imgp.add(imgL);
					imgp.add(imgL2);
					table.repaint();
					imgp.repaint();

				} catch (MalformedURLException ex) {
					System.out.println("Malformed URL");
				} catch (IOException iox) {
					System.out.println("Can not load file");
				}

			}

			cp.revalidate();
		}

	}

	public static void main(String[] args) {

		// *------------------------스크롤 패널 꾸미기--------------------------------*
		// //

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
		// ----------------------------------------------------------------------------
		// //
		CarInfoGui db = new CarInfoGui();
	}

}