import javax.swing.*;
import java.awt.*;
 
public class AdvicePanel extends JPanel
{
    private JPanel  anaP,resultP;
    private JLabel  lblAna,lblResult,lblName;
    private int     check, std;
    private ImageIcon vs, lbs, ok;
     
    public AdvicePanel(){}
    public AdvicePanel(String str,double data,double dataD)
    {//조언을 담당하는 패널
        anaP        = new JPanel();
        resultP     = new JPanel();
        lblAna      = new JLabel();
        lblResult   = new JLabel();
        lblName     = new JLabel();
        vs= new ImageIcon("picture/third/very serious.png");
        lbs=new ImageIcon("picture/third/little bit serious.png");
        ok=new ImageIcon("picture/third/ok.png");
        
        //AdvicePanel 설정
        this.setPreferredSize(new Dimension(400,150));
        this.setLayout(null);
        
        //개인정보에 따른 권장량과 비교하기 위한 값
        check   = Math.abs((int)(data - dataD));
        std     = (int) dataD;
         
        // anaP -- left
        anaP.setLayout(null);
        anaP.setBounds(0,0,160,150);
        anaP.setBackground(Color.white);
        this.add(anaP);   
        
        // lblName  -- left top
        lblName.setText(str);
        lblName.setFont(new Font("한컴 윤고딕 230",Font.BOLD,30));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setVerticalAlignment(SwingConstants.CENTER);
        lblName.setBounds(-20,20,200,100);  
        anaP.add(lblName);
        
        // lblAna   -- left bottom
        lblAna.setText("(" + Math.round(data*100d)/100d + "/" +Math.round(dataD*100d)/100d + ")");
        lblAna.setFont(new Font("Verdana",Font.BOLD,15));
        lblAna.setHorizontalAlignment(SwingConstants.CENTER);
        lblAna.setVerticalAlignment(SwingConstants.CENTER);
        lblAna.setBounds(-20,80,200,50);
        anaP.add(lblAna);
         
        // resultP  -- right
        resultP.setLayout(null);
        resultP.setBounds(140,0,175,150);
        
        // 권장량값과 비교
        if(check>0)          resultP.setBackground(Color. yellow);
        else if(check<0) resultP.setBackground(Color.yellow);
        else                resultP.setBackground(Color.white);
        this.add(resultP);
        
        // lblResult
        AdviceLabel(lblResult,check);
        lblResult.setBounds(0,0,190,150);
        resultP.add(lblResult);                 
    } // AdvicePanel()
     
    public void AdviceLabel(JLabel lbl, int check)
    {//비교를 통하여 해당 범위에 해당하는 그림표시
        lbl.setFont(new Font("Verdana",Font.BOLD,40));
        lbl.setForeground(Color.white);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setVerticalAlignment(SwingConstants.CENTER);
        lbl.setPreferredSize(new Dimension(190,150));
         
        if(check > (std*0.2))        lbl.setIcon(vs);    //  많이 위험 표시
        else if(check > (std*0.1))   lbl.setIcon(lbs);   //  조금 위험 표시
        else                        lbl.setIcon(ok);    //  적당  표시
    }   // AdviceLabel()
}//AdvicePanel
 
