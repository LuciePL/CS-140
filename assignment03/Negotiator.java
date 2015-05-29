package assignment03;

public class Negotiator{
	public void trade(String name, Person from, Person to){
		Bunny bunny = from.getFarm().findBunny(name);
		from.getFarm().removeBunny(bunny);
		to.getFarm().addBunny(bunny);
	}
}