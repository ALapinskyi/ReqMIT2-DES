package bw.khpi.reqmit.des.thread;

import bw.khpi.reqmit.des.currentInfo.SelectedRequirement;
import bw.khpi.reqmit.des.model.DataTime;
import bw.khpi.reqmit.des.model.Event;
import bw.khpi.reqmit.des.model.EventMap;
import bw.khpi.reqmit.des.model.EventStructure;
import bw.khpi.reqmit.des.model.Message;
import bw.khpi.reqmit.des.service.ServerService;
import bw.khpi.reqmit.des.service.ServerServiceImpl;

public class EventThread implements Runnable {

	private ServerService serverRepository = new ServerServiceImpl();
	private Message message;
	private Event event;

	public EventThread(Message message) {
		Thread thread = new Thread(this, "Event");
		this.message = message;
		thread.start();

	}

	@Override
	public void run() {
		EventStructure es = EventMap.getUnits().get(message.getFileName());
		if (SelectedRequirement.getRequirement() != null) {
			String projectId = SelectedRequirement.getRequirement().getProjectId();
			String requirementId = String.valueOf(SelectedRequirement.getRequirement().getId());
			this.event = new Event(message.getEventType(), projectId, requirementId, es.getFile().getId().toString(), new DataTime(message.getData()));
			es.getEvents().add(event);
			if (event.getEventType().equals("CLOSE")) {
				serverRepository.sendEventList(es.getEvents());
			}
		}
	}

}
