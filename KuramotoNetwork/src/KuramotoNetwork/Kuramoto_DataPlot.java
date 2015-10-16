package KuramotoNetwork;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import DataPlot.DataPlot;

public class Kuramoto_DataPlot extends DataPlot implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	KuramotoNetWork_Manage knm;
	
	public Kuramoto_DataPlot(KuramotoNetWork_Manage mng) {
		super();
		knm = mng;
		n = knm.getAllKuramotoUnit();
		
		JButton button1 = new JButton("next");
		button1.setBounds(0, 0, 100, 10);
		button1.addActionListener(this);
		add(button1);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		knm.nextStep();
		knm.calcValue();
		knm.checkWire();
		for(double d : knm.getOrderPrm()) {
//		for(double d: knm.getUnitData_Array_Phase()) {
			System.out.println(d);
		}
		this.repaint();
	}
}
