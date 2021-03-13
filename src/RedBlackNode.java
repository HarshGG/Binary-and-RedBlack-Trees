import java.awt.Color;
public class RedBlackNode {
//	private enum Color {
//		red, black;
//	}
	private RedBlackNode parent;
	private int col;
	private String val;
	private RedBlackNode left, right;
	private final int RED = 0;
	private final int BLACK = 1;
	public RedBlackNode() {
		parent = null;
		val = null;
		left = null;
		right = null;
		col = RED;
	}
	public RedBlackNode(String x) {
		val = x;
		left = null;
		right = null;
		parent = null;
	}
	public void setColor(int c) {
		col = c;
	}
	public void setRight(RedBlackNode node) {
		right = node;
	}
	public void setLeft(RedBlackNode node) {
		left = node;
	}
	public RedBlackNode getRight() {
		return right;
	}
	public RedBlackNode getLeft() {
		return left;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String x) {
		val = x;
	}
	public void switchColors() {
		if(parent==null) {
			left.setColor(BLACK);
			right.setColor(RED);
		}
		else {
			int temp = left.getColor();
			left.setColor(col);
			right.setColor(col);
			col = temp;
			
		}
	}
	public int getColor() {
		return col;
	}
	public void setParent(RedBlackNode x) {
		parent = x;
	}
	public RedBlackNode getParent() {
		return parent;
	}
	public boolean equals(RedBlackNode x) {
		if(x!=null)
		return x.getVal().equals(val);
		return false;
	}
}
