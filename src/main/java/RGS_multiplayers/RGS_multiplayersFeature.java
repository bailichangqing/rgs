package RGS_multiplayers;
import RGS.*;
import ddt.lang.*;
import external.*;
import java.io.*;
import java.net.*;
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

public class RGS_multiplayersFeature
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

public RGS_multiplayersFeature(  Player  realPlayer ,   Player  aiPlayer) {
super();
RGSDomain.realPlayer = realPlayer;
RGSDomain.aiPlayer = aiPlayer;
RGSDomain.state = State  . Init;
{Map<String, Boolean>currentState= new HashMap<String, Boolean>(previousState);
currentState.put("rgsdomain.state.equalstoconstant(state.judge)",RGSDomain.state.equalsToConstant(State.Judge));
currentState.put("rgsdomain.state.equalstoconstant(state.preparegesture)",RGSDomain.state.equalsToConstant(State.PrepareGesture));
currentState.put("rgsdomain.state.equalstoconstant(state.askforplayagain)",RGSDomain.state.equalsToConstant(State.AskforPlayAgain));
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
RGS_multiplayersFeature.this.XEvent((FL_EVENT_STEM)buffer.remove());
}catch(Exception ex){
ex.printStackTrace();
}//end of catch
}//end of while
}//end of run
}//end of Consumer Class
public  RGS_multiplayersFeature(RGSfeatureFeature _rgsfeaturefeature)
 {
super();
this._rgsfeaturefeature = _rgsfeaturefeature;
}
/***********************************/

 ;

 String id;

 int gamemode;

 HashMap<Integer,String> idmap;

 int playercount;

 ArrayList<Socket> clientsocketlist;

 ArrayList<RockGloveScissor> glist;

 int serverclientflag;

 Socket clientsocket;

 ServerSocket ss;

 Socket is;

 PrintWriter pw;

 BufferedReader in;

 Socket tmpsocket;

 PrintWriter out;

 Iterator<Socket> si;

 String inplayername;

 
         
           
         
         
 
    
    
         
        
         
        
         
 
    
    
          
        
         
        
       
                
        
           
        
          
 
         
        
       
                
        
           
        
 
        
        
 
        
              
       
         
 
 
 
 
    
          
              
                
       
         
         
 
 
 
 
    
 
 /**********************************/
