package delivery.mvc.session;

import java.util.HashMap;
import java.util.Map;




/**
 * 사용자 객체
 * : 로그인(인증)을 하면 인증된 사용자의 정보를 Session 객체로 만들어서 저장한다.
 */
public class Session {
	private String sessionId; //로그인 된 사용자의 아이디
	private Map<String,Object> attributes; //장바구니 (또 다른 사용자의 정보 저장이 필요하다면 map에 추가)
	
	
	public Session() {}
	public Session(String sessionId) {
		this.sessionId = sessionId;
		attributes = new HashMap<>();
	}
	public String getSessionId() {
		return sessionId;
	}
	
	//추가
	public void setAttribute(String name, Object value) {//cart , Map<Goods, Integer>
		attributes.put(name,value);
	}
	
	//조회(Map에 key에 해당하는 value 찾기)
	public Object getAttribute(String name) {//cart
		return attributes.get(name);
	}
	
	//제거(장바구니를 비울대 사용한다)
	public void removeAttribute(String name) {//cart
		attributes.remove(name);
	}
	
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	
	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", attributes=" + attributes + "]"+"\n";
	}
	
	
	@Override
	public int hashCode() {
		return sessionId.hashCode();
	}
	
	/**
	 * 같은 객체라는 뜻은 hashCode가 같아야하고,
	 * equlas의 결과가 true여야한다.
	 * 
	 *  hash코드가 다르면 무조건 다른 객체
	 *  hash코드가 같으면 같은 객체일수도, 다른 객체일수도 있다.
	 * */
	@Override
	public boolean equals(Object obj) {
		Session other = (Session) obj;
		if(sessionId.equals(other.sessionId)) {
			return true;
		}else {
			return false;
		}
		
	}
}
