package assignment05;

import java.util.ArrayList;

public class Counter{
    public static ArrayList<Integer> count(ArrayList<Animal> al) {
        ArrayList<Integer> totals = new ArrayList<Integer>();
		int bunnyCount = 0;
		int bearCount = 0;
		int pandaCount = 0;
		int parrotCount = 0;
		totals.add(al.size());
		for(int i = 0; i <al.size();i++){
			if(al.get(i) instanceof Bunny){
				bunnyCount += 1;
			}
			else if(al.get(i) instanceof Bear){
				if(!(al.get(i) instanceof Panda)){
					bearCount += 1;
				}
				else{
					pandaCount += 1;
				}
			}
			else if(al.get(i) instanceof Parrot){
				parrotCount +=1;
			}
		}
		totals.add(bunnyCount);
		totals.add(bearCount);
		totals.add(pandaCount);
		totals.add(parrotCount);
		
		return totals;
    }
}
