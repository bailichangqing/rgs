package RGS_multiplayers;

import java.io.*;
import java.net.*;
import java.util.Date;

public class socketclient {
	
	public static void main(String[] args) throws IOException
	{

		//ServerSocket listener = new ServerSocket(4444);
		ServerSocket listener = null;
        try {	
        	listener = new ServerSocket(4444);
                Socket socket = listener.accept();
                try {
                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } finally {
                    socket.close();
                }
        }
        finally 
        {
        	if(listener != null)
        	{
        		listener.close();
        	}
        }
	}
}
