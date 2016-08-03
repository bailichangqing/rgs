package RGS_timer;
import RGS.*;
import external.*;
import java.io.*;
import java.util.*;

feature RGS_timerfeature
{
	domain:RGS;
	anchor:RGSfeature;
	straightPrecedence(RGS_timerfeature,RGSfeature);
	
	long starttime;
	long endtime;
	
	settimer
	{
		condition: state.equalsToConstant(State.PrepareGesture);
		event: enter;
		{
			System.out.println("plz make your decision within 3 seconds,otherwise you will lose");
			starttime = new Date().getTime();
		}
	}
	
	checktimer
	{
		condition: state.equalsToConstant(State.PrepareGesture);
		event: leave;
		{
			endtime = new Date().getTime();
			if(endtime - starttime >= 3000)
			{
				realPlayer.setguesture(RockGloveScissor.Nothing);
			}
		}
	}
}