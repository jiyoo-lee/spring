package webpage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("moviedao")
public class movieDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;	//movie_api2에서 openSession에 대한 정보값
		
	public List<movieDTO> selectAll(String value1,String value2){
		
		//2개 이상의 파라미터값을 xml에 적용시 map을 이용하여 동일한 #{} 이름으로 키배열을 생성함
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("value1", value1);
		map.put("value2", value2);
		List<movieDTO> list = session.selectList("sql.select_api",map);
		
		return list;
	}
}
