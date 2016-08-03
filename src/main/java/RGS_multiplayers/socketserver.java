package RGS_multiplayers;
import java.io.*;
import java.net.*;

public class socketserver 
{
	
	public static void main(String[] args) throws IOException
	{
        String serverAddress = "localhost";
        Socket s = new Socket(serverAddress, 4444);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        System.out.println(answer);
        s.close();
	}
}
