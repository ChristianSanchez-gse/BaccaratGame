import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;



public class Client extends Thread{
	
	Socket socketClient;
	
	ObjectOutputStream out;
	ObjectInputStream in;
	private int port;
	private String ip;
	private Consumer<Serializable> callback;
	
	Client(Consumer<Serializable> call, int portNumber, String ip){
	
		callback = call;
		this.port = portNumber;
		this.ip = ip;
	}
	
	public void run() {
		
		try {
		socketClient= new Socket(ip,port);
	    out = new ObjectOutputStream(socketClient.getOutputStream());
	    in = new ObjectInputStream(socketClient.getInputStream());
	    socketClient.setTcpNoDelay(true);
		}
		catch(Exception e) {}
		
		while(true) {
			 
			try {
			BaccaratInfo message = (BaccaratInfo) in.readObject();
			System.out.println("Passing the object back to the controller. Winner: " + message.getWinner());
			callback.accept(message);
			//callback.accept(message.getBid() + " was the bid");
			//callback.accept(message.getWalletTotal() + " was the walletTotal");
			//callback.accept(message.getRoundPayout() + " was the round payout");
			
			}
			catch(Exception e) {}
		}
	
    }
	
	public void send(BaccaratInfo data) {
		
		try {
			out.writeObject(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
