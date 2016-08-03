package RGS_timer;
import RGS.*;
import RGS_history.*;
import external.*;
import java.rmi.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class mpfeaturesFeaturePackage
 extends FeaturePackage implements Serializable 
{

RGS_historyfeatureFeature _rgs_historyfeaturefeature;RGS_timerfeatureFeature _rgs_timerfeaturefeature;RGSfeatureFeature _rgsfeaturefeature;
private boolean activated = true;
Map<String, Boolean> previousState = new HashMap<String, Boolean>();
private EventBuffer<FL_EVENT_STEM> sharedBuffer;

public EventBuffer<FL_EVENT_STEM> getSharedBuffer(){
return this.sharedBuffer;
}
public void activate() { activated = true; }
public void deactivate() { activated = false; }
public boolean isActivated() { return activated; }

public mpfeaturesFeaturePackage(  Player  realPlayer_RGS ,   Player  aiPlayer_RGS) {
super();
RGSDomain.realPlayer = realPlayer_RGS;
RGSDomain.aiPlayer = aiPlayer_RGS;
RGSDomain.state = State  . Init;
{Map<String, Boolean>currentState= new HashMap<String, Boolean>(previousState);
currentState.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
currentState.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
currentState.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
currentState.put("rgsdomain.state.equalstoconstant(state.init)",RGSDomain.state.equalsToConstant(State.Init));
previousState = new HashMap<String, Boolean>(currentState);}
this._rgsfeaturefeature = new RGSfeatureFeature();
this._rgs_timerfeaturefeature = new RGS_timerfeatureFeature( this._rgsfeaturefeature );
this._rgs_historyfeaturefeature = new RGS_historyfeatureFeature( this._rgsfeaturefeature );
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
mpfeaturesFeaturePackage.this.XEvent((FL_EVENT_STEM)buffer.remove());
}catch(Exception ex){
ex.printStackTrace();
}//end of catch
}//end of while
}//end of run
}//end of Consumer Class
public mpfeaturesFeaturePackage(RGS_timerfeatureFeature _rgs_timerfeaturefeature, RGS_historyfeatureFeature _rgs_historyfeaturefeature, RGSfeatureFeature _rgsfeaturefeature)
 {
super();
this._rgs_timerfeaturefeature = _rgs_timerfeaturefeature;
this._rgs_historyfeaturefeature = _rgs_historyfeaturefeature;
this._rgsfeaturefeature = _rgsfeaturefeature;
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
currentState.put("rgsdomain.state.equalstoconstant(state.init)",RGSDomain.state.equalsToConstant(State.Init));
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
currentState.put("rgsdomain.state.equalstoconstant(state.init)",RGSDomain.state.equalsToConstant(State.Init));
if(currentState.equals(previousState))return;}
boolean possibleEnter = true; boolean possibleLeave = true;
Map<String, Boolean> temp;
while(true){
boolean noLeaveEvent = true;
boolean noEnterEvent = true;
temp = new HashMap<String, Boolean>(previousState);
temp.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
temp.put("rgsdomain.state.equalstoconstant(state.init)",RGSDomain.state.equalsToConstant(State.Init));
temp.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
temp.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
if(possibleLeave)
			{
			if (previousState.get("rgsdomain.state.equalstoconstant(state.preparegesture)") && !(RGSDomain.state.equalsToConstant(State.PrepareGesture)))
			{				noLeaveEvent = false;if(true){ if(!(RGSDomain.state.equalsToConstant(State  . PrepareGesture))) _rgs_timerfeaturefeature.checktimer(e);
}else{/* no qualifier matched */}			}
			else if (previousState.get("rgsdomain.state.equalstoconstant(state.judge)") && !(RGSDomain.state.equalsToConstant(State.Judge)))
			{				noLeaveEvent = false;if(true){ if(!(RGSDomain.state.equalsToConstant(State  . Judge))) _rgs_historyfeaturefeature.storeHistory(e);
}else{/* no qualifier matched */}			}
			else if (previousState.get("rgsdomain.state.equalstoconstant(state.init)") && !(RGSDomain.state.equalsToConstant(State.Init)))
			{				noLeaveEvent = false;if(true){ if(!(RGSDomain.state.equalsToConstant(State  . Init))) _rgs_historyfeaturefeature.viewHistory(e);
}else{/* no qualifier matched */}			}

else{/*no condition matched*/}
			}
if(!noLeaveEvent){
Map<String, Boolean>temp2 = new HashMap<String, Boolean>(previousState);
temp2.put("rgsdomain.state.equalstoconstant(state.init)",RGSDomain.state.equalsToConstant(State.Init));
temp2.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
temp2.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
temp2.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
if (!temp.equals(temp2)) {previousState = temp;possibleEnter = true;possibleLeave = true; }else{ possibleLeave = false;}
}
temp = new HashMap<String, Boolean>(previousState);
temp.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
temp.put("rgsdomain.state.equalstoconstant(state.init)",RGSDomain.state.equalsToConstant(State.Init));
temp.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
temp.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
if(possibleEnter)
			{
			if (!previousState.get("rgsdomain.state.equalstoconstant(state.preparegesture)")&&RGSDomain.state.equalsToConstant(State.PrepareGesture))
			{				noEnterEvent = false;if(true){ if((RGSDomain.state.equalsToConstant(State  . PrepareGesture))) _rgs_timerfeaturefeature.settimer(e);
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
temp2.put("rgsdomain.state.equalstoconstant(state.init)",RGSDomain.state.equalsToConstant(State.Init));
temp2.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
temp2.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
temp2.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
previousState = temp;if (!temp.equals(temp2)) {possibleEnter = true;possibleLeave = true; }else{ possibleEnter = false;}
}
if(noLeaveEvent && noEnterEvent) break;
}
	}

}

