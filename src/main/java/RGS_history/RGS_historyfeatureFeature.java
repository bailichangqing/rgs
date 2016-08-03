package RGS_history;
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

public class RGS_historyfeatureFeature
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

public RGS_historyfeatureFeature(  Player  realPlayer ,   Player  aiPlayer) {
super();
RGSDomain.realPlayer = realPlayer;
RGSDomain.aiPlayer = aiPlayer;
RGSDomain.state = State  . Init;
{Map<String, Boolean>currentState= new HashMap<String, Boolean>(previousState);
currentState.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
currentState.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
currentState.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
currentState.put("rgsdomain.state.equalstoconstant(state.init)",RGSDomain.state.equalsToConstant(State.Init));
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
RGS_historyfeatureFeature.this.XEvent((FL_EVENT_STEM)buffer.remove());
}catch(Exception ex){
ex.printStackTrace();
}//end of catch
}//end of while
}//end of run
}//end of Consumer Class
public  RGS_historyfeatureFeature(RGSfeatureFeature _rgsfeaturefeature)
 {
super();
this._rgsfeaturefeature = _rgsfeaturefeature;
}
/***********************************/

 ;

 String historyPath = "C:\\Users\\conghao\\Desktop\\svn\\Samples\\src\\main\\java\\RGS_history\\history.txt";

 String history;

 Scanner scan;

 
         
           
         
         
 
    
 
 
            
        
 
        
 
      
         
 
     
 
         
 
 
 /**********************************/
public synchronized void viewHistory( FL_EVENT_STEM  e)
{
try { 
if (activated)
{
System . out . println ( "Do you want to view history? y:yes n:no" ) ;
Scanner input_scanner = new Scanner ( System . in ) ;
String answer = input_scanner . nextLine ( ) ;
if ( answer . equals ( "y" ) ) {
history = "" ;
try {
scan = new Scanner ( new File ( historyPath ) ) ;
while ( scan . hasNextLine ( ) ) {
history += scan . nextLine ( ) ;
}
scan . close ( ) ;
System . out . println ( history ) ;
}
catch ( FileNotFoundException fnfe ) {
System . out . println ( "file not found" ) ;
}
}
}

} 
finally {}
}


 PrintWriter out;

 
    
 
 
                  
               
 
     
 
         
 
 
 
      
 
      
 
 
 /**********************************/
