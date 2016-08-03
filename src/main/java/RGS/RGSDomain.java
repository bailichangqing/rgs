package RGS;
import ddt.lang.*;
import external.*;import java.io.IOException;import java.io.ObjectInputStream;import java.io.ObjectOutputStream;import java.io.Serializable;
public class
 RGSDomain extends FeaturePackage {

 public static DTenum state ;public RGSDomain()
{
 state = State . Init ;}
 public Object clone() throws CloneNotSupportedException { return super.clone(); }



 public static Player realPlayer;
 public static Player aiPlayer;
 private void writeObject(ObjectOutputStream out) throws IOException {  
 try {
   out.defaultWriteObject();
out.writeObject( aiPlayer);
out.writeObject( realPlayer);
 } catch (IOException e) {
   e.printStackTrace();
 }
}
private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException { 
     in.defaultReadObject();
this.aiPlayer = (  Player ) in.readObject(); 
this.realPlayer = (  Player ) in.readObject(); 
}

protected void finalize() {
try {
super.finalize();
} catch(Throwable e) {
// do nothing
}
}

}
/* IntermediateInfo:RGSResource
rO0ABXNyABNqYXZhLnV0aWwuSGFzaHRhYmxlE7sPJSFK5LgDAAJGAApsb2FkRmFjdG9ySQAJdGhy
ZXNob2xkeHA/QAAAAAAACHcIAAAACwAAAAB4

*/


/* IntermediateInfo:RGSPath
rO0ABXQACGZpbGVQYXRo

*/


/* IntermediateInfo:pureResources
rO0ABXNyABNqYXZhLnV0aWwuSGFzaHRhYmxlE7sPJSFK5LgDAAJGAApsb2FkRmFjdG9ySQAJdGhy
ZXNob2xkeHA/QAAAAAAACHcIAAAACwAAAAJ0AAhhaVBsYXllcnQACSAgUGxheWVyIHQACnJlYWxQ
bGF5ZXJ0AAkgIFBsYXllciB4

*/


/* IntermediateInfo:pureOrders
rO0ABXNyABBqYXZhLnV0aWwuVmVjdG9y2Zd9W4A7rwEDAANJABFjYXBhY2l0eUluY3JlbWVudEkA
DGVsZW1lbnRDb3VudFsAC2VsZW1lbnREYXRhdAATW0xqYXZhL2xhbmcvT2JqZWN0O3hwAAAAAAAA
AAJ1cgATW0xqYXZhLmxhbmcuT2JqZWN0O5DOWJ8QcylsAgAAeHAAAAACdAAKcmVhbFBsYXllcnQA
CGFpUGxheWVyeA==

*/


/* IntermediateInfo:DefinedVariables
rO0ABXNyABNqYXZhLnV0aWwuSGFzaHRhYmxlE7sPJSFK5LgDAAJGAApsb2FkRmFjdG9ySQAJdGhy
ZXNob2xkeHA/QAAAAAAACHcIAAAACwAAAAF0AA9SR1NEb21haW4uc3RhdGV0AAkgIERUZW51bSB4

*/


/* IntermediateInfo:domainInitiationStatement
rO0ABXNyABNqYXZhLnV0aWwuSGFzaHRhYmxlE7sPJSFK5LgDAAJGAApsb2FkRmFjdG9ySQAJdGhy
ZXNob2xkeHA/QAAAAAAACHcIAAAACwAAAAF0AA9SR1NEb21haW4uc3RhdGV0ABAgPSBTdGF0ZSAg
LiBJbml0eA==

*/

