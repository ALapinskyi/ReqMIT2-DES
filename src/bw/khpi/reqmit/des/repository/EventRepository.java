package bw.khpi.reqmit.des.repository;

public interface EventRepository {
	
	public String sendList(String key, String list);
	

	public String listAllByRequirement(String key, String projectId, String requirementId);
}
