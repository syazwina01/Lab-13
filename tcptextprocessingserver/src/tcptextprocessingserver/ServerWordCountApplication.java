package tcptextprocessingserver;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class launch the server side application using TCP.
 * The server will handle request and process the word count.
 * The server will send the word count to every client
 * 
 * @author Syazwina
 *
 */

public class ServerWordCountApplication {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerWordCountFrame svFrame = new ServerWordCountFrame();
		svFrame.setVisible(true);
		
		// 1. Binding to a port number, 1234 that enables for connection
		int portNo = 1234;
		
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		WordCountGenerator wordGenerator = new WordCountGenerator();
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		
		// 2. Listen continuously for request of connection
		// Server needs to be alive forever in unterminated while loop
		while (true) {
			
			// Message to indicate server is alive
			svFrame.updateServerStatus(false);
			
			// 3. Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// 4. Process request
			// Generate word count for a text
			int output = wordGenerator.getWordCount();
			
			// 5. Respond to the client
			// code: clientSocket.getOutputStream()
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			// Send word count back to the client
			outputStream.writeBytes(String.valueOf(output));
			
			// Close the socket
			clientSocket.close();
		
			// Update the request status
			svFrame.updateRequestStatus(
					"Data sent to the client: " + output);
			svFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
		
		

	}

}