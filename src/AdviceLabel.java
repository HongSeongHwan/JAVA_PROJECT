import javax.swing.*;
import java.awt.*;

public class AdviceLabel extends JLabel
{
	
	public AdviceLabel(){}
	public AdviceLabel(int flag, int check)
	{
		/*	
			flag	-- to know tot,dan,tan,ji
			check	-- compare ated with standard
		*/
		this.setFont(new Font("Verdana",Font.BOLD,40));
		this.setForeground(Color.white);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setBounds(0,0,400,150);
		
		// tot
		if(flag ==1){
			if(check==1)		setText("too much");
			else if(check==-1)	setText("too little");
			else 				setText("Good");
		}
		
		// dan
		else if(flag ==2) {
			if(check==1)		setText("too much");
			else if(check==-1)	setText("too little");
			else 				setText("Good");
		}
		
		// tan
		else if(flag ==3) {
			if(check==1)		setText("too much");
			else if(check==-1)	setText("too little");
			else 				setText("Good");
		}
		
		// ji
		else{//flag == 4
			if(check==1)		setText("too much");
			else if(check==-1)	setText("too little");
			else 				setText("Good");
		}
	}
}