import java.util.*;
public class BinarySearchTree {
	private BinaryNode root;
	public BinarySearchTree() {
		root = null;
	}
	public BinarySearchTree(BinaryNode x) {
		root = x;
	}
	public void add(BinaryNode x) {
		if(root==null) {
			root = x;
		}
		else {
		if(root.getVal().compareTo(x.getVal())<=0) {
			BinarySearchTree tree = new BinarySearchTree();
			tree.setRoot(root.getRight());
			tree.add(x);
			root.setRight(tree.getRoot());
		}
		else if(root.getVal().compareTo(x.getVal())>0) {
			BinarySearchTree tree = new BinarySearchTree();
			tree.setRoot(root.getLeft());
			tree.add(x);
			root.setLeft(tree.getRoot());
		}
		}
	}
	public BinaryNode getRoot() {
		return root;
	}
	public String inOrder() {
		return iO(root);
	}
	public String iO(BinaryNode x) {
		String a = "";
		if(x!=null) {
			a+=iO(x.getLeft());
			a+=x.getVal()+" ";
			a+=iO(x.getRight());
		}
		return a;
  	}
	public String tempprint(BinaryNode x) {
		String a = "";
		if(x==null)
			a+="NULL ";
		else{
			a+=iO(x.getLeft());
			a+=x.getVal()+" ";
			a+=iO(x.getRight());
		}
		return a;
  	}
	public String preOrder() {
		return preO(root);
	}
	private String preO(BinaryNode x) {
		String a = "";
		if(x!=null) {
			a+=x.getVal()+" ";
			a+=preO(x.getLeft());
			a+=preO(x.getRight());
		}
		return a;
	}
	public String postOrder() {
		return pO(root);
	}
	public String pO(BinaryNode x) {
		String a = "";
		if(x!=null) {
			a+=pO(x.getLeft());
			a+=pO(x.getRight());
			a+=(x.getVal()+" ");
		}
		return a;
	}
	public String reverseOrder() {
		return pRO(root);
	}
	private String pRO(BinaryNode x) {
		String a = "";
		if(x!=null) {
			a+=pRO(x.getRight());
			a+=x.getVal()+" ";
			a+=pRO(x.getLeft());
		}
		return a;
	}
	public int getNumLeaves() {
		return leavCount(root);
	}
	public int leavCount(BinaryNode x) {
		if(x==null) 
			return 0;
		else if(x.getLeft()==null&&x.getRight()==null)
			return 1;
		else
			return leavCount(x.getLeft())+leavCount(x.getRight());
			}
	public int getNumLevels() {
		return height(root)+1;
	}
	public boolean isFull() {
		if(getNumNodes(root)<Math.pow(2.0, getNumLevels()))
			return false;
		else
			return true;
	}
	public int getNumNodes() {
		return getNumNodes(root);
	}
	public int getNumNodes(BinaryNode x) {
		int c = 0;
		if(x!=null) {
			c++;
			c+=getNumNodes(x.getLeft());
			c+=getNumNodes(x.getRight());
		}
		return c;
	}
	public boolean checkC(BinaryNode s, String x) {
		Boolean ret;
		if(s!=null) {
			if(s.getVal().equals(x))
				return true;
			else if(checkC(s.getLeft(),x))
				return true;
			else if(checkC(s.getRight(),x))
				return true;
			return false;
		}
		return false;
	}
	public String getSmallest(BinaryNode x) {
		String ret = x.getVal();
		if(x!=null) {
			if(getSmallest(x.getLeft()).compareTo(ret)<0)
				ret = getSmallest(x.getLeft());
			else if(getSmallest(x.getRight()).compareTo(ret)<0)
				ret = getSmallest(x.getRight());
		}
		return ret;
	}
	public String getLargest(BinaryNode x) {
		String ret = x.getVal();
		if(x!=null) {
			if(getSmallest(x.getLeft()).compareTo(ret)>0)
				ret = getSmallest(x.getLeft());
			else if(getSmallest(x.getRight()).compareTo(ret)>0)
				ret = getSmallest(x.getRight());
		}
		return ret;
	}
	public void setRoot(BinaryNode x) {
		root = x;
	}
	public int getWidth() {
		return width(root);
	}
	public int width(BinaryNode x)
	{
	if(x.getLeft()==null&&x.getRight()==null)//if leaf
	return 1;
	else if(x.getLeft()==null)
	return 1+width(x.getRight());
	else if(x.getRight()==null)
	return 1+width(x.getLeft());
	else{
	int lw = width(x.getLeft());
	int rw = width(x.getRight());
	return 1+Math.max(lw,rw);
	}
	}
	public int getHeight(){
		return height(root);
	}	
	public int height(BinaryNode x) {
		if(x==null)
			return -1;
		return 1+Math.max(height(x.getLeft()),height(x.getRight()));
	}
	public boolean contains(String x) {
		return contain(root,x);
	}
	public boolean contain(BinaryNode x, String str) {
		if(x.getVal().equals(str))
			return true;
		else if(str.compareTo(x.getVal())<0 && x.getLeft()!=null && contain(x.getLeft(),str))
			return true;
		else if(str.compareTo(x.getVal())>0 && x.getRight()!=null && contain(x.getRight(),str))
			return true;
		return false;
	}
	public String getLargest() {
		BinaryNode x = root;
		while(x.getRight()!=null) {
			x = x.getRight();
		}
		return x.getVal();
	}
	public String getSmallest() {
		BinaryNode x = root;
		while(x.getLeft()!=null) {
			x = x.getLeft();
		}
		return x.getVal();
	}
	public ArrayList<String> levelOrder2() {
		ArrayList<String> s = new ArrayList<String>();
		Queue<BinaryNode> nodes = new LinkedList<BinaryNode>();
		nodes.add(root);
		while(!nodes.isEmpty()) {
			BinaryNode temp = (nodes.poll());
			if(temp!=null) {
			s.add(temp.getVal());
			if(temp.getLeft()!=null) 
				nodes.add(temp.getLeft());
			else
				nodes.add(null);
			if(temp.getRight()!=null)
				nodes.add(temp.getRight());
			else
				nodes.add(null);
			}
			else
				s.add(null);
		}
		return s;
	}
	public String trueOrder() {
		String s = "";
		s = tO(root);
		return s;
	}
	public String tO(BinaryNode x) {
		String s = "";
		Queue<BinaryNode> nodes = new LinkedList<BinaryNode>();
		nodes.add(root);
		while(!nodes.isEmpty()) {
			BinaryNode temp = (nodes.poll());
			s+=(temp.getVal());
				nodes.add(temp.getLeft());
				nodes.add(temp.getRight());
		}
		return s.toString();
	}
	public BinaryNode remove(String x) {
		return delete(root,x);
	}
	public BinaryNode delete(BinaryNode top, String x) {
		if(top==null)
			return top;
		else if(x.compareTo(top.getVal())<0) {
			BinaryNode temp = top.getLeft();
			temp = delete(top.getLeft(),x);
		}
		else if(x.compareTo(top.getVal())>0) {
			BinaryNode temp = top.getRight();
			temp = delete(top.getRight(),x);
			}
		else {
			if(top.getLeft()==null)
				return top.getRight();
			else if(top.getRight()==null)
				return top.getLeft();
			else if(top.getLeft().getRight()!=null){
				BinaryNode temp= top.getLeft();
				String leftRightest = top.getLeft().getRight().getVal();
				while(temp.getRight()!=null) {
					leftRightest = temp.getRight().getVal();
					temp = temp.getRight();
				}
				root.setVal(leftRightest);
				BinaryNode leftKaRight = top.getRight();
				leftKaRight = delete(root.getRight(),leftRightest);
				return root;
			}
		}
		return null;
	}
	public ArrayList<String> fullLevelOrder() {
		ArrayList<String> ret = new ArrayList<String>();
		int h = getHeight();
		for(int x = 1;x<=h;x++) {
			ret.addAll(printGivenLevel(root,x));
		}
		return ret;
	}
	public ArrayList<String> printGivenLevel(BinaryNode node,int x){
		ArrayList<String> ret = new ArrayList<String>();
		if(node==null) {
			ret.add(null);
			return ret;
		}
		else {
			if(x==1)
				ret.add(node.getVal());
			else if(x>1) {
				ret.addAll(printGivenLevel(node.getLeft(),x-1));
				ret.addAll(printGivenLevel(node.getRight(),x-1));
			}
		}
		return ret;
	}
}

