import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String args[]){
		
		try {
			
			JOptionPane.showMessageDialog(null, "CONNECTING TO SERVER");
			
			Socket socket = new Socket("192.168.0.19", 6675);
			
			Scanner listener = new Scanner(socket.getInputStream());
			
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
