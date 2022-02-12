// SERVER SIDE implementation of two part client server TCP packet receiver
package localTalk; // Local package, change to suited package and needs.

// Import java io and java net packages, all attributes 
import java.io.* ;
import java.net.* ;

// ServerSide class for Serverside init
public class ServerSide {
	// attributes for setting sockers and input stream using libraries
	private Socket socket =null; // JAVA NET socket 
	private ServerSocket server =null; // JAVA NET SERVER socket 
	private DataInputStream input_data =null; // JAVA IO DATA INPUT
	// All null identifiers give default null value
	
	
	public ServerSide(int port) { // serverside constructor for PORT field 
		try {
			
		server = new ServerSocket(port); // starting server on given port
		System.out.println("Server started"); // tells user server has started
		System.out.println("Server Waiting for Client");
		
		socket = server.accept(); // will accept the socket of client, therefore starting process
		System.out.println("Client accepted");
		
		
		input_data = new DataInputStream( // this will display the data from client to serverside using getinput stream from datagram
				new BufferedInputStream(
						socket.getInputStream())); // gets input and puts it on stream
				
				String line ="";
				
				while(!line.equals("end")) { // while program runs, read for line end, when found it will initalize a TCP flag FIN
					// THIS WILL GRACEFULY EXIT PROGRAM, no RST handle used.
					
				
				try {
					line = input_data.readUTF(); // Try for reading UTF 
					System.out.println(line); ;// prints line to user
				}
				catch(IOException i){ // catch for IOExec 
					System.out.println(i);
				}
			}
				System.out.println("Closing Socket Connection");
				socket.close(); // This will close the socket and input data
				input_data.close();
		}
				
				catch(IOException i){ // catch system error
					System.out.println(i);
					
				}
		}

	public static void main(String[] args) //static main
	{
		ServerSide server = new ServerSide(6070); // specifies port to communicate and init serverside comm.
	}
}
