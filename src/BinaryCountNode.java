//@SuppressWarnings("unchecked")
public class BinaryCountNode {
	private String val;
	private BinaryCountNode left;
	private BinaryCountNode right;
	private int count;
	public BinaryCountNode() {
		val = null;
		left = null;
		right = null;
		count = 1;
	}
	public BinaryCountNode(String a, BinaryCountNode b, BinaryCountNode c) {
		val = a;
		left = b;
		right = c;
		count = 1;
	}
	public BinaryCountNode(String a) {
		val = a;
		left = null;
		right = null;
		count = 1;
	}
	public String getVal() {
		return val;
	}
	public BinaryCountNode getLeft() {
		return left;
	}
	public BinaryCountNode getRight() {
		return right;
	}
	public void setVal(String x) {
		val = x;
	}
	public void setLeft(BinaryCountNode x) {
		left = x;
	}
	public void setRight(BinaryCountNode x) {
		right = x;
	}
	public void addCount() {
		count = count+1;
	}
	public void reduce() {
		count--;
	}
	public int getCount() {
		return count;
	}
	public boolean equals(BinaryCountNode node) {
		return val.equals(node.getVal());
	}
}
