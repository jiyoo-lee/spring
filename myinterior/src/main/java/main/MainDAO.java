package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MainDAO {
	
	public List<MainDTO> selectHomeConfig(){
		List<MainDTO> configList = new ArrayList<>();
		
		String sql = "select * from homepage_configuration limit 0, 1";
		
		
		return configList;
	}
}
