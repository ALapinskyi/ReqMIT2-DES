package bw.khpi.reqmit.des.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventMap  {
	
	private static Map<String, EventStructure> unitMap = new HashMap<String, EventStructure>();
	
	private EventMap(){
		
	}
	
	public static Map<String, EventStructure> getUnits() {
		return unitMap;
	}
	
	public static void addUnit(String key, EventStructure value) {
		unitMap.put(key, value);
	}
	
	public static void removeUnit(String key) {
		unitMap.remove(key);
	}
	
	public static void removeAll() {
		unitMap.clear();
	}
	
}