public synchronized void storeHistory( FL_EVENT_STEM  e)
{
try { 
if (activated)
{
out = null ;
try {
out = new PrintWriter ( new BufferedWriter ( new FileWriter ( historyPath , true ) ) ) ;
out . println ( realPlayer . getguesture ( ) . toString ( ) ) ;
}
catch ( IOException ioe ) {
System . err . println ( ioe ) ;
}
finally {
if ( out != null ) {
out . close ( ) ;
}
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
currentState.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
currentState.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
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
currentState.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
currentState.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
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
			if (previousState.get("rgsdomain.state.equalstoconstant(state.init)") && !(RGSDomain.state.equalsToConstant(State.Init)))
			{				noLeaveEvent = false;if(true){ if(!(RGSDomain.state.equalsToConstant(State  . Init))) this.viewHistory(e);
}else{/* no qualifier matched */}			}
			else if (previousState.get("rgsdomain.state.equalstoconstant(state.judge)") && !(RGSDomain.state.equalsToConstant(State.Judge)))
			{				noLeaveEvent = false;if(true){ if(!(RGSDomain.state.equalsToConstant(State  . Judge))) this.storeHistory(e);
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
			if (!previousState.get("rgsdomain.state.equalstoconstant(state.askforplayagain)")&&RGSDomain.state.equalsToConstant(State.AskforPlayAgain))
			{				noEnterEvent = false;if(true){ if((RGSDomain.state.equalsToConstant(State  . AskforPlayAgain))) _rgsfeaturefeature.enterAskforPlayAgain(e);
}else{/* no qualifier matched */}			}
			else if (!previousState.get("rgsdomain.state.equalstoconstant(state.preparegesture)")&&RGSDomain.state.equalsToConstant(State.PrepareGesture))
			{				noEnterEvent = false;if(true){ if((RGSDomain.state.equalsToConstant(State  . PrepareGesture))) _rgsfeaturefeature.enterPrepareGesture(e);
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
public ProceedToHandler _rgs_historyfeature_viewhistory_rgsdomain_state_equalstoconstant_state_init_leave_null_soft_binding_handler;
public ProceedToHandler _rgs_historyfeature_storehistory_rgsdomain_state_equalstoconstant_state_judge_leave_null_soft_binding_handler;

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
UHJlY2VkZW5jZXh0ABJSR1NfaGlzdG9yeWZlYXR1cmVzcQB+ABF3DAAAABA/QAAAAAAAAHh4cQB+
ABZxAH4AE3hzcQB+ABF3DAAAABA/QAAAAAAAAXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnH
YZ0DAAFJAARzaXpleHAAAAACdwQAAAACcQB+ABZxAH4ADXh4c3IAF2phdmEudXRpbC5MaW5rZWRI
YXNoU2V02GzXWpXdKh4CAAB4cQB+ABF3DAAAABA/QAAAAAAAAXQAA1JHU3hzcgAmY29yZS5jb21w
aWxlcmVzb3VyY2VzLkV2ZW50Tm9kZU1hcEltcGxoO63QT4+YggIAAUwAA21hcHQAD0xqYXZhL3V0
aWwvTWFwO3hwc3EAfgALP0AAAAAAAAh3CAAAAAsAAAABdAAFbGVhdmVzcgAqY29yZS5jb21waWxl
cmVzb3VyY2VzLlF1YWxpZmllck5vZGVNYXBJbXBs6vPcfcurpLUCAAFMAANtYXBxAH4AH3hwc3EA
fgALP0AAAAAAAAh3CAAAAAsAAAABdAADYWxsc3IAKmNvcmUuY29tcGlsZXJlc291cmNlcy5Db25k
aXRpb25Ob2RlTWFwSW1wbHdsFiq+55RpAgABTAADbWFwdAAoTGNvcmUvY29tcGlsZXJlc291cmNl
cy9PcmRlcmVkSGFzaHRhYmxlO3hwc3IAJmNvcmUuY29tcGlsZXJlc291cmNlcy5PcmRlcmVkSGFz
aHRhYmxleGSg3tJkITACAAFMAAxrZXlPcmRlckxpc3R0ABZMamF2YS91dGlsL0xpbmtlZExpc3Q7
eHEAfgALP0AAAAAAAAh3CAAAAAsAAAACdAAvUkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3Rh
bnQoU3RhdGUgIC4gSW5pdClzcgAlY29yZS5jb21waWxlcmVzb3VyY2VzLkZpdFN1YmVudHJ5VHJl
ZWOV/PQLAYmrAgADTAAIY2hpbGRyZW50ABBMamF2YS91dGlsL0xpc3Q7TAARZGVmYXVsdFByZWNl
ZGVuY2VxAH4AAUwAA3ZhbHQAI0xjb3JlL2NvbXBpbGVyZXNvdXJjZXMvRml0U3ViZW50cnk7eHBz
cgAUamF2YS51dGlsLkxpbmtlZExpc3QMKVNdSmCIIgMAAHhwdwQAAAABc3EAfgAuc3EAfgAydwQA
AAAAeHNxAH4ABnNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAHhzcQB+ABF3DAAAABA/QAAAAAAAAHhz
cgAnY29yZS5jb21waWxlcmVzb3VyY2VzLkZpdFB1U3ViZW50cnlJbXBsyeojOz7mE5oCAAFMAANt
YXBxAH4AH3hyACVjb3JlLmNvbXBpbGVyZXNvdXJjZXMuRml0U3ViZW50cnlJbXBs6jkwnHf1IecC
AAZMABBmZWF0dXJlTmFtZUVudHJ5cQB+AARMAAtwcmVSZWxhdGlvbnEAfgABTAAQcHJvZ3JhbUJv
ZHlFbnRyeXEAfgAETAAQcHJvZ3JhbUNvbmRpdGlvbnEAfgAETAAUcHJvZ3JhbVVuaXROYW1lRW50
cnlxAH4ABEwADXdoZW5Db25kaXRpb250AB9MY29yZS9sYW5nL0NvbmRpdGlvbkV4cHJlc3Npb247
eHB0ABJSR1NfaGlzdG9yeWZlYXR1cmVzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EA
fgARdwwAAAAQP0AAAAAAAAB4dAIhICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgiRG8geW91
IHdhbnQgdG8gdmlldyBoaXN0b3J5PyB5OnllcyBuOm5vIikgIDsgICAgIFNjYW5uZXIgIGlucHV0
X3NjYW5uZXIgPSAgbmV3IFNjYW5uZXIgICAoU3lzdGVtICAuIGluKSAgICA7ICAgICBTdHJpbmcg
IGFuc3dlciA9IGlucHV0X3NjYW5uZXIgIC4gbmV4dExpbmUgKCkgIDsgaWYgKCBhbnN3ZXIgIC4g
ZXF1YWxzICgieSIpICkgeyAgICBoaXN0b3J5ICA9ICIiIDsgdHJ5IHsgICAgc2NhbiAgPSAgbmV3
IFNjYW5uZXIgICAoIG5ldyBGaWxlICAgKGhpc3RvcnlQYXRoKSAgKSAgIDsgd2hpbGUgKCBzY2Fu
ICAuIGhhc05leHRMaW5lICgpICkgeyAgICBoaXN0b3J5ICArPSBzY2FuICAuIG5leHRMaW5lICgp
IDsgfSAgIHNjYW4gIC4gY2xvc2UgKCkgIDsgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKGhp
c3RvcnkpICA7IH0gICBjYXRjaCAoICAgRmlsZU5vdEZvdW5kRXhjZXB0aW9uIGZuZmUgKSB7ICAg
IFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoImZpbGUgbm90IGZvdW5kIikgIDsgfSAgfSBxAH4A
LXQAC3ZpZXdIaXN0b3J5c3IAHWNvcmUubGFuZy5Db25kaXRpb25FeHByZXNzaW9uiIriGx69VJQC
AARaAAhuZWdhdGl2ZUwABWNoaWxkcQB+ADtMAARuZXh0cQB+ADtMAANzdHJxAH4ABHhwAHBwdAAE
dHJ1ZXNyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3RvckkACXRocmVz
aG9sZHhwP0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4
c3EAfgARdwwAAAAQP0AAAAAAAAB4cHQAMFJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50
KFN0YXRlICAuIEp1ZGdlKXNxAH4ALnNxAH4AMncEAAAAAXNxAH4ALnNxAH4AMncEAAAAAHhzcQB+
AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4c3EAfgA5cQB+
AD1zcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4dAFF
ICAgb3V0ICA9IG51bGwgOyB0cnkgeyAgICBvdXQgID0gIG5ldyBQcmludFdyaXRlciAgICggbmV3
IEJ1ZmZlcmVkV3JpdGVyICAgKCBuZXcgRmlsZVdyaXRlciAgIChoaXN0b3J5UGF0aCAgLCB0cnVl
KSAgKSAgKSAgIDsgICBvdXQgIC4gcHJpbnRsbiAocmVhbFBsYXllciAgLiBnZXRndWVzdHVyZSAo
KSAgLiB0b1N0cmluZyAoKSkgIDsgfSAgIGNhdGNoICggICBJT0V4Y2VwdGlvbiBpb2UgKSB7ICAg
IFN5c3RlbSAgLiBlcnIgIC4gcHJpbnRsbiAoaW9lKSAgOyB9ICBmaW5hbGx5IHsgIGlmICggb3V0
ICAhPSBudWxsICkgeyAgICBvdXQgIC4gY2xvc2UgKCkgIDsgfSAgfXEAfgBLdAAMc3RvcmVIaXN0
b3J5c3EAfgBDAHBwcQB+AEVzcQB+AEY/QAAAAAAAAHcIAAAAEAAAAAB4eHNxAH4ABnNxAH4ACz9A
AAAAAAAIdwgAAAALAAAAAHhzcQB+ABF3DAAAABA/QAAAAAAAAHhweHNxAH4AMncEAAAAAnEAfgAt
cQB+AEt4eHhxAH4APQ==

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
UHJlY2VkZW5jZXh0ABJSR1NfaGlzdG9yeWZlYXR1cmVzcQB+ABF3DAAAABA/QAAAAAAAAHh4cQB+
ABZxAH4AE3hzcQB+ABF3DAAAABA/QAAAAAAAAXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnH
YZ0DAAFJAARzaXpleHAAAAACdwQAAAACcQB+ABZxAH4ADXh4c3IAF2phdmEudXRpbC5MaW5rZWRI
YXNoU2V02GzXWpXdKh4CAAB4cQB+ABF3DAAAABA/QAAAAAAAAXQAA1JHU3hzcgAmY29yZS5jb21w
aWxlcmVzb3VyY2VzLkV2ZW50Tm9kZU1hcEltcGxoO63QT4+YggIAAUwAA21hcHQAD0xqYXZhL3V0
aWwvTWFwO3hwc3EAfgALP0AAAAAAAAh3CAAAAAsAAAADdAAFbGVhdmVzcgAqY29yZS5jb21waWxl
cmVzb3VyY2VzLlF1YWxpZmllck5vZGVNYXBJbXBs6vPcfcurpLUCAAFMAANtYXBxAH4AH3hwc3EA
fgALP0AAAAAAAAh3CAAAAAsAAAABdAADYWxsc3IAKmNvcmUuY29tcGlsZXJlc291cmNlcy5Db25k
aXRpb25Ob2RlTWFwSW1wbHdsFiq+55RpAgABTAADbWFwdAAoTGNvcmUvY29tcGlsZXJlc291cmNl
cy9PcmRlcmVkSGFzaHRhYmxlO3hwc3IAJmNvcmUuY29tcGlsZXJlc291cmNlcy5PcmRlcmVkSGFz
aHRhYmxleGSg3tJkITACAAFMAAxrZXlPcmRlckxpc3R0ABZMamF2YS91dGlsL0xpbmtlZExpc3Q7
eHEAfgALP0AAAAAAAAh3CAAAAAsAAAACdABDUkdTX2hpc3RvcnlmZWF0dXJlLlJHU0RvbWFpbi5z
dGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXNyACVjb3JlLmNvbXBpbGVyZXNv
dXJjZXMuRml0U3ViZW50cnlUcmVlY5X89AsBiasCAANMAAhjaGlsZHJlbnQAEExqYXZhL3V0aWwv
TGlzdDtMABFkZWZhdWx0UHJlY2VkZW5jZXEAfgABTAADdmFsdAAjTGNvcmUvY29tcGlsZXJlc291
cmNlcy9GaXRTdWJlbnRyeTt4cHNyABRqYXZhLnV0aWwuTGlua2VkTGlzdAwpU11KYIgiAwAAeHB3
BAAAAAFzcQB+AC5zcQB+ADJ3BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNx
AH4AEXcMAAAAED9AAAAAAAAAeHNyACdjb3JlLmNvbXBpbGVyZXNvdXJjZXMuRml0UHVTdWJlbnRy
eUltcGzJ6iM7PuYTmgIAAUwAA21hcHEAfgAfeHIAJWNvcmUuY29tcGlsZXJlc291cmNlcy5GaXRT
dWJlbnRyeUltcGzqOTCcd/Uh5wIABkwAEGZlYXR1cmVOYW1lRW50cnlxAH4ABEwAC3ByZVJlbGF0
aW9ucQB+AAFMABBwcm9ncmFtQm9keUVudHJ5cQB+AARMABBwcm9ncmFtQ29uZGl0aW9ucQB+AARM
ABRwcm9ncmFtVW5pdE5hbWVFbnRyeXEAfgAETAANd2hlbkNvbmRpdGlvbnQAH0xjb3JlL2xhbmcv
Q29uZGl0aW9uRXhwcmVzc2lvbjt4cHQAElJHU19oaXN0b3J5ZmVhdHVyZXNxAH4ABnNxAH4ACz9A
AAAAAAAIdwgAAAALAAAAAHhzcQB+ABF3DAAAABA/QAAAAAAAAHh0AUUgICBvdXQgID0gbnVsbCA7
IHRyeSB7ICAgIG91dCAgPSAgbmV3IFByaW50V3JpdGVyICAgKCBuZXcgQnVmZmVyZWRXcml0ZXIg
ICAoIG5ldyBGaWxlV3JpdGVyICAgKGhpc3RvcnlQYXRoICAsIHRydWUpICApICApICAgOyAgIG91
dCAgLiBwcmludGxuIChyZWFsUGxheWVyICAuIGdldGd1ZXN0dXJlICgpICAuIHRvU3RyaW5nICgp
KSAgOyB9ICAgY2F0Y2ggKCAgIElPRXhjZXB0aW9uIGlvZSApIHsgICAgU3lzdGVtICAuIGVyciAg
LiBwcmludGxuIChpb2UpICA7IH0gIGZpbmFsbHkgeyAgaWYgKCBvdXQgICE9IG51bGwgKSB7ICAg
IG91dCAgLiBjbG9zZSAoKSAgOyB9ICB9dAAwUkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3Rh
bnQoU3RhdGUgIC4gSnVkZ2UpdAAMc3RvcmVIaXN0b3J5c3IAHWNvcmUubGFuZy5Db25kaXRpb25F
eHByZXNzaW9uiIriGx69VJQCAARaAAhuZWdhdGl2ZUwABWNoaWxkcQB+ADtMAARuZXh0cQB+ADtM
AANzdHJxAH4ABHhwAHBwdAAEdHJ1ZXNyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAK
bG9hZEZhY3RvckkACXRocmVzaG9sZHhwP0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZzcQB+AAs/
QAAAAAAACHcIAAAACwAAAAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4cHQAQlJHU19oaXN0b3J5ZmVh
dHVyZS5SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBJbml0KXNxAH4A
LnNxAH4AMncEAAAAAXNxAH4ALnNxAH4AMncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAA
CwAAAAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4c3EAfgA5cQB+AD1zcQB+AAZzcQB+AAs/QAAAAAAA
CHcIAAAACwAAAAB4c3EAfgARdwwAAAAQP0AAAAAAAAB4dAIhICAgU3lzdGVtICAuIG91dCAgLiBw
cmludGxuICgiRG8geW91IHdhbnQgdG8gdmlldyBoaXN0b3J5PyB5OnllcyBuOm5vIikgIDsgICAg
IFNjYW5uZXIgIGlucHV0X3NjYW5uZXIgPSAgbmV3IFNjYW5uZXIgICAoU3lzdGVtICAuIGluKSAg
ICA7ICAgICBTdHJpbmcgIGFuc3dlciA9IGlucHV0X3NjYW5uZXIgIC4gbmV4dExpbmUgKCkgIDsg
aWYgKCBhbnN3ZXIgIC4gZXF1YWxzICgieSIpICkgeyAgICBoaXN0b3J5ICA9ICIiIDsgdHJ5IHsg
ICAgc2NhbiAgPSAgbmV3IFNjYW5uZXIgICAoIG5ldyBGaWxlICAgKGhpc3RvcnlQYXRoKSAgKSAg
IDsgd2hpbGUgKCBzY2FuICAuIGhhc05leHRMaW5lICgpICkgeyAgICBoaXN0b3J5ICArPSBzY2Fu
ICAuIG5leHRMaW5lICgpIDsgfSAgIHNjYW4gIC4gY2xvc2UgKCkgIDsgICBTeXN0ZW0gIC4gb3V0
ICAuIHByaW50bG4gKGhpc3RvcnkpICA7IH0gICBjYXRjaCAoICAgRmlsZU5vdEZvdW5kRXhjZXB0
aW9uIGZuZmUgKSB7ICAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoImZpbGUgbm90IGZvdW5k
IikgIDsgfSAgfSB0AC9SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBJ
bml0KXQAC3ZpZXdIaXN0b3J5c3EAfgBEAHBwcQB+AEZzcQB+AEc/QAAAAAAAAHcIAAAAEAAAAAB4
eHNxAH4ABnNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAHhzcQB+ABF3DAAAABA/QAAAAAAAAHhweHNx
AH4AMncEAAAAAnEAfgBMcQB+AC14eHQACHJHUy5Jbml0c3EAfgAjc3EAfgALP0AAAAAAAAh3CAAA
AAsAAAABdAADYWxsc3EAfgAnc3EAfgAqP0AAAAAAAAh3CAAAAAsAAAABdAA6UkdTZmVhdHVyZS5S
R1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBJbml0KXNxAH4ALnNxAH4A
MncEAAAAAXNxAH4ALnNxAH4AMncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAAAncIAAAAAwAAAAB4
c3EAfgARdwwAAAABP0AAAAAAAAB4c3EAfgA5dAAKUkdTZmVhdHVyZXNxAH4ABnNxAH4ACz9AAAAA
AAACdwgAAAADAAAAAHhzcQB+ABF3DAAAAAE/QAAAAAAAAHh0AFMgICBTeXN0ZW0gIC4gb3V0ICAu
IHByaW50bG4gKCJnYW1lIGJlZ2lucyIpICA7ICAgc3RhdGUgID0gU3RhdGUgIC4gUHJlcGFyZUdl
c3R1cmUgO3QAL1JHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEluaXQp
dAAKaW5pdGlhbGl6ZXNxAH4ARABwcHQABHRydWVzcQB+AEc/QAAAAAAAAHcIAAAAEAAAAAB4eHNx
AH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAAAHhzcQB+ABF3DAAAAAE/QAAAAAAAAHhweHNxAH4A
MncEAAAAAXEAfgBneHh0AAVlbnRlcnNxAH4AI3NxAH4ACz9AAAAAAAAIdwgAAAALAAAAAXEAfgBk
c3EAfgAnc3EAfgAqP0AAAAAAAAh3CAAAAAsAAAADdABFUkdTZmVhdHVyZS5SR1NEb21haW4uc3Rh
dGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBBc2tmb3JQbGF5QWdhaW4pc3EAfgAuc3EAfgAy
dwQAAAABc3EAfgAuc3EAfgAydwQAAAAAeHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAAAHhz
cQB+ABF3DAAAAAE/QAAAAAAAAHhzcQB+ADlxAH4AcHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAAD
AAAAAHhzcQB+ABF3DAAAAAE/QAAAAAAAAHh0AQYgICAgIFNjYW5uZXIgIGlucHV0X3NjYW5uZXIg
PSAgbmV3IFNjYW5uZXIgICAoU3lzdGVtICAuIGluKSAgICA7ICAgU3lzdGVtICAuIG91dCAgLiBw
cmludGxuICgiZG8geW91IHdhbnQgdG8gcGxheSBhZ2Fpbj8geTp5ZXMgbjpubyIpICA7ICAgICBT
dHJpbmcgIHJlc3VsdCA9IGlucHV0X3NjYW5uZXIgIC4gbmV4dExpbmUgKCkgIDsgaWYgKCByZXN1
bHQgIC4gZXF1YWxzICgieSIpICkgeyAgICBzdGF0ZSAgPSBTdGF0ZSAgLiBQcmVwYXJlR2VzdHVy
ZSA7IH0gdAA6UkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gQXNrZm9y
UGxheUFnYWluKXQAFGVudGVyQXNrZm9yUGxheUFnYWluc3EAfgBEAHBwcQB+AHhzcQB+AEc/QAAA
AAAAAHcIAAAAEAAAAAB4eHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAAAHhzcQB+ABF3DAAA
AAE/QAAAAAAAAHhwdABEUkdTZmVhdHVyZS5SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFu
dChTdGF0ZSAgLiBQcmVwYXJlR2VzdHVyZSlzcQB+AC5zcQB+ADJ3BAAAAAFzcQB+AC5zcQB+ADJ3
BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAA
eHNxAH4AOXEAfgBwc3EAfgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9A
AAAAAAAAeHQAWiAgIHJlYWxQbGF5ZXIgIC4gYXNrZm9yUkdTICgpICA7ICAgYWlQbGF5ZXIgIC4g
YXNrZm9yUkdTICgpICA7ICAgc3RhdGUgID0gU3RhdGUgIC4gSnVkZ2UgO3QAOVJHU0RvbWFpbi5z
dGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIFByZXBhcmVHZXN0dXJlKXQAE2VudGVyUHJl
cGFyZUdlc3R1cmVzcQB+AEQAcHBxAH4AeHNxAH4ARz9AAAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAG
c3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAAeHB0ADtSR1NmZWF0
dXJlLlJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXNxAH4A
LnNxAH4AMncEAAAAAXNxAH4ALnNxAH4AMncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAAAncIAAAA
AwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4c3EAfgA5cQB+AHBzcQB+AAZzcQB+AAs/QAAAAAAA
AncIAAAAAwAAAAB4c3EAfgARdwwAAAABP0AAAAAAAAB4dAIaICAgU3lzdGVtICAuIG91dCAgLiBw
cmludGxuICgieW91ciBnZXN0dXJlIGlzICIgICsgcmVhbFBsYXllciAgLiBnZXRndWVzdHVyZSAo
KSAgLiB0b1N0cmluZyAoKSkgIDsgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJBSVBsYXll
cidzIGdlc3R1cmUgaXMgIiAgKyBhaVBsYXllciAgLiBnZXRndWVzdHVyZSAoKSAgLiB0b1N0cmlu
ZyAoKSkgIDsgc3dpdGNoICggUm9ja0dsb3ZlU2Npc3NvciAgLiBqdWRnZSAocmVhbFBsYXllciAg
LiBnZXRndWVzdHVyZSAoKSAgLCBhaVBsYXllciAgLiBnZXRndWVzdHVyZSAoKSkgKSB7ICAgIGNh
c2UgMSA6ICAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoInBsYXllciAxIHdvbiEiKSAgOyBi
cmVhayA7ICAgY2FzZSAwIDogICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgiZHJhdyIpICA7
IGJyZWFrIDsgICBjYXNlICAtIDEgOiAgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJwbGF5
ZXIgMiB3b24iKSAgOyBicmVhayA7IH0gICBzdGF0ZSAgPSBTdGF0ZSAgLiBBc2tmb3JQbGF5QWdh
aW4gO3QAMFJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXQA
CmVudGVySnVkZ2VzcQB+AEQAcHBxAH4AeHNxAH4ARz9AAAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAG
c3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AEXcMAAAAAT9AAAAAAAAAeHB4c3EAfgAydwQA
AAADcQB+AINxAH4Al3EAfgCreHh4cQB+AD0=

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
cHVUb0FkZHEAfgADeHB0AC9SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAg
LiBJbml0KXQAAWV0AAVsZWF2ZXQAGl9yZ3NfaGlzdG9yeWZlYXR1cmVmZWF0dXJldAASUkdTX2hp
c3RvcnlmZWF0dXJlcHB0AAt2aWV3SGlzdG9yeXBzcQB+AAJ0ADBSR1NEb21haW4uc3RhdGUuZXF1
YWxzVG9Db25zdGFudChTdGF0ZSAgLiBKdWRnZSlxAH4ABnQABWxlYXZldAAaX3Jnc19oaXN0b3J5
ZmVhdHVyZWZlYXR1cmVxAH4ACXBwdAAMc3RvcmVIaXN0b3J5cHg=

*/


/* IntermediateInfo:anchorFeature
rO0ABXQAClJHU2ZlYXR1cmU=

*/

