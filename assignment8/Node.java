package assignment08;

public class Node implements Comparable<Node> {
	private int data;
	private Node left;
	private Node right;
	private String out = "";
	
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public int compareTo(Node other){
		if (this.data > other.data){
			
			return 1;
		}
		else if(this.data == other.data){
			if(other instanceof NodeB){
				return -1;
			}
			else{
				return 0;
			}
		}
		else{
			return -1;
		}
	}
	
	public int getData() {
		return data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	public void clear(){
		this.out = "";
	}
	
	public String traverse(Node rootest){
		
		if(rootest != null){
			traverse(rootest.left);
			String retu = Integer.toString(rootest.data);
			if(rootest instanceof NodeB){
				out = out + " " + "b"+retu;
			}
			else{
			out = out +" " + retu;
			}
			traverse(rootest.right);
		}
		return out;
	}

	
}
