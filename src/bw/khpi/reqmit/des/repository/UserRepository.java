package bw.khpi.reqmit.des.repository;

public interface UserRepository {
	
	public String loginUser(String username, String password);
	
	public String createUser(String username, String password);
	
	public String updateUser(String token, Integer id);
	
	public String deleteUser(String token, Integer id);

}
