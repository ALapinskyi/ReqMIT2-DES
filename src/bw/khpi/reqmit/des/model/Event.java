package bw.khpi.reqmit.des.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
	
	private Integer id;
	private String type;
	private Integer user_id;
	private Integer requirement_id;
	private Integer file_id;
	private String data;
	
	public Event(){
		
	}
	
	public Event(String type, Integer user_id, Integer requirement_id, Integer file_id, String data) {
		super();
		this.type = type;
		this.user_id = user_id;
		this.requirement_id = requirement_id;
		this.file_id = file_id;
		this.data = data;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getRequirement_id() {
		return requirement_id;
	}
	public void setRequirement_id(Integer requirement_id) {
		this.requirement_id = requirement_id;
	}
	public Integer getFile_id() {
		return file_id;
	}
	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
