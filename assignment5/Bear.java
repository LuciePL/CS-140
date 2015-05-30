package assignment05;

public class Bear extends Animal {
    public Bear(String name) {
        super(name);
    }
	
	@Override
	public String speak(){
		return "roar";
	}
}
