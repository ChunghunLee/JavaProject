package etc;
import java.sql.*;
 
public class dbdb {
 
        public static void main(String[] args)
        {
                try
                {
               
                String driverName = "com.mysql.cj.jdbc.Driver"; // ����̹� �̸� ����
                String DBName = "CBNU";
                String dbURL = "jdbc:mysql://13.209.68.158:3306/"+DBName; // URL ����
                String SQL = "select * from User;";
                String sqlCT = "CREATE TABLE STUDENT (" +
                "id varchar(20) NOT NULL, " +
                "name varchar(20) NOT NULL, " +
                "snum int NOT NULL, " +
                "dept varchar(20) NOT NULL, " +
                "PRIMARY KEY(id) " +
                ");";
               
               
                Class.forName(driverName); // ����̹� �ε�
                Connection con  = DriverManager.getConnection(dbURL,"Woo","cbnuroot123"); // ����
                System.out.println("Mysql DB Connection.");
               
                Statement stmt = con.createStatement();
        //      stmt.executeUpdate("CREATE DATABASE noondb");
        //      System.out.println("������ ���̽��� mydb�� �����Ǿ����ϴ�.");
               
        //      stmt.executeUpdate(sqlCT);
                System.out.println("Table Created");
                //data Insert
                /*
                stmt.executeUpdate("insert into STUDENT values('01','Noon',20100909,'Security');");
                stmt.executeUpdate("insert into STUDENT values('02','Bom',20100909,'IT');");
                stmt.executeUpdate("insert into STUDENT values('03','Rye',20100909,'Devel');");
                stmt.executeUpdate("insert into STUDENT values('04','Kim',20100909,'Random');");
                System.out.println("Insert Data");*/
               
                stmt.executeQuery(SQL);
                ResultSet result = stmt.executeQuery(SQL);
                while(result.next())
                {
                        System.out.print(result.getString(1)+"\t");
                        System.out.print(result.getString(2)+"\t");
                        System.out.print(result.getString(3)+"\t");
                        System.out.print(result.getString(4)+"\n");
                }
               
                con.close();
                }
                catch(Exception e)
                {
                        System.out.println("Mysql Server Not Connection.");
                        e.printStackTrace();
                }
        }
       
}