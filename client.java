import java.net.*;
import java.io.*;
public class Client {
				private static Socket socket;
				public static void main (String args []) {
				try {
					String host="localhost";
					int port=25000;
					//InetAddress address=InetAddress.getByName (host);
					socket = new Socket (address, port);
					OutputStream os=socket.getOutputStream ();
					OutputStreamWriter osw=new OutputStreamWriter (os);
					BufferedWriter bw =new BufferedWriter (osw);
					String msg="HEllo from client";
					String sendMsg=msg+"\n";
					bw.write (sendMsg);
					bw.flush ();
					System.out.println ("msg sent to the server:"+sendMsg);
					InputStream is=socket.getInputStream ();
					InputStreamReader isr=new InputStreamReader (is);
					BufferedReader br=new BufferedReader (isr);
					String mesg=br.readLine ();
					System.out.println ("msg received from the server:"+mesg);
				}
				catch (Exception exception) {
						exception.printStackTrace();
				}
				finally{
						try{
							socket.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}
}
