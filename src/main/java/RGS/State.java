package RGS;
import ddt.lang.*;
import external.*;import java.io.Serializable;
public class
 State extends DTenum implements Serializable
{
private enum RawEnum  {Init,PrepareGesture,Judge,AskforPlayAgain}private final RawEnum value;
public String name(){return value.name();}
private 
State(final RawEnum value){super(value.ordinal());this.value = value;}public final static State Init = new State(RawEnum.Init);
public final static State PrepareGesture = new State(RawEnum.PrepareGesture);
public final static State Judge = new State(RawEnum.Judge);
public final static State AskforPlayAgain = new State(RawEnum.AskforPlayAgain);
}
