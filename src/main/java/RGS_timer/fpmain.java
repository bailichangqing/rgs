package RGS_timer;

import RGS.AIPlayer;
import RGS.Init;
import RGS.RealPlayer;
import RGS_history.RGS_historyfeatureFeature;

public class fpmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RealPlayer rp = new RealPlayer();
		AIPlayer ap = new AIPlayer();
		mpfeaturesFeaturePackage rf = new mpfeaturesFeaturePackage(rp,ap);
		rf.sendEvent(new Init());
	}

}
