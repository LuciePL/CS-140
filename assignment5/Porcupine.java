package assignment05;

public class Porcupine extends Animal {
    public Porcupine(String name) {
        super(name);
    }
	
	@Override
	public String speak(){
		return "squeak";
	}
}
