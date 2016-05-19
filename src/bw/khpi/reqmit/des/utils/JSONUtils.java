package bw.khpi.reqmit.des.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtils {

	public static String readStream(InputStream in) {
		BufferedReader reader = null;
		StringBuffer data = new StringBuffer("");
		String line = "";
		try {
			reader = new BufferedReader(new InputStreamReader(in));
			line = reader.readLine();
			/*
			 * while (line != null) { data.append(line); }
			 */
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// return data.toString();
		return line;
	}

	public static ArrayList<?> parseToList(String inputStream, Class<?> object) {

		ArrayList<Object> data = null;
		GsonBuilder builder = new GsonBuilder();

		Gson gson = builder.create();

		try {
			JSONArray jArray = new JSONArray(inputStream);
			data = new ArrayList();

			for (int i = 0; i < jArray.length(); i++) {
				Object obj = gson.fromJson(String.valueOf(jArray.getJSONObject(i)), object);
				data.add(obj);
			}
		} catch (Exception e) {
		}
		return data;
	}

	public static Object parseToObject(String result, Class<?> object) {

		Object data = null;
		GsonBuilder builder = new GsonBuilder();

		Gson gson = builder.create();

		try {
			JSONParser parser = new JSONParser();
			org.json.simple.JSONObject jObj = (org.json.simple.JSONObject) parser.parse(result);
			data = gson.fromJson(String.valueOf(jObj), object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public static String objectToJson(Object object) {

		String data = null;
		GsonBuilder builder = new GsonBuilder();

		Gson gson = builder.create();

		try {
			data = gson.toJson(object);
		} catch (Exception e) {
		}
		return data;
	}
}
