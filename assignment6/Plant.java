package assignment06;

public class Plant extends Thing{
	public Plant(){
		super(8,0);
	}
	
	@Override
	public void takeDamage(int damage) {
      super.takeDamage(damage*2);
    }
}
