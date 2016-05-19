package bw.khpi.reqmit.des.repository;

public interface FileRepository {

	public String createFile(String key, String project_id, String name);

	public String updateFile(String key, Integer id, String project_id, String name);

	public String deleteFile(String key, Integer id);

	public String findByName(String key, String name, String projectId);

	public String listAllByProject(String key, String projectId);
}
