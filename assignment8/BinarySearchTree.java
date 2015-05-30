package assignment08;

public class BinarySearchTree {
	private Node root;
	public BinarySearchTree(){
		this.root = null;
	}
	
	public void insert(Node node){
		if(root == null){
			root =node;
			return;
		}
		inserter(root,node);
	}

	
	public void inserter(Node rooter, Node noder){
		if(rooter.compareTo(noder) > 0){
			if(rooter.getLeft()== null){
				rooter.setLeft(noder);
				return;
			}
			else{
				inserter(rooter.getLeft(),noder);
			}
		}
		else if(rooter.compareTo(noder) <= 0){
			if(rooter.getRight() == null){
				rooter.setRight(noder);
				return;
			}
			else{
				inserter(rooter.getRight(),noder);
			}
		}
			
	}
	

	public String toString(){
		String ret = "";
		if(root != null){
			String order = root.traverse(root);
			root.clear();
			ret = order.replaceAll("^\\s+", "");
		}
		return ret;
	}
		
	
	
}