protected void finalize() {
try {
super.finalize();
} catch(Throwable e) {
// do nothing
}
}

//ProceedTo handlers
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
AAALAAAAA3QAClJHU2ZlYXR1cmVzcgAXY29yZS5jb2RlZ2VuZXJhdG9yLk5vZGU57IiELEUMtAIA
BUkAFGRpcmVjdFByZWRlY2Vzc29yTnVtWgAKd2FzVmlzaXRlZEwAD2RpcmVjdFN1Y2NOb2Rlc3EA
fgAJTAAFbGFiZWxxAH4ABEwAC3BhcmVudE5vZGVzcQB+AAd4cAAAAAIAc3EAfgALP0AAAAAAAAh3
CAAAAAsAAAAAeHEAfgANc3IAEWphdmEudXRpbC5IYXNoU2V0ukSFlZa4tzQDAAB4cHcMAAAAED9A
AAAAAAACc3EAfgAOAAAAAQBzcQB+AAs/QAAAAAAACHcIAAAACwAAAAFxAH4AD3QAEnN0cmFpZ2h0
UHJlY2VkZW5jZXh0ABJSR1NfaGlzdG9yeWZlYXR1cmVzcQB+ABF3DAAAABA/QAAAAAAAAXNxAH4A
DgAAAAAAc3EAfgALP0AAAAAAAAh3CAAAAAsAAAACcQB+AA9xAH4AFXEAfgATcQB+ABV4dAAQUkdT
X3RpbWVyZmVhdHVyZXNxAH4AEXcMAAAAED9AAAAAAAAAeHhxAH4AGHhxAH4AFnEAfgATcQB+ABpx
AH4AGHhzcQB+ABF3DAAAABA/QAAAAAAAAHhzcgAXamF2YS51dGlsLkxpbmtlZEhhc2hTZXTYbNda
ld0qHgIAAHhxAH4AEXcMAAAAED9AAAAAAAABdAADUkdTeHNyACZjb3JlLmNvbXBpbGVyZXNvdXJj
ZXMuRXZlbnROb2RlTWFwSW1wbGg7rdBPj5iCAgABTAADbWFwdAAPTGphdmEvdXRpbC9NYXA7eHBz
cQB+AAs/QAAAAAAACHcIAAAACwAAAAB4dAAYbXBmZWF0dXJlc0ZlYXR1cmVQYWNrYWdl

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
AAALAAAAA3QAClJHU2ZlYXR1cmVzcgAXY29yZS5jb2RlZ2VuZXJhdG9yLk5vZGU57IiELEUMtAIA
BUkAFGRpcmVjdFByZWRlY2Vzc29yTnVtWgAKd2FzVmlzaXRlZEwAD2RpcmVjdFN1Y2NOb2Rlc3EA
fgAJTAAFbGFiZWxxAH4ABEwAC3BhcmVudE5vZGVzcQB+AAd4cAAAAAIAc3EAfgALP0AAAAAAAAh3
CAAAAAsAAAAAeHEAfgANc3IAEWphdmEudXRpbC5IYXNoU2V0ukSFlZa4tzQDAAB4cHcMAAAAED9A
AAAAAAACc3EAfgAOAAAAAQBzcQB+AAs/QAAAAAAACHcIAAAACwAAAAFxAH4AD3QAEnN0cmFpZ2h0
UHJlY2VkZW5jZXh0ABJSR1NfaGlzdG9yeWZlYXR1cmVzcQB+ABF3DAAAABA/QAAAAAAAAXNxAH4A
DgAAAAAAc3EAfgALP0AAAAAAAAh3CAAAAAsAAAACcQB+AA9xAH4AFXEAfgATcQB+ABV4dAAQUkdT
X3RpbWVyZmVhdHVyZXNxAH4AEXcMAAAAED9AAAAAAAAAeHhxAH4AGHhxAH4AFnEAfgATcQB+ABpx
AH4AGHhzcQB+ABF3DAAAABA/QAAAAAAAAHhzcgAXamF2YS51dGlsLkxpbmtlZEhhc2hTZXTYbNda
ld0qHgIAAHhxAH4AEXcMAAAAED9AAAAAAAABdAADUkdTeHNyACZjb3JlLmNvbXBpbGVyZXNvdXJj
ZXMuRXZlbnROb2RlTWFwSW1wbGg7rdBPj5iCAgABTAADbWFwdAAPTGphdmEvdXRpbC9NYXA7eHBz
cQB+AAs/QAAAAAAACHcIAAAACwAAAAN0AAVsZWF2ZXNyACpjb3JlLmNvbXBpbGVyZXNvdXJjZXMu
UXVhbGlmaWVyTm9kZU1hcEltcGzq89x9y6uktQIAAUwAA21hcHEAfgAheHBzcQB+AAs/QAAAAAAA
CHcIAAAACwAAAAF0AANhbGxzcgAqY29yZS5jb21waWxlcmVzb3VyY2VzLkNvbmRpdGlvbk5vZGVN
YXBJbXBsd2wWKr7nlGkCAAFMAANtYXB0AChMY29yZS9jb21waWxlcmVzb3VyY2VzL09yZGVyZWRI
YXNodGFibGU7eHBzcgAmY29yZS5jb21waWxlcmVzb3VyY2VzLk9yZGVyZWRIYXNodGFibGV4ZKDe
0mQhMAIAAUwADGtleU9yZGVyTGlzdHQAFkxqYXZhL3V0aWwvTGlua2VkTGlzdDt4cQB+AAs/QAAA
AAAACHcIAAAACwAAAAN0AEpSR1NfdGltZXJmZWF0dXJlLlJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNU
b0NvbnN0YW50KFN0YXRlICAuIFByZXBhcmVHZXN0dXJlKXNyACVjb3JlLmNvbXBpbGVyZXNvdXJj
ZXMuRml0U3ViZW50cnlUcmVlY5X89AsBiasCAANMAAhjaGlsZHJlbnQAEExqYXZhL3V0aWwvTGlz
dDtMABFkZWZhdWx0UHJlY2VkZW5jZXEAfgABTAADdmFsdAAjTGNvcmUvY29tcGlsZXJlc291cmNl
cy9GaXRTdWJlbnRyeTt4cHNyABRqYXZhLnV0aWwuTGlua2VkTGlzdAwpU11KYIgiAwAAeHB3BAAA
AAFzcQB+ADBzcQB+ADR3BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4A
EXcMAAAAAT9AAAAAAAAAeHNyACdjb3JlLmNvbXBpbGVyZXNvdXJjZXMuRml0UHVTdWJlbnRyeUlt
cGzJ6iM7PuYTmgIAAUwAA21hcHEAfgAheHIAJWNvcmUuY29tcGlsZXJlc291cmNlcy5GaXRTdWJl
bnRyeUltcGzqOTCcd/Uh5wIABkwAEGZlYXR1cmVOYW1lRW50cnlxAH4ABEwAC3ByZVJlbGF0aW9u
cQB+AAFMABBwcm9ncmFtQm9keUVudHJ5cQB+AARMABBwcm9ncmFtQ29uZGl0aW9ucQB+AARMABRw
cm9ncmFtVW5pdE5hbWVFbnRyeXEAfgAETAANd2hlbkNvbmRpdGlvbnQAH0xjb3JlL2xhbmcvQ29u
ZGl0aW9uRXhwcmVzc2lvbjt4cHQAEFJHU190aW1lcmZlYXR1cmVzcQB+AAZzcQB+AAs/QAAAAAAA
AncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4dACWICAgZW5kdGltZSAgPSAgbmV3IERh
dGUgICAoKSAgICAuIGdldFRpbWUgKCkgOyBpZiAoIGVuZHRpbWUgIC0gc3RhcnR0aW1lICA+PSAz
MDAwICkgeyAgICByZWFsUGxheWVyICAuIHNldGd1ZXN0dXJlIChSb2NrR2xvdmVTY2lzc29yICAu
IE5vdGhpbmcpICA7IH0gdAA5UkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUg
IC4gUHJlcGFyZUdlc3R1cmUpdAAKY2hlY2t0aW1lcnNyAB1jb3JlLmxhbmcuQ29uZGl0aW9uRXhw
cmVzc2lvboiK4hsevVSUAgAEWgAIbmVnYXRpdmVMAAVjaGlsZHEAfgA9TAAEbmV4dHEAfgA9TAAD
c3RycQB+AAR4cABwcHQABHRydWVzcgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxv
YWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AA
AAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAAeHB0AENSR1NfaGlzdG9yeWZlYXR1
cmUuUkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gSnVkZ2Upc3EAfgAw
c3EAfgA0dwQAAAABc3EAfgAwc3EAfgA0dwQAAAAAeHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAAD
AAAAAHhzcQB+ABF3DAAAAAE/QAAAAAAAAHhzcQB+ADt0ABJSR1NfaGlzdG9yeWZlYXR1cmVzcQB+
AAZzcQB+AAs/QAAAAAAAAncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4dAFFICAgb3V0
ICA9IG51bGwgOyB0cnkgeyAgICBvdXQgID0gIG5ldyBQcmludFdyaXRlciAgICggbmV3IEJ1ZmZl
cmVkV3JpdGVyICAgKCBuZXcgRmlsZVdyaXRlciAgIChoaXN0b3J5UGF0aCAgLCB0cnVlKSAgKSAg
KSAgIDsgICBvdXQgIC4gcHJpbnRsbiAocmVhbFBsYXllciAgLiBnZXRndWVzdHVyZSAoKSAgLiB0
b1N0cmluZyAoKSkgIDsgfSAgIGNhdGNoICggICBJT0V4Y2VwdGlvbiBpb2UgKSB7ICAgIFN5c3Rl
bSAgLiBlcnIgIC4gcHJpbnRsbiAoaW9lKSAgOyB9ICBmaW5hbGx5IHsgIGlmICggb3V0ICAhPSBu
dWxsICkgeyAgICBvdXQgIC4gY2xvc2UgKCkgIDsgfSAgfXQAMFJHU0RvbWFpbi5zdGF0ZS5lcXVh
bHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXQADHN0b3JlSGlzdG9yeXNxAH4ARgBwcHQABHRy
dWVzcQB+AEk/QAAAAAAAAHcIAAAAEAAAAAB4eHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAA
AHhzcQB+ABF3DAAAAAE/QAAAAAAAAHhwdABCUkdTX2hpc3RvcnlmZWF0dXJlLlJHU0RvbWFpbi5z
dGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEluaXQpc3EAfgAwc3EAfgA0dwQAAAABc3EA
fgAwc3EAfgA0dwQAAAAAeHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAAAHhzcQB+ABF3DAAA
AAE/QAAAAAAAAHhzcQB+ADtxAH4AV3NxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAAAHhzcQB+
ABF3DAAAAAE/QAAAAAAAAHh0AiEgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJEbyB5b3Ug
d2FudCB0byB2aWV3IGhpc3Rvcnk/IHk6eWVzIG46bm8iKSAgOyAgICAgU2Nhbm5lciAgaW5wdXRf
c2Nhbm5lciA9ICBuZXcgU2Nhbm5lciAgIChTeXN0ZW0gIC4gaW4pICAgIDsgICAgIFN0cmluZyAg
YW5zd2VyID0gaW5wdXRfc2Nhbm5lciAgLiBuZXh0TGluZSAoKSAgOyBpZiAoIGFuc3dlciAgLiBl
cXVhbHMgKCJ5IikgKSB7ICAgIGhpc3RvcnkgID0gIiIgOyB0cnkgeyAgICBzY2FuICA9ICBuZXcg
U2Nhbm5lciAgICggbmV3IEZpbGUgICAoaGlzdG9yeVBhdGgpICApICAgOyB3aGlsZSAoIHNjYW4g
IC4gaGFzTmV4dExpbmUgKCkgKSB7ICAgIGhpc3RvcnkgICs9IHNjYW4gIC4gbmV4dExpbmUgKCkg
OyB9ICAgc2NhbiAgLiBjbG9zZSAoKSAgOyAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoaGlz
dG9yeSkgIDsgfSAgIGNhdGNoICggICBGaWxlTm90Rm91bmRFeGNlcHRpb24gZm5mZSApIHsgICAg
U3lzdGVtICAuIG91dCAgLiBwcmludGxuICgiZmlsZSBub3QgZm91bmQiKSAgOyB9ICB9IHQAL1JH
U0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEluaXQpdAALdmlld0hpc3Rv
cnlzcQB+AEYAcHBxAH4AX3NxAH4AST9AAAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AA
AAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAAeHB4c3EAfgA0dwQAAAADcQB+AC9x
AH4ATnEAfgBkeHh0AAhyR1MuSW5pdHNxAH4AJXNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAXQAA2Fs
bHNxAH4AKXNxAH4ALD9AAAAAAAAIdwgAAAALAAAAAXQAOlJHU2ZlYXR1cmUuUkdTRG9tYWluLnN0
YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gSW5pdClzcQB+ADBzcQB+ADR3BAAAAAFzcQB+
ADBzcQB+ADR3BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAA
AT9AAAAAAAAAeHNxAH4AO3QAClJHU2ZlYXR1cmVzcQB+AAZzcQB+AAs/QAAAAAAAAncIAAAAAwAA
AAB4c3EAfgARdwwAAAABP0AAAAAAAAB4dABTICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgi
Z2FtZSBiZWdpbnMiKSAgOyAgIHN0YXRlICA9IFN0YXRlICAuIFByZXBhcmVHZXN0dXJlIDt0AC9S
R1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBJbml0KXQACmluaXRpYWxp
emVzcQB+AEYAcHB0AAR0cnVlc3EAfgBJP0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZzcQB+AAs/
QAAAAAAAAncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4cHhzcQB+ADR3BAAAAAFxAH4A
f3h4dAAFZW50ZXJzcQB+ACVzcQB+AAs/QAAAAAAACHcIAAAACwAAAAFxAH4AfHNxAH4AKXNxAH4A
LD9AAAAAAAAIdwgAAAALAAAABXQAkFJHU190aW1lcmZlYXR1cmUuUkdTRG9tYWluLnN0YXRlLmVx
dWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gUHJlcGFyZUdlc3R1cmUpJiZSR1NmZWF0dXJlLlJHU0Rv
bWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIFByZXBhcmVHZXN0dXJlKXNxAH4A
MHNxAH4ANHcEAAAAAXNxAH4AMHNxAH4ANHcEAAAAAXNxAH4AMHNxAH4ANHcEAAAAAHhzcQB+AAZz
cQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4c3EAfgA7cQB+AIhz
cQB+AAZzcQB+AAs/QAAAAAAAAncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4dABaICAg
cmVhbFBsYXllciAgLiBhc2tmb3JSR1MgKCkgIDsgICBhaVBsYXllciAgLiBhc2tmb3JSR1MgKCkg
IDsgICBzdGF0ZSAgPSBTdGF0ZSAgLiBKdWRnZSA7dAA5UkdTRG9tYWluLnN0YXRlLmVxdWFsc1Rv
Q29uc3RhbnQoU3RhdGUgIC4gUHJlcGFyZUdlc3R1cmUpdAATZW50ZXJQcmVwYXJlR2VzdHVyZXNx
AH4ARgBwcHEAfgCQc3EAfgBJP0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZzcQB+AAs/QAAAAAAA
CHcIAAAACwAAAAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4c3EAfgA7cQB+AD9zcQB+AAZzcQB+AAs/
QAAAAAAAAncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4dACSICAgU3lzdGVtICAuIG91
dCAgLiBwcmludGxuICgicGx6IG1ha2UgeW91ciBkZWNpc2lvbiB3aXRoaW4gMyBzZWNvbmRzLG90
aGVyd2lzZSB5b3Ugd2lsbCBsb3NlIikgIDsgICBzdGFydHRpbWUgID0gIG5ldyBEYXRlICAgKCkg
ICAgLiBnZXRUaW1lICgpIDt0ADlSR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0
ZSAgLiBQcmVwYXJlR2VzdHVyZSl0AAhzZXR0aW1lcnNxAH4ARgBwcHEAfgBIc3EAfgBJP0AAAAAA
AAB3CAAAABAAAAAAeHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgARdwwAAAAQ
P0AAAAAAAAB4cHQASlJHU190aW1lcmZlYXR1cmUuUkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29u
c3RhbnQoU3RhdGUgIC4gUHJlcGFyZUdlc3R1cmUpc3EAfgAwc3EAfgA0dwQAAAABc3EAfgAwc3EA
fgA0dwQAAAAAeHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAAAHhzcQB+ABF3DAAAAAE/QAAA
AAAAAHhxAH4AsXhzcQB+AAZzcQB+AAs/QAAAAAAAAncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AA
AAAAAAB4cHQARVJHU2ZlYXR1cmUuUkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3Rh
dGUgIC4gQXNrZm9yUGxheUFnYWluKXNxAH4AMHNxAH4ANHcEAAAAAXNxAH4AMHNxAH4ANHcEAAAA
AHhzcQB+AAZzcQB+AAs/QAAAAAAAAncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4c3EA
fgA7cQB+AIhzcQB+AAZzcQB+AAs/QAAAAAAAAncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAA
AAB4dAEGICAgICBTY2FubmVyICBpbnB1dF9zY2FubmVyID0gIG5ldyBTY2FubmVyICAgKFN5c3Rl
bSAgLiBpbikgICAgOyAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoImRvIHlvdSB3YW50IHRv
IHBsYXkgYWdhaW4/IHk6eWVzIG46bm8iKSAgOyAgICAgU3RyaW5nICByZXN1bHQgPSBpbnB1dF9z
Y2FubmVyICAuIG5leHRMaW5lICgpICA7IGlmICggcmVzdWx0ICAuIGVxdWFscyAoInkiKSApIHsg
ICAgc3RhdGUgID0gU3RhdGUgIC4gUHJlcGFyZUdlc3R1cmUgOyB9IHQAOlJHU0RvbWFpbi5zdGF0
ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEFza2ZvclBsYXlBZ2Fpbil0ABRlbnRlckFza2Zv
clBsYXlBZ2FpbnNxAH4ARgBwcHEAfgCQc3EAfgBJP0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZz
cQB+AAs/QAAAAAAAAncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4cHQARFJHU2ZlYXR1
cmUuUkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gUHJlcGFyZUdlc3R1
cmUpc3EAfgAwc3EAfgA0dwQAAAABc3EAfgAwc3EAfgA0dwQAAAAAeHNxAH4ABnNxAH4ACz9AAAAA
AAACdwgAAAADAAAAAHhzcQB+ABF3DAAAAAE/QAAAAAAAAHhxAH4ApXhzcQB+AAZzcQB+AAs/QAAA
AAAAAncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4cHQAO1JHU2ZlYXR1cmUuUkdTRG9t
YWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gSnVkZ2Upc3EAfgAwc3EAfgA0dwQA
AAABc3EAfgAwc3EAfgA0dwQAAAAAeHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAAAHhzcQB+
ABF3DAAAAAE/QAAAAAAAAHhzcQB+ADtxAH4AiHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAA
AHhzcQB+ABF3DAAAAAE/QAAAAAAAAHh0AhogICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJ5
b3VyIGdlc3R1cmUgaXMgIiAgKyByZWFsUGxheWVyICAuIGdldGd1ZXN0dXJlICgpICAuIHRvU3Ry
aW5nICgpKSAgOyAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoIkFJUGxheWVyJ3MgZ2VzdHVy
ZSBpcyAiICArIGFpUGxheWVyICAuIGdldGd1ZXN0dXJlICgpICAuIHRvU3RyaW5nICgpKSAgOyBz
d2l0Y2ggKCBSb2NrR2xvdmVTY2lzc29yICAuIGp1ZGdlIChyZWFsUGxheWVyICAuIGdldGd1ZXN0
dXJlICgpICAsIGFpUGxheWVyICAuIGdldGd1ZXN0dXJlICgpKSApIHsgICAgY2FzZSAxIDogICAg
U3lzdGVtICAuIG91dCAgLiBwcmludGxuICgicGxheWVyIDEgd29uISIpICA7IGJyZWFrIDsgICBj
YXNlIDAgOiAgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJkcmF3IikgIDsgYnJlYWsgOyAg
IGNhc2UgIC0gMSA6ICAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoInBsYXllciAyIHdvbiIp
ICA7IGJyZWFrIDsgfSAgIHN0YXRlICA9IFN0YXRlICAuIEFza2ZvclBsYXlBZ2FpbiA7dAAwUkdT
RG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gSnVkZ2UpdAAKZW50ZXJKdWRn
ZXNxAH4ARgBwcHEAfgCQc3EAfgBJP0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZzcQB+AAs/QAAA
AAAAAncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4cHhzcQB+ADR3BAAAAAVxAH4Am3EA
fgC9cQB+AMhxAH4A3HEAfgDneHh4dAAKbXBmZWF0dXJlcw==

*/


/* IntermediateInfo:domains
rO0ABXNyABdqYXZhLnV0aWwuTGlua2VkSGFzaFNldNhs11qV3SoeAgAAeHIAEWphdmEudXRpbC5I
YXNoU2V0ukSFlZa4tzQDAAB4cHcMAAAAED9AAAAAAAABdAADUkdTeA==

*/


/* IntermediateInfo:proceedToPuhandler
rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAAdwQAAAAA
eA==

*/

