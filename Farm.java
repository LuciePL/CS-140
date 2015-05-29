package assignment05;

import java.util.ArrayList;

public class Farm {
    private ArrayList<Animal> animals;

    public Farm() {
        this.animals = new ArrayList<Animal>();
    }
	
	void addAnimal(Animal a){
		animals.add(a);
	}
	
	public String chorus(){
		ArrayList<String> singing = new ArrayList<String>();
		for(int i = 0; i < animals.size(); i++){
			singing.add(animals.get(i).speak());
		}
		String song = "";
		for(int i = 0; i < singing.size(); i++){
			if (i==0){
				song = singing.get(i);
			}
			else{
				song = song + "\n"+ singing.get(i);
			}
		}
		return song;
	}
}