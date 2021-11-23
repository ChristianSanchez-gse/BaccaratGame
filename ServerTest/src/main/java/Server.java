import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.scene.control.ListView;
/*
 * Clicker: A: I really get it    B: No idea what you are talking about
 * C: kind of following
 */

public class Server{

	int count = 1;	
	ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
	TheServer server;
	private Consumer<Serializable> callback;
	int port;
	
	Server(Consumer<Serializable> call, int portInput){
	
		callback = call;
		server = new TheServer();
		server.start();
		this.port = portInput;
	}
	
	
	public class TheServer extends Thread{
		
		public void run() {
		
			try(ServerSocket mysocket = new ServerSocket(port);){
		    System.out.println("Server is waiting for a client!");
		  
			
		    while(true) {
		
				ClientThread c = new ClientThread(mysocket.accept(), count);
				callback.accept("client has connected to server: " + "client #" + count);
				clients.add(c);
				c.start();
				
				count++;
				
			    }
			}//end of try
				catch(Exception e) {
					callback.accept("Server socket did not launch");
				}
			}//end of while

		
		}
	

		class ClientThread extends Thread{
			
		
			Socket connection;
			int count;
			ObjectInputStream in;
			ObjectOutputStream out;
			
			ClientThread(Socket s, int count){
				this.connection = s;
				this.count = count;	
			}
			
			public void updateClients(BaccaratInfo message) {
				//for(int i = 0; i < clients.size(); i++) {
					System.out.println("This is wehere it will break");
					ClientThread t = clients.get(count);
					try {
					 t.out.writeObject(message);
					}
					catch(Exception e) {}
				//}
			}
			
			public void run(){
					
				try {
					in = new ObjectInputStream(connection.getInputStream());
					out = new ObjectOutputStream(connection.getOutputStream());
					connection.setTcpNoDelay(true);	
				}
				catch(Exception e) {
					System.out.println("Streams not open");
				}
				
				//updateClients("new client on server: client #"+count);
					
				 while(true) {
					    try {
					    	BaccaratInfo data = (BaccaratInfo) in.readObject();
					    	System.out.println("THE WALLET TOTAL RECIEVED TO THE SERVER IS: " + data.getWalletTotal());
					    	BaccaratGame newGame = new BaccaratGame(data.getBid(), data.getChoice(), data.getWalletTotal());
					    	callback.accept("Client " + count + ": Bet amount: " + data.getBid() + " on " + data.getChoice());
					    	callback.accept(": Winner for this round is " + newGame.getWinner());
					    	
					    	
					    	BaccaratInfo returnObj = new BaccaratInfo(newGame.playerHandInt(), newGame.playerHandInt(), newGame.getRoundPayout(), newGame.getWalletTotal(), newGame.getWinner() );
					    	
					    	System.out.println(newGame.getChoice());
					    	System.out.println(newGame.getRoundPayout());
					    	System.out.println(newGame.getWalletTotal());
					    	System.out.println(newGame.getWinner());
					    	out.writeObject(returnObj);
					    	
					    	}
					    catch(Exception e) {
					    	callback.accept("----Client: " + count + " disconnected----");
					    	//updateClients("Client #"+count+" has left the server!");
					    	clients.remove(this);
					    	break;
					    }
					}
				 
				 
				}//end of run
			
		}//end of client thread



}


	
	

	
