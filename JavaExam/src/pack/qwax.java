import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.util.qwax;

public class qwax {
	public static void main(String[] args) {
		Connection conn=qwax.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		
		String sql;
		
		try {
			sql="SELECT * FROM BUS";
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			rsmd=rs.getMetaData();
			
			int cols=rsmd.getColumnCount();
			System.out.println("컬럼명\t타입\t타입명\t폭");
			for(int i=1; i<=cols; i++) {
				System.out.print(rsmd.getColumnName(i)+"\t");
				System.out.print(rsmd.getColumnType(i)+"\t");
				System.out.print(rsmd.getColumnTypeName(i)+"\t");
				System.out.print(rsmd.getPrecision(i)+"\n");
			}
		}catch (Exception e){
			System.out.println(e.toString());
		}
	}

	private static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}