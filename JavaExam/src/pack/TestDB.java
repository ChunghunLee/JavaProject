package pack;

import java.sql.*;
import java.awt.Color;
import java.awt.event.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.*;


 public class TestDB extends JFrame implements ActionListener{
	 
	 	Dimension dim= new Dimension(700,700);
		JFrame frame = new JFrame("BUS 시간표");
		Container cPane;
		ImageIcon icon;
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
	    JPanel panel4 = new JPanel();
	    JPanel panel5 = new JPanel();
	    
	    
	    
	    JScrollPane scrollPane;
	    
		JLabel departure,destination;
		JLabel label = new JLabel(); 
		
		JComboBox<String> dep_cb, avl_cb;
		String start[]={"서울","수원","청주","대전","천안","대구","원주","강릉","전주","광주","부산","목포","인천"};
		String end[]={"서울","수원","청주","대전","천안","대구","원주","강릉","전주","광주","부산","목포","인천"};
		JButton check;
		JButton connect;
		JButton T_check;
        
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:sduDB";
      Connection con;
      Statement stmt ;
      PreparedStatement ps;
      PreparedStatement ps2;
      ResultSet rset;
      ResultSet rset2;
      
      public TestDB(){
    	  cPane = getContentPane();
    	  cPane.setLayout(null);
    	  setTitle("버스 운행 정보");
    	  panel1.setBackground(Color.BLUE);
    	  panel2.setBackground(Color.BLUE);
    	  
    	  panel3.setBackground(Color.GREEN);
    	  panel4.setBackground(Color.GREEN);
    	  panel5.setBackground(Color.GREEN);
    	 /* icon = new ImageIcon("C:\\2mainimg.jpg");
    	  JPanel panel5 = new JPanel(){
  	    	public void paintComponent(Graphics g){
  	    		g.drawImage(icon.getImage(), 0, 0,null);
  	    		setOpaque(false);
  	    		super.paintComponent(g);
  	    	}
  	    };
  	    
  	    scrollPane = new JScrollPane(panel5);
  	    setContentPane(scrollPane); */
    	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  this.setSize(600,600);
    	  this.setVisible(true);
    	  
    	  GridLayout grid = new GridLayout(5,1);
    	  setLayout(grid);
    	  
    	  departure = new JLabel("출발지");
    	  dep_cb = new JComboBox<>(start);

    	  destination = new JLabel("도착지");
    	  avl_cb = new JComboBox<>(end);
    	  
    	  panel1.add(departure);
    	  panel1.add(dep_cb);
    	  panel2.add(destination);
    	  panel2.add(avl_cb);
    	  
    	  check = new JButton("조회");
    	  check.addActionListener(this);
    	  panel3.add(check);
    	  
    	  connect = new JButton("연결");
    	  connect.addActionListener(this);
    	  panel4.add(connect);
    	 
    	  T_check = new JButton("티켓출력");
    	  T_check.addActionListener(this);
    	  panel5.add(T_check);
    	  
    	  this.add(panel1);
    	  this.add(panel2);
    	  this.add(panel3);
    	  this.add(panel4);
    	  this.add(panel5);
    	  
      }
     /* JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(4,2));
      */

public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
	
	//dep_cb.getSelectedItem().toString();
	//dep_cb.getItemAt(dep_cb.getSelectedIndex()).toString();
	if(source==connect)
	{
		try{
			Class.forName(driver);
        con = DriverManager.getConnection(url, "chunghun", "1234");
        System.out.println("접속 완료");
        System.out.println();
       }
		
		catch (Exception e2) {
	         System.out.println("데이터베이스 연결 실패");
	         e2.printStackTrace();
	      }
	}
	
	else if(source==T_check){
		try{
			String sql1= "select * from TICKET";
	     	 ps2 = con.prepareStatement(sql1);
	     	 rset2 = ps2.executeQuery();
		
		while(rset2.next()) {
       	 String T_ID = rset2.getString("T_ID");
       	 String dp = rset2.getString("DEPARTURE");
       	 String dt = rset2.getString("DESTINATION");
       	 String Dtime = rset2.getString("DEPARTURE_TIME");
       	 String Atime = rset2.getString("ARRIVAL_TIME");
       	 String PRICE = rset2.getString("PRICE");
       	 String VAL = rset2.getString("VALID");
       	 String BN = rset2.getString("B_NUM");
       	 String PID = rset2.getString("P_ID");
       	 
       	System.out.println("티켓번호  출발지  도착지  출발시간 도착시간  가격  유효기간  버스번호  승객번호");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("  "+T_ID+"\t  "+dp+"\t  "+dt+"\t  "+Dtime+"\t "+Atime+"\t "+PRICE+"\t     "+VAL+"\t       "+BN+"\t      "+PID);
        System.out.println("--------------------------------------------------------------------------"); 
   	    System.out.println();
		}
		}
		 catch (Exception e4) {
	         System.out.println("출력 실패");
	         e4.printStackTrace();
	      }
	}
	else if(source==check)
	{
      try {
      	String sel_dep = dep_cb.getSelectedItem().toString();
     	String sel_avl = avl_cb.getSelectedItem().toString();
   
          String sql = "select * from BUS WHERE DEPARTURE = '서울' AND DESTINATION ='대구'";
          String sql3 = "select * from BUS WHERE DEPARTURE = '전주'";
          String sql4 = "select * from BUS WHERE DEPARTURE = '대구'";
          String sql5 = "select * from BUS WHERE DEPARTURE = '부산'";
          
         
     	 ps = con.prepareStatement(sql);
         stmt = con.createStatement();
         
         rset = ps.executeQuery();
        
     	System.out.println("출발지는"+sel_dep+"입니다");
        System.out.println("도착지는"+sel_avl+"입니다"); 
        System.out.println();
        
         while(rset.next()) {
        	 String B_num = rset.getString("B_NUM");
        	 String dp = rset.getString("DEPARTURE");
        	 String dt = rset.getString("DESTINATION");
        	 String comp = rset.getString("COMPANY");
        	 String Dtime = rset.getString("DPTIME");
        	 String Atime = rset.getString("APTIME");
        	 String seat = rset.getString("TOTAL_SEATS");
        	 String via = rset.getString("ROUTE");
        	 
        	 System.out.println("버스번호  출발지  도착지  회사  출발시간 도착시간   전체좌석   경유");
             System.out.println("-------------------------------------------------------------------------");
             System.out.println("  "+B_num+"\t  "+dp+"\t  "+dt+"\t  "+comp+"\t "+Dtime+"\t "+Atime+"\t     "+seat+"\t       "+via);
             System.out.println("--------------------------------------------------------------------------"); 
        	 System.out.println();
				
         }

        /* 
      if(rset != null) rset.close();
      if(stmt != null) stmt.close();
      if(con != null) con.close();
      */
      }
      catch (Exception e3) {
         System.out.println("조회 실패");
         e3.printStackTrace();
      }
      }
   }

public static void main(String[] args) {

	new TestDB();
	}
 }
