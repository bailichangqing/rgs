package RGS_multiplayers;

import RGS.*;
import ddt.lang.*;
import external.*;
import java.io.*;
import java.net.*;
import java.util.*;

feature RGS_multiplayers
{
	domain:RGS;
	anchor:RGSfeature;
	straightPrecedence(RGS_multiplayers,RGSfeature);
	
	String id;
	int gamemode;
	HashMap<Integer,String> idmap;
	int playercount;
	ArrayList<Socket> clientsocketlist;
	ArrayList<RockGloveScissor> glist;
	int serverclientflag;
	Socket clientsocket;
	
	ServerSocket ss;
	Socket is;
	PrintWriter pw;
	BufferedReader in;
	Socket tmpsocket;
	PrintWriter out;
	Iterator<Socket> si;
	
	String inplayername;
	
	choosegamemode
	{
		condition: state.equalsToConstant(State.Init);
		event: leave;
		{
			System.out.println("do you want to play with other players? y:yes n:no");
			Scanner input_scanner = new Scanner(System.in);
			String answer = input_scanner.nextLine();
			if(answer.equals("y"))
			{
				//play with other players
				gamemode = 1;
				//idmap = new HashMap<Integer,String>();
				playercount = 1;
				System.out.println("set your name");
				id = input_scanner.nextLine();
				
				//idmap.put(0,id);
				
				System.out.println("do you want to host a game or join a game? 0:host 1:join");
				answer = input_scanner.nextLine();
				if(answer.equals("0"))
				{
					//server mode
					serverclientflag = 0;
					ss = null;
					clientsocketlist = new ArrayList<Socket>();
					ss = new ServerSocket(9090);
					//do
					//{
						System.out.println("wait for another player");
						is = ss.accept();
						clientsocketlist.add(is);
						in = new BufferedReader(new InputStreamReader(is.getInputStream()));
						inplayername = in.readLine();
						//idmap.put(playercount,inplayername);
						//playercount += 1;
						System.out.println(inplayername + " is ready do you want to start game? y:yes n:no");
						answer = input_scanner.nextLine();
					//}
					while(!answer.equals("y"))
					{
						System.out.println("wait for another player");
						is = ss.accept();
						clientsocketlist.add(is);
						in = new BufferedReader(new InputStreamReader(is.getInputStream()));
						inplayername = in.readLine();
						//idmap.put(playercount,inplayername);
						//playercount += 1;
						System.out.println(inplayername + " is ready do you want to start game? y:yes n:no");
						answer = input_scanner.nextLine();
					}
					//start game
					si = clientsocketlist.iterator();
					while(si.hasNext())
					{
						tmpsocket = si.next();
						pw = new PrintWriter(tmpsocket.getOutputStream(),true);
						pw.println("go");
						System.out.println("done go");
					}
				}
				else
				{
					//client mode
					serverclientflag = 1;
					clientsocket = new Socket("localhost",9090);
					out = new PrintWriter(clientsocket.getOutputStream(),true);
					in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
					out.println(id);
					String start = in.readLine();
					System.out.println("prepare gusture");
				}
			}
			else
			{
				//play with AI
				gamemode = 0;
			}
		}
	}
	BufferedReader br;
	String gesture;
	Socket tmp;
	preparejudge
	{
		condition: state.equalsToConstant(State.PrepareGesture);
		event: leave;
		{
			if(gamemode == 1)
			{
				System.out.println("enter pj");
				if(serverclientflag == 0)
				{
					//server
					glist = new ArrayList<RockGloveScissor>();
					glist.add(realPlayer.getguesture());
					si = clientsocketlist.iterator();
					while(si.hasNext())
					{
						tmp = si.next();
						br = new BufferedReader(new InputStreamReader(tmp.getInputStream()));
						gesture = br.readLine();
						if(gesture.equals("Rock"))
						{
							glist.add(RockGloveScissor.Rock);
						}
						else if(gesture.equals("Glove"))
						{
							glist.add(RockGloveScissor.Glove);
						}
						else if(gesture.equals("Scissor"))
						{
							glist.add(RockGloveScissor.Scissor);
						}
						else
						{
							glist.add(RockGloveScissor.Nothing);
						}
					}
				}
				else
				{
					//client
					pw = new PrintWriter(clientsocket.getOutputStream(),true);
					pw.println(realPlayer.getguesture().toString());
				}
			}
		}
	}
	String gameresult;
	Iterator<Integer> winneriterator;
	Iterator<RockGloveScissor> rgsi;
	RockGloveScissor rgstmp;
	multiplayersjudge
	{
		condition: state.equalsToConstant(State.Judge);
		event: enter;
		{
			when(gamemode == 1)priorityPrecedence(RGS_multiplayers,RGSfeature);
			{
				System.out.println("enter judge");
				

				if(serverclientflag == 0)
				{
					//server 
				
					gameresult = "";
					
					ArrayList<Integer> winners = RockGloveScissor.judge(glist);
					if(winners.size() == 0)
					{
						System.out.println("draw");
					}
					else
					{
						System.out.print("winners are: ");
						winneriterator = winners.iterator();
						while(winneriterator.hasNext())
						{
							System.out.print(winneriterator.next());
						}
						System.out.print("\n");
					}
	
					//System.out.println(winners.size());
					
					/*
					gameresult += "winners are: ";
					winneriterator = winners.iterator();
					while(winneriterator.hasNext())
					{
						gameresult += idmap.get(winneriterator.next());
						gameresult += " ";
					}
					si = clientsocketlist.iterator();
					while(si.hasNext())
					{
						tmp = si.next();
						pw = new PrintWriter(tmp.getOutputStream(),true);
						pw.println(gameresult);
					}
					*/
					
				}
				else
				{
					//client
					//gameresult = in.readLine();
				}
				//System.out.println(gameresult);
				state = State.AskforPlayAgain;
			}
		}
	}
	
}