import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

import javafx.scene.control.TextField;



public class Client extends Thread{

	
	Socket socketClient;
	
	ObjectOutputStream out;
	ObjectInputStream in;
	int port;
	String ip;
	
	private Consumer<Serializable> callback;
	
	Client(Consumer<Serializable> call, int portNumber, String ipText){
	
		callback = call;
		port = portNumber;
		ip = ipText;
	}
	
	public void run() {
		
		try {
		System.out.println("Starting the client at port: " + port);
		System.out.println("On address: " + ip);
		socketClient= new Socket(ip,port); // "127.0.0.1" and 5555 are the original
	    out = new ObjectOutputStream(socketClient.getOutputStream());
	    in = new ObjectInputStream(socketClient.getInputStream());
	    socketClient.setTcpNoDelay(true);
		}
		catch(Exception e) {}
		
		while(true) {
			 
			try {
			String message = in.readObject().toString();
			callback.accept(message);
			}
			catch(Exception e) {}
		}
	
    }
	
	public void send(String data) {
		
		try {
			out.writeObject(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
