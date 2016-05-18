package bw.khpi.reqmit.des.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bw.khpi.reqmit.des.service.Methods;
import bw.khpi.reqmit.des.utils.ConnectUtils;

public class ProjectRepositoryImpl implements ProjectRepository {

	@Override
	public String createProject(String key, String name) {
		Map<String, String> map = new HashMap<>();
		map.put("projectName", name);
		return ConnectUtils.performPostCall(Methods.getProjectUrl(), map, "POST", key);
	}

	@Override
	public String updateUser(String key, Integer id, String name) {
		return null;
	}

	@Override
	public String deleteUser(String key, Integer id) {
		return null;
	}

	@Override
	public String listAll(String key) {
		return ConnectUtils.performPostCall(Methods.getProjectUrl(), new HashMap<>(), "GET", key);
	}
}
