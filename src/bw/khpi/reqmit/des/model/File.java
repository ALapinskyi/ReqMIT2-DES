package bw.khpi.reqmit.des.model;

public class File {
	
	private Integer id;
	private String project_id;
	private String name;
	
	
	
	public File(String project_id, String name) {
		super();
		this.project_id = project_id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
