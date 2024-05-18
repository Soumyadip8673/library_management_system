package LibManage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Conn {
	
	Connection c;
	Statement s;
	
	public Conn() {
		try {
			//Class.forName(com.mysql.cj.jdbc.Driver);
			c=DriverManager.getConnection("jdbc:mysql:///lms","root","root");//password : root
			s=c.createStatement();
//			c.close();
;		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
