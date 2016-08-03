package RGS_timer;
import RGS.*;
import external.*;
import java.io.*;
import java.util.*;/**

 RGS**/

import java.io.Serializable;
import rmi.RMIService;
import java.lang.Cloneable;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class RGS_timerfeatureFeature
 extends RGSDomain implements Serializable 
{

RGSfeatureFeature _rgsfeaturefeature;
private boolean activated = true;
Map<String, Boolean> previousState = new HashMap<String, Boolean>();
private EventBuffer<FL_EVENT_STEM> sharedBuffer;

public EventBuffer<FL_EVENT_STEM> getSharedBuffer(){
return this.sharedBuffer;
}
public void activate() { activated = true; }
public void deactivate() { activated = false; }
public boolean isActivated() { return activated; }

public RGS_timerfeatureFeature(  Player  realPlayer ,   Player  aiPlayer) {
super();
RGSDomain.realPlayer = realPlayer;
RGSDomain.aiPlayer = aiPlayer;
RGSDomain.state = State  . Init;
{Map<String, Boolean>currentState= new HashMap<String, Boolean>(previousState);
currentState.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
currentState.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
currentState.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
previousState = new HashMap<String, Boolean>(currentState);}
this._rgsfeaturefeature = new RGSfeatureFeature();
sharedBuffer = new EventBuffer<FL_EVENT_STEM>();
ExecutorService threadExecuter = Executors.newCachedThreadPool();
Consumer consumer = new Consumer(sharedBuffer);
threadExecuter.execute(consumer);
}
class Consumer implements Runnable{
private EventBuffer<FL_EVENT_STEM> buffer;
public Consumer(EventBuffer<FL_EVENT_STEM> buffer){
this.buffer = buffer;
}
public void run() {
while(true){
try{
RGS_timerfeatureFeature.this.XEvent((FL_EVENT_STEM)buffer.remove());
}catch(Exception ex){
ex.printStackTrace();
}//end of catch
}//end of while
}//end of run
}//end of Consumer Class
public  RGS_timerfeatureFeature(RGSfeatureFeature _rgsfeaturefeature)
 {
super();
this._rgsfeaturefeature = _rgsfeaturefeature;
}
/***********************************/

 ;

 long starttime;

 long endtime;

 
         
           
 /**********************************/
public synchronized void settimer( FL_EVENT_STEM  e)
{
try { 
if (activated)
{
System . out . println ( "plz make your decision within 3 seconds,otherwise you will lose" ) ;
starttime = new Date ( ) . getTime ( ) ;
}

} 
finally {}
}


 
           
        
 
         
 
 /**********************************/
public synchronized void checktimer( FL_EVENT_STEM  e)
{
try { 
if (activated)
{
endtime = new Date ( ) . getTime ( ) ;
if ( endtime - starttime >= 3000 ) {
realPlayer . setguesture ( RockGloveScissor . Nothing ) ;
}
}

} 
finally {}
}


public void sendEvent( FL_EVENT_STEM e ) {
	sharedBuffer.add(e);
}
public synchronized void XEvent(final FL_EVENT_STEM e )
{
{Map<String, Boolean>currentState= new HashMap<String, Boolean>(previousState);
currentState.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
currentState.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
currentState.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
previousState = new HashMap<String, Boolean>(currentState);}

	if(activated) {
		if ( e instanceof Init) {
			{
			if (RGSDomain.state.equalsToConstant(State.Init))
			{if(true){ if((RGSDomain.state.equalsToConstant(State  . Init))) _rgsfeaturefeature.initialize((Init) e);
}else{/* no qualifier matched */}			}

else{/*no condition matched*/}
			}
			}
else{/* no event matched*/}
{Map<String, Boolean>currentState= new HashMap<String, Boolean>(previousState);
currentState.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
currentState.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
currentState.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
if(currentState.equals(previousState))return;}
boolean possibleEnter = true; boolean possibleLeave = true;
Map<String, Boolean> temp;
while(true){
boolean noLeaveEvent = true;
boolean noEnterEvent = true;
temp = new HashMap<String, Boolean>(previousState);
temp.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
temp.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
temp.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
if(possibleLeave)
			{
			if (previousState.get("rgsdomain.state.equalstoconstant(state.preparegesture)") && !(RGSDomain.state.equalsToConstant(State.PrepareGesture)))
			{				noLeaveEvent = false;if(true){ if(!(RGSDomain.state.equalsToConstant(State  . PrepareGesture))) this.checktimer(e);
}else{/* no qualifier matched */}			}

else{/*no condition matched*/}
			}
if(!noLeaveEvent){
Map<String, Boolean>temp2 = new HashMap<String, Boolean>(previousState);
temp2.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
temp2.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
temp2.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
if (!temp.equals(temp2)) {previousState = temp;possibleEnter = true;possibleLeave = true; }else{ possibleLeave = false;}
}
temp = new HashMap<String, Boolean>(previousState);
temp.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
temp.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
temp.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
if(possibleEnter)
			{
			if (!previousState.get("rgsdomain.state.equalstoconstant(state.preparegesture)")&&RGSDomain.state.equalsToConstant(State.PrepareGesture))
			{				noEnterEvent = false;if(true){ if((RGSDomain.state.equalsToConstant(State  . PrepareGesture))) this.settimer(e);
if(true){ if((RGSDomain.state.equalsToConstant(State  . PrepareGesture))) _rgsfeaturefeature.enterPrepareGesture(e);
}}else{/* no qualifier matched */}			}
			else if (!previousState.get("rgsdomain.state.equalstoconstant(state.askforplayagain)")&&RGSDomain.state.equalsToConstant(State.AskforPlayAgain))
			{				noEnterEvent = false;if(true){ if((RGSDomain.state.equalsToConstant(State  . AskforPlayAgain))) _rgsfeaturefeature.enterAskforPlayAgain(e);
}else{/* no qualifier matched */}			}
			else if (!previousState.get("rgsdomain.state.equalstoconstant(state.judge)")&&RGSDomain.state.equalsToConstant(State.Judge))
			{				noEnterEvent = false;if(true){ if((RGSDomain.state.equalsToConstant(State  . Judge))) _rgsfeaturefeature.enterJudge(e);
}else{/* no qualifier matched */}			}

else{/*no condition matched*/}
			}
if(!noEnterEvent){
Map<String, Boolean>temp2 = new HashMap<String, Boolean>(previousState);
temp2.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
temp2.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
temp2.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
previousState = temp;if (!temp.equals(temp2)) {possibleEnter = true;possibleLeave = true; }else{ possibleEnter = false;}
}
if(noLeaveEvent && noEnterEvent) break;
}
	}

}

public Object clone() throws CloneNotSupportedException {
return super.clone();
}


protected void finalize() {
try {
super.finalize();
} catch(Throwable e) {
// do nothing
}
}

//ProceedTo handlers
public ProceedToHandler _rgs_timerfeature_settimer_rgsdomain_state_equalstoconstant_state_preparegesture_enter_null_soft_binding_handler;
public ProceedToHandler _rgs_timerfeature_checktimer_rgsdomain_state_equalstoconstant_state_preparegesture_leave_null_soft_binding_handler;

}
/* IntermediateInfo:FeatureInteractionTable
rO0ABXNyACZjb3JlLnRhYmxlLkZlYXR1cmVJbnRlcmFjdGlvblRhYmxlSW1wbKRW9OnaNkzmAgAF
WgAQaXNGZWF0dXJlTmFtZVNldEwAEmRlZmF1bHRQcmVSZWxhdGlvbnQAKkxjb3JlL2NvbXBpbGVy
ZXNvdXJjZXMvUHJlY2VkZW5jZVJlbGF0aW9uO0wAB2RvbWFpbnN0AA9MamF2YS91dGlsL1NldDtM
AApldmVudE5vZGVzdAAoTGNvcmUvY29tcGlsZXJlc291cmNlcy9FdmVudE5vZGVNYXBJbXBsO0wA
C2ZlYXR1cmVOYW1ldAASTGphdmEvbGFuZy9TdHJpbmc7eHABc3IAKWNvcmUuY29kZWdlbmVyYXRv
ci5QcmVjZWRlbmNlUmVsYXRpb25JbXBspX7kJRXyFGoCAAFMAAlwcmVPcmRlcnN0ABNMamF2YS91
dGlsL0hhc2hTZXQ7eHIAJmNvcmUuY29kZWdlbmVyYXRvci5QYXJ0aWFsT3JkZXJpbmdUcmVl2diA
5Z4HBGACAAFMAAVub2Rlc3QAFUxqYXZhL3V0aWwvSGFzaHRhYmxlO3hwc3IAE2phdmEudXRpbC5I
YXNodGFibGUTuw8lIUrkuAMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAIdwgA
AAALAAAAAnQAClJHU2ZlYXR1cmVzcgAXY29yZS5jb2RlZ2VuZXJhdG9yLk5vZGU57IiELEUMtAIA
BUkAFGRpcmVjdFByZWRlY2Vzc29yTnVtWgAKd2FzVmlzaXRlZEwAD2RpcmVjdFN1Y2NOb2Rlc3EA
fgAJTAAFbGFiZWxxAH4ABEwAC3BhcmVudE5vZGVzcQB+AAd4cAAAAAEAc3EAfgALP0AAAAAAAAh3
CAAAAAsAAAAAeHEAfgANc3IAEWphdmEudXRpbC5IYXNoU2V0ukSFlZa4tzQDAAB4cHcMAAAAED9A
AAAAAAABc3EAfgAOAAAAAABzcQB+AAs/QAAAAAAACHcIAAAACwAAAAFxAH4AD3QAEnN0cmFpZ2h0
UHJlY2VkZW5jZXh0ABBSR1NfdGltZXJmZWF0dXJlc3EAfgARdwwAAAAQP0AAAAAAAAB4eHEAfgAW
cQB+ABN4c3EAfgARdwwAAAAQP0AAAAAAAAFzcgATamF2YS51dGlsLkFycmF5TGlzdHiB0h2Zx2Gd
AwABSQAEc2l6ZXhwAAAAAncEAAAAAnEAfgAWcQB+AA14eHNyABdqYXZhLnV0aWwuTGlua2VkSGFz
aFNldNhs11qV3SoeAgAAeHEAfgARdwwAAAAQP0AAAAAAAAF0AANSR1N4c3IAJmNvcmUuY29tcGls
ZXJlc291cmNlcy5FdmVudE5vZGVNYXBJbXBsaDut0E+PmIICAAFMAANtYXB0AA9MamF2YS91dGls
L01hcDt4cHNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAnQABWxlYXZlc3IAKmNvcmUuY29tcGlsZXJl
c291cmNlcy5RdWFsaWZpZXJOb2RlTWFwSW1wbOrz3H3Lq6S1AgABTAADbWFwcQB+AB94cHNxAH4A
Cz9AAAAAAAAIdwgAAAALAAAAAXQAA2FsbHNyACpjb3JlLmNvbXBpbGVyZXNvdXJjZXMuQ29uZGl0
aW9uTm9kZU1hcEltcGx3bBYqvueUaQIAAUwAA21hcHQAKExjb3JlL2NvbXBpbGVyZXNvdXJjZXMv
T3JkZXJlZEhhc2h0YWJsZTt4cHNyACZjb3JlLmNvbXBpbGVyZXNvdXJjZXMuT3JkZXJlZEhhc2h0
YWJsZXhkoN7SZCEwAgABTAAMa2V5T3JkZXJMaXN0dAAWTGphdmEvdXRpbC9MaW5rZWRMaXN0O3hx
AH4ACz9AAAAAAAAIdwgAAAALAAAAAXQAOVJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50
KFN0YXRlICAuIFByZXBhcmVHZXN0dXJlKXNyACVjb3JlLmNvbXBpbGVyZXNvdXJjZXMuRml0U3Vi
ZW50cnlUcmVlY5X89AsBiasCAANMAAhjaGlsZHJlbnQAEExqYXZhL3V0aWwvTGlzdDtMABFkZWZh
dWx0UHJlY2VkZW5jZXEAfgABTAADdmFsdAAjTGNvcmUvY29tcGlsZXJlc291cmNlcy9GaXRTdWJl
bnRyeTt4cHNyABRqYXZhLnV0aWwuTGlua2VkTGlzdAwpU11KYIgiAwAAeHB3BAAAAAFzcQB+AC5z
cQB+ADJ3BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4AEXcMAAAAED9A
AAAAAAAAeHNyACdjb3JlLmNvbXBpbGVyZXNvdXJjZXMuRml0UHVTdWJlbnRyeUltcGzJ6iM7PuYT
mgIAAUwAA21hcHEAfgAfeHIAJWNvcmUuY29tcGlsZXJlc291cmNlcy5GaXRTdWJlbnRyeUltcGzq
OTCcd/Uh5wIABkwAEGZlYXR1cmVOYW1lRW50cnlxAH4ABEwAC3ByZVJlbGF0aW9ucQB+AAFMABBw
cm9ncmFtQm9keUVudHJ5cQB+AARMABBwcm9ncmFtQ29uZGl0aW9ucQB+AARMABRwcm9ncmFtVW5p
dE5hbWVFbnRyeXEAfgAETAANd2hlbkNvbmRpdGlvbnQAH0xjb3JlL2xhbmcvQ29uZGl0aW9uRXhw
cmVzc2lvbjt4cHQAEFJHU190aW1lcmZlYXR1cmVzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAA
AAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4dACWICAgZW5kdGltZSAgPSAgbmV3IERhdGUgICAoKSAg
ICAuIGdldFRpbWUgKCkgOyBpZiAoIGVuZHRpbWUgIC0gc3RhcnR0aW1lICA+PSAzMDAwICkgeyAg
ICByZWFsUGxheWVyICAuIHNldGd1ZXN0dXJlIChSb2NrR2xvdmVTY2lzc29yICAuIE5vdGhpbmcp
ICA7IH0gcQB+AC10AApjaGVja3RpbWVyc3IAHWNvcmUubGFuZy5Db25kaXRpb25FeHByZXNzaW9u
iIriGx69VJQCAARaAAhuZWdhdGl2ZUwABWNoaWxkcQB+ADtMAARuZXh0cQB+ADtMAANzdHJxAH4A
BHhwAHBwdAAEdHJ1ZXNyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3Rv
ckkACXRocmVzaG9sZHhwP0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZzcQB+AAs/QAAAAAAACHcI
AAAACwAAAAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4cHhzcQB+ADJ3BAAAAAFxAH4ALXh4dAAFZW50
ZXJzcQB+ACNzcQB+AAs/QAAAAAAACHcIAAAACwAAAAFxAH4AJnNxAH4AJ3NxAH4AKj9AAAAAAAAI
dwgAAAALAAAAAXQAOVJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIFBy
ZXBhcmVHZXN0dXJlKXNxAH4ALnNxAH4AMncEAAAAAXNxAH4ALnNxAH4AMncEAAAAAHhzcQB+AAZz
cQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4c3EAfgA5cQB+AD1z
cQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4dACSICAg
U3lzdGVtICAuIG91dCAgLiBwcmludGxuICgicGx6IG1ha2UgeW91ciBkZWNpc2lvbiB3aXRoaW4g
MyBzZWNvbmRzLG90aGVyd2lzZSB5b3Ugd2lsbCBsb3NlIikgIDsgICBzdGFydHRpbWUgID0gIG5l
dyBEYXRlICAgKCkgICAgLiBnZXRUaW1lICgpIDtxAH4AUXQACHNldHRpbWVyc3EAfgBDAHBwcQB+
AEVzcQB+AEY/QAAAAAAAAHcIAAAAEAAAAAB4eHNxAH4ABnNxAH4ACz9AAAAAAAAIdwgAAAALAAAA
AHhzcQB+ABF3DAAAABA/QAAAAAAAAHhweHNxAH4AMncEAAAAAXEAfgBReHh4cQB+AD0=

*/


