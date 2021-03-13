import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionListener;

import javax.swing.*;
public class TreeGraphics extends JPanel{
	private BinarySearchTree tree;
	public TreeGraphics(BinarySearchTree x) throws IOException {
		tree = x;
		tree = fillTree(tree);
	}
	public void paintComponent(Graphics g) {
		draw(tree.getRoot(),627,50,1,g,0,0);
		}
	public void draw(BinaryNode node, int centerX, int centerY, int level, Graphics g, int prevX, int prevY) {
		if(node==null) {
			if(level<6) {
			if(prevX!=0 && prevY!=0) {
				g.setColor(Color.gray);
				g.drawLine(prevX+22, prevY+30, centerX+22, centerY);
			}
			g.setColor(Color.gray.LIGHT_GRAY);
			g.fillOval(centerX, centerY, 45,30);
			g.setColor(Color.black);
			g.drawString("NULL", centerX, centerY);
			return;
			}
		}
		else {
			if(prevX!=0 && prevY!=0) {
				g.setColor(Color.gray);
				g.drawLine(prevX+22, prevY+30, centerX+22, centerY);
			}
			g.setColor(Color.gray.LIGHT_GRAY);
			g.fillOval(centerX, centerY, 45,30);
			g.setColor(Color.black);
			g.drawString(node.getVal(), centerX, centerY);
			draw(node.getLeft(), centerX-(730/(int)(Math.pow(2,level))),centerY+100,level+1,g,centerX,centerY);
			draw(node.getRight(), centerX+(730/(int)(Math.pow(2,level))),centerY+100,level+1,g,centerX,centerY);
		}
	}
	public static void main(String[] args) throws IOException{
		TreeGraphics gui= new TreeGraphics(new BinarySearchTree());
		JFrame f = new JFrame();
		f.setTitle("BINARY SEARCH TREE");
		f.setSize(1920,1080);
		f.setVisible(true);
		//gui.setBackground(Color.BLUE.darker());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
//		JTextField form = new JTextField(20);
//		gui.setLayout(new FlowLayout());
//		gui.add(form);
//		JButton button = new JButton("ENTER");
//		gui.add(button);
//		button.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent e) {
//				String str = form.getText();
//				addTree(new BinaryNode(str), tree);
//			}
//		});
		
		
		
		f.getContentPane().add(gui);
		f.setVisible(true);
		//BinarySearchTree tree = new BinarySearchTree();
//		tree = fillTree(tree);
		
//	}
//	public static void addTree(BinaryNode x, BinarySearchTree tree) {
//		tree.add(x);
	}
	public static BinarySearchTree fillTree(BinarySearchTree tree) throws IOException {
		Scanner input = new Scanner(new File("BinaryGraphics.txt"));
		while(input.hasNext()) {
			tree.add(new BinaryNode(input.next()));
		}
		return tree;
	}
}