package etc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.net.MalformedURLException;
import java.net.URL;


import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DropMode;
import java.util.Date;
import java.util.Vector;

public class Guitest extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	Vector v;
	Vector cols;
	private JTextField textField_11;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guitest frame = new Guitest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	 public Vector getColumn(){
	        Vector col = new Vector();
	        col.add("일자");
	        col.add("이름");
	        col.add("연락처");
	        col.add("주소");
	        col.add("차량번호");
	        return col;
	    }
	public Guitest() {
		/* 각각의 변수에 새롭게 작성된 DB 정보가 입력됨 */
		String Owner=null;
	    String Address=null;
	    String Phone=null;
	    String ID_num=null;
	    String Car_num=null;
	    String Car_type=null;
	    String license_num=null;
	    String license_date=null;
	    String license_exp_date=null;
	    String Police_record=null;
	    String license_state=null;
	    String Wanted=null;
	    String Img_url=null;
	    String default_Check=null;
	      File inFile = new File("C:/Users/any/Desktop/python","test.txt");
	      FileReader textFileReader;
	      
	      BufferedReader br = null;
	      Date today = new Date();
	      String[] words=null;
	       try {
	           br = new BufferedReader(new FileReader(inFile));
	           String line;
	           while ((line = br.readLine()) != null) {
	               System.out.println(line);
	               line = line.replaceAll(" " ,"");
	               line = line.replaceAll("\\(" ,"");
	               line = line.replaceAll("\\(" ,"");
	               line = line.replaceAll("\\)", "");
	               line = line.replaceAll("\\'", "");
	            
	               words = line.split(",");
	               
	        
	           											}
	          
	           for(String t: words)
	           {
	       
	              System.out.println(t);
	     
	           }
	       } catch (FileNotFoundException e) {
	           e.printStackTrace();
	       } catch (IOException e) {
	           e.printStackTrace();
	       }finally {
	           if(br != null) try {br.close(); } catch (IOException e) {}
	       }
	       
	       int i=0;
	       Owner=words[i++];
	       Address=words[i++];
	       Phone=words[i++];
	       ID_num=words[i++];
	       Car_num=words[i++];
	       Car_type=words[i++];
	       license_num=words[i++];
	       license_date=words[i++];
	       license_exp_date=words[i++];
	       Police_record=words[i++];
	       license_state=words[i++];
	       Wanted=words[i++];
	       Img_url=words[i++];
	       default_Check=words[i++];
	       
	       String[][] data = new String[30][4];
	       try{
	    	   for(int k = 0 ; k < 30 ; k++)
	    	   {
	    	    for(int j = 0 ; j < 4; j++)
	    	    {
	    	     data[k][j]="";
	    	    }
	    	   }
	    	   //rs=stmt.executeQuery("select * from emp");
	    	   int k=0;
	    	   try {
	  	         textFileReader = new FileReader("C:/Users/any/Desktop/python/test.txt");
	  	      }
	  	      catch (FileNotFoundException e) {
	  	          System.out.println("test.txt 파일이 존재하지 않습니다.");
	  	          e.printStackTrace();
	  	      }
	    	   /*
	    	   while(k<30)
	    	   {
	    	    data[i][0]=Car_num;
	    	    data[i][1]=Owner;
	    	    data[i][2]=Address;
	    	    data[i][3]=Phone;
	      	   }
	      	   */
	    	  }
	    	  catch(Exception e)
	    	  {
	    	   System.err.println("보여 주기 에러");
	    	  }
	       for(int m=0;m<4;m++){
	       System.out.println(data[0][m]);
	       }
	    		
		setTitle("CarInfo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("List");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
		
		
		//JPanel panel_1 = new JPanel();
		//panel_1.setBounds(662, 48, 233, 259);
		
		Image image = null;
	    URL url = null;
	    try {
	        url = new URL(Img_url);
	        image = ImageIO.read(url);
	    } catch (MalformedURLException ex) {
	        System.out.println("Malformed URL");
	    } catch (IOException iox) {
	        System.out.println("Can not load file");
	    }
	    JLabel label1 = new JLabel(new ImageIcon(image));
	    contentPane.add(label1);
	    
	    JPanel panel_5 = new JPanel();
	    contentPane.add(panel_5);
	    
	    JLabel label_5 = new JLabel("\uCC28\uC885");
	    panel_5.add(label_5);
	    
	    textField_5 = new JTextField();
	    panel_5.add(textField_5);
	    textField_5.setColumns(10);
	    
	    JLabel label_11 = new JLabel("");
	    contentPane.add(label_11);
	    
	    JPanel panel_6 = new JPanel();
	    contentPane.add(panel_6);
	    
	    JLabel label_13 = new JLabel("\uBA74\uD5C8\uBC88\uD638");
	    panel_6.add(label_13);
	    
	    textField_6 = new JTextField();
	    panel_6.add(textField_6);
	    textField_6.setColumns(10);
	    
	    JLabel label_12 = new JLabel("");
	    contentPane.add(label_12);
	    
	    JPanel panel_7 = new JPanel();
	    contentPane.add(panel_7);
	    
	    JLabel label_6 = new JLabel("\uBA74\uD5C8\uBC1C\uAE09\uC77C");
	    panel_7.add(label_6);
	    
	    textField_7 = new JTextField();
	    panel_7.add(textField_7);
	    textField_7.setColumns(10);
	    
	    JPanel panel_8 = new JPanel();
	    contentPane.add(panel_8);
	    
	    JLabel label_7 = new JLabel("\uBA74\uD5C8\uB9CC\uB8CC\uC77C");
	    panel_8.add(label_7);
	    
	    textField_8 = new JTextField();
	    panel_8.add(textField_8);
	    textField_8.setColumns(10);
	    
	    JPanel panel_9 = new JPanel();
	    contentPane.add(panel_9);
	    
	    JLabel label_8 = new JLabel("\uACFC\uAC70\uC774\uB825");
	    panel_9.add(label_8);
	    
	    textField_9 = new JTextField();
	    panel_9.add(textField_9);
	    textField_9.setColumns(10);
	    
	    JPanel panel_10 = new JPanel();
	    contentPane.add(panel_10);
	    
	    JLabel label_9 = new JLabel("\uBA74\uD5C8\uC0C1\uD0DC");
	    panel_10.add(label_9);
	    
	    textField_10 = new JTextField();
	    panel_10.add(textField_10);
	    textField_10.setColumns(10);
	    
	    JPanel panel_12 = new JPanel();
	    contentPane.add(panel_12);
	    
	    JPanel panel = new JPanel();
	    panel_12.add(panel);
	    
	    JLabel lblNewLabel_4 = new JLabel("\uC774\uB984");
	    panel.add(lblNewLabel_4);
	    
	    textField_2 = new JTextField();
	    panel.add(textField_2);
	    textField_2.setColumns(10);
	    
	    JPanel panel_4 = new JPanel();
	    panel_12.add(panel_4);
	    
	    JLabel label_3 = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
	    panel_4.add(label_3);
	    
	    textField_3 = new JTextField();
	    panel_4.add(textField_3);
	    textField_3.setColumns(10);
	    
	    JPanel panel_2 = new JPanel();
	    panel_12.add(panel_2);
	    
	    JLabel label_1 = new JLabel("\uC8FC\uC18C");
	    panel_2.add(label_1);
	    
	    textField_1 = new JTextField();
	    panel_2.add(textField_1);
	    textField_1.setColumns(10);
	    
	    JPanel panel_3 = new JPanel();
	    panel_12.add(panel_3);
	    
	    JLabel label_2 = new JLabel("\uC5F0\uB77D\uCC98");
	    panel_3.add(label_2);
	    
	    textField = new JTextField();
	    panel_3.add(textField);
	    textField.setColumns(10);
	    
	    JPanel panel_1 = new JPanel();
	    contentPane.add(panel_1);
	    
	    JLabel label_4 = new JLabel("\uCC28\uB7C9\uBC88\uD638");
	    panel_1.add(label_4);
	    
	    textField_4 = new JTextField();
	    panel_1.add(textField_4);
	    textField_4.setColumns(10);
	    
	    JLabel label = new JLabel("Info");
	    label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 17));
	    contentPane.add(label);
	    
	    JPanel panel_11 = new JPanel();
	    contentPane.add(panel_11);
	    
	    JLabel label_10 = new JLabel("\uC218\uBC30\uC0C1\uD0DC");
	    panel_11.add(label_10);
	    
	    textField_11 = new JTextField();
	    panel_11.add(textField_11);
	    textField_11.setColumns(10);
	    //JTextField jtfFilter = new JTextField();
	    //JButton jbtFilter = new JButton("Filter");
	    
	    
		

	}
   
}

