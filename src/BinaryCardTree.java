import java.util.*;
import static java.lang.System.*;

public class BinaryCardTree {
	
	private BinaryCountNode root;
	private Goals goals= new Goals();
	public BinaryCardTree()
	{
		root = null;
	}
	
	public void add(BinaryCountNode x)
	{
		root = add(root,x);
	}
	public BinaryCountNode add(BinaryCountNode node, BinaryCountNode toAdd) {
//		if(goals.contains(toAdd.getVal()))
//			goals.increment(toAdd.getVal());
//		else
//			goals.addGoal(toAdd);
		if(node==null)
			return toAdd;
		else {
		if(node.equals(toAdd)) {
			node.addCount();
			return node;
		}
		else {
			int cTO = node.getVal().compareTo(toAdd.getVal());
			if(cTO>0) 
				node.setLeft(add(node.getLeft(),toAdd));
			else if(cTO<0)
				node.setRight(add(node.getRight(),toAdd));
			return node;
			}
		}
	}
	public int contains(String x)
	{
		BinaryCountNode node = find(root,x);
		if(node!=null)
			return node.getCount();
		return 0;
	}
	
	public BinaryCountNode find(BinaryCountNode node, String x) {
		String str = (String) x;
		if(node!=null) {
		if(node.getVal().equals(str)) {
			return node;
		}
		else if(node.getVal().compareTo(str)>0)
			return find(node.getLeft(),x);
		else if(node.getVal().compareTo(str)<0)
			return find(node.getRight(),x);
		}
		return null;
	}
	
	public ArrayList<Comparable> getAllCards(BinaryCountNode x)
	{
		ArrayList<Comparable> ret= new ArrayList<Comparable>();
		if(x!=null) {
		ret.addAll(getAllCards(x.getLeft()));
		for(int a = 0;a<x.getCount();a++)
			ret.add(x.getVal());
		ret.addAll(getAllCards(x.getRight()));
		}
		return ret;
	}
	
	public int numCardsInHand(BinaryCountNode x)
	{
		return getAllCards(root).size();
	}
	
	public ArrayList<Comparable> getMostColorCard()
	{
		TreeMap<Comparable,Integer> map = new TreeMap<Comparable,Integer>();
		ArrayList<Comparable> all = new ArrayList<Comparable>();
		all = getAllCards(root);
		for(Comparable x: all) {
			if(map.containsKey(x))
				map.put(x,map.get(x)+1);
			else
				map.put(x,0);
		}
		int most = map.get(all.get(0));
		ArrayList<Comparable> ret = new ArrayList<Comparable>();
		ret.add( map.get(all.get(0)));
		for(Comparable x:map.keySet()) {
			if(map.get(x)==most)
				ret.add(x);
			else if(map.get(x)>most) {
				ret.clear();
				ret.add(x);
				most = map.get(x);
			}
		}
		return ret;
	}
	
	public ArrayList<Comparable> getLeastColorCard()
	{
		TreeMap<Comparable,Integer> map = new TreeMap<Comparable,Integer>();
		ArrayList<Comparable> all = new ArrayList<Comparable>();
		all = getAllCards(root);
		for(Comparable x: all) {
			if(map.containsKey(x))
				map.put(x,map.get(x)+1);
			else
				map.put(x,0);
		}
		int least = map.get(all.get(0));
		ArrayList<Comparable> ret = new ArrayList<Comparable>();
		ret.add( map.get(all.get(0)));
		for(Comparable x:map.keySet()) {
			if(map.get(x)==least)
				ret.add(x);
			else if(map.get(x)<least) {
				ret.clear();
				ret.add(x);
				least = map.get(x);
			}
		}
		return ret;
	}

    public ArrayList<Comparable> remove(Comparable target, int num)
    {
        int count = find(root,(String)target).getCount();
        ArrayList<Comparable> ret = new ArrayList<Comparable>();
        if(count>num) {
        	for(int x = 0;x<find(root,(String)target).getCount();x++) {
        		find(root,(String)target).reduce();
        		ret.add(target);
        	}
        }
        return ret;
    }
    public BinaryCountNode getRoot() {
    	return root;
    }
    public void setRoot(BinaryCountNode node) {
    	root = node;
    }
    public int getNumber(Comparable val) {
    	return find(root,(String)val).getCount() + find(root, "wild").getCount();
    }
    public ArrayList<Comparable> getAll(Comparable val){
    	ArrayList<Comparable> ret = new ArrayList<Comparable>();
    	BinaryCountNode temp = find(root,(String)val);
    	for(int x = 0;x<temp.getCount();x++)
    		ret.add(val);
    	temp = find(root,"wild");
    	for(int x = 0;x<temp.getCount();x++)
    		ret.add("wild");
    	return ret;
    }
}


