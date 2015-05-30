package assignment05;

public class Parrot extends Animal{
	String repeat = "";
	public Parrot(String name, String phrase){
		super(name);
		repeat = phrase;
	}
	
	@Override
	public String speak(){
		return repeat;
	}
	
}
