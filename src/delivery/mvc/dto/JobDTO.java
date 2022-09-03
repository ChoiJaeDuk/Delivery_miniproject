package delivery.mvc.dto;
/**
 * 회원 판매자 운영자를 나누는 dto
 */
public class JobDTO {
	//필드
	private String job_code;
	private String job_name;
	
	//생성자
	public JobDTO() {}
	
	public JobDTO(String job_code, String job_name) {
		this.job_code = job_code;
		this.job_name = job_name;
	}
	
	//Get and Set
	public String getJob_code() {
		return job_code;
	}
	public void setJob_code(String job_code) {
		this.job_code = job_code;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JobDTO [job_code=");
		builder.append(job_code);
		builder.append(", job_name=");
		builder.append(job_name);
		builder.append("]");
		return builder.toString();
	}
}