public synchronized void choosegamemode( FL_EVENT_STEM  e)
 throws java.io.IOException{
try { 
if (activated)
{
System . out . println ( "do you want to play with other players? y:yes n:no" ) ;
Scanner input_scanner = new Scanner ( System . in ) ;
String answer = input_scanner . nextLine ( ) ;
if ( answer . equals ( "y" ) ) {
gamemode = 1 ;
playercount = 1 ;
System . out . println ( "set your name" ) ;
id = input_scanner . nextLine ( ) ;
System . out . println ( "do you want to host a game or join a game? 0:host 1:join" ) ;
answer = input_scanner . nextLine ( ) ;
if ( answer . equals ( "0" ) ) {
serverclientflag = 0 ;
ss = null ;
clientsocketlist = new ArrayList < Socket > ( ) ;
ss = new ServerSocket ( 9090 ) ;
System . out . println ( "wait for another player" ) ;
try{ //for resume accept & 
 is = ss . accept ( ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_choosegamemode_accept_java_io_ioexception!=null)_rgs_multiplayers_choosegamemode_accept_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 clientsocketlist . add ( is ) ;
try{ //for resume getInputStream & 
 in = new BufferedReader ( new InputStreamReader ( is . getInputStream ( ) ) ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_choosegamemode_getinputstream_java_io_ioexception!=null)_rgs_multiplayers_choosegamemode_getinputstream_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 try{ //for resume readLine & 
 inplayername = in . readLine ( ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_choosegamemode_readline_java_io_ioexception!=null)_rgs_multiplayers_choosegamemode_readline_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 System . out . println ( inplayername + " is ready do you want to start game? y:yes n:no" ) ;
answer = input_scanner . nextLine ( ) ;
while ( ! answer . equals ( "y" ) ) {
System . out . println ( "wait for another player" ) ;
try{ //for resume accept & 
 is = ss . accept ( ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_choosegamemode_accept_java_io_ioexception!=null)_rgs_multiplayers_choosegamemode_accept_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 clientsocketlist . add ( is ) ;
try{ //for resume getInputStream & 
 in = new BufferedReader ( new InputStreamReader ( is . getInputStream ( ) ) ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_choosegamemode_getinputstream_java_io_ioexception!=null)_rgs_multiplayers_choosegamemode_getinputstream_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 try{ //for resume readLine & 
 inplayername = in . readLine ( ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_choosegamemode_readline_java_io_ioexception!=null)_rgs_multiplayers_choosegamemode_readline_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 System . out . println ( inplayername + " is ready do you want to start game? y:yes n:no" ) ;
answer = input_scanner . nextLine ( ) ;
}
si = clientsocketlist . iterator ( ) ;
while ( si . hasNext ( ) ) {
tmpsocket = si . next ( ) ;
try{ //for resume getOutputStream & 
 pw = new PrintWriter ( tmpsocket . getOutputStream ( ) , true ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_choosegamemode_getoutputstream_java_io_ioexception!=null)_rgs_multiplayers_choosegamemode_getoutputstream_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 pw . println ( "go" ) ;
System . out . println ( "done go" ) ;
}
}
else {
serverclientflag = 1 ;
clientsocket = new Socket ( "localhost" , 9090 ) ;
try{ //for resume getOutputStream & 
 out = new PrintWriter ( clientsocket . getOutputStream ( ) , true ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_choosegamemode_getoutputstream_java_io_ioexception!=null)_rgs_multiplayers_choosegamemode_getoutputstream_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 try{ //for resume getInputStream & 
 in = new BufferedReader ( new InputStreamReader ( clientsocket . getInputStream ( ) ) ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_choosegamemode_getinputstream_java_io_ioexception!=null)_rgs_multiplayers_choosegamemode_getinputstream_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 out . println ( id ) ;
try{ //for resume readLine & 
 String start = in . readLine ( ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_choosegamemode_readline_java_io_ioexception!=null)_rgs_multiplayers_choosegamemode_readline_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 System . out . println ( "prepare gusture" ) ;
}
}
else {
gamemode = 0 ;
}
}

} 
finally {}
}


 BufferedReader br;

 String gesture;

 Socket tmp;

 
      
 
         
      
 
          
           
        
        
 
        
                
        
         
 
         
 
          
 
         
 
          
 
         
 
 
 
         
 
 
 
 
 
              
               
 
 
 /**********************************/
public synchronized void preparejudge( FL_EVENT_STEM  e)
 throws java.io.IOException{
try { 
if (activated)
{
if ( gamemode == 1 ) {
System . out . println ( "enter pj" ) ;
if ( serverclientflag == 0 ) {
glist = new ArrayList < RockGloveScissor > ( ) ;
glist . add ( realPlayer . getguesture ( ) ) ;
si = clientsocketlist . iterator ( ) ;
while ( si . hasNext ( ) ) {
tmp = si . next ( ) ;
try{ //for resume getInputStream & 
 br = new BufferedReader ( new InputStreamReader ( tmp . getInputStream ( ) ) ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_preparejudge_getinputstream_java_io_ioexception!=null)_rgs_multiplayers_preparejudge_getinputstream_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 try{ //for resume readLine & 
 gesture = br . readLine ( ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_preparejudge_readline_java_io_ioexception!=null)_rgs_multiplayers_preparejudge_readline_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 if ( gesture . equals ( "Rock" ) ) {
glist . add ( RockGloveScissor . Rock ) ;
}
else if ( gesture . equals ( "Glove" ) ) {
glist . add ( RockGloveScissor . Glove ) ;
}
else if ( gesture . equals ( "Scissor" ) ) {
glist . add ( RockGloveScissor . Scissor ) ;
}
else {
glist . add ( RockGloveScissor . Nothing ) ;
}
}
}
else {
try{ //for resume getOutputStream & 
 pw = new PrintWriter ( clientsocket . getOutputStream ( ) , true ) ;
}
catch( java.io.IOException ex){
if(_rgs_multiplayers_preparejudge_getoutputstream_java_io_ioexception!=null)_rgs_multiplayers_preparejudge_getoutputstream_java_io_ioexception.handle(ex);else throw ex; 
} // automacitally created for resume 
 pw . println ( realPlayer . getguesture ( ) . toString ( ) ) ;
}
}
}

} 
finally {}
}


 String gameresult;

 Iterator<Integer> winneriterator;

 Iterator<RockGloveScissor> rgsi;

 RockGloveScissor rgstmp;

 
         
      
 
    
             
          
 
         
 
 
 
         
        
        
 
             
 
         
 
 
 
 
 
      
 public boolean get_multiplayersjudge_0_condition(){
return (gamemode==1);
}
/**********************************/
public synchronized void multiplayersjudge_0( FL_EVENT_STEM  e)
{
try { 
if (activated)
{
System . out . println ( "enter judge" ) ;
if ( serverclientflag == 0 ) {
gameresult = "" ;
ArrayList < Integer > winners = RockGloveScissor . judge ( glist ) ;
if ( winners . size ( ) == 0 ) {
System . out . println ( "draw" ) ;
}
else {
System . out . print ( "winners are: " ) ;
winneriterator = winners . iterator ( ) ;
while ( winneriterator . hasNext ( ) ) {
System . out . print ( winneriterator . next ( ) ) ;
}
System . out . print ( "\n" ) ;
}
}
else {
}
state = State . AskforPlayAgain ;
}

} 
finally {}
}
{}public boolean get_multiplayersjudge_1_condition(){
return !((gamemode==1));
}
/**********************************/
public synchronized void multiplayersjudge_1( FL_EVENT_STEM  e)
{
try { 
if (activated)
;
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
			{				noLeaveEvent = false;if(true){try {// for default
			this._rgs_multiplayers_preparejudge_getinputstream_java_io_ioexception = null;this._rgs_multiplayers_preparejudge_getoutputstream_java_io_ioexception = null;this._rgs_multiplayers_preparejudge_readline_java_io_ioexception = null; if(!(RGSDomain.state.equalsToConstant(State  . PrepareGesture))) this.preparejudge(e);
			}//for default hander
catch(java.io.IOException exception)
{
DefaultExceptionHandler defaultExceptionHandler=new DefaultExceptionHandler();
defaultExceptionHandler.setFeaturePackageName("RGS_multiplayers");
defaultExceptionHandler.setFeatureName("RGS_multiplayers");
defaultExceptionHandler.setProgramUnitName("preparejudge");
defaultExceptionHandler.setEventName("leave");
defaultExceptionHandler.setExceptionName("java.io.IOException");
defaultExceptionHandler.printException();
}
}else{/* no qualifier matched */}			}
			else if (previousState.get("rgsdomain.state.equalstoconstant(state.init)") && !(RGSDomain.state.equalsToConstant(State.Init)))
			{				noLeaveEvent = false;if(true){try {// for default
			this._rgs_multiplayers_choosegamemode_readline_java_io_ioexception = null;this._rgs_multiplayers_choosegamemode_getinputstream_java_io_ioexception = null;this._rgs_multiplayers_choosegamemode_accept_java_io_ioexception = null;this._rgs_multiplayers_choosegamemode_getoutputstream_java_io_ioexception = null; if(!(RGSDomain.state.equalsToConstant(State  . Init))) this.choosegamemode(e);
			}//for default hander
catch(java.io.IOException exception)
{
DefaultExceptionHandler defaultExceptionHandler=new DefaultExceptionHandler();
defaultExceptionHandler.setFeaturePackageName("RGS_multiplayers");
defaultExceptionHandler.setFeatureName("RGS_multiplayers");
defaultExceptionHandler.setProgramUnitName("choosegamemode");
defaultExceptionHandler.setEventName("leave");
defaultExceptionHandler.setExceptionName("java.io.IOException");
defaultExceptionHandler.printException();
}
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
			if (!previousState.get("rgsdomain.state.equalstoconstant(state.judge)")&&RGSDomain.state.equalsToConstant(State.Judge))
			{				noEnterEvent = false;if(this.get_multiplayersjudge_0_condition()){ if((RGSDomain.state.equalsToConstant(State  . Judge))) this.multiplayersjudge_0(e);
}else if(this.get_multiplayersjudge_1_condition()){ if((RGSDomain.state.equalsToConstant(State  . Judge))) this.multiplayersjudge_1(e);
if(true){ if((RGSDomain.state.equalsToConstant(State  . Judge))) _rgsfeaturefeature.enterJudge(e);
}}else{/* no qualifier matched */}			}
			else if (!previousState.get("rgsdomain.state.equalstoconstant(state.askforplayagain)")&&RGSDomain.state.equalsToConstant(State.AskforPlayAgain))
			{				noEnterEvent = false;if(true){ if((RGSDomain.state.equalsToConstant(State  . AskforPlayAgain))) _rgsfeaturefeature.enterAskforPlayAgain(e);
}else{/* no qualifier matched */}			}
			else if (!previousState.get("rgsdomain.state.equalstoconstant(state.preparegesture)")&&RGSDomain.state.equalsToConstant(State.PrepareGesture))
			{				noEnterEvent = false;if(true){ if((RGSDomain.state.equalsToConstant(State  . PrepareGesture))) _rgsfeaturefeature.enterPrepareGesture(e);
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

public IResumeHandler _rgs_multiplayers_preparejudge_getinputstream_java_io_ioexception;
public IResumeHandler _rgs_multiplayers_choosegamemode_readline_java_io_ioexception;
public IResumeHandler _rgs_multiplayers_choosegamemode_getinputstream_java_io_ioexception;
public IResumeHandler _rgs_multiplayers_preparejudge_getoutputstream_java_io_ioexception;
public IResumeHandler _rgs_multiplayers_choosegamemode_accept_java_io_ioexception;
public IResumeHandler _rgs_multiplayers_preparejudge_readline_java_io_ioexception;
public IResumeHandler _rgs_multiplayers_choosegamemode_getoutputstream_java_io_ioexception;

protected void finalize() {
try {
super.finalize();
} catch(Throwable e) {
// do nothing
}
}

//ProceedTo handlers
public ProceedToHandler _rgs_multiplayers_choosegamemode_rgsdomain_state_equalstoconstant_state_init_leave_null_soft_binding_handler;
public ProceedToHandler _rgs_multiplayers_preparejudge_rgsdomain_state_equalstoconstant_state_preparegesture_leave_null_soft_binding_handler;
public ProceedToHandler _rgs_multiplayers_multiplayersjudge_0_rgsdomain_state_equalstoconstant_state_judge_enter_null_soft_binding_handler;
public ProceedToHandler _rgs_multiplayers_multiplayersjudge_1_rgsdomain_state_equalstoconstant_state_judge_enter_null_soft_binding_handler;

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
AAALAAAAAnQAEFJHU19tdWx0aXBsYXllcnNzcgAXY29yZS5jb2RlZ2VuZXJhdG9yLk5vZGU57IiE
LEUMtAIABUkAFGRpcmVjdFByZWRlY2Vzc29yTnVtWgAKd2FzVmlzaXRlZEwAD2RpcmVjdFN1Y2NO
b2Rlc3EAfgAJTAAFbGFiZWxxAH4ABEwAC3BhcmVudE5vZGVzcQB+AAd4cAAAAAAAc3EAfgALP0AA
AAAAAAh3CAAAAAsAAAABc3EAfgAOAAAAAQBzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4dAAKUkdT
ZmVhdHVyZXNyABFqYXZhLnV0aWwuSGFzaFNldLpEhZWWuLc0AwAAeHB3DAAAABA/QAAAAAAAAXEA
fgAPeHQAEnN0cmFpZ2h0UHJlY2VkZW5jZXhxAH4ADXNxAH4AFHcMAAAAED9AAAAAAAAAeHEAfgAT
cQB+ABF4c3EAfgAUdwwAAAAQP0AAAAAAAAFzcgATamF2YS51dGlsLkFycmF5TGlzdHiB0h2Zx2Gd
AwABSQAEc2l6ZXhwAAAAAncEAAAAAnEAfgANcQB+ABN4eHNyABdqYXZhLnV0aWwuTGlua2VkSGFz
aFNldNhs11qV3SoeAgAAeHEAfgAUdwwAAAAQP0AAAAAAAAF0AANSR1N4c3IAJmNvcmUuY29tcGls
ZXJlc291cmNlcy5FdmVudE5vZGVNYXBJbXBsaDut0E+PmIICAAFMAANtYXB0AA9MamF2YS91dGls
L01hcDt4cHNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAnQABWxlYXZlc3IAKmNvcmUuY29tcGlsZXJl
c291cmNlcy5RdWFsaWZpZXJOb2RlTWFwSW1wbOrz3H3Lq6S1AgABTAADbWFwcQB+AB94cHNxAH4A
Cz9AAAAAAAAIdwgAAAALAAAAAXQAA2FsbHNyACpjb3JlLmNvbXBpbGVyZXNvdXJjZXMuQ29uZGl0
aW9uTm9kZU1hcEltcGx3bBYqvueUaQIAAUwAA21hcHQAKExjb3JlL2NvbXBpbGVyZXNvdXJjZXMv
T3JkZXJlZEhhc2h0YWJsZTt4cHNyACZjb3JlLmNvbXBpbGVyZXNvdXJjZXMuT3JkZXJlZEhhc2h0
YWJsZXhkoN7SZCEwAgABTAAMa2V5T3JkZXJMaXN0dAAWTGphdmEvdXRpbC9MaW5rZWRMaXN0O3hx
AH4ACz9AAAAAAAAIdwgAAAALAAAAAnQAOVJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50
KFN0YXRlICAuIFByZXBhcmVHZXN0dXJlKXNyACVjb3JlLmNvbXBpbGVyZXNvdXJjZXMuRml0U3Vi
ZW50cnlUcmVlY5X89AsBiasCAANMAAhjaGlsZHJlbnQAEExqYXZhL3V0aWwvTGlzdDtMABFkZWZh
dWx0UHJlY2VkZW5jZXEAfgABTAADdmFsdAAjTGNvcmUvY29tcGlsZXJlc291cmNlcy9GaXRTdWJl
bnRyeTt4cHNyABRqYXZhLnV0aWwuTGlua2VkTGlzdAwpU11KYIgiAwAAeHB3BAAAAAFzcQB+AC5z
cQB+ADJ3BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4AFHcMAAAAED9A
AAAAAAAAeHNyACdjb3JlLmNvbXBpbGVyZXNvdXJjZXMuRml0UHVTdWJlbnRyeUltcGzJ6iM7PuYT
mgIAAUwAA21hcHEAfgAfeHIAJWNvcmUuY29tcGlsZXJlc291cmNlcy5GaXRTdWJlbnRyeUltcGzq
OTCcd/Uh5wIABkwAEGZlYXR1cmVOYW1lRW50cnlxAH4ABEwAC3ByZVJlbGF0aW9ucQB+AAFMABBw
cm9ncmFtQm9keUVudHJ5cQB+AARMABBwcm9ncmFtQ29uZGl0aW9ucQB+AARMABRwcm9ncmFtVW5p
dE5hbWVFbnRyeXEAfgAETAANd2hlbkNvbmRpdGlvbnQAH0xjb3JlL2xhbmcvQ29uZGl0aW9uRXhw
cmVzc2lvbjt4cHQAEFJHU19tdWx0aXBsYXllcnNzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAA
AAB4c3EAfgAUdwwAAAAQP0AAAAAAAAB4dAOUIGlmICggZ2FtZW1vZGUgID09IDEgKSB7ICAgIFN5
c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoImVudGVyIHBqIikgIDsgaWYgKCBzZXJ2ZXJjbGllbnRm
bGFnICA9PSAwICkgeyAgICBnbGlzdCAgPSAgbmV3IEFycmF5TGlzdDwgIFJvY2tHbG92ZVNjaXNz
b3IgPiAgICgpICAgOyAgIGdsaXN0ICAuIGFkZCAocmVhbFBsYXllciAgLiBnZXRndWVzdHVyZSAo
KSkgIDsgICBzaSAgPSBjbGllbnRzb2NrZXRsaXN0ICAuIGl0ZXJhdG9yICgpIDsgd2hpbGUgKCBz
aSAgLiBoYXNOZXh0ICgpICkgeyAgICB0bXAgID0gc2kgIC4gbmV4dCAoKSA7ICAgYnIgID0gIG5l
dyBCdWZmZXJlZFJlYWRlciAgICggbmV3IElucHV0U3RyZWFtUmVhZGVyICAgKHRtcCAgLiBnZXRJ
bnB1dFN0cmVhbSAoKSkgICkgICA7ICAgZ2VzdHVyZSAgPSBiciAgLiByZWFkTGluZSAoKSA7IGlm
ICggZ2VzdHVyZSAgLiBlcXVhbHMgKCJSb2NrIikgKSB7ICAgIGdsaXN0ICAuIGFkZCAoUm9ja0ds
b3ZlU2Npc3NvciAgLiBSb2NrKSAgOyB9ICBlbHNlIGlmICggZ2VzdHVyZSAgLiBlcXVhbHMgKCJH
bG92ZSIpICkgeyAgICBnbGlzdCAgLiBhZGQgKFJvY2tHbG92ZVNjaXNzb3IgIC4gR2xvdmUpICA7
IH0gIGVsc2UgaWYgKCBnZXN0dXJlICAuIGVxdWFscyAoIlNjaXNzb3IiKSApIHsgICAgZ2xpc3Qg
IC4gYWRkIChSb2NrR2xvdmVTY2lzc29yICAuIFNjaXNzb3IpICA7IH0gIGVsc2UgeyAgICBnbGlz
dCAgLiBhZGQgKFJvY2tHbG92ZVNjaXNzb3IgIC4gTm90aGluZykgIDsgfSB9IH0gIGVsc2UgeyAg
ICBwdyAgPSAgbmV3IFByaW50V3JpdGVyICAgKGNsaWVudHNvY2tldCAgLiBnZXRPdXRwdXRTdHJl
YW0gKCkgICwgdHJ1ZSkgICA7ICAgcHcgIC4gcHJpbnRsbiAocmVhbFBsYXllciAgLiBnZXRndWVz
dHVyZSAoKSAgLiB0b1N0cmluZyAoKSkgIDsgfSB9IHEAfgAtdAAMcHJlcGFyZWp1ZGdlc3IAHWNv
cmUubGFuZy5Db25kaXRpb25FeHByZXNzaW9uiIriGx69VJQCAARaAAhuZWdhdGl2ZUwABWNoaWxk
cQB+ADtMAARuZXh0cQB+ADtMAANzdHJxAH4ABHhwAHBwdAAEdHJ1ZXNyABFqYXZhLnV0aWwuSGFz
aE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZHhwP0AAAAAAAAB3CAAAABAA
AAAAeHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgAUdwwAAAAQP0AAAAAAAAB4
cHQAL1JHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEluaXQpc3EAfgAu
c3EAfgAydwQAAAABc3EAfgAuc3EAfgAydwQAAAAAeHNxAH4ABnNxAH4ACz9AAAAAAAAIdwgAAAAL
AAAAAHhzcQB+ABR3DAAAABA/QAAAAAAAAHhzcQB+ADlxAH4APXNxAH4ABnNxAH4ACz9AAAAAAAAI
dwgAAAALAAAAAHhzcQB+ABR3DAAAABA/QAAAAAAAAHh0CGAgICBTeXN0ZW0gIC4gb3V0ICAuIHBy
aW50bG4gKCJkbyB5b3Ugd2FudCB0byBwbGF5IHdpdGggb3RoZXIgcGxheWVycz8geTp5ZXMgbjpu
byIpICA7ICAgICBTY2FubmVyICBpbnB1dF9zY2FubmVyID0gIG5ldyBTY2FubmVyICAgKFN5c3Rl
bSAgLiBpbikgICAgOyAgICAgU3RyaW5nICBhbnN3ZXIgPSBpbnB1dF9zY2FubmVyICAuIG5leHRM
aW5lICgpICA7IGlmICggYW5zd2VyICAuIGVxdWFscyAoInkiKSApIHsgICAgZ2FtZW1vZGUgID0g
MSA7ICAgcGxheWVyY291bnQgID0gMSA7ICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgic2V0
IHlvdXIgbmFtZSIpICA7ICAgaWQgID0gaW5wdXRfc2Nhbm5lciAgLiBuZXh0TGluZSAoKSA7ICAg
U3lzdGVtICAuIG91dCAgLiBwcmludGxuICgiZG8geW91IHdhbnQgdG8gaG9zdCBhIGdhbWUgb3Ig
am9pbiBhIGdhbWU/IDA6aG9zdCAxOmpvaW4iKSAgOyAgIGFuc3dlciAgPSBpbnB1dF9zY2FubmVy
ICAuIG5leHRMaW5lICgpIDsgaWYgKCBhbnN3ZXIgIC4gZXF1YWxzICgiMCIpICkgeyAgICBzZXJ2
ZXJjbGllbnRmbGFnICA9IDAgOyAgIHNzICA9IG51bGwgOyAgIGNsaWVudHNvY2tldGxpc3QgID0g
IG5ldyBBcnJheUxpc3Q8ICBTb2NrZXQgPiAgICgpICAgOyAgIHNzICA9ICBuZXcgU2VydmVyU29j
a2V0ICAgKDkwOTApICAgOyAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoIndhaXQgZm9yIGFu
b3RoZXIgcGxheWVyIikgIDsgICBpcyAgPSBzcyAgLiBhY2NlcHQgKCkgOyAgIGNsaWVudHNvY2tl
dGxpc3QgIC4gYWRkIChpcykgIDsgICBpbiAgPSAgbmV3IEJ1ZmZlcmVkUmVhZGVyICAgKCBuZXcg
SW5wdXRTdHJlYW1SZWFkZXIgICAoaXMgIC4gZ2V0SW5wdXRTdHJlYW0gKCkpICApICAgOyAgIGlu
cGxheWVybmFtZSAgPSBpbiAgLiByZWFkTGluZSAoKSA7ICAgU3lzdGVtICAuIG91dCAgLiBwcmlu
dGxuIChpbnBsYXllcm5hbWUgICsgIiBpcyByZWFkeSBkbyB5b3Ugd2FudCB0byBzdGFydCBnYW1l
PyB5OnllcyBuOm5vIikgIDsgICBhbnN3ZXIgID0gaW5wdXRfc2Nhbm5lciAgLiBuZXh0TGluZSAo
KSA7IHdoaWxlICggICEgYW5zd2VyICAuIGVxdWFscyAoInkiKSApIHsgICAgU3lzdGVtICAuIG91
dCAgLiBwcmludGxuICgid2FpdCBmb3IgYW5vdGhlciBwbGF5ZXIiKSAgOyAgIGlzICA9IHNzICAu
IGFjY2VwdCAoKSA7ICAgY2xpZW50c29ja2V0bGlzdCAgLiBhZGQgKGlzKSAgOyAgIGluICA9ICBu
ZXcgQnVmZmVyZWRSZWFkZXIgICAoIG5ldyBJbnB1dFN0cmVhbVJlYWRlciAgIChpcyAgLiBnZXRJ
bnB1dFN0cmVhbSAoKSkgICkgICA7ICAgaW5wbGF5ZXJuYW1lICA9IGluICAuIHJlYWRMaW5lICgp
IDsgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKGlucGxheWVybmFtZSAgKyAiIGlzIHJlYWR5
IGRvIHlvdSB3YW50IHRvIHN0YXJ0IGdhbWU/IHk6eWVzIG46bm8iKSAgOyAgIGFuc3dlciAgPSBp
bnB1dF9zY2FubmVyICAuIG5leHRMaW5lICgpIDsgfSAgIHNpICA9IGNsaWVudHNvY2tldGxpc3Qg
IC4gaXRlcmF0b3IgKCkgOyB3aGlsZSAoIHNpICAuIGhhc05leHQgKCkgKSB7ICAgIHRtcHNvY2tl
dCAgPSBzaSAgLiBuZXh0ICgpIDsgICBwdyAgPSAgbmV3IFByaW50V3JpdGVyICAgKHRtcHNvY2tl
dCAgLiBnZXRPdXRwdXRTdHJlYW0gKCkgICwgdHJ1ZSkgICA7ICAgcHcgIC4gcHJpbnRsbiAoImdv
IikgIDsgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJkb25lIGdvIikgIDsgfSB9ICBlbHNl
IHsgICAgc2VydmVyY2xpZW50ZmxhZyAgPSAxIDsgICBjbGllbnRzb2NrZXQgID0gIG5ldyBTb2Nr
ZXQgICAoImxvY2FsaG9zdCIgICwgOTA5MCkgICA7ICAgb3V0ICA9ICBuZXcgUHJpbnRXcml0ZXIg
ICAoY2xpZW50c29ja2V0ICAuIGdldE91dHB1dFN0cmVhbSAoKSAgLCB0cnVlKSAgIDsgICBpbiAg
PSAgbmV3IEJ1ZmZlcmVkUmVhZGVyICAgKCBuZXcgSW5wdXRTdHJlYW1SZWFkZXIgICAoY2xpZW50
c29ja2V0ICAuIGdldElucHV0U3RyZWFtICgpKSAgKSAgIDsgICBvdXQgIC4gcHJpbnRsbiAoaWQp
ICA7ICAgICBTdHJpbmcgIHN0YXJ0ID0gaW4gIC4gcmVhZExpbmUgKCkgIDsgICBTeXN0ZW0gIC4g
b3V0ICAuIHByaW50bG4gKCJwcmVwYXJlIGd1c3R1cmUiKSAgOyB9IH0gIGVsc2UgeyAgICBnYW1l
bW9kZSAgPSAwIDsgfXEAfgBLdAAOY2hvb3NlZ2FtZW1vZGVzcQB+AEMAcHBxAH4ARXNxAH4ARj9A
AAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4AFHcM
AAAAED9AAAAAAAAAeHB4c3EAfgAydwQAAAACcQB+AEtxAH4ALXh4dAAFZW50ZXJzcQB+ACNzcQB+
AAs/QAAAAAAACHcIAAAACwAAAAFxAH4AJnNxAH4AJ3NxAH4AKj9AAAAAAAAIdwgAAAALAAAAAXQA
MFJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXNxAH4ALnNx
AH4AMncEAAAAAnNxAH4ALnNxAH4AMncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAA
AAB4c3EAfgAUdwwAAAAQP0AAAAAAAAB4c3EAfgA6cQB+AD1zcQB+AAZzcQB+AAs/QAAAAAAACHcI
AAAACwAAAAJ0ABBSR1NfbXVsdGlwbGF5ZXJzc3EAfgAOAAAAAABzcQB+AAs/QAAAAAAACHcIAAAA
CwAAAAFzcQB+AA4AAAABAHNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAHh0AApSR1NmZWF0dXJlc3EA
fgAUdwwAAAAQP0AAAAAAAAFxAH4AcHh0ABJwcmlvcml0eVByZWNlZGVuY2V4cQB+AG9zcQB+ABR3
DAAAABA/QAAAAAAAAHhxAH4AdHEAfgByeHNxAH4AFHcMAAAAED9AAAAAAAAAeHQCHnsgICAgU3lz
dGVtICAuIG91dCAgLiBwcmludGxuICgiZW50ZXIganVkZ2UiKSAgOyBpZiAoIHNlcnZlcmNsaWVu
dGZsYWcgID09IDAgKSB7ICAgIGdhbWVyZXN1bHQgID0gIiIgOyAgICAgQXJyYXlMaXN0PCAgSW50
ZWdlciA+ICB3aW5uZXJzID0gUm9ja0dsb3ZlU2Npc3NvciAgLiBqdWRnZSAoZ2xpc3QpICA7IGlm
ICggd2lubmVycyAgLiBzaXplICgpICA9PSAwICkgeyAgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50
bG4gKCJkcmF3IikgIDsgfSAgZWxzZSB7ICAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnQgKCJ3aW5u
ZXJzIGFyZTogIikgIDsgICB3aW5uZXJpdGVyYXRvciAgPSB3aW5uZXJzICAuIGl0ZXJhdG9yICgp
IDsgd2hpbGUgKCB3aW5uZXJpdGVyYXRvciAgLiBoYXNOZXh0ICgpICkgeyAgICBTeXN0ZW0gIC4g
b3V0ICAuIHByaW50ICh3aW5uZXJpdGVyYXRvciAgLiBuZXh0ICgpKSAgOyB9ICAgU3lzdGVtICAu
IG91dCAgLiBwcmludCAoIlxuIikgIDsgfSB9ICBlbHNlIHsgIH0gICBzdGF0ZSAgPSBTdGF0ZSAg
LiBBc2tmb3JQbGF5QWdhaW4gOyB9cQB+AGR0ABNtdWx0aXBsYXllcnNqdWRnZV8wc3EAfgBDAHBw
dAALZ2FtZW1vZGU9PTFzcQB+AC5zcQB+ADJ3BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAA
AAsAAAAAeHNxAH4AFHcMAAAAED9AAAAAAAAAeHNxAH4AOnEAfgA9c3EAfgAGc3EAfgALP0AAAAAA
AAh3CAAAAAsAAAAAeHNxAH4AFHcMAAAAED9AAAAAAAAAeHQABHsgIH1xAH4AZHQAE211bHRpcGxh
eWVyc2p1ZGdlXzFzcQB+AEMBcQB+AHtwdAAAeHNxAH4ABnNxAH4ACz9AAAAAAAAIdwgAAAALAAAA
AHhzcQB+ABR3DAAAABA/QAAAAAAAAHhweHNxAH4AMncEAAAAAXEAfgBkeHh4cQB+AD0=

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
AAALAAAAAnQAEFJHU19tdWx0aXBsYXllcnNzcgAXY29yZS5jb2RlZ2VuZXJhdG9yLk5vZGU57IiE
LEUMtAIABUkAFGRpcmVjdFByZWRlY2Vzc29yTnVtWgAKd2FzVmlzaXRlZEwAD2RpcmVjdFN1Y2NO
b2Rlc3EAfgAJTAAFbGFiZWxxAH4ABEwAC3BhcmVudE5vZGVzcQB+AAd4cAAAAAAAc3EAfgALP0AA
AAAAAAh3CAAAAAsAAAABc3EAfgAOAAAAAQBzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4dAAKUkdT
ZmVhdHVyZXNyABFqYXZhLnV0aWwuSGFzaFNldLpEhZWWuLc0AwAAeHB3DAAAABA/QAAAAAAAAXEA
fgAPeHQAEnN0cmFpZ2h0UHJlY2VkZW5jZXhxAH4ADXNxAH4AFHcMAAAAED9AAAAAAAAAeHEAfgAT
cQB+ABF4c3EAfgAUdwwAAAAQP0AAAAAAAAFzcgATamF2YS51dGlsLkFycmF5TGlzdHiB0h2Zx2Gd
AwABSQAEc2l6ZXhwAAAAAncEAAAAAnEAfgANcQB+ABN4eHNyABdqYXZhLnV0aWwuTGlua2VkSGFz
aFNldNhs11qV3SoeAgAAeHEAfgAUdwwAAAAQP0AAAAAAAAF0AANSR1N4c3IAJmNvcmUuY29tcGls
ZXJlc291cmNlcy5FdmVudE5vZGVNYXBJbXBsaDut0E+PmIICAAFMAANtYXB0AA9MamF2YS91dGls
L01hcDt4cHNxAH4ACz9AAAAAAAAIdwgAAAALAAAAA3QABWxlYXZlc3IAKmNvcmUuY29tcGlsZXJl
c291cmNlcy5RdWFsaWZpZXJOb2RlTWFwSW1wbOrz3H3Lq6S1AgABTAADbWFwcQB+AB94cHNxAH4A
Cz9AAAAAAAAIdwgAAAALAAAAAXQAA2FsbHNyACpjb3JlLmNvbXBpbGVyZXNvdXJjZXMuQ29uZGl0
aW9uTm9kZU1hcEltcGx3bBYqvueUaQIAAUwAA21hcHQAKExjb3JlL2NvbXBpbGVyZXNvdXJjZXMv
T3JkZXJlZEhhc2h0YWJsZTt4cHNyACZjb3JlLmNvbXBpbGVyZXNvdXJjZXMuT3JkZXJlZEhhc2h0
YWJsZXhkoN7SZCEwAgABTAAMa2V5T3JkZXJMaXN0dAAWTGphdmEvdXRpbC9MaW5rZWRMaXN0O3hx
AH4ACz9AAAAAAAAIdwgAAAALAAAAAnQASlJHU19tdWx0aXBsYXllcnMuUkdTRG9tYWluLnN0YXRl
LmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gUHJlcGFyZUdlc3R1cmUpc3IAJWNvcmUuY29tcGls
ZXJlc291cmNlcy5GaXRTdWJlbnRyeVRyZWVjlfz0CwGJqwIAA0wACGNoaWxkcmVudAAQTGphdmEv
dXRpbC9MaXN0O0wAEWRlZmF1bHRQcmVjZWRlbmNlcQB+AAFMAAN2YWx0ACNMY29yZS9jb21waWxl
cmVzb3VyY2VzL0ZpdFN1YmVudHJ5O3hwc3IAFGphdmEudXRpbC5MaW5rZWRMaXN0DClTXUpgiCID
AAB4cHcEAAAAAXNxAH4ALnNxAH4AMncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAA
AAB4c3EAfgAUdwwAAAAQP0AAAAAAAAB4c3IAJ2NvcmUuY29tcGlsZXJlc291cmNlcy5GaXRQdVN1
YmVudHJ5SW1wbMnqIzs+5hOaAgABTAADbWFwcQB+AB94cgAlY29yZS5jb21waWxlcmVzb3VyY2Vz
LkZpdFN1YmVudHJ5SW1wbOo5MJx39SHnAgAGTAAQZmVhdHVyZU5hbWVFbnRyeXEAfgAETAALcHJl
UmVsYXRpb25xAH4AAUwAEHByb2dyYW1Cb2R5RW50cnlxAH4ABEwAEHByb2dyYW1Db25kaXRpb25x
AH4ABEwAFHByb2dyYW1Vbml0TmFtZUVudHJ5cQB+AARMAA13aGVuQ29uZGl0aW9udAAfTGNvcmUv
bGFuZy9Db25kaXRpb25FeHByZXNzaW9uO3hwdAAQUkdTX211bHRpcGxheWVyc3NxAH4ABnNxAH4A
Cz9AAAAAAAAIdwgAAAALAAAAAHhzcQB+ABR3DAAAABA/QAAAAAAAAHh0A5QgaWYgKCBnYW1lbW9k
ZSAgPT0gMSApIHsgICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgiZW50ZXIgcGoiKSAgOyBp
ZiAoIHNlcnZlcmNsaWVudGZsYWcgID09IDAgKSB7ICAgIGdsaXN0ICA9ICBuZXcgQXJyYXlMaXN0
PCAgUm9ja0dsb3ZlU2Npc3NvciA+ICAgKCkgICA7ICAgZ2xpc3QgIC4gYWRkIChyZWFsUGxheWVy
ICAuIGdldGd1ZXN0dXJlICgpKSAgOyAgIHNpICA9IGNsaWVudHNvY2tldGxpc3QgIC4gaXRlcmF0
b3IgKCkgOyB3aGlsZSAoIHNpICAuIGhhc05leHQgKCkgKSB7ICAgIHRtcCAgPSBzaSAgLiBuZXh0
ICgpIDsgICBiciAgPSAgbmV3IEJ1ZmZlcmVkUmVhZGVyICAgKCBuZXcgSW5wdXRTdHJlYW1SZWFk
ZXIgICAodG1wICAuIGdldElucHV0U3RyZWFtICgpKSAgKSAgIDsgICBnZXN0dXJlICA9IGJyICAu
IHJlYWRMaW5lICgpIDsgaWYgKCBnZXN0dXJlICAuIGVxdWFscyAoIlJvY2siKSApIHsgICAgZ2xp
c3QgIC4gYWRkIChSb2NrR2xvdmVTY2lzc29yICAuIFJvY2spICA7IH0gIGVsc2UgaWYgKCBnZXN0
dXJlICAuIGVxdWFscyAoIkdsb3ZlIikgKSB7ICAgIGdsaXN0ICAuIGFkZCAoUm9ja0dsb3ZlU2Np
c3NvciAgLiBHbG92ZSkgIDsgfSAgZWxzZSBpZiAoIGdlc3R1cmUgIC4gZXF1YWxzICgiU2Npc3Nv
ciIpICkgeyAgICBnbGlzdCAgLiBhZGQgKFJvY2tHbG92ZVNjaXNzb3IgIC4gU2Npc3NvcikgIDsg
fSAgZWxzZSB7ICAgIGdsaXN0ICAuIGFkZCAoUm9ja0dsb3ZlU2Npc3NvciAgLiBOb3RoaW5nKSAg
OyB9IH0gfSAgZWxzZSB7ICAgIHB3ICA9ICBuZXcgUHJpbnRXcml0ZXIgICAoY2xpZW50c29ja2V0
ICAuIGdldE91dHB1dFN0cmVhbSAoKSAgLCB0cnVlKSAgIDsgICBwdyAgLiBwcmludGxuIChyZWFs
UGxheWVyICAuIGdldGd1ZXN0dXJlICgpICAuIHRvU3RyaW5nICgpKSAgOyB9IH0gdAA5UkdTRG9t
YWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gUHJlcGFyZUdlc3R1cmUpdAAMcHJl
cGFyZWp1ZGdlc3IAHWNvcmUubGFuZy5Db25kaXRpb25FeHByZXNzaW9uiIriGx69VJQCAARaAAhu
ZWdhdGl2ZUwABWNoaWxkcQB+ADtMAARuZXh0cQB+ADtMAANzdHJxAH4ABHhwAHBwdAAEdHJ1ZXNy
ABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZHhw
P0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgAU
dwwAAAAQP0AAAAAAAAB4cHQAQFJHU19tdWx0aXBsYXllcnMuUkdTRG9tYWluLnN0YXRlLmVxdWFs
c1RvQ29uc3RhbnQoU3RhdGUgIC4gSW5pdClzcQB+AC5zcQB+ADJ3BAAAAAFzcQB+AC5zcQB+ADJ3
BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4AFHcMAAAAED9AAAAAAAAA
eHNxAH4AOXEAfgA9c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4AFHcMAAAAED9A
AAAAAAAAeHQIYCAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoImRvIHlvdSB3YW50IHRvIHBs
YXkgd2l0aCBvdGhlciBwbGF5ZXJzPyB5OnllcyBuOm5vIikgIDsgICAgIFNjYW5uZXIgIGlucHV0
X3NjYW5uZXIgPSAgbmV3IFNjYW5uZXIgICAoU3lzdGVtICAuIGluKSAgICA7ICAgICBTdHJpbmcg
IGFuc3dlciA9IGlucHV0X3NjYW5uZXIgIC4gbmV4dExpbmUgKCkgIDsgaWYgKCBhbnN3ZXIgIC4g
ZXF1YWxzICgieSIpICkgeyAgICBnYW1lbW9kZSAgPSAxIDsgICBwbGF5ZXJjb3VudCAgPSAxIDsg
ICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJzZXQgeW91ciBuYW1lIikgIDsgICBpZCAgPSBp
bnB1dF9zY2FubmVyICAuIG5leHRMaW5lICgpIDsgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4g
KCJkbyB5b3Ugd2FudCB0byBob3N0IGEgZ2FtZSBvciBqb2luIGEgZ2FtZT8gMDpob3N0IDE6am9p
biIpICA7ICAgYW5zd2VyICA9IGlucHV0X3NjYW5uZXIgIC4gbmV4dExpbmUgKCkgOyBpZiAoIGFu
c3dlciAgLiBlcXVhbHMgKCIwIikgKSB7ICAgIHNlcnZlcmNsaWVudGZsYWcgID0gMCA7ICAgc3Mg
ID0gbnVsbCA7ICAgY2xpZW50c29ja2V0bGlzdCAgPSAgbmV3IEFycmF5TGlzdDwgIFNvY2tldCA+
ICAgKCkgICA7ICAgc3MgID0gIG5ldyBTZXJ2ZXJTb2NrZXQgICAoOTA5MCkgICA7ICAgU3lzdGVt
ICAuIG91dCAgLiBwcmludGxuICgid2FpdCBmb3IgYW5vdGhlciBwbGF5ZXIiKSAgOyAgIGlzICA9
IHNzICAuIGFjY2VwdCAoKSA7ICAgY2xpZW50c29ja2V0bGlzdCAgLiBhZGQgKGlzKSAgOyAgIGlu
ICA9ICBuZXcgQnVmZmVyZWRSZWFkZXIgICAoIG5ldyBJbnB1dFN0cmVhbVJlYWRlciAgIChpcyAg
LiBnZXRJbnB1dFN0cmVhbSAoKSkgICkgICA7ICAgaW5wbGF5ZXJuYW1lICA9IGluICAuIHJlYWRM
aW5lICgpIDsgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKGlucGxheWVybmFtZSAgKyAiIGlz
IHJlYWR5IGRvIHlvdSB3YW50IHRvIHN0YXJ0IGdhbWU/IHk6eWVzIG46bm8iKSAgOyAgIGFuc3dl
ciAgPSBpbnB1dF9zY2FubmVyICAuIG5leHRMaW5lICgpIDsgd2hpbGUgKCAgISBhbnN3ZXIgIC4g
ZXF1YWxzICgieSIpICkgeyAgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJ3YWl0IGZvciBh
bm90aGVyIHBsYXllciIpICA7ICAgaXMgID0gc3MgIC4gYWNjZXB0ICgpIDsgICBjbGllbnRzb2Nr
ZXRsaXN0ICAuIGFkZCAoaXMpICA7ICAgaW4gID0gIG5ldyBCdWZmZXJlZFJlYWRlciAgICggbmV3
IElucHV0U3RyZWFtUmVhZGVyICAgKGlzICAuIGdldElucHV0U3RyZWFtICgpKSAgKSAgIDsgICBp
bnBsYXllcm5hbWUgID0gaW4gIC4gcmVhZExpbmUgKCkgOyAgIFN5c3RlbSAgLiBvdXQgIC4gcHJp
bnRsbiAoaW5wbGF5ZXJuYW1lICArICIgaXMgcmVhZHkgZG8geW91IHdhbnQgdG8gc3RhcnQgZ2Ft
ZT8geTp5ZXMgbjpubyIpICA7ICAgYW5zd2VyICA9IGlucHV0X3NjYW5uZXIgIC4gbmV4dExpbmUg
KCkgOyB9ICAgc2kgID0gY2xpZW50c29ja2V0bGlzdCAgLiBpdGVyYXRvciAoKSA7IHdoaWxlICgg
c2kgIC4gaGFzTmV4dCAoKSApIHsgICAgdG1wc29ja2V0ICA9IHNpICAuIG5leHQgKCkgOyAgIHB3
ICA9ICBuZXcgUHJpbnRXcml0ZXIgICAodG1wc29ja2V0ICAuIGdldE91dHB1dFN0cmVhbSAoKSAg
LCB0cnVlKSAgIDsgICBwdyAgLiBwcmludGxuICgiZ28iKSAgOyAgIFN5c3RlbSAgLiBvdXQgIC4g
cHJpbnRsbiAoImRvbmUgZ28iKSAgOyB9IH0gIGVsc2UgeyAgICBzZXJ2ZXJjbGllbnRmbGFnICA9
IDEgOyAgIGNsaWVudHNvY2tldCAgPSAgbmV3IFNvY2tldCAgICgibG9jYWxob3N0IiAgLCA5MDkw
KSAgIDsgICBvdXQgID0gIG5ldyBQcmludFdyaXRlciAgIChjbGllbnRzb2NrZXQgIC4gZ2V0T3V0
cHV0U3RyZWFtICgpICAsIHRydWUpICAgOyAgIGluICA9ICBuZXcgQnVmZmVyZWRSZWFkZXIgICAo
IG5ldyBJbnB1dFN0cmVhbVJlYWRlciAgIChjbGllbnRzb2NrZXQgIC4gZ2V0SW5wdXRTdHJlYW0g
KCkpICApICAgOyAgIG91dCAgLiBwcmludGxuIChpZCkgIDsgICAgIFN0cmluZyAgc3RhcnQgPSBp
biAgLiByZWFkTGluZSAoKSAgOyAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoInByZXBhcmUg
Z3VzdHVyZSIpICA7IH0gfSAgZWxzZSB7ICAgIGdhbWVtb2RlICA9IDAgOyB9dAAvUkdTRG9tYWlu
LnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gSW5pdCl0AA5jaG9vc2VnYW1lbW9kZXNx
AH4ARABwcHEAfgBGc3EAfgBHP0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZzcQB+AAs/QAAAAAAA
CHcIAAAACwAAAAB4c3EAfgAUdwwAAAAQP0AAAAAAAAB4cHhzcQB+ADJ3BAAAAAJxAH4ALXEAfgBM
eHh0AAhyR1MuSW5pdHNxAH4AI3NxAH4ACz9AAAAAAAAIdwgAAAALAAAAAXQAA2FsbHNxAH4AJ3Nx
AH4AKj9AAAAAAAAIdwgAAAALAAAAAXQAOlJHU2ZlYXR1cmUuUkdTRG9tYWluLnN0YXRlLmVxdWFs
c1RvQ29uc3RhbnQoU3RhdGUgIC4gSW5pdClzcQB+AC5zcQB+ADJ3BAAAAAFzcQB+AC5zcQB+ADJ3
BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AFHcMAAAAAT9AAAAAAAAA
eHNxAH4AOXQAClJHU2ZlYXR1cmVzcQB+AAZzcQB+AAs/QAAAAAAAAncIAAAAAwAAAAB4c3EAfgAU
dwwAAAABP0AAAAAAAAB4dABTICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgiZ2FtZSBiZWdp
bnMiKSAgOyAgIHN0YXRlICA9IFN0YXRlICAuIFByZXBhcmVHZXN0dXJlIDt0AC9SR1NEb21haW4u
c3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBJbml0KXQACmluaXRpYWxpemVzcQB+AEQA
cHB0AAR0cnVlc3EAfgBHP0AAAAAAAAB3CAAAABAAAAAAeHhzcQB+AAZzcQB+AAs/QAAAAAAAAncI
AAAAAwAAAAB4c3EAfgAUdwwAAAABP0AAAAAAAAB4cHhzcQB+ADJ3BAAAAAFxAH4AZ3h4dAAFZW50
ZXJzcQB+ACNzcQB+AAs/QAAAAAAACHcIAAAACwAAAAFxAH4AJnNxAH4AJ3NxAH4AKj9AAAAAAAAI
dwgAAAALAAAABXQAQVJHU19tdWx0aXBsYXllcnMuUkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29u
c3RhbnQoU3RhdGUgIC4gSnVkZ2Upc3EAfgAuc3EAfgAydwQAAAACc3EAfgAuc3EAfgAydwQAAAAA
eHNxAH4ABnNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAHhzcQB+ABR3DAAAABA/QAAAAAAAAHhzcQB+
ADpxAH4APXNxAH4ABnNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAnQAEFJHU19tdWx0aXBsYXllcnNz
cQB+AA4AAAAAAHNxAH4ACz9AAAAAAAAIdwgAAAALAAAAAXNxAH4ADgAAAAEAc3EAfgALP0AAAAAA
AAh3CAAAAAsAAAAAeHQAClJHU2ZlYXR1cmVzcQB+ABR3DAAAABA/QAAAAAAAAXEAfgCPeHQAEnBy
aW9yaXR5UHJlY2VkZW5jZXhxAH4AjnNxAH4AFHcMAAAAED9AAAAAAAAAeHEAfgCTcQB+AJF4c3EA
fgAUdwwAAAAQP0AAAAAAAAB4dAIeeyAgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJlbnRl
ciBqdWRnZSIpICA7IGlmICggc2VydmVyY2xpZW50ZmxhZyAgPT0gMCApIHsgICAgZ2FtZXJlc3Vs
dCAgPSAiIiA7ICAgICBBcnJheUxpc3Q8ICBJbnRlZ2VyID4gIHdpbm5lcnMgPSBSb2NrR2xvdmVT
Y2lzc29yICAuIGp1ZGdlIChnbGlzdCkgIDsgaWYgKCB3aW5uZXJzICAuIHNpemUgKCkgID09IDAg
KSB7ICAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnRsbiAoImRyYXciKSAgOyB9ICBlbHNlIHsgICAg
U3lzdGVtICAuIG91dCAgLiBwcmludCAoIndpbm5lcnMgYXJlOiAiKSAgOyAgIHdpbm5lcml0ZXJh
dG9yICA9IHdpbm5lcnMgIC4gaXRlcmF0b3IgKCkgOyB3aGlsZSAoIHdpbm5lcml0ZXJhdG9yICAu
IGhhc05leHQgKCkgKSB7ICAgIFN5c3RlbSAgLiBvdXQgIC4gcHJpbnQgKHdpbm5lcml0ZXJhdG9y
ICAuIG5leHQgKCkpICA7IH0gICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50ICgiXG4iKSAgOyB9IH0g
IGVsc2UgeyAgfSAgIHN0YXRlICA9IFN0YXRlICAuIEFza2ZvclBsYXlBZ2FpbiA7IH10ADBSR1NE
b21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBKdWRnZSl0ABNtdWx0aXBsYXll
cnNqdWRnZV8wc3EAfgBEAHBwdAALZ2FtZW1vZGU9PTFzcQB+AC5zcQB+ADJ3BAAAAAB4c3EAfgAG
c3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4AFHcMAAAAED9AAAAAAAAAeHNxAH4AOnEAfgA9
c3EAfgAGc3EAfgALP0AAAAAAAAh3CAAAAAsAAAAAeHNxAH4AFHcMAAAAED9AAAAAAAAAeHQABHsg
IH1xAH4AmXQAE211bHRpcGxheWVyc2p1ZGdlXzFzcQB+AEQBcQB+AJtwdAAAeHNxAH4ABnNxAH4A
Cz9AAAAAAAAIdwgAAAALAAAAAHhzcQB+ABR3DAAAABA/QAAAAAAAAHhwdAB+UkdTX211bHRpcGxh
eWVycy5SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBKdWRnZSkmJlJH
U2ZlYXR1cmUuUkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gSnVkZ2Up
c3EAfgAuc3EAfgAydwQAAAACc3EAfgAuc3EAfgAydwQAAAAAeHNxAH4ABnNxAH4ACz9AAAAAAAAI
dwgAAAALAAAAAHhzcQB+ABR3DAAAABA/QAAAAAAAAHhxAH4Ai3NxAH4ALnNxAH4AMncEAAAAAXNx
AH4ALnNxAH4AMncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAACHcIAAAACwAAAAB4c3EAfgAUdwwA
AAAQP0AAAAAAAAB4c3EAfgA5cQB+AHBzcQB+AAZzcQB+AAs/QAAAAAAAAncIAAAAAwAAAAB4c3EA
fgAUdwwAAAABP0AAAAAAAAB4dAIaICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgieW91ciBn
ZXN0dXJlIGlzICIgICsgcmVhbFBsYXllciAgLiBnZXRndWVzdHVyZSAoKSAgLiB0b1N0cmluZyAo
KSkgIDsgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJBSVBsYXllcidzIGdlc3R1cmUgaXMg
IiAgKyBhaVBsYXllciAgLiBnZXRndWVzdHVyZSAoKSAgLiB0b1N0cmluZyAoKSkgIDsgc3dpdGNo
ICggUm9ja0dsb3ZlU2Npc3NvciAgLiBqdWRnZSAocmVhbFBsYXllciAgLiBnZXRndWVzdHVyZSAo
KSAgLCBhaVBsYXllciAgLiBnZXRndWVzdHVyZSAoKSkgKSB7ICAgIGNhc2UgMSA6ICAgIFN5c3Rl
bSAgLiBvdXQgIC4gcHJpbnRsbiAoInBsYXllciAxIHdvbiEiKSAgOyBicmVhayA7ICAgY2FzZSAw
IDogICAgU3lzdGVtICAuIG91dCAgLiBwcmludGxuICgiZHJhdyIpICA7IGJyZWFrIDsgICBjYXNl
ICAtIDEgOiAgICBTeXN0ZW0gIC4gb3V0ICAuIHByaW50bG4gKCJwbGF5ZXIgMiB3b24iKSAgOyBi
cmVhayA7IH0gICBzdGF0ZSAgPSBTdGF0ZSAgLiBBc2tmb3JQbGF5QWdhaW4gO3QAMFJHU0RvbWFp
bi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXQACmVudGVySnVkZ2VzcQB+
AEQAcHBxAH4AeHNxAH4ARz9AAAAAAAAAdwgAAAAQAAAAAHh4c3EAfgAGc3EAfgALP0AAAAAAAAh3
CAAAAAsAAAAAeHNxAH4AFHcMAAAAED9AAAAAAAAAeHEAfgCieHNxAH4ABnNxAH4ACz9AAAAAAAAI
dwgAAAALAAAAAHhzcQB+ABR3DAAAABA/QAAAAAAAAHhwdABFUkdTZmVhdHVyZS5SR1NEb21haW4u
c3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAgLiBBc2tmb3JQbGF5QWdhaW4pc3EAfgAuc3EA
fgAydwQAAAABc3EAfgAuc3EAfgAydwQAAAAAeHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAA
AHhzcQB+ABR3DAAAAAE/QAAAAAAAAHhzcQB+ADlxAH4AcHNxAH4ABnNxAH4ACz9AAAAAAAACdwgA
AAADAAAAAHhzcQB+ABR3DAAAAAE/QAAAAAAAAHh0AQYgICAgIFNjYW5uZXIgIGlucHV0X3NjYW5u
ZXIgPSAgbmV3IFNjYW5uZXIgICAoU3lzdGVtICAuIGluKSAgICA7ICAgU3lzdGVtICAuIG91dCAg
LiBwcmludGxuICgiZG8geW91IHdhbnQgdG8gcGxheSBhZ2Fpbj8geTp5ZXMgbjpubyIpICA7ICAg
ICBTdHJpbmcgIHJlc3VsdCA9IGlucHV0X3NjYW5uZXIgIC4gbmV4dExpbmUgKCkgIDsgaWYgKCBy
ZXN1bHQgIC4gZXF1YWxzICgieSIpICkgeyAgICBzdGF0ZSAgPSBTdGF0ZSAgLiBQcmVwYXJlR2Vz
dHVyZSA7IH0gdAA6UkdTRG9tYWluLnN0YXRlLmVxdWFsc1RvQ29uc3RhbnQoU3RhdGUgIC4gQXNr
Zm9yUGxheUFnYWluKXQAFGVudGVyQXNrZm9yUGxheUFnYWluc3EAfgBEAHBwcQB+AHhzcQB+AEc/
QAAAAAAAAHcIAAAAEAAAAAB4eHNxAH4ABnNxAH4ACz9AAAAAAAACdwgAAAADAAAAAHhzcQB+ABR3
DAAAAAE/QAAAAAAAAHhwdABEUkdTZmVhdHVyZS5SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25z
dGFudChTdGF0ZSAgLiBQcmVwYXJlR2VzdHVyZSlzcQB+AC5zcQB+ADJ3BAAAAAFzcQB+AC5zcQB+
ADJ3BAAAAAB4c3EAfgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AFHcMAAAAAT9AAAAA
AAAAeHNxAH4AOXEAfgBwc3EAfgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AFHcMAAAA
AT9AAAAAAAAAeHQAWiAgIHJlYWxQbGF5ZXIgIC4gYXNrZm9yUkdTICgpICA7ICAgYWlQbGF5ZXIg
IC4gYXNrZm9yUkdTICgpICA7ICAgc3RhdGUgID0gU3RhdGUgIC4gSnVkZ2UgO3QAOVJHU0RvbWFp
bi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIFByZXBhcmVHZXN0dXJlKXQAE2VudGVy
UHJlcGFyZUdlc3R1cmVzcQB+AEQAcHBxAH4AeHNxAH4ARz9AAAAAAAAAdwgAAAAQAAAAAHh4c3EA
fgAGc3EAfgALP0AAAAAAAAJ3CAAAAAMAAAAAeHNxAH4AFHcMAAAAAT9AAAAAAAAAeHB0ADtSR1Nm
ZWF0dXJlLlJHU0RvbWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXNx
AH4ALnNxAH4AMncEAAAAAXNxAH4ALnNxAH4AMncEAAAAAHhzcQB+AAZzcQB+AAs/QAAAAAAAAncI
AAAAAwAAAAB4c3EAfgAUdwwAAAABP0AAAAAAAAB4cQB+ALx4c3EAfgAGc3EAfgALP0AAAAAAAAJ3
CAAAAAMAAAAAeHNxAH4AFHcMAAAAAT9AAAAAAAAAeHB4c3EAfgAydwQAAAAFcQB+AK1xAH4Ag3EA
fgDLcQB+AN9xAH4A83h4eHEAfgA9

*/


/* IntermediateInfo:domains
rO0ABXNyABdqYXZhLnV0aWwuTGlua2VkSGFzaFNldNhs11qV3SoeAgAAeHIAEWphdmEudXRpbC5I
YXNoU2V0ukSFlZa4tzQDAAB4cHcMAAAAED9AAAAAAAABdAADUkdTeA==

*/


/* IntermediateInfo:isExecutable
rO0ABXNyABFqYXZhLmxhbmcuQm9vbGVhbs0gcoDVnPruAgABWgAFdmFsdWV4cAE=

*/


/* IntermediateInfo:proceedToPuhandler
rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAEdwQAAAAE
c3IAJ2NvcmUuZGF0YXN0cnVjdHVyZS5Qcm9jZWVkVG9IYW5kbGVySW5mb/NJGznJidC0AgAJTAAJ
Y29uZGl0aW9udAASTGphdmEvbGFuZy9TdHJpbmc7TAAPZXZlbnRJZGVudGlmaWVycQB+AANMAAll
dmVudFR5cGVxAH4AA0wAD2ZlYXR1cmVJbnN0YW5jZXEAfgADTAALZmVhdHVyZU5hbWVxAH4AA0wA
CXByb2NlZWRUb3EAfgADTAARcHJvY2VlZFRvSW5zdGFuY2VxAH4AA0wABnB1TmFtZXEAfgADTAAH
cHVUb0FkZHEAfgADeHB0AC9SR1NEb21haW4uc3RhdGUuZXF1YWxzVG9Db25zdGFudChTdGF0ZSAg
LiBJbml0KXQAAWV0AAVsZWF2ZXQAGF9yZ3NfbXVsdGlwbGF5ZXJzZmVhdHVyZXQAEFJHU19tdWx0
aXBsYXllcnNwcHQADmNob29zZWdhbWVtb2RlcHNxAH4AAnQAOVJHU0RvbWFpbi5zdGF0ZS5lcXVh
bHNUb0NvbnN0YW50KFN0YXRlICAuIFByZXBhcmVHZXN0dXJlKXEAfgAGdAAFbGVhdmV0ABhfcmdz
X211bHRpcGxheWVyc2ZlYXR1cmVxAH4ACXBwdAAMcHJlcGFyZWp1ZGdlcHNxAH4AAnQAMFJHU0Rv
bWFpbi5zdGF0ZS5lcXVhbHNUb0NvbnN0YW50KFN0YXRlICAuIEp1ZGdlKXEAfgAGdAAFZW50ZXJ0
ABhfcmdzX211bHRpcGxheWVyc2ZlYXR1cmVxAH4ACXBwdAATbXVsdGlwbGF5ZXJzanVkZ2VfMHBz
cQB+AAJxAH4AEXEAfgAGcQB+ABJ0ABhfcmdzX211bHRpcGxheWVyc2ZlYXR1cmVxAH4ACXBwdAAT
bXVsdGlwbGF5ZXJzanVkZ2VfMXB4

*/


/* IntermediateInfo:anchorFeature
rO0ABXQAClJHU2ZlYXR1cmU=

*/

