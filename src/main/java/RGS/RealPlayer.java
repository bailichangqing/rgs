package RGS;

import java.util.Scanner;
import java.lang.*;

public class RealPlayer implements Player,Runnable  {
	public RockGloveScissor mygesture;
	@Override
	public RockGloveScissor getguesture()
	{
		return mygesture;
	}
	
	@Override
	public void setguesture(RockGloveScissor g)
	{
		mygesture = g;
	}
	
	@Override
	public void run()
	{
		askforRGS();
	}

	@Override
	public RockGloveScissor askforRGS()
	{
		Scanner input_scanner = new	Scanner(System.in);
		RockGloveScissor gesture = null;
		while(gesture == null)
		{
			System.out.println("plz enter your gesture: r stands for rock,g stands for glove,s stands for scissor");
			String gesturecode = input_scanner.nextLine();
			switch (gesturecode){
			case "r":
				gesture = RockGloveScissor.Rock;
				break;
			case "g":
				gesture = RockGloveScissor.Glove;
				break;
			case "s":
				gesture = RockGloveScissor.Scissor;
				break;
			
			}
			if(gesture == null)
			{
				System.out.println("null gesture");
			}
		}
		//input_scanner.close();
		mygesture = gesture;
		return gesture;
	}

	public static void main(String[] args){
		RealPlayer rp = new RealPlayer();
		RockGloveScissor r = rp.askforRGS();
		System.out.println(r);
	}
}
