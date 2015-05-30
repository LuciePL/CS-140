package assignment03;
import java.util.ArrayList;

public class BunnyFarm {
	private ArrayList<Bunny> bunnies;

	public BunnyFarm() {
	        this.bunnies = new ArrayList<Bunny>();
    	}

	public void addBunny(Bunny bunny) {
	        this.bunnies.add(bunny);
	}

	public Bunny findBunny(String name) {
		for(int i=0; i<this.bunnies.size(); i++) {
			if(this.bunnies.get(i).getName().equals(name)) {
			return this.bunnies.get(i);
			}
		}
		return null;
	}

	public void removeBunny(Bunny bunny){
		this.bunnies.remove(bunny);
	}

	public ArrayList<Bunny> getBunnies() {
		return this.bunnies;
	}
}