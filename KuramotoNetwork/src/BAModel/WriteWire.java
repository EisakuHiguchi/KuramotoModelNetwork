package BAModel;

import java.util.ArrayList;
import java.io.*;

public class WriteWire {
	
	public void write(String path, ArrayList<BA_Node> allnode) {
		
		for(int i = 0; i< allnode.size(); i++) {
			write(path + "data" + i + ".txt", allnode.get(i));
		}
		
		createScript(path, allnode.size());
	}
	
	public void write(String fn, BA_Node n) {
		ArrayList<BA_Node> node = n.getNode();
		String r = "";
		r = formatPoint(n);
		
		for(BA_Node e: node) {
			r = r + formatPoint(e) + formatPoint(n);
		}
		
		try {
			FileWriter fw = new FileWriter(fn);
			fw.write(r);
			fw.close();
		} catch(Exception e) {
			
		}
		
	}
	
	private String formatPoint(BA_Node n) {
		double[] p = n.getPoint();
		return p[0] + " " + p[1] + "\n";
	}
	
	private void createScript(String path, int size) {
		try {
			FileWriter fw = new FileWriter(path + "script.txt");
			fw.write("plot \"" + path + "data" + 0 + ".txt\" w l \n");
			for(int i = 1; i < size; i++) {
				fw.write("replot \"" + path + "data" + i + ".txt\" w l \n");
			}
			fw.close();
		} catch(Exception e) {
			
		}
	}
}
