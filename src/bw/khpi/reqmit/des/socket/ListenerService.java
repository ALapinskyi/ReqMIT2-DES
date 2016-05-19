package bw.khpi.reqmit.des.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import bw.khpi.reqmit.des.currentInfo.SelectedRequirement;
import bw.khpi.reqmit.des.model.Event;
import bw.khpi.reqmit.des.model.EventMap;
import bw.khpi.reqmit.des.model.EventStructure;
import bw.khpi.reqmit.des.model.File;
import bw.khpi.reqmit.des.model.Message;
import bw.khpi.reqmit.des.service.ServerService;
import bw.khpi.reqmit.des.service.ServerServiceImpl;
import bw.khpi.reqmit.des.thread.EventThread;
import bw.khpi.reqmit.des.thread.FinderThread;
import bw.khpi.reqmit.des.utils.JSONUtils;

public class ListenerService extends AbstractService implements Runnable {

	private ServerSocket providerSocket;

	public ListenerService() {
		thread = new Thread(this, "Listener");
		try {
			providerSocket = new ServerSocket(2004, 10);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		thread.start();

	}

	@Override
	public void run() {
		try {
			requestSocket = providerSocket.accept();
			in = new ObjectInputStream(requestSocket.getInputStream());
			do {
				try {
					message = (String) in.readObject();
					System.out.println("client>" + message);
					Message m = (Message) JSONUtils.parseToObject(message, Message.class);
					if (m.getEventType().equals("OPEN")) {
						if (EventMap.getUnits().containsKey(m.getFileName())) {
							System.out.println("CONTAINS");
						} else {
							new FinderThread(m);
						}
					} else {
						new EventThread(m);
					}
					if (m.equals("bye"))
						sendMessage("bye");
				} catch (ClassNotFoundException e) {
					System.err.println("Data received in unknown format");
				}
			} while (!message.equals("bye"));

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
