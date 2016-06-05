package bw.khpi.reqmit.des.service;

public abstract class Methods {
	
	public static String PROTOCOL = "http";

    public static String IP_PORT = "192.168.2.114:8080";

    public static String FOLDER = "/api";
    public static String FOLDER_OAUTH = "/oauth";
    
    public static String getLoginUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER_OAUTH + "/token?";
    }
    
    public static String getUserUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/users?";
    }
    
    public static String getProjectUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/projects?";
    }

    public static String getRequirementUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/requirements?";
    }

    public static String getEventUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/events?";
    }

    public static String getEventAddUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/events/addAll?";
    }

    public static String getFileUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/files?";
    }

    public static String getFileFindUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/files/find?";
    }

    public static String getTMUrl(){
        return PROTOCOL + "://" + IP_PORT + FOLDER + "/tm?";
    }
}
