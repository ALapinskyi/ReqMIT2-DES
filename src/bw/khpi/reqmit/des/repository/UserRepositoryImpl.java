package bw.khpi.reqmit.des.repository;

import java.util.HashMap;
import java.util.Map;

import bw.khpi.reqmit.des.service.Methods;
import bw.khpi.reqmit.des.utils.ConnectUtils;

public class UserRepositoryImpl implements UserRepository{


	@Override
	public String loginUser(String username, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		map.put("grant_type", "password");
		return ConnectUtils.performPostCall(Methods.getLoginUrl(), map, "POST", null);
	}
	
	@Override
	public String createUser(String username, String password) {		
		Map<String, String> map = new HashMap<>();
		map.put("login", username);
		map.put("password", password);
		map.put("email", "johnsmith@gmail.com");
		return ConnectUtils.performPostCall(Methods.getUserUrl(), map, "POST", null);
	}

	@Override
	public String updateUser(String token, Integer id) {
		return null;
	}

	@Override
	public String deleteUser(String token, Integer id) {
		return null;
	}

}
