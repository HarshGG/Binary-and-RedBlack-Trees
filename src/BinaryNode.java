//@SuppressWarnings("unchecked")
public class BinaryNode {
	private String val;
	private BinaryNode left;
	private BinaryNode right;
	public BinaryNode() {
		val = null;
		left = null;
		right = null;
	}
	public BinaryNode(String a, BinaryNode b, BinaryNode c) {
		val = a;
		left = b;
		right = c;
	}
	public BinaryNode(String a) {
		val = a;
		left = null;
		right = null;
	}
	public String getVal() {
		return val;
	}
	public BinaryNode getLeft() {
		return left;
	}
	public BinaryNode getRight() {
		return right;
	}
	public void setVal(String x) {
		val = x;
	}
	public void setLeft(BinaryNode x) {
		left = x;
	}
	public void setRight(BinaryNode x) {
		right = x;
	}
	public String toString() {
		if(val==null)
			return null;
		return"Value:"+val+ ", Left:"+null +", Right:"+null;
	}
}
