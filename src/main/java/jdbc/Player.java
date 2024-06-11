package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
public class Player {
	

	public static void main(String[] args) {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system", "root");
			 System.out.println("connected");
			 Statement stmt=con.createStatement();
			 stmt.execute("create table Player1 (Playername varchar2(30),JersyNo number(2)) ");
			 stmt.executeUpdate("insert into Player1 values('ms dhoni',7)");
			 stmt.executeUpdate("insert into Player1 values('virat kolhi',18)");
			 ResultSet rs=stmt.executeQuery("select * from Player1");
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
}
	}

	}