package bw.khpi.reqmit.des.model;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {
	
	private Integer id;
	private String name;

    @XmlElement(name = "requirements")
	private List<Requirement> requirements = new LinkedList<>();
    
    public Project() {
	}
	
	public Project(String name) {
		super();
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Requirement> getRequirements() {
		return requirements;
	}
	public void setRequirements(List<Requirement> requirements) {
		this.requirements = requirements;
	}
	@Override
	public String toString() {
		return name;
	}
	
	
	
	

}
