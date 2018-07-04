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
	// * --------------------------------- ���� ���� �� �г� ����
	// ----------------------------* //

	private JButton btn = new JButton(); // ��ư ����
	private JLabel[] label = new JLabel[12]; // 12���� DB���� �޾ƿ��� ����
	private JTextField[] text = new JTextField[12];
	private JTable table;
	private JScrollPane jp = new JScrollPane();
	private JPanel p[] = new JPanel[6]; // 2���� ���� �ؽ�Ʈ�ڽ����� �г�
	static JLabel infL = new JLabel(); // info ��
	static JLabel imgL = new JLabel(); // �̹����� �� ��
	static JLabel imgL2 = new JLabel();
	private JPanel imgp = new JPanel(); // �̹��� ���� �г�
	private JLabel LogL = new JLabel(); // �ΰ� ��
	private JPanel pdb1 = new JPanel(); // DB ����(1)�� �г�
	private JPanel pdb2 = new JPanel(); // DB ����(1)�� �г�

	private JPanel pdb = new JPanel(); // pdb1 pdb2 �� ���� �г�
	Container cp;

	private String[][] data = new String[20][14];
	private String[] col = { "     �̸�     ", "  �ֹι�ȣ   ", "     �ּ�     ", "  ��ȭ��ȣ   ", "  ������ȣ ", "     ����     ",
			"  �����ȣ   ", "  ����߱���  ", " ���㸸���� ", "  �����̷�   ", "  �������   ", "   �������   " };
	private String[] col2 = { "�̸�", "�ֹι�ȣ", "�ּ�", "��ȭ��ȣ" };

	private String[] words = null;
	private String[][] words2 = new String[20][14];
	private String Img_url = null;

	int count = 0;

	// * ------------------------- ��ü Ŭ���� ��ü �ۼ�-------------------------- * //

	public CarInfoGui() {

		// * ---------------- test.txt�� ����� DB 1���� ���ڿ��� �и� -------------------*
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

		pdb1.setLayout(new GridLayout(3, 1)); // �ؽ�Ʈ�ڽ� �г��� 3�� 1��
		pdb2.setLayout(new GridLayout(3, 1));
		pdb.add(pdb1);
		pdb.add(pdb2);
		pdb.setLayout(new GridLayout(1, 2)); // �ؽ�Ʈ�ڽ� ��ü �г� 1�� 2��

		// *----------------��ư,�ΰ� �� ��ܹ� �ٹ̱�--------------------------* //

		URL lgURL = getClass().getResource("cb.png");
		ImageIcon lgicon = new ImageIcon(lgURL);
		LogL = new JLabel("�ڵ��� ��ȣ�� �ν� �ý���ver.1.0", lgicon, JLabel.CENTER);

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
		this.setTitle("���� ������ ��ȸ �ý���");

		// *-----------------------������ �ʱ�ȭ------------------------------------*
		// //

		for (int i = 0; i < 12; i++) {
			label[i] = new JLabel(col[i]);
		}
		for (int i = 0; i < 12; i++) {
			text[i] = new JTextField(15);
		}
		for (int i = 0; i < 6; i++) {
			p[i] = new JPanel(); // ��,�ؽ�Ʈ�� ��� ���� �гι迭 ����
		}

		int j = -1;
		for (int i = 0; i < 12; i++) {

			if (i % 2 == 0) { // �г� 1���� label,text�� 2�� �� ���
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

		// *----------���̺��� �޾ƿ� DB ������ col2 �迭�� ���� ��, ����--------------* //

		table = new JTable(data, col2);
		table.setMinimumSize(new Dimension(1100, 200));
		DefaultTableCellRenderer dterCenter = new DefaultTableCellRenderer();
		dterCenter.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer dterRight = new DefaultTableCellRenderer();
		dterRight.setHorizontalAlignment(JLabel.RIGHT);

		DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
		thr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();

		table.getColumn("�̸�").setPreferredWidth(30);
		table.getColumn("�̸�").setCellRenderer(dterCenter);

		table.getColumn("�ֹι�ȣ").setPreferredWidth(80);
		table.getColumn("�ֹι�ȣ").setCellRenderer(dterCenter);

		table.getColumn("�ּ�").setPreferredWidth(200);
		table.getColumn("�ּ�").setCellRenderer(dterCenter);

		table.getColumn("��ȭ��ȣ").setPreferredWidth(80);
		table.getColumn("��ȭ��ȣ").setCellRenderer(dterCenter);

		// *---------------------Img�г� ��� ���� �� �̹��� �߰�---------------------* //

		TitledBorder tborder;
		tborder = new TitledBorder(new LineBorder(Color.BLACK, 3), "[Info]");
		tborder.setTitlePosition(TitledBorder.CENTER);
		tborder.setTitleJustification(TitledBorder.CENTER);
		imgp.setBorder(tborder);
		imgp.setPreferredSize(new Dimension(1200, 450));
		imgp.add(imgL);
		imgp.add(imgL2);

		jp = new JScrollPane(table); // ���̺��� Scrollȭ
		// jp.setLayout(null);
		jp.setPreferredSize(new Dimension(600, 200));
		jp.setMinimumSize(new Dimension(900, 200));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jp.addMouseListener(new MouseAdapter() {
		});

		// * --------------------------------��ü �гε� ���
		// ----------------------------------------* //

		cp = this.getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 10)); // Flowlayout����
																	// ��->�� ����

		cp.add(imgp); // �̹��� �г� ����
		cp.add(pdb); // �ؽ�Ʈ �ڽ� �г�
		cp.add(jp); // table �߰�
		cp.add(btn); // ��ư �г�
		cp.add(LogL); // �����ΰ� �г�

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0, 0, 500, 500);
		showTable(); // ���̺� ����
		setVisible(true);

	}

	// *--------------------Table�� ȣ���ϱ� ���� �޼ҵ�---------------------------* //

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

	// * -----------------------��ư Ŭ�� �̺�Ʈ �߻� Ŭ����---------------------- * //

	class ActionBtn extends Exception implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn) {
				imgp.removeAll();
				int row = table.getSelectedRow();

				// *------------------�ؽ�Ʈ �ʵ忡 ������ ������ ���----------------------*
				// //

				for (int i = 0; i < 12; i++) {
					text[i].setText(data[row][i]);
				}
				JOptionPane.showMessageDialog(null, "����ڸ� ��ȸ�մϴ�.", "����� ��ȸ", JOptionPane.QUESTION_MESSAGE);

				// * ------------------------������ �� ������ ���� �̹��� �гο�
				// ����-----------------------------------* //

				BufferedImage image; // URL�� �ҷ��������� �����̹��� ����

				try {
					Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
					URL url = new URL(data[row][12]); // ���� �̹����� �ҷ��ɴϴ�.
					image = ImageIO.read(url);

					String dir = "c:/test/recog_img/";
					String temp;
					temp = dir + data[row][4] + ".jpg";

					InputStream in = new BufferedInputStream(new FileInputStream(temp)); // imgPath��
																							// ����
																							// ����
					System.out.println(in);
					Image image2 = ImageIO.read(in);

					// *----------------����ȸ�� �̹��� �� �߰� ��
					// �ߺ�����-------------------* //

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

		// *------------------------��ũ�� �г� �ٹ̱�--------------------------------*
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