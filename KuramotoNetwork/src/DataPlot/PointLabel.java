package DataPlot;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class PointLabel extends JLabel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean state = false;
	
	public PointLabel() {
		addMouseListener(this);
	}
	
	public void clicked() {
		
		if(state) {
			this.setForeground(Color.red);
			state = false;
		} else {
			this.setForeground(Color.black);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) { }

	@Override
	public void mouseEntered(MouseEvent arg0) {
//		if(getCursor().getType() != Cursor.HAND_CURSOR) setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
//		if(getCursor().getType() != Cursor.DEFAULT_CURSOR) setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent arg0) {	
		state = true;
		System.out.println("read");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) { }
}
