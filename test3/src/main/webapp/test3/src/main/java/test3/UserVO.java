package test3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
	private String id;		// 자동증가 값(auto_increment)
	private String mid;		// 아이디
	private String mpw;		// 패스워드
	private String usernm;	// 고객명
	private String mtel; 	// 연락처
	private String mage;	// 나이
}
