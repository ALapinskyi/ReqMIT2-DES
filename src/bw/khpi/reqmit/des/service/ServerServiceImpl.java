package bw.khpi.reqmit.des.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import bw.khpi.reqmit.des.currentInfo.SelectedRequirement;
import bw.khpi.reqmit.des.model.*;
import bw.khpi.reqmit.des.repository.*;
import bw.khpi.reqmit.des.utils.ConnectUtils;
import bw.khpi.reqmit.des.utils.JSONUtils;
import bw.khpi.reqmit.des.utils.XMLUtils;

public class ServerServiceImpl implements ServerService {

	private UserRepository userRepository = new UserRepositoryImpl();

	private ProjectRepository projectRepository = new ProjectRepositoryImpl();

	private RequirementRepository requirementRepository = new RequirementRepositoryImpl();

	private FileRepository fileRepository = new FileRepositoryImpl();

	private EventRepository eventRepository = new EventRepositoryImpl();
	// -----------------------------
	// User Repository
	// -----------------------------

	public User getAuthentication(User user) {

		String result = userRepository.loginUser(user.getUsername(), user.getPassword());

		String newToken = ConnectUtils.requestErrors(result);
		if ("incorrectlogin".equals(newToken)) {
			XMLUtils.removeUser();
			return null;
		}

		JSONObject object = new JSONObject(result);
		if (object.has("access_token")) {
			user.setToken((String) object.get("access_token"));
		}
		XMLUtils.saveUser(user);
		return user;
	}

	@Override
	public User saveUser(User user) {

		String result = userRepository.createUser(user.getUsername(), user.getPassword());
		user = (User) JSONUtils.parseToObject(result, User.class);
		XMLUtils.saveUser(user);
		return user;
	}

	/*
	 * @Override public boolean updateUser(User user) { return false; }
	 * 
	 * @Override public boolean deleteUser(User user) { return false; }
	 */

	// -----------------------------
	// Project Repository
	// -----------------------------

	@Override
	public Project saveProject(Project project) {
		User user = XMLUtils.loadUser();
		if (user != null && user.getToken() != null) {
			String result = projectRepository.createProject(user.getToken(), project.getName());
			String newToken = ConnectUtils.requestErrors(result);
			if ("incorrectlogin".equals(newToken)) {
				XMLUtils.removeUser();
				return null;
			}
			return (Project) JSONUtils.parseToObject(result, Project.class);
		}
		return null;
	}

	@Override
	public ProjectList listAllProjects() {
		User user = XMLUtils.loadUser();
		if (user != null && user.getToken() != null) {
			String result = projectRepository.listAll(user.getToken());
			String newToken = ConnectUtils.requestErrors(result);
			if ("incorrectlogin".equals(newToken)) {
				XMLUtils.removeUser();
				return null;
			}
			return new ProjectList((ArrayList<Project>) JSONUtils.parseToList(result, Project.class));
		}
		return null;
	}

	/*
	 * @Override public boolean updateProject(Project project) { return false; }
	 * 
	 * @Override public boolean deleteProject(Project project) { return false; }
	 */

	// -----------------------------
	// Requirement Repository
	// -----------------------------

	@Override
	public Requirement saveRequirement(Requirement requirement) {
		User user = XMLUtils.loadUser();
		if (user != null && user.getToken() != null) {
			String result = requirementRepository.createRequirement(user.getToken(), requirement.getProjectId(),
					requirement.getName());
			String newToken = ConnectUtils.requestErrors(result);
			if ("incorrectlogin".equals(newToken)) {
				XMLUtils.removeUser();
				return null;
			}
			return (Requirement) JSONUtils.parseToObject(result, Requirement.class);
		}
		return null;
	}

	@Override
	public ArrayList<Requirement> listAllRequirements() {
		User user = XMLUtils.loadUser();
		if (user != null && user.getToken() != null) {
			String result = requirementRepository.listAll(user.getToken());
			String newToken = ConnectUtils.requestErrors(result);
			if ("incorrectlogin".equals(newToken)) {
				XMLUtils.removeUser();
				return null;
			}
			return (ArrayList<Requirement>) JSONUtils.parseToList(result, Requirement.class);
		}
		return null;
	}

	@Override
	public ArrayList<Requirement> listAllRequirementsByProject(String projectId) {
		User user = XMLUtils.loadUser();
		if (user != null && user.getToken() != null) {
			String result = requirementRepository.listAllByProjeñt(user.getToken(), projectId);
			String newToken = ConnectUtils.requestErrors(result);
			if ("incorrectlogin".equals(newToken)) {
				XMLUtils.removeUser();
				return null;
			}
			return (ArrayList<Requirement>) JSONUtils.parseToList(result, Requirement.class);
		}
		return null;
	}

	/*
	 * @Override public boolean updateRequirement(Requirement requirement) {
	 * return false; }
	 * 
	 * @Override public boolean deleteRequirement(Requirement requirement) {
	 * return false; }
	 */

	@Override
	public List<Event> sendEventList(List<Event> list) {
		if(!list.get(0).getEventType().equals("OPEN")){
			Event event = new Event("OPEN",list.get(0).getProjectId(), list.get(0).getFileId(), list.get(0).getData());
			list.add(event);
		}
		String json = JSONUtils.objectToJson(list);
		User user = XMLUtils.loadUser();
		if (user != null && user.getToken() != null) {
			String result = eventRepository.sendList(user.getToken(), json);
			String newToken = ConnectUtils.requestErrors(result);
			if ("incorrectlogin".equals(newToken)) {
				XMLUtils.removeUser();
				return null;
			}
			return (List<Event>) JSONUtils.parseToList(result, Event.class);
		}
		return null;
	}

	@Override
	public DOI listAllByRequirement(String projectId, String requirementId) {
		User user = XMLUtils.loadUser();
		if (user != null && user.getToken() != null) {
			String result = eventRepository.listAllByRequirement(user.getToken(), projectId, requirementId);
			String newToken = ConnectUtils.requestErrors(result);
			if ("incorrectlogin".equals(newToken)) {
				XMLUtils.removeUser();
				return null;
			}
			return (DOI) JSONUtils.parseToObject(result, DOI.class);
		}
		return null;
	}

	@Override
	public List<File> findByName(File file) {
		User user = XMLUtils.loadUser();
		if (user != null && user.getToken() != null) {
			String result = fileRepository.findByName(user.getToken(), file.getName(), file.getProject_id());
			String newToken = ConnectUtils.requestErrors(result);
			if ("incorrectlogin".equals(newToken)) {
				XMLUtils.removeUser();
				return null;
			}
			return (List<File>) JSONUtils.parseToList(result, File.class);
		}
		return null;
	}

	@Override
	public File saveFile(File file) {
		User user = XMLUtils.loadUser();
		if (user != null && user.getToken() != null) {
			String result = fileRepository.createFile(user.getToken(), file.getProject_id(), file.getName());
			String newToken = ConnectUtils.requestErrors(result);
			if ("incorrectlogin".equals(newToken)) {
				XMLUtils.removeUser();
				return null;
			}
			return (File) JSONUtils.parseToObject(result, File.class);
		}
		return null;
	}
}
