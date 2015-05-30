package assignment04;

import java.util.ArrayList;

public class BunnyFarm {
    private ArrayList<Bunny> bunnies;

    public BunnyFarm() {
        this.bunnies = new ArrayList<Bunny>();
    }

    public void addBunny(Bunny bunny) {
        this.bunnies.add(bunny);
    }

    public ArrayList<Bunny> getBunnies() {
        return this.bunnies;
    }
		
}
