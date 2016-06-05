package bw.khpi.reqmit.des.service;

import java.util.ArrayList;
import java.util.List;

import bw.khpi.reqmit.des.model.*;

public interface ServerService {
	
	//-----------------------------
	// User Repository
	//-----------------------------
	
	public User getAuthentication(User user);

	public User saveUser(User user);
	
	//public boolean updateUser(User user);
	
	//public boolean deleteUser(User user);
	

	//-----------------------------
	// Project Repository
	//-----------------------------

	public Project saveProject(Project project);

	public ProjectList listAllProjects();
	
	//public boolean updateProject(Project project);
	
	//public boolean deleteProject(Project project);
	

	//-----------------------------
	// Requirement Repository
	//-----------------------------

	public Requirement saveRequirement(Requirement requirement);

	public ArrayList<Requirement> listAllRequirements();

	public ArrayList<Requirement> listAllRequirementsByProject(String projectId);
	
	//public boolean updateRequirement(Requirement requirement);
	
	//public boolean deleteRequirement(Requirement requirement);


	//-----------------------------
	// Event Repository
	//-----------------------------
	
	public List<Event> sendEventList(List<Event> list);

	public DOI listAllByRequirement(String projectId, String  requirementId);

	//-----------------------------
	// File Repository
	//-----------------------------
	
	public List<File> findByName(File file);
	
	public File saveFile(File file);
}
