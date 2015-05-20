package assignment06;

public class Arena{
/** A method to continuously have two Things attack each other until one has 0 or less than 0 HP left.
@param first One of the Things in the battle and will always attack first
@param second One of the Things in the battle
@return The Thing with more than 0 HP left

*/

	public static Thing battle(Thing first, Thing second){
		Thing winner = null;
		
		while(first.getHP() > 0 && second.getHP() > 0){
			first.attack(second);
			if(second.getHP() >0){
				second.attack(first);
			}
		}
		
		if(first.getHP() <=0){
			winner = second;
		}
		else{
			winner = first;
		}
		return winner;
	}
}