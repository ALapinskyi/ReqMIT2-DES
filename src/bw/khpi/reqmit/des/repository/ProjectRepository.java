package bw.khpi.reqmit.des.repository;

import java.util.List;

import bw.khpi.reqmit.des.model.Project;

public interface ProjectRepository {
	
	public String createProject(String key, String name);
	
	public String updateUser(String key, Integer id, String name);
	
	public String deleteUser(String key, Integer id);

	public String listAll(String key);
}
