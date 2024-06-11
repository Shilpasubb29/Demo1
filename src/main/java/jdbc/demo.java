package jdbc;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class demo {

	public static void main(String[] args) throws SQLException {
		try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system", "root");
		 System.out.println("connected");
		 Statement stmt =con.createStatement();
		 stmt.execute("create table employee1(id number(2),name varchar2(30),age number(2),department varchar2(15))");
		 System.out.println("table created");
		 stmt.executeUpdate("insert into employee1 values(12,'Max',40,'finance')");
	}
catch(Exception e) {
	System.err.println(e);
}}
	
}




