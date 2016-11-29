import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.util.*;

public class TimeLinePanel extends JPanel {
	private ArrayList<JPanel> list;
	public TimeLinePanel(){
		list = new ArrayList<JPanel>();
		this.setPreferredSize(new Dimension(360, 130));
		this.setBackground(Color.black);
		this.setLayout(new GridLayout(1,3));
	}
	void addF(JPanel b){
		list.add(b);
		this.add(b);
		validate();
	}
	void deleteF(JPanel b){
		this.remove(b);
		list.remove(b);
		validate();
		
	}
}
