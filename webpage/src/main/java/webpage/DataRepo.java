package webpage;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

//<![CDATA[>=]]>
@Repository("dataRepo")
public class DataRepo {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate session;

	//현재 시간을 구함
	public dataDTO selectNow() {
		dataDTO data = session.selectOne("sql.select_test");
		
		return data;
	}
	
	//데이터 하나만 SELECT
	public dataDTO selectOne(String mid) {
		
		dataDTO data = session.selectOne("sql.selectOne",mid);
		return data;
	}
}
