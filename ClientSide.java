// CLIENT SIDE implementation of two part client server TCP packet receiver
// program author Isaac
//re-edit for depreciation removal
package localTalk;

//Import java io and java net packages, all attributes 
import java.io.*;
import java.net.*;

// Client Side Class created private
public class ClientSide {
	// three attributes set too null data,  
	private Socket socket = null; // JAVA NET socket stream
	//private DataInputStream data_input = null; // JAVA IO stream DEPRECEATED 
	private BufferedReader data_input_new = null; // JAVA IO Buffered Reader to replace depreceated datainput stream
	private DataOutputStream data_output = null; // JAVA IO stream
	
	// NO LONGER REQUIRED< DEPRECIATION REMOVED @SuppressWarnings("deprecation") // current warning is set in place for deprecation for data_input readline. 
	public ClientSide(String address, int port) // Constructor for Clientside, adding address and port
	{
		try { // try, except catch included
			socket = new Socket(address, port); // inits socket with address and port
			System.out.println("Socket Connected"); // lets user know socket connected 
			
			//data_input = new DataInputStream(System.in); // allows system input through the datainput stream
			data_input_new
				= new BufferedReader (new InputStreamReader(System.in));// Buffered reader for reading the input from the client.

			
			data_output = new DataOutputStream( // creates dataoutput stream
					socket.getOutputStream());
			
		}
		catch(UnknownHostException u) { // error handling for client exchange
			System.out.println(u);
		}
		catch(IOException i){ // error handling for client exchange
			System.out.println(i);
		}
		
		String line = "";
		while(!line.equals("end")) { // while program runs, read for line end, when found it will initalize a TCP flag FIN
			// THIS WILL GRACEFULY EXIT PROGRAM, no RST handle used.
			try {
				//line = data_input.readLine(); //deprecated read line function
				line = data_input_new.readLine(); // New datainput readline to replace old datainput
				data_output.writeUTF(line); // UTF output
			}
			catch(IOException i){ // catching errors due to IOExec
				System.out.println(i);
			}
		}
		try {
			data_input_new.close(); // Closes all sockets on error handle or RST TMP with new BufferedRead
			//data_input.close(); // closes all sockets on error handle or RST TMP
			data_output.close();
			socket.close();
			
		}
		catch(IOException i) { // error handling
			System.out.println(i);
		}
		
		
	}
	

public static void main(String [] args) { // static main function
	ClientSide client // use of client side too init object with attributed of IP and port
		= new ClientSide("127.0.0.1",6070); // PORT MUST BE SAME ON RECEIVING SERVER
}}
