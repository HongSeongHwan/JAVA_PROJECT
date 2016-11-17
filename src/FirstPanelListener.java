import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class FirstPanelListener implements MouseListener {
	
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){
		ViewControl.viewPanel(1,2);
		//view.viewSecondPanel();
		PrivateInfo.setAge(Integer.parseInt(ViewControl.first.field[0].getText()));
		//System.out.println(PrivateInfo.getAge());
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}
