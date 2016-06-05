package bw.khpi.reqmit.des.model;

public class File {
	
	private String id;
	private String projectId;
	private String name;
	
	
	
	public File(String project_id, String name) {
		super();
		this.projectId = project_id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProject_id() {
		return projectId;
	}
	public void setProject_id(String project_id) {
		this.projectId = project_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
