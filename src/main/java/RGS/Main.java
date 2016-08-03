package RGS;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RealPlayer rp = new RealPlayer();
		AIPlayer ap = new AIPlayer();
		RGSfeatureFeature rf = new RGSfeatureFeature(rp,ap);
		rf.sendEvent(new Init());
	}
}
