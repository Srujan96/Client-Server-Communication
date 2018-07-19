import java.io.*;
import java.net.*;
public class Server{
	private static Socket socket;
	public static void main(String args[]){
		try{
			int port=25000;
			ServerSocket serverSocket=new ServerSocket(port);
			System.out.println("server started and listening to the port 25000");
			while (true) {
					socket =serverSocket.accept ();
					InputStream is=socket.getInputStream ();
					InputStreamReader isr=new InputStreamReader (is);
					BufferedReader br=new BufferedReader (isr);
					String num=br.readLine ();
					System.out.println ("msg received from the client is:"+ num);
					String retMsg="Hello from server";
					String sendretMsg=retMsg+"\n";
					OutputStream os=socket.getOutputStream ();
					OutputStreamWriter osw=new OutputStreamWriter (os);
					BufferedWriter bw =new BufferedWriter (osw);
					bw.write (sendretMsg);
					bw.flush ();
					System.out.println ("msg sent to the client:"+ retMsg);
					System.out.println ("\n process complete\n");
				}
			}
		catch (Exception e) {
				e.printStackTrace ();
		}
		finally {
				try {
					socket.close
					}
				catch (Exception e) {
					e.printStackTrace ();
				}
			}
	}
}