package assignment04;
import java.util.ArrayList;

public class Person {
    private BunnyFarm bunnyFarm;
    private String name;

    public Person(String name) {
        this.name = name;
        this.bunnyFarm = new BunnyFarm();
    }

    public String getName() {
        return this.name;
    }

    public BunnyFarm getFarm() {
        return this.bunnyFarm;
    }
	
	public int bunnyLength(Person pers){
		int actualLength = 0;
		ArrayList<Bunny> bLength = pers.getFarm().getBunnies();
		for(int i = 0; i < bLength.size();i++){
			actualLength = actualLength + bLength.get(i).getName().length();
		}
		return actualLength;
	}
}
