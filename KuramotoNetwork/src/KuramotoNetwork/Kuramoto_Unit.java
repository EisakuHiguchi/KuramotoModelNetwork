package KuramotoNetwork;

import BAModel.BA_Node;
import KuramotoUnit.Kuramoto;

public class Kuramoto_Unit extends BA_Node {
	
	protected Kuramoto k;
	
	
	public Kuramoto_Unit(double x, double y,
			double w, double dt, double K) {
		super(x,y);
		Kuramoto_Init(w, dt, K);
	}
	
	public Kuramoto_Unit(double[] xy, 
			double w, double dt, double K) {
		super(xy);
		Kuramoto_Init(w, dt, K);
	}
	
	private void Kuramoto_Init(double w, double dt, double K) {
		k = new Kuramoto(w, dt, K);
	}
	
	public double[] getPhj() {
		double[] r = new double[getNode().size()];
		for(int i = 0; i < r.length; i++) r[i] = getNode().get(i).getKuramoto().getPhase();
		return r;
	}
	public Kuramoto getKuramoto() { return k; }
}
