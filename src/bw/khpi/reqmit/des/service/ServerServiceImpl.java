package bw.khpi.reqmit.des.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import bw.khpi.reqmit.des.model.Project;
import bw.khpi.reqmit.des.model.ProjectList;
import bw.khpi.reqmit.des.model.Requirement;
import bw.khpi.reqmit.des.model.User;
import bw.khpi.reqmit.des.repository.ProjectRepository;
import bw.khpi.reqmit.des.repository.ProjectRepositoryImpl;
import bw.khpi.reqmit.des.repository.RequirementRepository;
import bw.khpi.reqmit.des.repository.RequirementRepositoryImpl;
import bw.khpi.reqmit.des.repository.UserRepository;
import bw.khpi.reqmit.des.repository.UserRepositoryImpl;
import bw.khpi.reqmit.des.utils.ConnectUtils;
import bw.khpi.reqmit.des.utils.JSONUtils;
import bw.khpi.reqmit.des.utils.XMLUtils;

public class ServerServiceImpl implements ServerService {

	private UserRepository userRepository = new UserRepositoryImpl();

	private ProjectRepository projectRepository = new ProjectRepositoryImpl();
	
	private RequirementRepository requirementRepository = new RequirementRepositoryImpl();
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
		user = (User)JSONUtils.parseToObject(result, User.class);
		XMLUtils.saveUser(user);
		return user;
	}

	/*@Override
	public boolean updateUser(User user) {
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		return false;
	}*/

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
			return (Project)JSONUtils.parseToObject(result, Project.class);
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

	/*@Override
	public boolean updateProject(Project project) {
		return false;
	}

	@Override
	public boolean deleteProject(Project project) {
		return false;
	}*/

	// -----------------------------
	// Requirement Repository
	// -----------------------------

	@Override
	public Requirement saveRequirement(Requirement requirement) {
		User user = XMLUtils.loadUser();
		if (user != null && user.getToken() != null) {
			String result = requirementRepository.createRequirement(user.getToken(), requirement.getProject_id(), requirement.getName());
			String newToken = ConnectUtils.requestErrors(result);
			if ("incorrectlogin".equals(newToken)) {
				XMLUtils.removeUser();
				return null;
			}
			return (Requirement)JSONUtils.parseToObject(result, Requirement.class);
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

	/*@Override
	public boolean updateRequirement(Requirement requirement) {
		return false;
	}

	@Override
	public boolean deleteRequirement(Requirement requirement) {
		return false;
	}*/

}
