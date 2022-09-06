package delivery.mvc.session;

import java.util.HashMap;
import java.util.Map;




/**
 * ����� ��ü
 * : �α���(����)�� �ϸ� ������ ������� ������ Session ��ü�� ���� �����Ѵ�.
 */
public class Session {
	private String sessionId; //�α��� �� ������� ���̵�
	private Map<String,Object> attributes; //��ٱ��� (�� �ٸ� ������� ���� ������ �ʿ��ϴٸ� map�� �߰�)
	
	
	public Session() {}
	public Session(String sessionId) {
		this.sessionId = sessionId;
		attributes = new HashMap<>();
	}
	public String getSessionId() {
		return sessionId;
	}
	
	//�߰�
	public void setAttribute(String name, Object value) {//cart , Map<Goods, Integer>
		attributes.put(name,value);
	}
	
	//��ȸ(Map�� key�� �ش��ϴ� value ã��)
	public Object getAttribute(String name) {//cart
		return attributes.get(name);
	}
	
	//����(��ٱ��ϸ� ���� ����Ѵ�)
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
	 * ���� ��ü��� ���� hashCode�� ���ƾ��ϰ�,
	 * equlas�� ����� true�����Ѵ�.
	 * 
	 *  hash�ڵ尡 �ٸ��� ������ �ٸ� ��ü
	 *  hash�ڵ尡 ������ ���� ��ü�ϼ���, �ٸ� ��ü�ϼ��� �ִ�.
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
