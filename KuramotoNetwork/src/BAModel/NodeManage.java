package BAModel;

import java.util.ArrayList;
import java.util.Random;

public class NodeManage {

	protected int size;
	protected double x,y, distance;
	protected int len, count;
	protected ArrayList<double[]> next;
	protected ArrayList<BA_Node> allNode;
	
	public NodeManage(){}
	
	public NodeManage(int distance, int size) {
		allNode = new ArrayList<>();
		x = 0; y = 0; len = 0; count = 1;
		this.distance = size / (Math.sqrt(distance + 4) + 3);
		init();
	}
	
	public void addNewNode() {
		int allwire = 0;
		Random r = new Random();
		BA_Node n = createNode();
		
		for(BA_Node e: allNode) allwire += e.getWireNum();
		for(BA_Node e: allNode) {
			if(r.nextInt(allwire) > (allwire - e.getWireNum())) {
				n.setNode(e);
			}
		}
	}
	
	
	protected void nextNodeLocations() {
		next = new ArrayList<>();
		count = 0;
		x += distance;
		y += distance;
		
		setNextLocation(x, y);
		for(int i = 1; i <= len; i++) {
			setNextLocation(x, y - i*distance);
			setNextLocation(x - i*distance, y);
		}
		len++;
	}
	
	protected double[] getNext() {
		if(count >= len*2-1) {
			nextNodeLocations();
		}
		count++;
		return next.get(count - 1);
	}
	
	protected void setNextLocation(double x, double y) {
		double[] loc = new double[2];
		loc[0] = x;
		loc[1] = y;
		next.add(loc);
	}
	
	public BA_Node createNode() {
		BA_Node n = new BA_Node(getNext());
		allNode.add(n);
		return n;
	}
	
	private void init() {
		for(int i = 0; i < 4; i++) {
			createNode();
		}
		
		for(int i = 0; i < allNode.size(); i++) {
			BA_Node n1 = allNode.get(i);
			for(int j = 0; j < allNode.size(); j++) {
				BA_Node n2 = allNode.get(j);
				if(i != j) n1.setNode(n2);
			}
		}
	}
	public ArrayList<BA_Node> getAllNode() { return allNode; }
	
}
