package RGS_timer;

import RGS.*;
import RGS_history.RGS_historyfeatureFeature;

public class historymain 
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		RealPlayer rp = new RealPlayer();
		AIPlayer ap = new AIPlayer();
		RGS_timerfeatureFeature rf = new RGS_timerfeatureFeature(rp,ap);
		rf.sendEvent(new Init());
	}
}
