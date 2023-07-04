package tcptextprocessingclient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This function initiates the client's word count interface and handles the server connection.
 * 
 * @author Syazwina
 *
 */

public class ClientWordCountApplication {

	
	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		// Launch client-side frame
		ClientWordCountFrame clientWordCountFrame = new ClientWordCountFrame();
		clientWordCountFrame.setVisible(true);
		
		// 1. Connect to the server
		// remote machine @ localhost, port 1234
		Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
		
		// Update the status of the connection
		clientWordCountFrame.updateConnectionStatus(socket.isConnected());
		
		// 2. Send request to server, request is made by default
		// 3. Accept response from the server - read from network
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		
		// Display the word count of the text
		String wordCountNumber = bufferedReader.readLine();
		
		// 4. Process the response - display on the front end
		clientWordCountFrame.updateServerWordCount(wordCountNumber);
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}

}