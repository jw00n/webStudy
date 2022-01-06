package Model;

import lombok.AllArgsConstructor;
//생성자를 자동으로 만들어줌.
import lombok.Data;
@Data
@AllArgsConstructor 
// 모든 필드를 매개변수로 갖는 생성자 추가.


public class MemberVO {
	
	private String id;
	private String pw;
	private String nickname;
	
	//altshift s없이? 하는방법
	//외부 라이브러리 사용 lombok
	
	
}
