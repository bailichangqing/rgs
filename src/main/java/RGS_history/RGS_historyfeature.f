package RGS_history;
import RGS.*;
import external.*;
import java.io.*;
import java.util.*;

feature RGS_historyfeature{
	domain:RGS;
	anchor:RGSfeature;
	straightPrecedence(RGS_historyfeature,RGSfeature);
	String historyPath = "C:\\Users\\conghao\\Desktop\\svn\\Samples\\src\\main\\java\\RGS_history\\history.txt";
	
	String history;
	Scanner scan;
	viewHistory
	{
		condition: state.equalsToConstant(State.Init);
		event: leave;
		{
			System.out.println("Do you want to view history? y:yes n:no");
			Scanner input_scanner = new Scanner(System.in);
			String answer = input_scanner.nextLine();
			if(answer.equals("y"))
			{
				history = "";
				try
				{
					scan = new Scanner(new File(historyPath));
	    			while(scan.hasNextLine())
	    			{
	        			history += scan.nextLine();
	    			}
	    			scan.close();
	    			System.out.println(history);
	    		}
	    		catch(FileNotFoundException fnfe)
	    		{
	    			System.out.println("file not found");
	    		}
    		}
		}
	}
	PrintWriter out;
	storeHistory
	{
		condition:state.equalsToConstant(State.Judge);
		event:leave;
		{
			out = null;
			try 
			{
				out = new PrintWriter(new BufferedWriter(new FileWriter(historyPath, true)));
				out.println(realPlayer.getguesture().toString());
			}
			catch (IOException ioe) 
			{
				System.err.println(ioe);
			}
			finally
			{
				if(out != null)
				{
					out.close();
				}
			}		
		}
	}
}