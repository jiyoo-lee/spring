package test3;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class select2 {
	
	@Autowired
	BasicDataSource dataSource;
	
	//생략가능 
	public void setDb(BasicDataSource dataSource){
		this.dataSource = dataSource;
	}
	
	@RequestMapping("/select2.do")
	public String selectAll(Model model)throws SQLException {
		//model dao(인지 dto인지를) class를 호출하면서 db정보를 di 해주는 형태
		ModelDTO dto = new ModelDTO(this.dataSource);
		String result = dto.d_select();
		
		model.addAttribute("result",result);
		
		return "view/select2";
	}
}
