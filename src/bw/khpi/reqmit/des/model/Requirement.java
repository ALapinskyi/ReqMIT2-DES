package bw.khpi.reqmit.des.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "requirement")
@XmlAccessorType(XmlAccessType.FIELD)
public class Requirement {
	
	private Integer id;
	private Integer project_id;
	private String name;
	private String description;
	
	public Requirement() {
	}
	
	public Requirement(Integer id, Integer project_id, String name, String description) {
		this.id = id;
		this.project_id = project_id;
		this.name = name;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProject_id() {
		return project_id;
	}
	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return name;
	}

}
