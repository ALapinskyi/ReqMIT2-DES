package bw.khpi.reqmit.des.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import bw.khpi.reqmit.des.model.User;
import bw.khpi.reqmit.des.service.Methods;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ConnectUtils {

	private static final int TIMEOUT_DELAY = 30000;

	public static String performPostCall(String requestURL, Map<String, String> postDataParams, String type, String key) {
		URL url;
		String response = "";
		try {
			url = new URL(requestURL);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if(key == null){
				String userCredentials = "clientapp:SKeTXh2EFdva5abk";
				String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
				conn.setRequestProperty("Authorization", basicAuth);
				conn.setRequestProperty("Accept", "application/json");
			} else {
				String userCredentials = "Bearer " + key; 
				conn.setRequestProperty("Authorization", userCredentials);
			}
			
			conn.setRequestMethod(type);
			conn.setReadTimeout(TIMEOUT_DELAY);
			conn.setConnectTimeout(TIMEOUT_DELAY);
			conn.setUseCaches(false);
			conn.setDoInput(true);
			
			if(!"GET".equals(type)){
				conn.setDoOutput(true);
				OutputStream os = conn.getOutputStream();
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
				writer.write(getPostDataString(postDataParams));
				writer.flush();
				writer.close();
				os.close();
			}

			int responseCode = conn.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				String line;
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while ((line = br.readLine()) != null) {
					response += line;
				}
			} else {
				String line;
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				while ((line = br.readLine()) != null) {
					response += line;
				}

			}
		} catch (ConnectException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR!");
			alert.setHeaderText("No connection to the server");
			alert.setContentText("Please, ñontact your administrator for further actions");
			alert.showAndWait();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}

	private static String getPostDataString(Map<String, String> params) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (first)
				first = false;
			else
				result.append("&");

			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}

		return result.toString();
	}

	public static String requestErrors(String data) {

		String newToken = null;
		User user = null;
		try {
			Object json = new JSONTokener(data).nextValue();
			if (json instanceof JSONObject) {
				JSONObject object = new JSONObject(data);
				if (object.has("error") && object.getString("error").equals("invalid_grant2")) {

					user = XMLUtils.loadUser();
					String login = user.getUsername();
					String password = user.getPassword();
					String urlToken = Methods.getLoginUrl();

					HashMap<String, String> paramsPOST = new HashMap<>();
					paramsPOST.put("grant_type", "password");
					paramsPOST.put("username", login);
					paramsPOST.put("password", password);

					String result = ConnectUtils.performPostCall(urlToken, paramsPOST, "POST", null);

					JSONObject obj = new JSONObject(result);
					try {
						if (obj.getString("access_token") != null) {
							newToken = obj.getString("access_token");
						}
					} catch (JSONException e) {
						e.printStackTrace();
						newToken = "incorrectlogin";
					}
					if (newToken != null) {
						user.setToken(newToken);
						XMLUtils.saveUser(user);
						return newToken;
					}
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return newToken;
	}
}
