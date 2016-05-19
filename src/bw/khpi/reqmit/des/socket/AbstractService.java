package bw.khpi.reqmit.des.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class AbstractService{

	public Socket requestSocket;
	public ObjectOutputStream out;
	public ObjectInputStream in;
	protected String message;
	protected Thread thread;
	
	public void closeConnection(){
		try{
			if(in != null)
				in.close();

			if(out != null)
				out.close();

			if(requestSocket != null)
            requestSocket.close();
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
	}
	
	public void sendMessage(String msg){
		
	}
	
	public void run(){
		
	}
}
