package test3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

//DTO : select
public class ModelDTO {
	
	//xml에 있는 id값을 Model에서 직접적으로 handling 할 수 없음
	@Autowired
	BasicDataSource dataSource; // null로 표기가 됨
	
	Connection conn =null;
	PreparedStatement pr = null;
	
	private String midx;
	private String mid;
	private String mpw;
	private String mnm;
	private String mtel;
	private String mage;
	
	//Controller에서 정보값을 받는 역할
	public ModelDTO(BasicDataSource dataSource) throws SQLException {
		this.dataSource= dataSource;
	}
	
	public String d_select () {	//DB를 연결 시켜 SQL을 실행하는 메서드
		String n = "";
		try {
			conn = this.dataSource.getConnection();
			String sql = "select count(*) count from test3";
			pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
				 n = rs.getString("count");
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pr != null) pr.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
	public String getMidx() {
		return midx;
	}

	public void setMidx(String midx) {
		this.midx = midx;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMnm() {
		return mnm;
	}

	public void setMnm(String mnm) {
		this.mnm = mnm;
	}

	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	public String getMage() {
		return mage;
	}

	public void setMage(String mage) {
		this.mage = mage;
	}
}
