package bw.khpi.reqmit.des.model;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "projects")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectList extends LinkedList<Event> {

    @XmlElement(name = "project")
	private List<Project> project = new LinkedList<>();

	public List<Project> getProjects() {
		return project;
	}

	public void setProjects(List<Project> project) {
		this.project = project;
	}
    
    
}
