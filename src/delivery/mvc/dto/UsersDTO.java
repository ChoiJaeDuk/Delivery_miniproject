package delivery.mvc.dto;

public class UsersDTO {
	private String users_id;
	private int job_code;
	private String users_pwd;
	private String users_name;
	private String users_nick;
	private String users_addr;
	private String users_phone;
	private String users_jumin;
	private String users_regist_date;
	
	
	public UsersDTO() { }
	
	
	



	public UsersDTO(String users_phone,String users_addr) {
		super();
		this.users_addr = users_addr;
		this.users_phone = users_phone;
	}






	public UsersDTO(String users_id, int job_code, String users_pwd, String users_name, String users_nick,
			String users_addr, String users_phone, String users_jumin, String users_regist_date) {
		super();
		this.users_id = users_id;
		this.job_code = job_code;
		this.users_pwd = users_pwd;
		this.users_name = users_name;
		this.users_nick = users_nick;
		this.users_addr = users_addr;
		this.users_phone = users_phone;
		this.users_jumin = users_jumin;
		this.users_regist_date = users_regist_date;
	}


	public String getUsers_id() {
		return users_id;
	}


	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}


	public int getJob_code() {
		return job_code;
	}


	public void setJob_code(int job_code) {
		this.job_code = job_code;
	}


	public String getUsers_pwd() {
		return users_pwd;
	}


	public void setUsers_pwd(String users_pwd) {
		this.users_pwd = users_pwd;
	}


	public String getUsers_name() {
		return users_name;
	}


	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}


	public String getUsers_nick() {
		return users_nick;
	}


	public void setUsers_nick(String users_nick) {
		this.users_nick = users_nick;
	}


	public String getUsers_addr() {
		return users_addr;
	}


	public void setUsers_addr(String users_addr) {
		this.users_addr = users_addr;
	}


	public String getUsers_phone() {
		return users_phone;
	}


	public void setUsers_phone(String users_phone) {
		this.users_phone = users_phone;
	}


	public String getUsers_jumin() {
		return users_jumin;
	}


	public void setUsers_jumin(String users_jumin) {
		this.users_jumin = users_jumin;
	}


	public String getUsers_regist_date() {
		return users_regist_date;
	}


	public void setUsers_regist_date(String users_regist_date) {
		this.users_regist_date = users_regist_date;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsersDTO [users_id=");
		builder.append(users_id);
		builder.append(", job_code=");
		builder.append(job_code);
		builder.append(", users_pwd=");
		builder.append(users_pwd);
		builder.append(", users_name=");
		builder.append(users_name);
		builder.append(", users_nick=");
		builder.append(users_nick);
		builder.append(", users_addr=");
		builder.append(users_addr);
		builder.append(", users_phone=");
		builder.append(users_phone);
		builder.append(", users_jumin=");
		builder.append(users_jumin);
		builder.append(", users_regist_date=");
		builder.append(users_regist_date);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
