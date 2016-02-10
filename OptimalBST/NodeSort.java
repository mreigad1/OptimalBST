public class NodeSort implements Comparable<NodeSort>{

	Node n;
	NodeSort left = null;
	NodeSort right = null;
	String parent = "";
	
	NodeSort(Node nd){
		n = nd;
	}
	
	NodeSort(double prob, String word){
		Node m = new Node(prob, word);
		n = m;
	}

	public int compareTo(NodeSort arg0) {
		NodeSort m = arg0;
		return n.word.compareTo(m.n.word);
	}
	
	public void print(){
		System.out.print("(" + n.word + "," + n.prob + ")");
	}

	void insert(NodeSort c){
		if(this.compareTo(c) > 0){
			if(left == null){
				left = c;
				left.parent = n.word;
			}else{
				left.insert(c);
			}
		}else{
			if(right == null){
				right = c;
				right.parent = n.word;
			}else{
				right.insert(c);
			}
		}
	}
	
	String PreOrderString(){
		String str = "";
		str += (n.word + " is the root of the tree");
		if(left != null){
			str += (left.PreOrderStringAux());
		}
		if(right != null){
			str += (right.PreOrderStringAux());
		}
		return str;		
	}
	
	String PreOrderStringAux(){
		String str = "";

		str += ("\n" + n.word + " is the child of " + parent);
		if(left != null){
			str += (left.PreOrderStringAux());
		}
		if(right != null){
			str += (right.PreOrderStringAux());
		}
		return str;
	}
	
}
