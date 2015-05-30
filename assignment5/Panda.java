package assignment05;

public class Panda extends Bear{
	public Panda(String name){
		super(name);
	}
	
	@Override
	public String speak(){
		return("chompchomp");
	}
}
