package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Emp_Info {

	public static void main(String[] args) throws SQLException {
		try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system", "root");
		 Statement stmt =con.createStatement();
		 ResultSet rs=stmt.executeQuery("select * from Emp_Info1");
		 Map<String, Integer> empInfo = new HashMap<>();
while(rs.next()) {
	String s= rs.getString("empFirstname");
empInfo.put(s, s.length());

}
	System.out.println(empInfo);	 
		
		 }
catch(Exception e) {
	System.err.println(e);
}}}
	





		
	

