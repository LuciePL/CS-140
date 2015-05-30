package pippin;

public class Memory {
	public static final int DATA_SIZE = 512;
	private int[] data = new int[DATA_SIZE];
	private int changedIndex = -1;
	
	public int getData(int index){
		return data[index];
	}
	
	public int[] getData() {
		return data;
	}

	void clear(){
		for(int i=0; i<data.length;i++){
			data[i]=0;
		}
		changedIndex = -1;
	}
	
	public void setData(int index, int value){
		data[index] = value;
	}

	public int getChangedIndex() {
		return changedIndex;
	}
	
	
}
