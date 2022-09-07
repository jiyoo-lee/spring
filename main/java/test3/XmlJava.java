package test3;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

// XML + Controller + Model

@Repository("XmlJava")	//해당 메서드 모두를 system 메모리에 기억시킴
public class XmlJava {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	//사용자 전체 리스트
	public List<uservo> selectall (){
		
		List<uservo> userList = session.selectList("userDB.selectall");
		return userList;
	}
	
	//사용자에 대한 정보만 출력
	public uservo selectid(String id) {
		
		uservo user = session.selectOne("userDB.selectid",id); 
		return user;
	}
	
	public List<uservo> selectage(int age) {
		
		List<uservo> users = session.selectList("userDB.selectage",age);
		
		return users;
	}
	
	//사용자값 입력 파트
	public String userinsert(String mid, String mname, String mpw, String mtel, String mage) {
				
		uservo vo = new uservo();
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setUsernm(mname);
		vo.setMtel(mtel);
		vo.setMage(mage);
		session.insert("userDB.userinsert",vo);
		
		String result = "ok";
		
		return result;
	}
	
	
	//사용자 수정
	public String updateInfo (String mid, String usernm, String mpw) {
		
		uservo vo = new uservo();
		vo.setMid(mid);
		vo.setUsernm(usernm);
		vo.setMpw(mpw);
		session.update("userDB.updatepw",vo);
		
		String result = "ok";
		return result;
	}
	
	
	//사용자 삭제
	public String deleteInfo(String mid, String usernm, String mpw) {
		uservo vo = new uservo();
		vo.setMid(mid);
		vo.setUsernm(usernm);
		vo.setMpw(mpw);
		session.delete("userDB.delteinfo", vo);
		
		String result = "ok";
		
		return result;
	}
	
	//session.selectOne : 한개의 데이터
	//session.selectList : 여러개의 데이터
	//session.selectMap: key, value
	//session.insert : 입력파트
	//session.update : 수정
	//session.delete : 삭제파트
}
