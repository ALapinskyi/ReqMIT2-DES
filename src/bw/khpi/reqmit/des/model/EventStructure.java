package bw.khpi.reqmit.des.model;

import java.util.List;

public class EventStructure {
	
	private File file;
	private List<Event> events;
	
	public EventStructure(File file, List<Event> events) {
		this.file = file;
		this.events = events;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
