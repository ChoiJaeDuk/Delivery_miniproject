package delivery.mvc.dto;

public class JobDTO {
	private int job_code;
	private int job_name;
	
	public JobDTO () { }

	public JobDTO(int job_code, int job_name) {
		super();
		this.job_code = job_code;
		this.job_name = job_name;
	}

	public int getJob_code() {
		return job_code;
	}

	public void setJob_code(int job_code) {
		this.job_code = job_code;
	}

	public int getJob_name() {
		return job_name;
	}

	public void setJob_name(int job_name) {
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
