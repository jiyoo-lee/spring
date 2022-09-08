package webpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.apache.commons.dbcp.BasicDataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* 최초 api 데이터를 로드시에는 객체형 프로그램으로 실행합니다. 
 * JSON library를 이용하여 해당 api 배열 데이터를 키값으로 분리되도록 합니다.
 * 출력 확인 후, Controller로 변경함.
 * 단, 변경시 주의사항 : 객체형 main method를 변경해야 함.
 * 그 외에 @Autowired, requsetMapping 등을 이용하여 웹 페이지로 실행 시킨 후 DB입력 값을 확인함*/

//Spring error
// 1. web.xml 경로
// 2. connect(DB연결) 오류사항
// 3. 웹페이지 실행경로
// 4. 문법(어노테이션 체크) SYSOUT으로 문법 라인별 체크, SQL 쿼리 체크

@Controller
public class jsonparser {
	
	@Autowired
	BasicDataSource dataSource;
	
	@RequestMapping("/jsonparser")
	//영화 진흥원 api
	public void parser() {
		
		String jsondata = 
				"[{\"rnum\":\"1\",\"rank\":\"1\",\"rankInten\":\"4\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20215601\",\"movieNm\":\"공조2: 인터내셔날\",\"openDt\":\"2022-09-07\",\"salesAmt\":\"2111720140\",\"salesShare\":\"74.0\",\"salesInten\":\"2082409140\",\"salesChange\":\"7104.5\",\"salesAcc\":\"2214244140\",\"audiCnt\":\"216311\",\"audiInten\":\"213060\",\"audiChange\":\"6553.7\",\"audiAcc\":\"227409\",\"scrnCnt\":\"2167\",\"showCnt\":\"10152\"},\r\n"
				+ "{\"rnum\":\"2\",\"rank\":\"2\",\"rankInten\":\"-1\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20217826\",\"movieNm\":\"육사오(6/45)\",\"openDt\":\"2022-08-24\",\"salesAmt\":\"164228269\",\"salesShare\":\"5.8\",\"salesInten\":\"-275828897\",\"salesChange\":\"-62.7\",\"salesAcc\":\"12382654766\",\"audiCnt\":\"17032\",\"audiInten\":\"-27949\",\"audiChange\":\"-62.1\",\"audiAcc\":\"1233521\",\"scrnCnt\":\"743\",\"showCnt\":\"2000\"},\r\n"
				+ "{\"rnum\":\"3\",\"rank\":\"3\",\"rankInten\":\"0\",\"rankOldAndNew\":\"NEW\",\"movieCd\":\"20212709\",\"movieNm\":\"블랙폰\",\"openDt\":\"2022-09-07\",\"salesAmt\":\"105377437\",\"salesShare\":\"3.7\",\"salesInten\":\"105377437\",\"salesChange\":\"100\",\"salesAcc\":\"257667437\",\"audiCnt\":\"10678\",\"audiInten\":\"10678\",\"audiChange\":\"100\",\"audiAcc\":\"26618\",\"scrnCnt\":\"480\",\"showCnt\":\"1450\"},\r\n"
				+ "{\"rnum\":\"4\",\"rank\":\"4\",\"rankInten\":\"0\",\"rankOldAndNew\":\"NEW\",\"movieCd\":\"20183867\",\"movieNm\":\"알라딘\",\"openDt\":\"2019-05-23\",\"salesAmt\":\"74181000\",\"salesShare\":\"2.6\",\"salesInten\":\"74181000\",\"salesChange\":\"100\",\"salesAcc\":\"108234730039\",\"audiCnt\":\"6512\",\"audiInten\":\"6512\",\"audiChange\":\"100\",\"audiAcc\":\"12730289\",\"scrnCnt\":\"39\",\"showCnt\":\"238\"},\r\n"
				+ "{\"rnum\":\"5\",\"rank\":\"5\",\"rankInten\":\"-3\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20211792\",\"movieNm\":\"헌트\",\"openDt\":\"2022-08-10\",\"salesAmt\":\"55319341\",\"salesShare\":\"1.9\",\"salesInten\":\"-153339477\",\"salesChange\":\"-73.5\",\"salesAcc\":\"42974976697\",\"audiCnt\":\"6404\",\"audiInten\":\"-14536\",\"audiChange\":\"-69.4\",\"audiAcc\":\"4166555\",\"scrnCnt\":\"585\",\"showCnt\":\"1143\"},\r\n"
				+ "{\"rnum\":\"6\",\"rank\":\"6\",\"rankInten\":\"9\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20226879\",\"movieNm\":\"인생은 뷰티풀: 비타돌체\",\"openDt\":\"2022-09-07\",\"salesAmt\":\"181029000\",\"salesShare\":\"6.3\",\"salesInten\":\"158488000\",\"salesChange\":\"703.1\",\"salesAcc\":\"235784000\",\"audiCnt\":\"5231\",\"audiInten\":\"4653\",\"audiChange\":\"805\",\"audiAcc\":\"6635\",\"scrnCnt\":\"102\",\"showCnt\":\"145\"},\r\n"
				+ "{\"rnum\":\"7\",\"rank\":\"7\",\"rankInten\":\"-3\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20194376\",\"movieNm\":\"탑건: 매버릭\",\"openDt\":\"2022-06-22\",\"salesAmt\":\"48117358\",\"salesShare\":\"1.7\",\"salesInten\":\"-36786323\",\"salesChange\":\"-43.3\",\"salesAcc\":\"86627341405\",\"audiCnt\":\"3433\",\"audiInten\":\"-3745\",\"audiChange\":\"-52.2\",\"audiAcc\":\"8082039\",\"scrnCnt\":\"104\",\"showCnt\":\"226\"},\r\n"
				+ "{\"rnum\":\"8\",\"rank\":\"8\",\"rankInten\":\"-5\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20209343\",\"movieNm\":\"한산: 용의 출현\",\"openDt\":\"2022-07-27\",\"salesAmt\":\"18788800\",\"salesShare\":\"0.7\",\"salesInten\":\"-50840150\",\"salesChange\":\"-73\",\"salesAcc\":\"72960007186\",\"audiCnt\":\"2428\",\"audiInten\":\"-5543\",\"audiChange\":\"-69.5\",\"audiAcc\":\"7177401\",\"scrnCnt\":\"265\",\"showCnt\":\"405\"},\r\n"
				+ "{\"rnum\":\"9\",\"rank\":\"9\",\"rankInten\":\"2\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20225892\",\"movieNm\":\"시맨틱 에러: 더 무비\",\"openDt\":\"2022-08-31\",\"salesAmt\":\"20544100\",\"salesShare\":\"0.7\",\"salesInten\":\"10634700\",\"salesChange\":\"107.3\",\"salesAcc\":\"393364400\",\"audiCnt\":\"2017\",\"audiInten\":\"1056\",\"audiChange\":\"109.9\",\"audiAcc\":\"33314\",\"scrnCnt\":\"32\",\"showCnt\":\"32\"},\r\n"
				+ "{\"rnum\":\"10\",\"rank\":\"10\",\"rankInten\":\"-3\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20219345\",\"movieNm\":\"놉\",\"openDt\":\"2022-08-17\",\"salesAmt\":\"8489080\",\"salesShare\":\"0.3\",\"salesInten\":\"-17843310\",\"salesChange\":\"-67.8\",\"salesAcc\":\"4593492276\",\"audiCnt\":\"1255\",\"audiInten\":\"-1222\",\"audiChange\":\"-49.3\",\"audiAcc\":\"404563\",\"scrnCnt\":\"30\",\"showCnt\":\"39\"}]";
		
		try {
			JSONParser parser = new JSONParser();
			Object result = parser.parse(jsondata);
			JSONArray jarray = (JSONArray)parser.parse(jsondata);
			int w = 0;
			while(w < jarray.size()) {
				JSONObject jo = (JSONObject)jarray.get(w);
				Connection con = dataSource.getConnection();
				String sql = "insert into api_movie(movie,rank,rank_part,person) values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, (String)jo.get("movieNm"));
				ps.setString(2, (String)jo.get("rank"));
				ps.setString(3, (String)jo.get("rankOldAndNew"));
				ps.setString(4, (String)jo.get("salesAcc"));
				ps.executeUpdate();
				w++;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
