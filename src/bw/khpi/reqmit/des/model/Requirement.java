package bw.khpi.reqmit.des.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "requirement")
@XmlAccessorType(XmlAccessType.FIELD)
public class Requirement {
	
	private Integer id;
	private String project_id;
	private String name;
	
	public Requirement() {
	}
	
	public Requirement(Integer id, String project_id, String name) {
		this.id = id;
		this.project_id = project_id;
		this.name = name;
	}
	
	public Requirement(String project_id, String name) {
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
	@Override
	public String toString(){
		return name;
	}

}
