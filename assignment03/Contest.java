package assignment03;
import java.util.ArrayList;

public class Contest{
	/*
		Finds the length of the names of each persons' bunnies and adds them together
		@param people List of people who own Bunnyfarms
		@return the person who's bunnies names added together is largest
	*/
	public Person run(ArrayList<Person> people){
		ArrayList<Bunny> ownBunnies; //The bunnies the current person has
		int currentTotalBunny = 0;
		int totalBunny = 0;
		Person winner = null;
		for(int i = 0; i < people.size(); i++){
			currentTotalBunny = 0;
			ownBunnies = people.get(i).getFarm().getBunnies();
			for(int j = 0; j <ownBunnies.size(); j++){
				currentTotalBunny = currentTotalBunny + ownBunnies.get(j).getName().length();
			}
			if(currentTotalBunny > totalBunny){
				totalBunny = currentTotalBunny;
				winner = people.get(i);
			}
		}
		return winner;
	}
}