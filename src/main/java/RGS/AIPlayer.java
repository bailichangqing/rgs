package RGS;

import java.util.Random;
import java.lang.*;

public class AIPlayer implements Player,Runnable {
	public RockGloveScissor myguesture;
	@Override
	public RockGloveScissor getguesture()
	{
		return myguesture;
	}
	@Override
	public void setguesture(RockGloveScissor g)
	{
		myguesture = g;
	}
	@Override
	public void run()
	{
		askforRGS();
	}

	@Override
	public RockGloveScissor askforRGS() {
		Random rand = new Random();
		RockGloveScissor gesture = null;
		int result = rand.nextInt(3);
		switch(result){
		case 0:
			gesture = RockGloveScissor.Rock;
			break;
		case 1:
			gesture = RockGloveScissor.Glove;
			break;
		case 2:
			gesture = RockGloveScissor.Scissor;
			break;
		default:
			gesture = RockGloveScissor.Rock;
			break;
		}
		myguesture = gesture;
		return gesture;
	}
}
