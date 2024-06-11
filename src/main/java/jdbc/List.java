package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
public class List {

	public static void main(String[] args) throws SQLException {
		try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system", "root");
		 System.out.println("connected");
		 Statement stmt =con.createStatement();
		 System.out.println("table created");
		 
		 ResultSet rs=stmt.executeQuery("select * from List");
		 Map<String, Integer> wordFrequency = new HashMap<>();
		 ResultSetMetaData rm=rs.getMetaData();
		 int n=rm.getColumnCount();
		 for(int i=1;i<=n;i++)
		 {
		 System.out.print(rm.getColumnName(i)+"\t");
		 }
		 System.out.println();
		 while(rs.next())
		 {String name = rs.getString("name");
		  wordFrequency.put(name, wordFrequency.getOrDefault(name, 0) + 1);
		 for(int i=1;i<=n;i++)
		 {
		 System.out.print(rs.getString(i)+"\t");
		 }
		 System.out.println();
		 }
		 System.out.println("Frequency of Employee names");
         System.out.println("------------------------------------");
         System.out.println(wordFrequency);
	}
catch(Exception e) {
	System.err.println(e);
}}
	
}



