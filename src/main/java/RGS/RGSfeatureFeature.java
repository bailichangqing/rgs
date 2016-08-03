package RGS;
import ddt.lang.*;
import external.*;
import java.util.Scanner;
import java.io.*;
import java.lang.*;import java.rmi.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import rmi.RMIService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class 
 RGSfeatureFeature extends 
 RGSDomain implements Serializable, Cloneable  {

private boolean activated = true;
Map<String, Boolean> previousState = new HashMap<String, Boolean>();
private EventBuffer<FL_EVENT_STEM> sharedBuffer;
public EventBuffer<FL_EVENT_STEM> getSharedBuffer(){
return this.sharedBuffer;
}
 public Object clone() throws CloneNotSupportedException { return super.clone(); }
public void activate() { activated = true; }
public void deactivate() { activated = false; }
public boolean isActivated() { return activated; }

public  RGSfeatureFeature()
{
super();
{Map<String, Boolean>currentState= new HashMap<String, Boolean>(previousState);
currentState.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
currentState.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
currentState.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
previousState = new HashMap<String, Boolean>(currentState);}
}
public  RGSfeatureFeature(  Player  realPlayer ,   Player  aiPlayer)
{
super();
RGSDomain.state = State  . Init;
RGSDomain.aiPlayer = aiPlayer;
RGSDomain.realPlayer = realPlayer;
{Map<String, Boolean>currentState= new HashMap<String, Boolean>(previousState);
currentState.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
currentState.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
currentState.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
previousState = new HashMap<String, Boolean>(currentState);}
sharedBuffer = new EventBuffer<FL_EVENT_STEM>();
ExecutorService threadExecuter = Executors.newCachedThreadPool();
class Consumer implements Runnable{
private EventBuffer<FL_EVENT_STEM> buffer;
public Consumer(EventBuffer<FL_EVENT_STEM> buffer){
this.buffer = buffer;
}
public void run() {
while(true){
try{
RGSfeatureFeature.this.XEvent(buffer.remove());
}catch(Exception ex){
ex.printStackTrace();
}//end of catch
}//end of while
}//end of run
}//end of Consumer Class
Consumer consumer = new Consumer(sharedBuffer);
threadExecuter.execute(consumer);
}

 
         
      
 /**********************************/
public synchronized void initialize(Init e)
{
try { 
if (activated)
{
System . out . println ( "game begins" ) ;
state = State . PrepareGesture ;
}

} 
finally {}
}


 
      
      
      
 /**********************************/
public synchronized void enterPrepareGesture( FL_EVENT_STEM  e)
{
try { 
if (activated)
{
realPlayer . askforRGS ( ) ;
aiPlayer . askforRGS ( ) ;
state = State . Judge ;
}

} 
finally {}
}


 
                   
                   
                   
 
   
         
  
   
         
  
    
         
  
 
      
 /**********************************/
public synchronized void enterJudge( FL_EVENT_STEM  e)
{
try { 
if (activated)
{
System . out . println ( "your gesture is " + realPlayer . getguesture ( ) . toString ( ) ) ;
System . out . println ( "AIPlayer's gesture is " + aiPlayer . getguesture ( ) . toString ( ) ) ;
switch ( RockGloveScissor . judge ( realPlayer . getguesture ( ) , aiPlayer . getguesture ( ) ) ) {
case 1 : System . out . println ( "player 1 won!" ) ;
break ;
case 0 : System . out . println ( "draw" ) ;
break ;
case - 1 : System . out . println ( "player 2 won" ) ;
break ;
}
state = State . AskforPlayAgain ;
}

} 
finally {}
}


 
           
         
         
         
 
      
 
 /**********************************/
public synchronized void enterAskforPlayAgain( FL_EVENT_STEM  e)
{
try { 
if (activated)
{
Scanner input_scanner = new Scanner ( System . in ) ;
System . out . println ( "do you want to play again? y:yes n:no" ) ;
String result = input_scanner . nextLine ( ) ;
if ( result . equals ( "y" ) ) {
state = State . PrepareGesture ;
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
			{if(true){ if((RGSDomain.state.equalsToConstant(State  . Init))) this.initialize((Init) e);
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
temp = new HashMap<String, Boolean>(previousState);
temp.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
temp.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
temp.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
if(possibleEnter)
			{
			if (!previousState.get("rgsdomain.state.equalstoconstant(state.preparegesture)")&&RGSDomain.state.equalsToConstant(State.PrepareGesture))
			{				noEnterEvent = false;if(true){ if((RGSDomain.state.equalsToConstant(State  . PrepareGesture))) this.enterPrepareGesture(e);
}else{/* no qualifier matched */}			}
			else if (!previousState.get("rgsdomain.state.equalstoconstant(state.askforplayagain)")&&RGSDomain.state.equalsToConstant(State.AskforPlayAgain))
			{				noEnterEvent = false;if(true){ if((RGSDomain.state.equalsToConstant(State  . AskforPlayAgain))) this.enterAskforPlayAgain(e);
}else{/* no qualifier matched */}			}
			else if (!previousState.get("rgsdomain.state.equalstoconstant(state.judge)")&&RGSDomain.state.equalsToConstant(State.Judge))
			{				noEnterEvent = false;if(true){ if((RGSDomain.state.equalsToConstant(State  . Judge))) this.enterJudge(e);
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

protected void finalize() {
try {
super.finalize();
} catch(Throwable e) {
// do nothing
}
}

//ProceedTo handlers
public ProceedToHandler _rgsfeature_initialize_rgsdomain_state_equalstoconstant_state_init_rgs_init_null_soft_binding_handler;
public ProceedToHandler _rgsfeature_enterpreparegesture_rgsdomain_state_equalstoconstant_state_preparegesture_enter_null_soft_binding_handler;
public ProceedToHandler _rgsfeature_enterjudge_rgsdomain_state_equalstoconstant_state_judge_enter_null_soft_binding_handler;
public ProceedToHandler _rgsfeature_enteraskforplayagain_rgsdomain_state_equalstoconstant_state_askforplayagain_enter_null_soft_binding_handler;

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
AAALAAAAAHhzcgARamF2YS51dGlsLkhhc2hTZXS6RIWVlri3NAMAAHhwdwwAAAAQP0AAAAAAAAB4
c3IAF2phdmEudXRpbC5MaW5rZWRIYXNoU2V02GzXWpXdKh4CAAB4cQB+AA13DAAAABA/QAAAAAAA
AXQAA1JHU3hzcgAmY29yZS5jb21waWxlcmVzb3VyY2VzLkV2ZW50Tm9kZU1hcEltcGxoO63QT4+Y
ggIAAUwAA21hcHQAD0xqYXZhL3V0aWwvTWFwO3hwc3EAfgALP0AAAAAAAAh3CAAAAAsAAAACdAAI
ckdTLkluaXRzcgAqY29yZS5jb21waWxlcmVzb3VyY2VzLlF1YWxpZmllck5vZGVNYXBJbXBs6vPc
fcurpLUCAAFMAANtYXBxAH4AE3hwc3EAfgALP0AAAAAAAAh3CAAAAAsAAAABdAADYWxsc3IAKmNv
cmUuY29tcGlsZXJlc291cmNlcy5Db25kaXRpb25Ob2RlTWFwSW1wbHdsFiq+55RpAgABTAADbWFw
dAAoTGNvcmUvY29tcGlsZXJlc291cmNlcy9PcmRlcmVkSGFzaHRhYmxlO3hwc3IAJmNvcmUuY29t
cGlsZXJlc291cmNlcy5PcmRlcmVkSGFzaHRhYmxleGSg3tJkITACAAFMAAxrZXlPcmRlckxpc3R0
ABZMamF2YS91dGlsL0xpbmtlZExpc3Q7eHEAfgALP0AAAAAAAAh3CAAAAAsAAAABdAAvUkdTRG9t
YWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gSW5pdClzcgAlY29yZS5jb21waWxl
cmVzb3VyY2VzLkZpdFN1YmVudHJ5VHJlZWOV/PQLAYmrAgADTAAIY2hpbGRyZW50ABBMamF2YS91
dGlsL0xpc3Q7TAARZGVmYXVsdFByZWNlZGVuY2VxAH4AAUwAA3ZhbHQAI0xjb3JlL2NvbXBpbGVy
ZXNvdXJjZXMvRml0U3ViZW50cnk7eHBzcgAUamF2YS51dGlsLkxpbmtlZExpc3QMKVNdSmCIIgMA
AHhwdwQAAAABc3EAfgAic3EAfgAmdwQAAAAAeHNxAH4ABnNxAH4ACz9AAAAAAAAIdwgAAAALAAAA
AHhzcQB+AA13DAAAABA/QAAAAAAAAHhzcgAnY29yZS5jb21waWxlcmVzb3VyY2VzLkZpdFB1U3Vi
ZW50cnlJbXBsyeojOz7mE5oCAAFMAANtYXBxAH4AE3hyACVjb3JlLmNvbXBpbGVyZXNvdXJjZXMu
Rml0U3ViZW50cnlJbXBs6jkwnHf1IecCAAZMABBmZWF0dXJlTmFtZUVudHJ5cQB+AARMAAtwcmVS
ZWxhdGlvbnEAfgABTAAQcHJvZ3JhbUJvZHlFbnRyeXEAfgAETAAQcHJvZ3JhbUNvbmRpdGlvbnEA
fgAETAAUcHJvZ3JhbVVuaXROYW1lRW50cnlxAH4ABEwADXdoZW5Db25kaXRpb250AB9MY29yZS9s
YW5nL0NvbmRpdGlvbkV4cHJlc3Npb247eHB0AApSR1NmZWF0dXJlc3EAfgAGc3EAfgALP0AAAAAA
AAh3CAAAAAsAAAAAeHNxAH4ADXcMAAAAED9AAAAAAAAAeHQAUyAgIFN5c3RlbSAgLiBvdXQgIC4g
cHJpbnRsbiAoImdhbWUgYmVnaW5zIikgIDsgICBzdGF0ZSAgPSBTdGF0ZSAgLiBQcmVwYXJlR2Vz
dHVyZSA7cQB+ACF0AAppbml0aWFsaXplc3IAHWNvcmUubGFuZy5Db25kaXRpb25FeHByZXNzaW9u
iIriGx69VJQCAARaAAhuZWdhdGl2ZUwABWNoaWxkcQB+AC9MAARuZXh0cQB+AC9MAANzdHJxAH4A
BHhwAHBwdAAEdHJ1ZXNyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3Rv
ckkACXRocmVzaG9sZHhwP0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZzcQB+AAs/QAAAAAAACHcI
AAAACwAAAAB4c3EAfgANdwwAAAAQP0AAAAAAAAB4cHhzcQB+ACZ3BAAAAAFxAH4AIXh4dAAFZW50
ZXJzcQB+ABdzcQB+AAs/QAAAAAAACHcIAAAACwAAAAFxAH4AGnNxAH4AG3NxAH4AHj9AAAAAAAAI
dwgAAAALAAAAA3QAOVJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIFBy
ZXBhcmVHZXN0dXJlKXNxAH4AInNxAH4AJncEAAAAAXNxAH4AInNxAH4AJncEAAAAAHhzcQB+AAZz
cQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgANdwwAAAAQP0AAAAAAAAB4c3EAfgAtcQB+ADFz
cQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgANdwwAAAAQP0AAAAAAAAB4dABaICAg
cmVhbFBsYXllciAgLiBhc2tmb3JSR1MgKCkgIDsgICBhaVBsYXllciAgLiBhc2tmb3JSR1MgKCkg
IDsgICBzdGF0ZSAgPSBTdGF0ZSAgLiBKdWRnZSA7cQB+AEV0ABNlbnRlclByZXBhcmVHZXN0dXJl
c3EAfgA3AHBwcQB+ADlzcQB+ADo/QAAAAAAAAHcIAAAAEAAAAAB4eHNxAH4ABnNxAH4ACz9AAAAA
AAAIdwgAAAALAAAAAHhzcQB+AA13DAAAABA/QAAAAAAAAHhwdAA6UkdTRG9tYWluLnN0YXRlLmVx
dWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gQXNrZm9yUGxheUFnYWluKXNxAH4AInNxAH4AJncEAAAA
AXNxAH4AInNxAH4AJncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgAN
dwwAAAAQP0AAAAAAAAB4c3EAfgAtcQB+ADFzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4
c3EAfgANdwwAAAAQP0AAAAAAAAB4dAEGICAgICBTY2FubmVyICBpbnB1dF9zY2FubmVyID0gIG5l
dyBTY2FubmVyICAgKFN5c3RlbSAgLiBpbikgICAgOyAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRs
biAoImRvIHlvdSB3YW50IHRvIHBsYXkgYWdhaW4/IHk6eWVzIG46bm8iKSAgOyAgICAgU3RyaW5n
ICByZXN1bHQgPSBpbnB1dF9zY2FubmVyICAuIG5leHRMaW5lICgpICA7IGlmICggcmVzdWx0ICAu
IGVxdWFscyAoInkiKSApIHsgICAgc3RhdGUgID0gU3RhdGUgIC4gUHJlcGFyZUdlc3R1cmUgOyB9
IHEAfgBYdAAUZW50ZXJBc2tmb3JQbGF5QWdhaW5zcQB+ADcAcHBxAH4AOXNxAH4AOj9AAAAAAAAA
dwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4ADXcMAAAAED9A
AAAAAAAAeHB0ADBSR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBKdWRn
ZSlzcQB+ACJzcQB+ACZ3BAAAAAFzcQB+ACJzcQB+ACZ3BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAA
AAh3CAAAAAsAAAAAeHNxAH4ADXcMAAAAED9AAAAAAAAAeHNxAH4ALXEAfgAxc3EAfgAGc3EAfgAL
P0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4ADXcMAAAAED9AAAAAAAAAeHQCGiAgIFN5c3RlbSAgLiBv
dXQgIC4gcHJpbnRsbiAoInlvdXIgZ2VzdHVyZSBpcyAiICArIHJlYWxQbGF5ZXIgIC4gZ2V0Z3Vl
c3R1cmUgKCkgIC4gdG9TdHJpbmcgKCkpICA7ICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgi
QUlQbGF5ZXIncyBnZXN0dXJlIGlzICIgICsgYWlQbGF5ZXIgIC4gZ2V0Z3Vlc3R1cmUgKCkgIC4g
dG9TdHJpbmcgKCkpICA7IHN3aXRjaCAoIFJvY2tHbG92ZVNjaXNzb3IgIC4ganVkZ2UgKHJlYWxQ
bGF5ZXIgIC4gZ2V0Z3Vlc3R1cmUgKCkgICwgYWlQbGF5ZXIgIC4gZ2V0Z3Vlc3R1cmUgKCkpICkg
eyAgICBjYXNlIDEgOiAgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJwbGF5ZXIgMSB3b24h
IikgIDsgYnJlYWsgOyAgIGNhc2UgMCA6ICAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoImRy
YXciKSAgOyBicmVhayA7ICAgY2FzZSAgLSAxIDogICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxu
ICgicGxheWVyIDIgd29uIikgIDsgYnJlYWsgOyB9ICAgc3RhdGUgID0gU3RhdGUgIC4gQXNrZm9y
UGxheUFnYWluIDtxAH4Aa3QACmVudGVySnVkZ2VzcQB+ADcAcHBxAH4AOXNxAH4AOj9AAAAAAAAA
dwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4ADXcMAAAAED9A
AAAAAAAAeHB4c3EAfgAmdwQAAAADcQB+AEVxAH4Aa3EAfgBYeHh4cQB+ADE=

*/


/* IntermediateInfo:MergedInteractionTable
rO0ABXNyACZjb3JlLnRhYmxlLkZlYXR1cmVJbnRlcmFjdGlvblRhYmxlSW1wbKRW9OnaNkzmAgAF
WgAQaXNGZWF0dXJlTmFtZVNldEwAEmRlZmF1bHRQcmVSZWxhdGlvbnQAKkxjb3JlL2NvbXBpbGVy
ZXNvdXJjZXMvUHJlY2VkZW5jZVJlbGF0aW9uO0wAB2RvbWFpbnN0AA9MamF2YS91dGlsL1NldDtM
AApldmVudE5vZGVzdAAoTGNvcmUvY29tcGlsZXJlc291cmNlcy9FdmVudE5vZGVNYXBJbXBsO0wA
C2ZlYXR1cmVOYW1ldAASTGphdmEvbGFuZy9TdHJpbmc7eHABc3IAKWNvcmUuY29kZWdlbmVyYXRv
ci5QcmVjZWRlbmNlUmVsYXRpb25JbXBspX7kJRXyFGoCAAFMAAlwcmVPcmRlcnN0ABNMamF2YS91
dGlsL0hhc2hTZXQ7eHIAJmNvcmUuY29kZWdlbmVyYXRvci5QYXJ0aWFsT3JkZXJpbmdUcmVl2diA
5Z4HBGACAAFMAAVub2Rlc3QAFUxqYXZhL3V0aWwvSGFzaHRhYmxlO3hwc3IAE2phdmEudXRpbC5I
YXNodGFibGUTuw8lIUrkuAMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAIdwgA
AAALAAAAAHhzcgARamF2YS51dGlsLkhhc2hTZXS6RIWVlri3NAMAAHhwdwwAAAAQP0AAAAAAAAB4
c3IAF2phdmEudXRpbC5MaW5rZWRIYXNoU2V02GzXWpXdKh4CAAB4cQB+AA13DAAAABA/QAAAAAAA
AXQAA1JHU3hzcgAmY29yZS5jb21waWxlcmVzb3VyY2VzLkV2ZW50Tm9kZU1hcEltcGxoO63QT4+Y
ggIAAUwAA21hcHQAD0xqYXZhL3V0aWwvTWFwO3hwc3EAfgALP0AAAAAAAAh3CAAAAAsAAAACdAAI
ckdTLkluaXRzcgAqY29yZS5jb21waWxlcmVzb3VyY2VzLlF1YWxpZmllck5vZGVNYXBJbXBs6vPc
fcurpLUCAAFMAANtYXBxAH4AE3hwc3EAfgALP0AAAAAAAAh3CAAAAAsAAAABdAADYWxsc3IAKmNv
cmUuY29tcGlsZXJlc291cmNlcy5Db25kaXRpb25Ob2RlTWFwSW1wbHdsFiq+55RpAgABTAADbWFw
dAAoTGNvcmUvY29tcGlsZXJlc291cmNlcy9PcmRlcmVkSGFzaHRhYmxlO3hwc3IAJmNvcmUuY29t
cGlsZXJlc291cmNlcy5PcmRlcmVkSGFzaHRhYmxleGSg3tJkITACAAFMAAxrZXlPcmRlckxpc3R0
ABZMamF2YS91dGlsL0xpbmtlZExpc3Q7eHEAfgALP0AAAAAAAAh3CAAAAAsAAAABdAA6UkdTZmVh
dHVyZS5SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBJbml0KXNyACVj
b3JlLmNvbXBpbGVyZXNvdXJjZXMuRml0U3ViZW50cnlUcmVlY5X89AsBiasCAANMAAhjaGlsZHJl
bnQAEExqYXZhL3V0aWwvTGlzdDtMABFkZWZhdWx0UHJlY2VkZW5jZXEAfgABTAADdmFsdAAjTGNv
cmUvY29tcGlsZXJlc291cmNlcy9GaXRTdWJlbnRyeTt4cHNyABRqYXZhLnV0aWwuTGlua2VkTGlz
dAwpU11KYIgiAwAAeHB3BAAAAAFzcQB+ACJzcQB+ACZ3BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAA
AAh3CAAAAAsAAAAAeHNxAH4ADXcMAAAAED9AAAAAAAAAeHNyACdjb3JlLmNvbXBpbGVyZXNvdXJj
ZXMuRml0UHVTdWJlbnRyeUltcGzJ6iM7PuYTmgIAAUwAA21hcHEAfgATeHIAJWNvcmUuY29tcGls
ZXJlc291cmNlcy5GaXRTdWJlbnRyeUltcGzqOTCcd/Uh5wIABkwAEGZlYXR1cmVOYW1lRW50cnlx
AH4ABEwAC3ByZVJlbGF0aW9ucQB+AAFMABBwcm9ncmFtQm9keUVudHJ5cQB+AARMABBwcm9ncmFt
Q29uZGl0aW9ucQB+AARMABRwcm9ncmFtVW5pdE5hbWVFbnRyeXEAfgAETAANd2hlbkNvbmRpdGlv
bnQAH0xjb3JlL2xhbmcvQ29uZGl0aW9uRXhwcmVzc2lvbjt4cHQAClJHU2ZlYXR1cmVzcQB+AAZz
cQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgANdwwAAAAQP0AAAAAAAAB4dABTICAgU3lzdGVt
ICAuIG91dCAgLiBwcmludGxuICgiZ2FtZSBiZWdpbnMiKSAgOyAgIHN0YXRlICA9IFN0YXRlICAu
IFByZXBhcmVHZXN0dXJlIDt0AC9SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0
ZSAgLiBJbml0KXQACmluaXRpYWxpemVzcgAdY29yZS5sYW5nLkNvbmRpdGlvbkV4cHJlc3Npb26I
iuIbHr1UlAIABFoACG5lZ2F0aXZlTAAFY2hpbGRxAH4AL0wABG5leHRxAH4AL0wAA3N0cnEAfgAE
eHAAcHB0AAR0cnVlc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9y
SQAJdGhyZXNob2xkeHA/QAAAAAAAAHcIAAAAEAAAAAB4eHNxAH4ABnNxAH4ACz9AAAAAAAAIdwgA
AAALAAAAAHhzcQB+AA13DAAAABA/QAAAAAAAAHhweHNxAH4AJncEAAAAAXEAfgAheHh0AAVlbnRl
cnNxAH4AF3NxAH4ACz9AAAAAAAAIdwgAAAALAAAAAXEAfgAac3EAfgAbc3EAfgAeP0AAAAAAAAh3
CAAAAAsAAAADdABFUkdTZmVhdHVyZS5SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChT
dGF0ZSAgLiBBc2tmb3JQbGF5QWdhaW4pc3EAfgAic3EAfgAmdwQAAAABc3EAfgAic3EAfgAmdwQA
AAAAeHNxAH4ABnNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAHhzcQB+AA13DAAAABA/QAAAAAAAAHhz
cQB+AC1xAH4AMXNxAH4ABnNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAHhzcQB+AA13DAAAABA/QAAA
AAAAAHh0AQYgICAgIFNjYW5uZXIgIGlucHV0X3NjYW5uZXIgPSAgbmV3IFNjYW5uZXIgICAoU3lz
dGVtICAuIGluKSAgICA7ICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgiZG8geW91IHdhbnQg
dG8gcGxheSBhZ2Fpbj8geTp5ZXMgbjpubyIpICA7ICAgICBTdHJpbmcgIHJlc3VsdCA9IGlucHV0
X3NjYW5uZXIgIC4gbmV4dExpbmUgKCkgIDsgaWYgKCByZXN1bHQgIC4gZXF1YWxzICgieSIpICkg
eyAgICBzdGF0ZSAgPSBTdGF0ZSAgLiBQcmVwYXJlR2VzdHVyZSA7IH0gdAA6UkdTRG9tYWluLnN0
YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gQXNrZm9yUGxheUFnYWluKXQAFGVudGVyQXNr
Zm9yUGxheUFnYWluc3EAfgA4AHBwcQB+ADpzcQB+ADs/QAAAAAAAAHcIAAAAEAAAAAB4eHNxAH4A
BnNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAHhzcQB+AA13DAAAABA/QAAAAAAAAHhwdABEUkdTZmVh
dHVyZS5SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBQcmVwYXJlR2Vz
dHVyZSlzcQB+ACJzcQB+ACZ3BAAAAAFzcQB+ACJzcQB+ACZ3BAAAAAB4c3EAfgAGc3EAfgALP0AA
AAAAAAh3CAAAAAsAAAAAeHNxAH4ADXcMAAAAED9AAAAAAAAAeHNxAH4ALXEAfgAxc3EAfgAGc3EA
fgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4ADXcMAAAAED9AAAAAAAAAeHQAWiAgIHJlYWxQbGF5
ZXIgIC4gYXNrZm9yUkdTICgpICA7ICAgYWlQbGF5ZXIgIC4gYXNrZm9yUkdTICgpICA7ICAgc3Rh
dGUgID0gU3RhdGUgIC4gSnVkZ2UgO3QAOVJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50
KFN0YXRlICAuIFByZXBhcmVHZXN0dXJlKXQAE2VudGVyUHJlcGFyZUdlc3R1cmVzcQB+ADgAcHBx
AH4AOnNxAH4AOz9AAAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsA
AAAAeHNxAH4ADXcMAAAAED9AAAAAAAAAeHB0ADtSR1NmZWF0dXJlLlJHU0RvbWFpbi5zdGF0ZS5l
cXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXNxAH4AInNxAH4AJncEAAAAAXNxAH4AInNx
AH4AJncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgANdwwAAAAQP0AA
AAAAAAB4c3EAfgAtcQB+ADFzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgANdwwA
AAAQP0AAAAAAAAB4dAIaICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgieW91ciBnZXN0dXJl
IGlzICIgICsgcmVhbFBsYXllciAgLiBnZXRndWVzdHVyZSAoKSAgLiB0b1N0cmluZyAoKSkgIDsg
ICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJBSVBsYXllcidzIGdlc3R1cmUgaXMgIiAgKyBh
aVBsYXllciAgLiBnZXRndWVzdHVyZSAoKSAgLiB0b1N0cmluZyAoKSkgIDsgc3dpdGNoICggUm9j
a0dsb3ZlU2Npc3NvciAgLiBqdWRnZSAocmVhbFBsYXllciAgLiBnZXRndWVzdHVyZSAoKSAgLCBh
aVBsYXllciAgLiBnZXRndWVzdHVyZSAoKSkgKSB7ICAgIGNhc2UgMSA6ICAgIFN5c3RlbSAgLiBv
dXQgIC4gcHJpbnRsbiAoInBsYXllciAxIHdvbiEiKSAgOyBicmVhayA7ICAgY2FzZSAwIDogICAg
U3lzdGVtICAuIG91dCAgLiBwcmludGxuICgiZHJhdyIpICA7IGJyZWFrIDsgICBjYXNlICAtIDEg
OiAgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJwbGF5ZXIgMiB3b24iKSAgOyBicmVhayA7
IH0gICBzdGF0ZSAgPSBTdGF0ZSAgLiBBc2tmb3JQbGF5QWdhaW4gO3QAMFJHU0RvbWFpbi5zdGF0
ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXQACmVudGVySnVkZ2VzcQB+ADgAcHBx
AH4AOnNxAH4AOz9AAAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsA
AAAAeHNxAH4ADXcMAAAAED9AAAAAAAAAeHB4c3EAfgAmdwQAAAADcQB+AFpxAH4ARnEAfgBueHh4
cQB+ADE=

*/


/* IntermediateInfo:domains
rO0ABXNyABdqYXZhLnV0aWwuTGlua2VkSGFzaFNldNhs11qV3SoeAgAAeHIAEWphdmEudXRpbC5I
YXNoU2V0ukSFlZa4tzQDAAB4cHcMAAAAED9AAAAAAAABdAADUkdTeA==

*/


/* IntermediateInfo:proceedToPuhandler
rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAEdwQAAAAE
c3IAJ2NvcmUuZGF0YXN0cnVjdHVyZS5Qcm9jZWVkVG9IYW5kbGVySW5mb/NJGznJidC0AgAJTAAJ
Y29uZGl0aW9udAASTGphdmEvbGFuZy9TdHJpbmc7TAAPZXZlbnRJZGVudGlmaWVycQB+AANMAAll
dmVudFR5cGVxAH4AA0wAD2ZlYXR1cmVJbnN0YW5jZXEAfgADTAALZmVhdHVyZU5hbWVxAH4AA0wA
CXByb2NlZWRUb3EAfgADTAARcHJvY2VlZFRvSW5zdGFuY2VxAH4AA0wABnB1TmFtZXEAfgADTAAH
cHVUb0FkZHEAfgADeHB0AC9SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAg
LiBJbml0KXQAAWV0AAhyR1MuSW5pdHQAEl9yZ3NmZWF0dXJlZmVhdHVyZXQAClJHU2ZlYXR1cmVw
cHQACmluaXRpYWxpemVwc3EAfgACdAA5UkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQo
U3RhdGUgIC4gUHJlcGFyZUdlc3R1cmUpcQB+AAZ0AAVlbnRlcnQAEl9yZ3NmZWF0dXJlZmVhdHVy
ZXEAfgAJcHB0ABNlbnRlclByZXBhcmVHZXN0dXJlcHNxAH4AAnQAMFJHU0RvbWFpbi5zdGF0ZS5l
cXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXEAfgAGdAAFZW50ZXJ0ABJfcmdzZmVhdHVy
ZWZlYXR1cmVxAH4ACXBwdAAKZW50ZXJKdWRnZXBzcQB+AAJ0ADpSR1NEb21haW4uc3RhdGUuZXF1
YWxzVG9Db25zdGFudChTdGF0ZSAgLiBBc2tmb3JQbGF5QWdhaW4pcQB+AAZ0AAVlbnRlcnQAEl9y
Z3NmZWF0dXJlZmVhdHVyZXEAfgAJcHB0ABRlbnRlckFza2ZvclBsYXlBZ2FpbnB4

*/

