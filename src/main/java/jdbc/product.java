package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class product {

	public static void main(String[] args) throws SQLException {
		try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system", "root");
		 System.out.println("connected");
		 Statement stmt =con.createStatement();
		 stmt.execute("create table product2(product_id number(3),product_name varchar2(30),price number(15),quantity number(2))");
		 System.out.println("table created");
		 stmt.executeUpdate("insert into product2 values(101,'Mobile',15000,3)");
		 stmt.executeUpdate("insert into product2 values(102,'Laptop',40000,5)");
		 ResultSet rs=stmt.executeQuery("select * from product2");
		 ResultSetMetaData rm=rs.getMetaData();
		 int n=rm.getColumnCount();
		 for(int i=1;i<=n;i++)
		 {
		 System.out.print(rm.getColumnName(i)+"\t");
		 }
		 System.out.println();
		 while(rs.next())
		 {
		 for(int i=1;i<=n;i++)
		 {
		 System.out.print(rs.getString(i)+"\t");
		 }
		 System.out.println();
		 }
	}
catch(Exception e) {
	System.err.println(e);
}}
	
}


