import java.util.*;
import java.io.*;
public class BinaryCardTreeDriver {
	public static void main(String[] args)throws IOException{
		Scanner input = new Scanner(new File("BinaryCardTree.txt"));
		int num = input.nextInt();
		BinaryCardTree tree = new BinaryCardTree();
		for(int x = 0;x<num;x++) {
			tree.add(new BinaryCountNode(input.next()));
		}
		System.out.println("hand size: "+tree.getAllCards(tree.getRoot()).size());
		System.out.println("hand --> " + tree.getAllCards(tree.getRoot()));
		num = input.nextInt();
		Goals g = new Goals();
		String str = input.nextLine();
		ArrayList<String> gStr = new ArrayList<String>();
		for(int x = 0;x<num;x++) {
			str = input.nextLine();
			int gNum = Integer.parseInt(str.substring(0,1));
			g.addGoal(str.substring(2), gNum);
			g.increment(str.substring(2), tree.getNumber(str.substring(2)));
			gStr.add(str.substring(2));
		}
		g.printer();
		for(String x:gStr) 
			if(g.done(x))
				g.evaluate(x, tree);
		System.out.println("Uncompleted Goals:");
		for(String x:gStr) 
			if(!g.done(x))
				g.evaluate(x, tree);
		num = input.nextInt();
		for(int x = 0;x<num;x++) {
			tree.add(new BinaryCountNode(input.next()));
		}
		System.out.println("hand size: "+tree.getAllCards(tree.getRoot()).size());
		System.out.println("hand --> " + tree.getAllCards(tree.getRoot()));
		System.out.println("Color with most cards: "+tree.getMostColorCard());
		System.out.println("Color with least cards: "+tree.getLeastColorCard());
	}
}