/* IntermediateInfo:MergedFeatureInteractionTable
rO0ABXNyACZjb3JlLnRhYmxlLkZlYXR1cmVJbnRlcmFjdGlvblRhYmxlSW1wbKRW9OnaNkzmAgAF
WgAQaXNGZWF0dXJlTmFtZVNldEwAEmRlZmF1bHRQcmVSZWxhdGlvbnQAKkxjb3JlL2NvbXBpbGVy
ZXNvdXJjZXMvUHJlY2VkZW5jZVJlbGF0aW9uO0wAB2RvbWFpbnN0AA9MamF2YS91dGlsL1NldDtM
AApldmVudE5vZGVzdAAoTGNvcmUvY29tcGlsZXJlc291cmNlcy9FdmVudE5vZGVNYXBJbXBsO0wA
C2ZlYXR1cmVOYW1ldAASTGphdmEvbGFuZy9TdHJpbmc7eHABc3IAKWNvcmUuY29kZWdlbmVyYXRv
ci5QcmVjZWRlbmNlUmVsYXRpb25JbXBspX7kJRXyFGoCAAFMAAlwcmVPcmRlcnN0ABNMamF2YS91
dGlsL0hhc2hTZXQ7eHIAJmNvcmUuY29kZWdlbmVyYXRvci5QYXJ0aWFsT3JkZXJpbmdUcmVl2diA
5Z4HBGACAAFMAAVub2Rlc3QAFUxqYXZhL3V0aWwvSGFzaHRhYmxlO3hwc3IAE2phdmEudXRpbC5I
YXNodGFibGUTuw8lIUrkuAMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAIdwgA
AAALAAAAAnQAClJHU2ZlYXR1cmVzcgAXY29yZS5jb2RlZ2VuZXJhdG9yLk5vZGU57IiELEUMtAIA
BUkAFGRpcmVjdFByZWRlY2Vzc29yTnVtWgAKd2FzVmlzaXRlZEwAD2RpcmVjdFN1Y2NOb2Rlc3EA
fgAJTAAFbGFiZWxxAH4ABEwAC3BhcmVudE5vZGVzcQB+AAd4cAAAAAEAc3EAfgALP0AAAAAAAAh3
CAAAAAsAAAAAeHEAfgANc3IAEWphdmEudXRpbC5IYXNoU2V0ukSFlZa4tzQDAAB4cHcMAAAAED9A
AAAAAAABc3EAfgAOAAAAAABzcQB+AAs/QAAAAAAACHcIAAAACwAAAAFxAH4AD3QAEnN0cmFpZ2h0
UHJlY2VkZW5jZXh0ABBSR1NfdGltZXJmZWF0dXJlc3EAfgARdwwAAAAQP0AAAAAAAAB4eHEAfgAW
cQB+ABN4c3EAfgARdwwAAAAQP0AAAAAAAAFzcgATamF2YS51dGlsLkFycmF5TGlzdHiB0h2Zx2Gd
AwABSQAEc2l6ZXhwAAAAAncEAAAAAnEAfgAWcQB+AA14eHNyABdqYXZhLnV0aWwuTGlua2VkSGFz
aFNldNhs11qV3SoeAgAAeHEAfgARdwwAAAAQP0AAAAAAAAF0AANSR1N4c3IAJmNvcmUuY29tcGls
ZXJlc291cmNlcy5FdmVudE5vZGVNYXBJbXBsaDut0E+PmIICAAFMAANtYXB0AA9MamF2YS91dGls
L01hcDt4cHNxAH4ACz9AAAAAAAAIdwgAAAALAAAAA3QABWxlYXZlc3IAKmNvcmUuY29tcGlsZXJl
c291cmNlcy5RdWFsaWZpZXJOb2RlTWFwSW1wbOrz3H3Lq6S1AgABTAADbWFwcQB+AB94cHNxAH4A
Cz9AAAAAAAAIdwgAAAALAAAAAXQAA2FsbHNyACpjb3JlLmNvbXBpbGVyZXNvdXJjZXMuQ29uZGl0
aW9uTm9kZU1hcEltcGx3bBYqvueUaQIAAUwAA21hcHQAKExjb3JlL2NvbXBpbGVyZXNvdXJjZXMv
T3JkZXJlZEhhc2h0YWJsZTt4cHNyACZjb3JlLmNvbXBpbGVyZXNvdXJjZXMuT3JkZXJlZEhhc2h0
YWJsZXhkoN7SZCEwAgABTAAMa2V5T3JkZXJMaXN0dAAWTGphdmEvdXRpbC9MaW5rZWRMaXN0O3hx
AH4ACz9AAAAAAAAIdwgAAAALAAAAAXQASlJHU190aW1lcmZlYXR1cmUuUkdTRG9tYWluLnN0YXRl
LmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gUHJlcGFyZUdlc3R1cmUpc3IAJWNvcmUuY29tcGls
ZXJlc291cmNlcy5GaXRTdWJlbnRyeVRyZWVjlfz0CwGJqwIAA0wACGNoaWxkcmVudAAQTGphdmEv
dXRpbC9MaXN0O0wAEWRlZmF1bHRQcmVjZWRlbmNlcQB+AAFMAAN2YWx0ACNMY29yZS9jb21waWxl
cmVzb3VyY2VzL0ZpdFN1YmVudHJ5O3hwc3IAFGphdmEudXRpbC5MaW5rZWRMaXN0DClTXUpgiCID
AAB4cHcEAAAAAXNxAH4ALnNxAH4AMncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAA
AAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4c3IAJ2NvcmUuY29tcGlsZXJlc291cmNlcy5GaXRQdVN1
YmVudHJ5SW1wbMnqIzs+5hOaAgABTAADbWFwcQB+AB94cgAlY29yZS5jb21waWxlcmVzb3VyY2Vz
LkZpdFN1YmVudHJ5SW1wbOo5MJx39SHnAgAGTAAQZmVhdHVyZU5hbWVFbnRyeXEAfgAETAALcHJl
UmVsYXRpb25xAH4AAUwAEHByb2dyYW1Cb2R5RW50cnlxAH4ABEwAEHByb2dyYW1Db25kaXRpb25x
AH4ABEwAFHByb2dyYW1Vbml0TmFtZUVudHJ5cQB+AARMAA13aGVuQ29uZGl0aW9udAAfTGNvcmUv
bGFuZy9Db25kaXRpb25FeHByZXNzaW9uO3hwdAAQUkdTX3RpbWVyZmVhdHVyZXNxAH4ABnNxAH4A
Cz9AAAAAAAAIdwgAAAALAAAAAHhzcQB+ABF3DAAAABA/QAAAAAAAAHh0AJYgICBlbmR0aW1lICA9
ICBuZXcgRGF0ZSAgICgpICAgIC4gZ2V0VGltZSAoKSA7IGlmICggZW5kdGltZSAgLSBzdGFydHRp
bWUgID49IDMwMDAgKSB7ICAgIHJlYWxQbGF5ZXIgIC4gc2V0Z3Vlc3R1cmUgKFJvY2tHbG92ZVNj
aXNzb3IgIC4gTm90aGluZykgIDsgfSB0ADlSR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFu
dChTdGF0ZSAgLiBQcmVwYXJlR2VzdHVyZSl0AApjaGVja3RpbWVyc3IAHWNvcmUubGFuZy5Db25k
aXRpb25FeHByZXNzaW9uiIriGx69VJQCAARaAAhuZWdhdGl2ZUwABWNoaWxkcQB+ADtMAARuZXh0
cQB+ADtMAANzdHJxAH4ABHhwAHBwdAAEdHJ1ZXNyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDR
AwACRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZHhwP0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZz
cQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4cHhzcQB+ADJ3BAAA
AAFxAH4ALXh4dAAIckdTLkluaXRzcQB+ACNzcQB+AAs/QAAAAAAACHcIAAAACwAAAAF0AANhbGxz
cQB+ACdzcQB+ACo/QAAAAAAACHcIAAAACwAAAAF0ADpSR1NmZWF0dXJlLlJHU0RvbWFpbi5zdGF0
ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEluaXQpc3EAfgAuc3EAfgAydwQAAAABc3EAfgAu
c3EAfgAydwQAAAAAeHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAAAHhzcQB+ABF3DAAAAAE/
QAAAAAAAAHhzcQB+ADl0AApSR1NmZWF0dXJlc3EAfgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAA
eHNxAH4AEXcMAAAAAT9AAAAAAAAAeHQAUyAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoImdh
bWUgYmVnaW5zIikgIDsgICBzdGF0ZSAgPSBTdGF0ZSAgLiBQcmVwYXJlR2VzdHVyZSA7dAAvUkdT
RG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gSW5pdCl0AAppbml0aWFsaXpl
c3EAfgBEAHBwdAAEdHJ1ZXNxAH4ARz9AAAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AA
AAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAAeHB4c3EAfgAydwQAAAABcQB+AFN4
eHQABWVudGVyc3EAfgAjc3EAfgALP0AAAAAAAAh3CAAAAAsAAAABcQB+ACZzcQB+ACdzcQB+ACo/
QAAAAAAACHcIAAAACwAAAAV0AJBSR1NfdGltZXJmZWF0dXJlLlJHU0RvbWFpbi5zdGF0ZS5lcXVh
bHNUb0NvbnN0YW50KFN0YXRlICAuIFByZXBhcmVHZXN0dXJlKSYmUkdTZmVhdHVyZS5SR1NEb21h
aW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBQcmVwYXJlR2VzdHVyZSlzcQB+AC5z
cQB+ADJ3BAAAAAFzcQB+AC5zcQB+ADJ3BAAAAAFzcQB+AC5zcQB+ADJ3BAAAAAB4c3EAfgAGc3EA
fgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4AEXcMAAAAED9AAAAAAAAAeHNxAH4AOXEAfgBcc3EA
fgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAAeHQAWiAgIHJl
YWxQbGF5ZXIgIC4gYXNrZm9yUkdTICgpICA7ICAgYWlQbGF5ZXIgIC4gYXNrZm9yUkdTICgpICA7
ICAgc3RhdGUgID0gU3RhdGUgIC4gSnVkZ2UgO3QAOVJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0Nv
bnN0YW50KFN0YXRlICAuIFByZXBhcmVHZXN0dXJlKXQAE2VudGVyUHJlcGFyZUdlc3R1cmVzcQB+
AEQAcHBxAH4AZHNxAH4ARz9AAAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AAAAAAAAh3
CAAAAAsAAAAAeHNxAH4AEXcMAAAAED9AAAAAAAAAeHNxAH4AOXEAfgA9c3EAfgAGc3EAfgALP0AA
AAAAAAh3CAAAAAsAAAAAeHNxAH4AEXcMAAAAED9AAAAAAAAAeHQAkiAgIFN5c3RlbSAgLiBvdXQg
IC4gcHJpbnRsbiAoInBseiBtYWtlIHlvdXIgZGVjaXNpb24gd2l0aGluIDMgc2Vjb25kcyxvdGhl
cndpc2UgeW91IHdpbGwgbG9zZSIpICA7ICAgc3RhcnR0aW1lICA9ICBuZXcgRGF0ZSAgICgpICAg
IC4gZ2V0VGltZSAoKSA7dAA5UkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUg
IC4gUHJlcGFyZUdlc3R1cmUpdAAIc2V0dGltZXJzcQB+AEQAcHBxAH4ARnNxAH4ARz9AAAAAAAAA
dwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4AEXcMAAAAED9A
AAAAAAAAeHB0AEpSR1NfdGltZXJmZWF0dXJlLlJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0
YW50KFN0YXRlICAuIFByZXBhcmVHZXN0dXJlKXNxAH4ALnNxAH4AMncEAAAAAXNxAH4ALnNxAH4A
MncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgARdwwAAAAQP0AAAAAA
AAB4cQB+AIV4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4AEXcMAAAAED9AAAAA
AAAAeHB0AEVSR1NmZWF0dXJlLlJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRl
ICAuIEFza2ZvclBsYXlBZ2FpbilzcQB+AC5zcQB+ADJ3BAAAAAFzcQB+AC5zcQB+ADJ3BAAAAAB4
c3EAfgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAAeHNxAH4A
OXEAfgBcc3EAfgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAA
eHQBBiAgICAgU2Nhbm5lciAgaW5wdXRfc2Nhbm5lciA9ICBuZXcgU2Nhbm5lciAgIChTeXN0ZW0g
IC4gaW4pICAgIDsgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJkbyB5b3Ugd2FudCB0byBw
bGF5IGFnYWluPyB5OnllcyBuOm5vIikgIDsgICAgIFN0cmluZyAgcmVzdWx0ID0gaW5wdXRfc2Nh
bm5lciAgLiBuZXh0TGluZSAoKSAgOyBpZiAoIHJlc3VsdCAgLiBlcXVhbHMgKCJ5IikgKSB7ICAg
IHN0YXRlICA9IFN0YXRlICAuIFByZXBhcmVHZXN0dXJlIDsgfSB0ADpSR1NEb21haW4uc3RhdGUu
ZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBBc2tmb3JQbGF5QWdhaW4pdAAUZW50ZXJBc2tmb3JQ
bGF5QWdhaW5zcQB+AEQAcHBxAH4AZHNxAH4ARz9AAAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAGc3EA
fgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAAeHB0AERSR1NmZWF0dXJl
LlJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIFByZXBhcmVHZXN0dXJl
KXNxAH4ALnNxAH4AMncEAAAAAXNxAH4ALnNxAH4AMncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAA
AncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4cQB+AHl4c3EAfgAGc3EAfgALP0AAAAAA
AAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAAeHB0ADtSR1NmZWF0dXJlLlJHU0RvbWFp
bi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXNxAH4ALnNxAH4AMncEAAAA
AXNxAH4ALnNxAH4AMncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAAAncIAAAAAwAAAAB4c3EAfgAR
dwwAAAABP0AAAAAAAAB4c3EAfgA5cQB+AFxzcQB+AAZzcQB+AAs/QAAAAAAAAncIAAAAAwAAAAB4
c3EAfgARdwwAAAABP0AAAAAAAAB4dAIaICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgieW91
ciBnZXN0dXJlIGlzICIgICsgcmVhbFBsYXllciAgLiBnZXRndWVzdHVyZSAoKSAgLiB0b1N0cmlu
ZyAoKSkgIDsgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJBSVBsYXllcidzIGdlc3R1cmUg
aXMgIiAgKyBhaVBsYXllciAgLiBnZXRndWVzdHVyZSAoKSAgLiB0b1N0cmluZyAoKSkgIDsgc3dp
dGNoICggUm9ja0dsb3ZlU2Npc3NvciAgLiBqdWRnZSAocmVhbFBsYXllciAgLiBnZXRndWVzdHVy
ZSAoKSAgLCBhaVBsYXllciAgLiBnZXRndWVzdHVyZSAoKSkgKSB7ICAgIGNhc2UgMSA6ICAgIFN5
c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoInBsYXllciAxIHdvbiEiKSAgOyBicmVhayA7ICAgY2Fz
ZSAwIDogICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgiZHJhdyIpICA7IGJyZWFrIDsgICBj
YXNlICAtIDEgOiAgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJwbGF5ZXIgMiB3b24iKSAg
OyBicmVhayA7IH0gICBzdGF0ZSAgPSBTdGF0ZSAgLiBBc2tmb3JQbGF5QWdhaW4gO3QAMFJHU0Rv
bWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXQACmVudGVySnVkZ2Vz
cQB+AEQAcHBxAH4AZHNxAH4ARz9AAAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AAAAAA
AAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAAeHB4c3EAfgAydwQAAAAFcQB+AG9xAH4A
kXEAfgCccQB+ALBxAH4Au3h4eHEAfgA9

*/


