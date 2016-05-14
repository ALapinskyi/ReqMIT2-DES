package bw.khpi.reqmit.des.service;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBException;

import bw.khpi.reqmit.des.model.Project;
import bw.khpi.reqmit.des.model.ProjectList;
import bw.khpi.reqmit.des.model.Requirement;
import bw.khpi.reqmit.des.model.User;
import bw.khpi.reqmit.des.utils.XMLUtils;

public class ServerRepositoryImpl implements ServerRepository{

	//-----------------------------
	// User Repository
	//-----------------------------
	
	public User getAuthentication(User user){
		
		XMLUtils.saveUser(user);
		
		User user2 = XMLUtils.loadUser();
		if (user2 != null) {
			if (user2.compareLoginData(user)) {
				user = user2;
			}
		}
		return user;
	}

	@Override
	public User saveUser(User user) {
		XMLUtils.saveUser(user);
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}


	//-----------------------------
	// Project Repository
	//-----------------------------
	
	@Override
	public User saveProject(Project project) {
		ProjectList projects = XMLUtils.loadProjects();
		if(projects == null){
			projects = new ProjectList();
		}
		projects.getProjects().add(project);
		XMLUtils.saveProjects(projects);
		return null;
	}

	@Override
	public boolean updateProject(Project project) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProject(Project project) {
		// TODO Auto-generated method stub
		return false;
	}


	//-----------------------------
	// Requirement Repository
	//-----------------------------
	
	@Override
	public User saveRequirement(Requirement requirement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRequirement(Requirement requirement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRequirement(Requirement requirement) {
		// TODO Auto-generated method stub
		return false;
	}

}
