package webpage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class movieDTO {
	private String id;	
	private String movie;	//영화제목
	private String rank;	//순위
	private String rank_part;	//신규진입여부
	private String person;	//관객수
	private String indatetime;	//데이터 등록 일자
}
