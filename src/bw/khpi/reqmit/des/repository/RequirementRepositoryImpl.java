package bw.khpi.reqmit.des.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bw.khpi.reqmit.des.service.Methods;
import bw.khpi.reqmit.des.utils.ConnectUtils;

public class RequirementRepositoryImpl implements RequirementRepository {



	@Override
	public String createRequirement(String key, String projectId, String name) {
		Map<String, String> map = new HashMap<>();
		map.put("projectId", String.valueOf(projectId));
		map.put("requirementName", name);
		return ConnectUtils.performPostCall(Methods.getRequirementUrl(), map, "POST", key);
	}

	@Override
	public String updateRequirement(String key, String id, String projectId, String name) {
		
		return null;
	}

	@Override
	public String deleteRequirement(String key, String id) {
		
		return null;
	}

	@Override
	public String listAll(String key) {
		return ConnectUtils.performPostCall(Methods.getRequirementUrl(), new HashMap<>(), "GET", key);
	}

}
