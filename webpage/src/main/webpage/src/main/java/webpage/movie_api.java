package webpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp.BasicDataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class movie_api {
   private String apikey = null;
   private String apidate = null;
   private String result = null;
   protected String json_parsing = "";
   
   @Autowired
   BasicDataSource dataSource;
   
   @RequestMapping(value="/movie",produces = "text/html;charset=utf-8",method=RequestMethod.GET)
   //method=RequestMethod.GET : Front에서 전송된 데이터를 get으로만 통신하겠다는 뜻
   //GetMapping,PostMapping, PutMapping, DeleteMapping : method 속성을 사용하지 않음.
   public String apiserver(String apikey,String apidate){
      try {
	      this.apikey = apikey;
	      this.apidate = apidate;
      
         if(!this.apikey.equals(null) || !this.apikey.equals("")) {
            if(this.apikey.equals("movie_jy") && !this.apidate.equals("")) {
            	Connection con = dataSource.getConnection();
            	String sdate = this.apidate + " 00:00:00";
            	String edate = this.apidate + " 23:59:59";
            	String sql = "select * from api_movie where indatetime >= '" + sdate + "' and indatetime <= '" + edate +"'";
            	PreparedStatement ps = con.prepareStatement(sql);
            	ResultSet rs = ps.executeQuery();
            	JSONArray ja = new JSONArray();
            	
            	while(rs.next()) {
            		JSONObject jo = new JSONObject();
	            	 jo.put("id",rs.getString("id"));
	            	 jo.put("movie",rs.getString("movie"));
	            	 jo.put("rank",rs.getString("rank"));
	            	 jo.put("rank_part",rs.getString("rank_part"));
	            	 jo.put("person",rs.getString("person"));
	            	 jo.put("indatetime",rs.getString("indatetime"));
	            	 ja.add(jo);
            	}
            	result= ja.toString();
            }
            else {
               
            }
         }
      }
      catch(Exception e) {
         result = "error : {해당 api키가 올바르지 않습니다.}";
         e.printStackTrace();
      }
      return result;
   }
   
}