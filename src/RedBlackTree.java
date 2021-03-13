//import java.awt.Color;
public class RedBlackTree {
	private RedBlackNode root;
	private final int RED = 0;
	private final int BLACK = 1;
//	enum Color{
//		red,black;
//	}
	public RedBlackTree() {
		root = null;
	}
	public RedBlackNode getRoot() {
		return root;
	}
	public void InOrder(RedBlackNode node) {
		if(node!=null) {
		String x = "b";
		if(node.getColor()!=BLACK)
			x = "r";
		InOrder(node.getLeft());
		InOrder(node.getRight());
		}
	}
		 public void add(RedBlackNode node) {
		        RedBlackNode temp = root;
		        if (root == null) {
		            root = node;
		            node.setColor(BLACK);
		            node.setParent(null);
		        } 
		        else {
		            node.setColor(RED);
		            while (true) {
		                if (node.getVal().compareTo(root.getVal())<0) {
		                    if (temp.getLeft()==null) {
		                        temp.setLeft(node);
		                        node.setParent(temp);
		                        break;
		                    } else {
		                        temp = temp.getLeft();
		                    }
		                } else if (node.getVal().compareTo(temp.getVal())>0) {
		                    if (temp.getRight()==null) {
		                        temp.setRight(node);
		                        node.setParent(temp);
		                        break;
		                    } else {
		                        temp = temp.getRight();
		                    }
		                }
		            }
		            fixTree(node);
		        }
			 }
		 public void fixTree(RedBlackNode node) {
		        while (node.getParent().getColor() == RED) {
		            RedBlackNode uncle = null;
		            if (node.getParent().equals(node.getParent().getParent().getLeft())) {
		                uncle = node.getParent().getParent().getRight();

		                if (uncle != null && uncle.getColor() == RED) {
		                    node.getParent().setColor(BLACK);
		                    uncle.setColor(BLACK);
		                    node.getParent().getParent().setColor(RED);
		                    node = node.getParent().getParent();
		                    continue;
		                } 
		                if (node.equals(node.getParent().getRight())) {
		                    //Double rotation needed
		                    node = node.getParent();
		                    rotateLeft(node);
		                } 
		                node.getParent().setColor(BLACK);
		                node.getParent().getParent().setColor(RED);
		                //double rotation needed^
		              /////////////////////////////////////  
		                //single rotation needed>>
		                rotateRight(node.getParent().getParent());
		            } else {
		                uncle = node.getParent().getParent().getLeft();
		                 if (uncle != null && uncle.getColor() == RED) {
		                    node.getParent().setColor(BLACK);
		                    uncle.setColor(BLACK);
		                    node.getParent().getParent().setColor(RED);
		                    node = node.getParent().getParent();
		                    continue;
		                }
		                if (node.equals(node.getParent().getLeft())) {
		                    //Double rotation needed
		                    node = node.getParent();
		                    rotateRight(node);
		                }
		                node.getParent().setColor(BLACK);
		                node.getParent().getParent().setColor(RED);		                //if the "else if" code hasn't executed, this
		                //is a case where we only need a single rotation
		                rotateLeft(node.getParent().getParent());
		            }
		        }
		        root.setColor(BLACK);
		    }
		 public void rotateLeft(RedBlackNode node) {
			 if(node.getParent()!=null) {
				 if (node.equals(node.getParent().getLeft())) {
					 RedBlackNode temp = node.getParent().getLeft();
		                temp = node.getRight();
		            } else {
		            	RedBlackNode temp = node.getParent().getRight();
		                temp = node.getRight();
		            }
				 	node.getRight().setParent(node.getParent());
		            node.setParent(node.getRight());
		            if (node.getRight().getLeft() != null) {
		                node.getRight().getLeft().setParent(node);
		            }
		            node.setRight(node.getRight().getLeft());
		            node.getParent().setLeft(node);
		        } else {//Need to rotate root
		            RedBlackNode right = root.getRight();
		            root.setRight(right.getLeft());
		            right.getLeft().setParent(root);
		            root.setParent(right);
		            right.setLeft(root);
		            right.setParent(null);
		            root = right;
		        }
		 }
		 public void rotateRight(RedBlackNode node) {
			 if(node.getParent()!=null) {
				 if (node.equals(node.getParent().getLeft())) {
					 node.getParent().setLeft(node.getLeft());
		            } 
				 else {
					 node.getParent().setRight(node.getLeft());
		            }
				 	node.getLeft().setParent(node.getParent());
				 	node.setParent(node.getLeft());
		            if (node.getLeft().getRight() != null) {
		                node.getLeft().getRight().setParent(node);
		            }
		            node.setLeft(node.getLeft().getRight());
		            node.getParent().setRight(node);
		        } else {//Need to rotate root
		            RedBlackNode left = root.getLeft();
		            root.setLeft(root.getLeft().getRight());
		            left.getRight().setParent(root);
		            root.setParent(left);
		            left.setRight(root);
		            left.setParent(null);
		            root = left;
		        }
		 }
	}
