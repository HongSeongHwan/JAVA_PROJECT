import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class SecondPanelListener implements MouseListener {
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){
		ViewControl.viewPanel(2, 3);
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}
