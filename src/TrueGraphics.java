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
public class TrueGraphics extends JPanel{
	private BinarySearchTree tree;
	private int xVal = 627;
	private int yVal = 50;
	private int[] xCoords = {627,407,847,297,517,737,957,242,352,462,572,682,792,902,1012,215,270,325,380,435,490,545,600,655,710,765,820,875,930,985,1040};
	private int[] yCoords = {50,150,150,250,250,250,250,350,350,350,350,350,350,350,350,450,450,450,450,450,450,450,450,450,450,450,450,450,450,450,450};
	private int numPasses = 0;
	public TrueGraphics(BinarySearchTree x) {
		tree = x;
	}
	public void paintComponent(Graphics g) {
		BinarySearchTree tree = new BinarySearchTree();
		try {
			tree = fillTree(tree);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.paintComponent(g);
		
		//ArrayList<String> vals = tree.levelOrder4();
		
		Queue<BinaryNode> raw = new LinkedList<BinaryNode>();
		raw = tree.levelOrder5();
		ArrayList<String> vals = new ArrayList<String>();
		for(BinaryNode n:raw) {
			if(n!=null)
				vals.add(n.getVal());
			else
				vals.add(null);
		}
		
		BinaryNode node = tree.getRoot();
		if(node!=null) {
			
		}
		
		System.out.println(vals+" THIS IS FFF");
		for(int x = 0;x<vals.size();x++) {
			if(vals.get(x)!=null) {
		g.setColor(Color.GRAY);
		g.fillOval(xCoords[x], yCoords[x], 45, 30);
		g.setColor(Color.BLACK);
		g.drawString(vals.get(x), xCoords[x]+5, yCoords[x]-10);
//		if(x+1<vals.size()-1) {
//		g.drawLine(xCoords[x]+5, yCoords[x]-5,xCoords[x+1]+5,yCoords[x+1]-5);
//				}
			}
		}
		//draw left node
//		if(tree.getRoot().getLeft()!=null) {
//			g.setColor(Color.GRAY);
//			g.fillOval(xVal+(50*numPasses), yVal-50, 45, 30);
//		}
	}
	public static void main(String[] args) throws IOException{
		TrueGraphics gui= new TrueGraphics(new BinarySearchTree());
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