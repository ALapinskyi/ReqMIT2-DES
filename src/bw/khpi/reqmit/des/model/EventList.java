package bw.khpi.reqmit.des.model;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "events")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventList extends LinkedList<Event> {

    @XmlElement(name = "event")
	private List<Event> events = new LinkedList<>();

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
    
    
}