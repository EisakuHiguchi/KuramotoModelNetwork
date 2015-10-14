package DataPlot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import BAModel.BA_Node;


public class DataPlot extends JPanel implements Runnable, ActionListener{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<BA_Node> n;
	Thread thread = null;
	
	public DataPlot(){
		super();
		thread = new Thread(this);
		thread.start();

		JButton button1 = new JButton("next");
		button1.setBounds(0, 0, 100, 10);
		add(button1);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(n != null) {
			this.setLayout(null);
			Graphics2D g2 = (Graphics2D)g.create();
			g2.setStroke(new BasicStroke(3f));
			g2.setPaint(Color.black);			

			for(BA_Node e: n) {
				ArrayList<BA_Node> wire = e.getNode();
				this.add(e.getLabel());
				double[] np = e.getPoint();
				if(e.getLabel().state) g2.setColor(Color.red);
				
				for(BA_Node u: wire) {
					double[] loc = u.getPoint();
					g2.drawLine((int)np[0], (int)np[1], (int)loc[0], (int)loc[1]);
				}
				g2.setColor(Color.black);
			}
			g2.dispose();
		}
	}
	
	
	
	public void drawBANode(ArrayList<BA_Node> n) {
		this.n = n;
		repaint();
	}

	@Override
	public void run() {
		while(true) {
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
