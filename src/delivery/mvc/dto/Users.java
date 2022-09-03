package delivery.mvc.dto;
/**
 * 회원의 정보를 객체화
 */
public class Users {
	//필드
	private String user_id;
	private String user_pwd;
	private String user_name;
	private String user_nick;
	private String user_addr;
	private String user_phone;
	private String user_jumin;
	private String job_code;
	
	//생성자
	public Users() {}
	public Users(String user_name, String user_jumin) {
		this.user_name = user_name;
		this.user_jumin = user_jumin;
	}
	public Users(String user_id, String user_name, String user_jumin) {
		this(user_name, user_jumin);
		this.user_id = user_id;
	}
	public Users(String user_id, String user_pwd, String user_name, String user_nick, String user_addr,
			String user_phone, String user_jumin, String job_code) {
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_nick = user_nick;
		this.user_addr = user_addr;
		this.user_phone = user_phone;
		this.user_jumin = user_jumin;
		this.job_code = job_code;
	}
	
	
	
	
}
