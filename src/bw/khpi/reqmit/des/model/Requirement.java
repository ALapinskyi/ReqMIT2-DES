package bw.khpi.reqmit.des.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "requirement")
@XmlAccessorType(XmlAccessType.FIELD)
public class Requirement {
	
	private String id;
	private String projectId;
	private String name;
	
	public Requirement() {
	}
	
	public Requirement(String id, String projectId, String name) {
		this.id = id;
		this.projectId = projectId;
		this.name = name;
	}
	
	public Requirement(String projectId, String name) {
		this.projectId = projectId;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProject_id(String projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString(){
		return name;
	}

}
