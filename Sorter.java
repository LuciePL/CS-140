package assignment04;
import java.util.ArrayList;
import java.util.Comparator;

public class Sorter{

	public Bunny helpMe(ArrayList<Bunny> buns, Comparator<Bunny> helpCompare){
		Bunny smaller = null;
		for(int i = 0; i < buns.size(); i++){
			/*if(i+1 == buns.size()){
				break;
			}*/
			
			if (i==0){
				smaller = buns.get(i);
				/*if(helpCompare.compare(smaller,buns.get(i+1))>0){
					smaller = buns.get(i+1);
				}*/
			}
			
			else if(helpCompare.compare(smaller,buns.get(i))>0){
				smaller = buns.get(i);
			}
		}
		return smaller;
	}
	

	public ArrayList<Bunny> selectionSort(ArrayList<Bunny> tosort, Comparator<Bunny> comparator) {
		ArrayList<Bunny> local = tosort;
		ArrayList<Bunny> smallestBunny = new ArrayList<Bunny>(); 
		int toSortSize = tosort.size();
		Bunny help = null;
		for(int i = 0; i < toSortSize; i++){
			help = helpMe(local, comparator);
			smallestBunny.add(help);
			local.remove(help);
				
		}
		return smallestBunny;
	}
}