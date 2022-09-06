package test3;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

// XML + Controller + Model

@Repository("xmljava")
public class XmlJava {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	//사용자 전체 리스트
	public List<uservo> selectAll (){
		
		List<uservo> userList = session.selectList("userDB.selectall");
		return userList;
	}
	
	//사용자에 대한 정보만 출력
	public uservo selectId(String id) {
		
		uservo user = session.selectOne("userDB.selectid"); 
		return user;
	}
}
