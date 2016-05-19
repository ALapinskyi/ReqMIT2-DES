package bw.khpi.reqmit.des.repository;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import bw.khpi.reqmit.des.service.Methods;
import bw.khpi.reqmit.des.utils.ConnectUtils;

public class FileRepositoryImpl implements FileRepository {

	@Override
	public String createFile(String key, String project_id, String name) {
		Map<String, String> map = new HashMap<>();
		map.put("projectId", project_id);
		map.put("name", name);
		return ConnectUtils.performPostCall(Methods.getFileUrl(), map, "POST", key);
	}

	@Override
	public String updateFile(String key, Integer id, String project_id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteFile(String key, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByName(String key, String name, String projectId) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("projectId", projectId);
		try {
			return ConnectUtils.performPostCall(Methods.getFileFindUrl() + ConnectUtils.getPostDataString(map), null, "GET", key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String listAllByProject(String key, String projectId) {
		Map<String, String> map = new HashMap<>();
		map.put("projectId", projectId);
		try {
			return ConnectUtils.performPostCall(Methods.getFileUrl() + ConnectUtils.getPostDataString(map), null, "GET", key);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}


}
