package RGS_multiplayers;
import java.util.HashMap;

import RGS.*;


public class mpmain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RealPlayer rp = new RealPlayer();
		AIPlayer ap = new AIPlayer();
		RGS_multiplayersFeature rf = new RGS_multiplayersFeature(rp,ap);
		rf.sendEvent(new Init());
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
	}
}
