package RGS_history;

import RGS.*;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RealPlayer rp = new RealPlayer();
		AIPlayer ap = new AIPlayer();
		RGS_historyfeatureFeature rf = new RGS_historyfeatureFeature(rp,ap);
		rf.sendEvent(new Init());
	}

}
