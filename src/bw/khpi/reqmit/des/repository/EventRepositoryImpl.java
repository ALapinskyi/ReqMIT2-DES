package bw.khpi.reqmit.des.repository;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import bw.khpi.reqmit.des.service.Methods;
import bw.khpi.reqmit.des.utils.ConnectUtils;

public class EventRepositoryImpl implements EventRepository {

	@Override
	public String sendList(String key, String list) {
		Map<String, String> map = new HashMap<>();
		map.put("json", list);
		return ConnectUtils.performPostCall(Methods.getEventAddUrl(), map, "POST", key);
	}

	@Override
	public String listAllByRequirement(String key, String projectId, String requirementId) {
		Map<String, String> map = new HashMap<>();
		map.put("projectId", projectId);
		map.put("requirementId", requirementId);
		try {
			return ConnectUtils.performPostCall(Methods.getTMUrl() + ConnectUtils.getPostDataString(map), map, "GET", key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
