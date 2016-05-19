package bw.khpi.reqmit.des.repository;

import java.util.HashMap;
import java.util.Map;

import bw.khpi.reqmit.des.service.Methods;
import bw.khpi.reqmit.des.utils.ConnectUtils;

public class EventRepositoryImpl implements EventRepository {

	@Override
	public String sendList(String key, String list) {
		Map<String, String> map = new HashMap<>();
		map.put("list", list);
		return ConnectUtils.performPostCall(Methods.getEventUrl(), map, "POST", key);
	}


}
