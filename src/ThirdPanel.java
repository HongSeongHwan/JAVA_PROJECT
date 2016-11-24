import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
public class ThirdPanel extends JPanel{
	private JButton nextPage;
	private ThirdPanelListener listener;
	
	public ThirdPanel(){
		listener = (new ThirdPanelListener());
		nextPage = new JButton("qwe");
		setBackground(Color.CYAN);
		this.setBounds(1, 1, 50, 50);
		
		nextPage.setBounds(400,410,50,50);
		nextPage.addMouseListener(new ThirdPanelListener());
		add(nextPage);
	}
	public class ThirdPanelListener implements MouseListener {
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseClicked(MouseEvent e){
			ViewControl.viewPanel(3, 2);
		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
	}

}
