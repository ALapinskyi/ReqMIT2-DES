package bw.khpi.reqmit.des.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	private Integer id;
	private String username;
	private String password;
	private String key;
	
	public User(){
		
	}
	
	public User(String username, String password, String key) {
		super();
		this.username = username;
		this.password = password;
		this.key = key;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pasword) {
		this.password = pasword;
	}
	public String getKet() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", key=" + key + "]";
	}
	
	public boolean compareLoginData(User user){
		if(this.username.equals(user.getUsername()) && this.password.equals(user.getPassword())){
			return true;
		} else {
			return false;
		}
	}
	
	

}
