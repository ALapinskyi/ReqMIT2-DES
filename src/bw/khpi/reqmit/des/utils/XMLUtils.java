package bw.khpi.reqmit.des.utils;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import bw.khpi.reqmit.des.model.Event;
import bw.khpi.reqmit.des.model.EventList;
import bw.khpi.reqmit.des.model.User;

public class XMLUtils {
	
	public static void saveUser(User user) throws JAXBException{

		File file = new File("storage/userData.req");
		JAXBContext context = JAXBContext.newInstance(User.class);

	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	    m.marshal(user, file);
	}
	
	public static User loadUser() throws JAXBException{
		File file = new File("storage/userData.req");
		JAXBContext context = JAXBContext.newInstance(User.class);
		
		Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
		User user = (User) jaxbUnmarshaller.unmarshal(file);
		
		return user;
	}
	
	public static void saveEvents(List<Event> events) throws JAXBException{

		File file = new File("storage/tempEvents.req");
		JAXBContext context = JAXBContext.newInstance(EventList.class);

	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	    m.marshal(events, file);
	}
	
	public static EventList loadEvents() throws JAXBException{

		File file = new File("storage/tempEvents.req");
		JAXBContext context = JAXBContext.newInstance(EventList.class);

		Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
		EventList events = (EventList) jaxbUnmarshaller.unmarshal(file);
		
		return events;
	}

}
