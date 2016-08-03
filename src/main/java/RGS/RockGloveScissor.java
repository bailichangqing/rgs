package RGS;

import java.util.ArrayList;

public enum RockGloveScissor {
	Rock{
		public String toString(){
			return "Rock";
		}
	},
	Glove{
		public String toString(){
			return "Glove";
		}
	},
	Scissor{
		public String toString(){
			return "Scissor";
		}
	},
	Nothing{
		public String toString(){
			return "nothing";
		}
	};
	
	public static int judge(RockGloveScissor r1,RockGloveScissor r2)
	{
		//return -1 if r1 == r2
		//return 0 if r1 win
		//return 1 if r2 win
		if (r1 == r2)
		{
			return 0;
		}
		else if (r1 == Rock && r2 == Scissor || r1 == Glove && r2 == Rock || r1 == Scissor && r2 == Glove || r1 != Nothing && r2 == Nothing)
		{
			return 1;
		}
		else 
		{
			return -1;
		}	
	}
	public static ArrayList<Integer> judge(ArrayList<RockGloveScissor> gesturelist)
	{
		//check if mix
		int mixflag = 0;
		int nothingflag = 0;
		ArrayList<Integer> winnerR = new ArrayList<Integer>();
		ArrayList<Integer> winnerG = new ArrayList<Integer>();
		ArrayList<Integer> winnerS = new ArrayList<Integer>();
		
		for(int i = 0;i < gesturelist.size();i++)
		{
			if(gesturelist.get(i) == RockGloveScissor.Rock)
			{
				mixflag |= 1;
				winnerR.add(i);
			}
			if(gesturelist.get(i) == RockGloveScissor.Glove)
			{
				mixflag |= 2;
				winnerG.add(i);
			}
			if(gesturelist.get(i) == RockGloveScissor.Scissor)
			{
				mixflag |= 4;
				winnerS.add(i);
			}
			if(gesturelist.get(i) == RockGloveScissor.Nothing)
			{
				nothingflag = 1;
			}
		}
		if(mixflag == 7)
		{
			return new ArrayList<Integer>();
		}
		else if(mixflag == 6)
		{
			return winnerS;
		}
		else if(mixflag == 5)
		{
			return winnerR;
		}
		else if(mixflag == 3)
		{
			return winnerG;
		}
		if(nothingflag == 1)
		{
			if(mixflag == 1)
			{
				return winnerR;
			}
			if(mixflag == 2)
			{
				return winnerG;
			}
			if(mixflag == 4)
			{
				return winnerS;
			}
		}
		return new ArrayList<Integer>();
	}
	public static void main(String[] args)
	{
		ArrayList<RockGloveScissor> al = new ArrayList<RockGloveScissor>();
		al.add(RockGloveScissor.Scissor);
		al.add(RockGloveScissor.Rock);
		al.add(RockGloveScissor.Nothing);
		ArrayList<Integer>rs = RockGloveScissor.judge(al);
		for(int i = 0;i < rs.size();i++)
		{
			System.out.println(rs.get(i));
		}
	}
}
