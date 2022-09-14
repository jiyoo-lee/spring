package webpage;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class movie_api2 {
	
	private String apikey = null;
	private String apidate = null;
	PrintWriter pr = null;
	
	@Inject
	private SqlSessionFactory sqlSessionFactory;
	
	@Resource(name = "moviedao")
	private movieDAO dao;
	
	Connection con = null;
	PreparedStatement ps = null;
	
	@RequestMapping(value="/movie_api",produces = "text/html;charset=utf-8",method=RequestMethod.GET)
	public void apidata(String apikey, String apidate, HttpServletResponse resp){
		
		try {
			resp.setContentType("text/html; charset=utf-8");
			this.apikey = apikey;
			this.apidate = apidate;
			pr = resp.getWriter();
			
			if(!this.apikey.equals(null) || !this.apikey.equals("")) {
				 if(this.apikey.equals("movie_jy") && !this.apidate.equals("")) {
					 String date1 = apidate + " 00:00:00";
					 String date2 = apidate + " 23:59:59";
					 
					 SqlSession session = sqlSessionFactory.openSession();
					 					 
					 List<movieDTO> list =  dao.selectAll(date1,date2);
					 
					 JSONArray ja = new JSONArray();
					 for(movieDTO movie : list) {
						 JSONObject jo = new JSONObject();
						 jo.put("movie", movie.getMovie());
						 jo.put("rank", movie.getRank());
						 jo.put("rank_part", movie.getRank_part());
						 jo.put("person", movie.getPerson());
						 ja.add(jo);
					 }
					 pr.write(ja.toString());
				 }
			}else {
				pr.write("error:31");
			}
		}catch (Exception e) {
			pr.write("error:32");
			e.printStackTrace();
		}
	}
}
