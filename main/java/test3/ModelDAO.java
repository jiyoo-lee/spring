package test3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelDAO {
	
	
	@Autowired
	BasicDataSource dataSource;
	
	Connection con = null;
	PreparedStatement pr = null;
	
	public List<ModelDTO> selectAll(){
		
		List<ModelDTO> list = new ArrayList<>();
		try {
			con = dataSource.getConnection();
			
			String sql = "select * from test3";
			pr = con.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			
			while(rs.next()) {
	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
