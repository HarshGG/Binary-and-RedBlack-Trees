import java.util.*;
public class Goals {
	private TreeMap<Comparable,Integer> goals = new TreeMap<Comparable,Integer>();
	private TreeMap<Comparable,Integer> counts = new TreeMap<Comparable,Integer>();
	public Goals() {}
	public void addGoal(Comparable val, int num) {
		goals.put(val,num);
		counts.put(val,0);
	}
	public void increment(Comparable val) {
		counts.put(val,counts.get(val)+1);
	}
	public boolean done(Comparable val) {
//		System.out.println(goals.get(val) + " AAA");
//		System.out.println(counts.get(val)+ " BBB");
		return goals.get(val)<=counts.get(val);
	}
	public boolean contains(Comparable val) {
		return goals.containsKey(val);
	}
	public void increment(Comparable val, int x) {
		counts.put(val,x);
	}
	public void evaluate(Comparable val, BinaryCardTree tree) {
		if(!done(val)) {
			System.out.println(goals.get(val)+ "-" + val);
		}
		else {
			ArrayList<Comparable> temp = tree.getAll(val);
			if(temp.size()==goals.get(val)) {
				System.out.println(goals.get(val) + "-" + val +" is completed: " + temp);
			}
			else {
				int diff = temp.size()-goals.get(val);
				for(int x = 0;x<goals.get(val);x++) {
					if(temp.get(x).equals("wild") && diff>=0) {
						temp.remove(x);
						diff--;
					}
				}
				System.out.println(goals.get(val) + "-" + val +" is completed: " + temp);
				}
		}
	}
	public void printer() {
		System.out.println(counts+ " counts");
		System.out.println(goals+ " goals");

		
	}
}
