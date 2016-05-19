package bw.khpi.reqmit.des.thread;

import java.util.LinkedList;
import java.util.List;

import bw.khpi.reqmit.des.currentInfo.SelectedRequirement;
import bw.khpi.reqmit.des.model.Event;
import bw.khpi.reqmit.des.model.EventMap;
import bw.khpi.reqmit.des.model.EventStructure;
import bw.khpi.reqmit.des.model.File;
import bw.khpi.reqmit.des.model.Message;
import bw.khpi.reqmit.des.service.ServerService;
import bw.khpi.reqmit.des.service.ServerServiceImpl;

public class FinderThread implements Runnable {

	private ServerService serverRepository = new ServerServiceImpl();
	private Message event;

	public FinderThread(Message event) {
		Thread thread = new Thread(this, "Finder");
		this.event = event;
		thread.start();
	}

	@Override
	public synchronized void run() {
		if (SelectedRequirement.getRequirement() != null) {
			File file = new File(SelectedRequirement.getRequirement().getProjectId(), event.getFileName());
			List<File> result = serverRepository.findByName(file);
			
			if(result.size() == 0){
				file = serverRepository.saveFile(file);
			}
			List<Event> events = new  LinkedList<Event>();
			events.add(new Event(event.getEventType(), SelectedRequirement.getRequirement().getProjectId(), file.getId(), event.getData()));
			EventMap.getUnits().put(event.getFileName(), new EventStructure(file, events));
		
		}
	}

}
