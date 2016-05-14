package bw.khpi.reqmit.des.utils;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import bw.khpi.reqmit.des.model.Event;
import bw.khpi.reqmit.des.model.EventList;
import bw.khpi.reqmit.des.model.Project;
import bw.khpi.reqmit.des.model.ProjectList;
import bw.khpi.reqmit.des.model.User;

public class XMLUtils {

	public static void saveUser(User user) {

		File file = new File("storage/userData.req");
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(User.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			m.marshal(user, file);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static User loadUser() {
		File file = new File("storage/userData.req");
		JAXBContext context;
		User user = null;
		try {
			context = JAXBContext.newInstance(User.class);

			if (file.exists()) {
				Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
				user = (User) jaxbUnmarshaller.unmarshal(file);
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public static boolean removeUser() {
		File file = new File("storage/userData.req");
		return file.delete();
	}

	public static void saveEvents(List<Event> events) {

		File file = new File("storage/tempEvents.req");
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(EventList.class);

			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			m.marshal(events, file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static EventList loadEvents() {

		File file = new File("storage/tempEvents.req");
		JAXBContext context;
		EventList events = null;
		try {
			context = JAXBContext.newInstance(EventList.class);
			Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
			events = (EventList) jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return events;
	}

	public static void saveProjects(ProjectList projects) {

		File file = new File("storage/prjReq.req");
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(ProjectList.class);

			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			m.marshal(projects, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static ProjectList loadProjects(){

		File file = new File("storage/prjReq.req");
		JAXBContext context;
		ProjectList projects = null;
		try {
			context = JAXBContext.newInstance(ProjectList.class);
		Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
		projects = (ProjectList) jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return projects;
	}

}
