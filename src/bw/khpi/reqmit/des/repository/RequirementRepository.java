package bw.khpi.reqmit.des.repository;


public interface RequirementRepository {
	
	public String createRequirement(String key, String projectId, String name);
	
	public String updateRequirement(String key, String id, String projectId, String name);
	
	public String deleteRequirement(String key, String id);

	public String listAll(String key);
}
