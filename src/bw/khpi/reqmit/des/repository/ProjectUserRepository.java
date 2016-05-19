package bw.khpi.reqmit.des.repository;


public interface ProjectUserRepository {
	
	public String findUsersByProject();
	
	public String addUserToProject();
	
	public String removeUserFromProject();
}
