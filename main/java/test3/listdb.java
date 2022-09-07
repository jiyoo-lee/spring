package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DB접속
public class listdb {
	
	Connection connection;
	PreparedStatement ps = null;
	
	public listdb() throws ClassNotFoundException, SQLException{
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://umj7-009.cafe24.com/jeeyulee";
		String user ="jeeyulee";
		String password = "jeeyu9400";
		
		Class.forName(driver);
		this.connection = DriverManager.getConnection(url,user,password);		
	}
	
	
	
	public String insert(dbservice dbservice) throws SQLException {
		String result ="error";
		String mid = dbservice.mid;
		String mpw = dbservice.mpw;
		String usernm = dbservice.usernm;
		String tel = dbservice.tel;
		String age = dbservice.age;
		
		String sql = "insert into test3(mid,mpw,usernm,mtel,mage) value (?,?,?,?,?)";
		this.ps = connection.prepareStatement(sql);
		this.ps.setString(1, mid);
		this.ps.setString(2, mpw);
		this.ps.setString(3, usernm);
		this.ps.setString(4, tel);
		this.ps.setString(5, age);
		
		int n = this.ps.executeUpdate();
		
		if(n > 0) {
			result = "ok";
		}
		return result;
	}	
	
	public List<dbservice> list () throws SQLException{
		List<dbservice> test = new ArrayList<>();
		String sql = "select * from test3";
		this.ps = this.connection.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		
		while(rs.next()) {
			dbservice db = new dbservice();
			db.setMid(rs.getString("mid"));
			db.setMid(rs.getString("mpw"));
			db.setMid(rs.getString("usernm"));
			db.setMid(rs.getString("tel"));
			db.setMid(rs.getString("age"));
			
			test.add(db);
		}
		return test;
	}
}
