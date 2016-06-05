package bw.khpi.reqmit.des.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
	
	private Integer id;
	private String eventType;
	private String projectId;
	private String requirementId;
	private String fileId;
	private DataTime data;
	
	public Event(){
		
	}
	
	
	

	public Event(String eventType, String projectId, String requirementId, String fileId, DataTime data) {
		super();
		this.eventType = eventType;
		this.projectId = projectId;
		this.requirementId = requirementId;
		this.fileId = fileId;
		this.data = data;
	}




	public Event( String eventType, String projectId, DataTime data) {
		super();
		this.eventType = eventType;
		this.projectId = projectId;
		this.data = data;
	}



	public Event(String eventType, String projectId, String fileId, DataTime data) {
		super();
		this.eventType = eventType;
		this.projectId = projectId;
		this.fileId = fileId;
		this.data = data;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public DataTime getData() {
		return data;
	}

	public void setData(DataTime data) {
		this.data = data;
	}



	public String getRequirementId() {
		return requirementId;
	}



	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}


	
	
	
}
