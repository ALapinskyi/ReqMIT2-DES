package bw.khpi.reqmit.des.model;

import java.util.Date;

public class Message {
	
	private String fileName;
	private String eventType;
	private String data;
	
	
	
	public Message(String fileName, String eventType, String data) {
		super();
		this.fileName = fileName;
		this.eventType = eventType;
		this.data = data;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	

}
