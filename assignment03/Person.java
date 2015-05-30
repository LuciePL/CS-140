package assignment03;

public class Person{
	private BunnyFarm bunnyFarm;
	public Person(){
		this.bunnyFarm = new BunnyFarm();
	}

	public BunnyFarm getFarm(){
	return this.bunnyFarm;
	}
}