/* IntermediateInfo:domains
rO0ABXNyABdqYXZhLnV0aWwuTGlua2VkSGFzaFNldNhs11qV3SoeAgAAeHIAEWphdmEudXRpbC5I
YXNoU2V0ukSFlZa4tzQDAAB4cHcMAAAAED9AAAAAAAABdAADUkdTeA==

*/


/* IntermediateInfo:isExecutable
rO0ABXNyABFqYXZhLmxhbmcuQm9vbGVhbs0gcoDVnPruAgABWgAFdmFsdWV4cAE=

*/


/* IntermediateInfo:proceedToPuhandler
rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAACdwQAAAAC
c3IAJ2NvcmUuZGF0YXN0cnVjdHVyZS5Qcm9jZWVkVG9IYW5kbGVySW5mb/NJGznJidC0AgAJTAAJ
Y29uZGl0aW9udAASTGphdmEvbGFuZy9TdHJpbmc7TAAPZXZlbnRJZGVudGlmaWVycQB+AANMAAll
dmVudFR5cGVxAH4AA0wAD2ZlYXR1cmVJbnN0YW5jZXEAfgADTAALZmVhdHVyZU5hbWVxAH4AA0wA
CXByb2NlZWRUb3EAfgADTAARcHJvY2VlZFRvSW5zdGFuY2VxAH4AA0wABnB1TmFtZXEAfgADTAAH
cHVUb0FkZHEAfgADeHB0ADlSR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAg
LiBQcmVwYXJlR2VzdHVyZSl0AAFldAAFZW50ZXJ0ABhfcmdzX3RpbWVyZmVhdHVyZWZlYXR1cmV0
ABBSR1NfdGltZXJmZWF0dXJlcHB0AAhzZXR0aW1lcnBzcQB+AAJ0ADlSR1NEb21haW4uc3RhdGUu
ZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBQcmVwYXJlR2VzdHVyZSlxAH4ABnQABWxlYXZldAAY
X3Jnc190aW1lcmZlYXR1cmVmZWF0dXJlcQB+AAlwcHQACmNoZWNrdGltZXJweA==

*/


/* IntermediateInfo:anchorFeature
rO0ABXQAClJHU2ZlYXR1cmU=

*/

