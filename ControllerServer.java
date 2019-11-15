import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ControllerServer {

	public static void main(String[] args) {
		try {
			
			
			
			ServerSocket serverSocket = new ServerSocket(6675);
			
			System.out.println("Server has started running");
			
			Socket client = serverSocket.accept();
			
			System.out.println("client accepted");
			
			PrintWriter printWriter = new PrintWriter(client.getOutputStream());
			
			//Robot robot = new Robot();
			
			while(true) {
				Point cursor = MouseInfo.getPointerInfo().getLocation();
				
				int x = cursor.x;
				int y = cursor.y;
				
				x*=3;
				y*=3;
				
				String cordinfo = x + "," + y;
				
				printWriter.println(cordinfo);
				printWriter.flush();
				Thread.sleep(1);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
