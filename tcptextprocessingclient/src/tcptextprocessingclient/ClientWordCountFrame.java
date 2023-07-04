package tcptextprocessingclient;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represent the GUI window for the client side TCP application.
 * It display the word count that is retrieved rom the server side.
 * 
 * @author Syazwina 
 *
 */
public class ClientWordCountFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	// Private frame components
	private JLabel lblServerCount;
	private JLabel lblStatusValue;
	
	// Private attributes for frame size
	private int width = 700;
	private int height = 200;


	/**
	 * The constructor that initialize and organize the Swing components on 
	 * the frame.
	 */
	public ClientWordCountFrame () {
		
		// Default frame setting
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Word Count Application: Client Side");
		this.setSize(width, height);
		
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		// Initialize default value for label
		lblServerCount = new JLabel("-");
		lblStatusValue = new JLabel("-");
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
		
	}
	
	
	/**
	 * This method update the value of word count on the frame
	 * 
	 * @param serverWordCount: Server's word count
	 */
	public void updateServerWordCount (String serverWordCount) {
		
		this.lblServerCount.setText(serverWordCount);
		
	}
	
	/**
	 * This method update the status of connection to the server.
	 * 
	 * @param connStatus: Connection status (true/false)
	 * 
	 */
	public void updateConnectionStatus (boolean connStatus) {
		

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";
		
				
		// Update the status on frame
		this.lblStatusValue.setText(status);
	}
	
	/**
	 * This method creates and arrange Swing components to display status of 
	 * client's connection to the server.
	 * 
	 * @param font
	 * @return Swing components organized in a panel.
	 */
	private JPanel getConnectionStatusPanel(Font font) {
		
		// Create component
		JPanel panel = new JPanel();
		JLabel ConnStatus = new JLabel ("Connection status: ");
		
		// Style the component
		ConnStatus.setFont(font);
		ConnStatus.setFont(font);
		ConnStatus.setBackground(Color.WHITE);
		ConnStatus.setOpaque(true);
		ConnStatus.setBackground(Color.WHITE);
		ConnStatus.setOpaque(true);
		
		// Organize components into panel
		panel.add(ConnStatus);
		panel.add(ConnStatus);
		
		return panel;
		
	}
	
	/**
	 * This method creates and arrange Swing components to word count obtained from 
	 * the server.
 	 *
	 * @param font
	 * @return Swing components organized in panel
	 */
	private JPanel getServerWordCountPanel(Font font) {
		
		// Create component to display word count retrieve from the server
		JPanel panel = new JPanel();
		JLabel Count = new JLabel ("Word Count (from Server): ");

		// Style the component
		Count.setFont(font);
		lblServerCount.setFont(font);
		Count.setBackground(Color.WHITE);
		Count.setOpaque(true);
		lblServerCount.setBackground(Color.WHITE);
		lblServerCount.setOpaque(true);

		// Organize components into panel
		panel.add(Count);
		panel.add(lblServerCount);
		
		return panel;
	} 
	
	
	/**
	 * This method arrange the Swing components on the frame.
	 */
	private void loadComponent() {
		
		// Get font
		Font font = this.getFontStyle();
		
		// Get server status's panel and add to frame
		JPanel northPanel = this.getConnectionStatusPanel(font);		
		this.add(northPanel, BorderLayout.NORTH);
		
		// Get server word count panel and add to frame
		JPanel center = getServerWordCountPanel(font);
		this.add(center, BorderLayout.CENTER);
		
	}
	
	
	/**
	 * This method define a font to a generic style.
	 * 
	 * @return font object
	 */
	private Font getFontStyle() {
		
		Font font = new Font ("Serif", Font.PLAIN, 30);
		
		return font;
		
	}
	
	
	
	
	
}