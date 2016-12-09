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
	private  TimeLinePanel t_prev; //직전에 눌린 타임 패널 기록  
	private  TimeLinePanel t_cur;// 현재 눌린 타임 패널 기록
	private  FoodButton prev;// 직전에 눌린 타임 패널 기록
	private  FoodButton cur;// 현재 눌린 타임 패널 기록
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

		if(e.getSource().getClass()==(new TimeLinePanel()).getClass()) //타임라인에서 이벤트 발생
		{
			t_cur = (TimeLinePanel)e.getSource();
			if(t_prev==null) //선택 되었던 타임 라인 존재 하지 않음
			{
				t_cur.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Constant.c2));// 현재 눌린 패널 표시
			}
			else if(t_cur==t_prev){//눌렸던게 또 눌리면 타임라인 지우기
				time.deleteT(t_prev);// 지우기
				t_prev=null;//이전꺼 선택 안 한걸로 바꾸기
			}
			else // 타임라인 선택 변경
			{
				for(FoodButtonPanel temp : t_prev.getList()){
					temp.removeMouseListener(listener);//타임 패널 내부 푸드패널 안 선택 되게 바꿈 리스너 삭제
				}
				for(FoodButtonPanel temp : t_cur.getList()){
					temp.addMouseListener(listener);// 타임 패널 내부 푸드 패널 선택 되서 삭제 되게 바꿈
				}
				t_cur.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Constant.c2));//현재 패널로 표시
				t_prev.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.white));//과거 패널러 표시

			}
			t_prev = t_cur;//현재 눌린 패널을 최근에 눌린 패널로 기록하고 끝
		}
		else if(e.getSource().getClass()==(new FoodButton()).getClass())//만약 푸드 버튼이 눌렸으면
		{
			cur = (FoodButton)e.getSource();
			if(t_prev!=null){   //타임이 선택되어 있었다면 음식을 추가한다.
				FoodButtonPanel temp = new FoodButtonPanel(cur );//타임에 추가할 음식 패널을 만들고
				temp.addMouseListener(listener);//리스너를 등록시킨후 이 리스너는 타임 패널에서 음식 삭제를 담당
				t_prev.addF(temp);////추가한다
				TotalAted.add(cur);//음식을 먹은것으로 기록후
				second.getGraphPanel().startThread();//그래프 패널쓰레드의 실시간 동작시킴
			}
			
			if(prev==null)//이전에 선택되었던게 없다면 현재 선택된거 표시
			{
				cur.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Constant.c2));
				prev = cur;	//최근 선택을 이전 선택으로 바꿔줌
			}
			else if(cur==prev){	//이전 선택과 현재 선택 같으면 아무것도 안함
			}
			else//이전에 선택된거 있었으면 이전 선택 표시하고 현재꺼 표시
			{
				cur.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Constant.c2));
				prev.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.white));
				prev = cur;// 이전 선택 버튼을 방금 선택 된걸로 업데이트
			}		
		}else if(e.getSource() == second.getOption_time()){ //만약 타임라인 추가 버튼이 눌리면 타임
			time.addTimeLine(new TimeLinePanel());//타임라인을 만든 후 추가
			time.setVisible(false);// 이부분 없으면 없어진게 바로 업데이트 안 되어서  
			time.setVisible(true);//  코드 추가 했음
		}else{// 만약 푸드 패널 근처에 있는 음식 카테고리 추가 버튼이 눌리면
			JDialog popup = new JDialog();//다이얼로그 만들어서 띄워준다.
			popup.setTitle("food setup");// 다이얼로그창 이름
			{
				DialogPan pan = new DialogPan(popup);//다이얼로그를 장식하고 각종 이벤트와 설정을 담당하는 패널을 만듬
				popup.setSize(new Dimension(500,750));
				popup.add(pan);//만든 패널을 추가
				popup.setVisible(true);//보이게 설정
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
			if(t_prev!=null )	// 타임에서 음식제거
			{					
				
				TotalAted.minus((FoodButtonPanel)(e.getSource())); // 만약 타임에서 음식이 될때 먹은량 빼줌
				t_prev.deleteF((FoodButtonPanel)e.getSource());//음식 없애주고
				t_prev.setVisible(false);// 
				t_prev.setVisible(true);// 없앤거 바로 보이게 해줌
				second.getGraphPanel().startThread();// 그래프 내용 업데이트하게 쓰레드 실행
			}
		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}

	}
}