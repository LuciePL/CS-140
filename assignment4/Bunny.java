package assignment04;

public class Bunny /*implements Comparable<Bunny>*/ {
	private String name;
	private int weight;

	/*@Override
	public int compareTo(Bunny other) {
		if(this.weight <= other.weight){
			if(this.weight == other.weight){
				if(this.name.compareTo(other.name)<0){
					return -1;
				}
				else{
					return 1;
				}
			}
			else{
				return -1;
			}
		}
		else{
			return 1;
		}
	}*/

	public Bunny(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Bunny(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	public int getWeight() {
		return this.weight;
	}

}
