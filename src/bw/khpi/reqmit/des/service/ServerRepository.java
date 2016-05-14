package bw.khpi.reqmit.des.service;

import bw.khpi.reqmit.des.model.Project;
import bw.khpi.reqmit.des.model.Requirement;
import bw.khpi.reqmit.des.model.User;

public interface ServerRepository {
	
	//-----------------------------
	// User Repository
	//-----------------------------
	
	public User getAuthentication(User user);

	public User saveUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
	

	//-----------------------------
	// Project Repository
	//-----------------------------

	public User saveProject(Project project);
	
	public boolean updateProject(Project project);
	
	public boolean deleteProject(Project project);
	

	//-----------------------------
	// Requirement Repository
	//-----------------------------

	public User saveRequirement(Requirement requirement);
	
	public boolean updateRequirement(Requirement requirement);
	
	public boolean deleteRequirement(Requirement requirement);
}
