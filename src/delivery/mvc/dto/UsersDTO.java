package delivery.mvc.dto;

public class UsersDTO {
	private String user_id;
	private String job_code;
	private String user_pwd;
	private String user_name;
	private String user_nick;
	private String user_addr;
	private String user_phone;
	private String user_jumin;
	private String user_regist_date;
	
	
	public UsersDTO() { }
	
	
	



	public UsersDTO(String users_phone,String users_addr) {
		super();
		this.user_addr = users_addr;
		this.user_phone = users_phone;
	}

	public UsersDTO(String users_id, String job_code, String users_pwd, String users_name, String users_nick,
			String users_addr, String users_phone, String users_jumin) {
		super();
		this.user_id = users_id;
		this.job_code = job_code;
		this.user_pwd = users_pwd;
		this.user_name = users_name;
		this.user_nick = users_nick;
		this.user_addr = users_addr;
		this.user_phone = users_phone;
		this.user_jumin = users_jumin;
	}




	public UsersDTO(String users_id, String job_code, String users_pwd, String users_name, String users_nick,
			String users_addr, String users_phone, String users_jumin, String users_regist_date) {
		this(users_id,job_code,users_pwd,users_name,users_nick,users_addr,users_phone,users_jumin);
		this.user_regist_date = users_regist_date;
	}


	public UsersDTO(String user_name) {
		this.user_name = user_name;
	}






	public String getUsers_id() {
		return user_id;
	}


	public void setUsers_id(String users_id) {
		this.user_id = users_id;
	}


	public String getJob_code() {
		return job_code;
	}


	public void setJob_code(String job_code) {
		this.job_code = job_code;
	}


	public String getUsers_pwd() {
		return user_pwd;
	}


	public void setUsers_pwd(String users_pwd) {
		this.user_pwd = users_pwd;
	}


	public String getUsers_name() {
		return user_name;
	}


	public void setUsers_name(String users_name) {
		this.user_name = users_name;
	}


	public String getUsers_nick() {
		return user_nick;
	}


	public void setUsers_nick(String users_nick) {
		this.user_nick = users_nick;
	}


	public String getUsers_addr() {
		return user_addr;
	}


	public void setUsers_addr(String users_addr) {
		this.user_addr = users_addr;
	}


	public String getUsers_phone() {
		return user_phone;
	}


	public void setUsers_phone(String users_phone) {
		this.user_phone = users_phone;
	}


	public String getUsers_jumin() {
		return user_jumin;
	}


	public void setUsers_jumin(String users_jumin) {
		this.user_jumin = users_jumin;
	}


	public String getUsers_regist_date() {
		return user_regist_date;
	}


	public void setUsers_regist_date(String users_regist_date) {
		this.user_regist_date = users_regist_date;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsersDTO [users_id=");
		builder.append(user_id);
		builder.append(", job_code=");
		builder.append(job_code);
		builder.append(", users_pwd=");
		builder.append(user_pwd);
		builder.append(", users_name=");
		builder.append(user_name);
		builder.append(", users_nick=");
		builder.append(user_nick);
		builder.append(", users_addr=");
		builder.append(user_addr);
		builder.append(", users_phone=");
		builder.append(user_phone);
		builder.append(", users_jumin=");
		builder.append(user_jumin);
		builder.append(", users_regist_date=");
		builder.append(user_regist_date);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
