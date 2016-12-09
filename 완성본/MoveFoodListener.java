import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class MoveFoodListener implements MouseListener 
{	

	JTextField name = new JTextField();
	JTextField tan= new JTextField();
	JTextField fat= new JTextField();
	JTextField protein= new JTextField();
	JTextField cal= new JTextField();
	JButton apply ;
	JButton exit ;
	private  TimePanel time;
	private  FoodButtonList food;  
	private  TimeLinePanel t_prev; //������ ���� Ÿ�� �г� ���  
	private  TimeLinePanel t_cur;// ���� ���� Ÿ�� �г� ���
	private  FoodButton prev;// ������ ���� Ÿ�� �г� ���
	private  FoodButton cur;// ���� ���� Ÿ�� �г� ���
	private MyListener listener;
	private SecondPanel second;
	private static MoveFoodListener me;
	public static MoveFoodListener getMoveFoodListener(){
		return me;
	}
	public  MoveFoodListener(SecondPanel s){
		me = this;
		listener = new MyListener();
		second = s;
		setTime();
		setFood();
	}
	public void setTime(){
		time = second.getTimePanel();
	}
	public void setFood(){
		food = second.getFoodPanel().getFoodButtonList();
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{

		if(e.getSource().getClass()==(new TimeLinePanel()).getClass()) //Ÿ�Ӷ��ο��� �̺�Ʈ �߻�
		{
			t_cur = (TimeLinePanel)e.getSource();
			if(t_prev==null) //���� �Ǿ��� Ÿ�� ���� ���� ���� ����
			{
				t_cur.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Constant.c2));// ���� ���� �г� ǥ��
			}
			else if(t_cur==t_prev){//���ȴ��� �� ������ Ÿ�Ӷ��� �����
				time.deleteT(t_prev);// �����
				t_prev=null;//������ ���� �� �Ѱɷ� �ٲٱ�
			}
			else // Ÿ�Ӷ��� ���� ����
			{
				for(FoodButtonPanel temp : t_prev.getList()){
					temp.removeMouseListener(listener);//Ÿ�� �г� ���� Ǫ���г� �� ���� �ǰ� �ٲ� ������ ����
				}
				for(FoodButtonPanel temp : t_cur.getList()){
					temp.addMouseListener(listener);// Ÿ�� �г� ���� Ǫ�� �г� ���� �Ǽ� ���� �ǰ� �ٲ�
				}
				t_cur.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Constant.c2));//���� �гη� ǥ��
				t_prev.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.white));//���� �гη� ǥ��

			}
			t_prev = t_cur;//���� ���� �г��� �ֱٿ� ���� �гη� ����ϰ� ��
		}
		else if(e.getSource().getClass()==(new FoodButton()).getClass())//���� Ǫ�� ��ư�� ��������
		{
			cur = (FoodButton)e.getSource();
			if(t_prev!=null){   //Ÿ���� ���õǾ� �־��ٸ� ������ �߰��Ѵ�.
				FoodButtonPanel temp = new FoodButtonPanel(cur );//Ÿ�ӿ� �߰��� ���� �г��� �����
				temp.addMouseListener(listener);//�����ʸ� ��Ͻ�Ų�� �� �����ʴ� Ÿ�� �гο��� ���� ������ ���
				t_prev.addF(temp);////�߰��Ѵ�
				TotalAted.add(cur);//������ ���������� �����
				second.getGraphPanel().startThread();//�׷��� �гξ������� �ǽð� ���۽�Ŵ
			}
			
			if(prev==null)//������ ���õǾ����� ���ٸ� ���� ���õȰ� ǥ��
			{
				cur.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Constant.c2));
				prev = cur;	//�ֱ� ������ ���� �������� �ٲ���
			}
			else if(cur==prev){	//���� ���ð� ���� ���� ������ �ƹ��͵� ����
			}
			else//������ ���õȰ� �־����� ���� ���� ǥ���ϰ� ���粨 ǥ��
			{
				cur.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Constant.c2));
				prev.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.white));
				prev = cur;// ���� ���� ��ư�� ��� ���� �Ȱɷ� ������Ʈ
			}		
		}else if(e.getSource() == second.getOption_time()){ //���� Ÿ�Ӷ��� �߰� ��ư�� ������ Ÿ��
			time.addTimeLine(new TimeLinePanel());//Ÿ�Ӷ����� ���� �� �߰�
			time.setVisible(false);// �̺κ� ������ �������� �ٷ� ������Ʈ �� �Ǿ  
			time.setVisible(true);//  �ڵ� �߰� ����
		}else{// ���� Ǫ�� �г� ��ó�� �ִ� ���� ī�װ� �߰� ��ư�� ������
			JDialog popup = new JDialog();//���̾�α� ���� ����ش�.
			popup.setTitle("food setup");// ���̾�α�â �̸�
			{
				DialogPan pan = new DialogPan(popup);//���̾�α׸� ����ϰ� ���� �̺�Ʈ�� ������ ����ϴ� �г��� ����
				popup.setSize(new Dimension(500,750));
				popup.add(pan);//���� �г��� �߰�
				popup.setVisible(true);//���̰� ����
			}
		}
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	private class MyListener implements MouseListener{
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseClicked(MouseEvent e)
		{
			if(t_prev!=null )	// Ÿ�ӿ��� ��������
			{					
				
				TotalAted.minus((FoodButtonPanel)(e.getSource())); // ���� Ÿ�ӿ��� ������ �ɶ� ������ ����
				t_prev.deleteF((FoodButtonPanel)e.getSource());//���� �����ְ�
				t_prev.setVisible(false);// 
				t_prev.setVisible(true);// ���ذ� �ٷ� ���̰� ����
				second.getGraphPanel().startThread();// �׷��� ���� ������Ʈ�ϰ� ������ ����
			}
		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}

	}
}