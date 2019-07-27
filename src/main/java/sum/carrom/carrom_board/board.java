package sum.carrom.carrom_board;


import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics;
//import java.awt.Container;
import java.net.URL;

public class  board extends JComponent implements variables
{
	int stri_midx=100;
	int stri_midy=300;
	int stri_rad=20;
	int stri_dia=stri_rad*2;
	int targetx=stri_midx;
	int targety=stri_midy;
	boolean set_target=true;
	boolean show_target=false;
	engine e;
	//carrom[] c=new carrom[3];


	//---------------------------data---------------
	String click=" ";
	double ax=1;
	double ay=1;
	double iax=1;
	double iay=1;
	Image image=new ImageIcon("carrom.jpg").getImage();

	public board()
	{	
		//engine e=new engine(this);
		e=new engine(this);
		//c[0]=new carrom(TABLE_MID_X,TABLE_MID_Y);
		//c[1]=new carrom(250+c[0].carm_dia-5,250+c[0].carm_dia-5);
		//c[2]=new carrom(250,250);
		addMouseMotionListener(e);
		addMouseListener(e);
		//Listen to the keyboard events
		addKeyListener(e);
		

	}

	void addPaneltoFrame(Container container)
	{
		container.add(this);
	}

	public void paintComponent(Graphics g)
	{
		URL res = getClass().getClassLoader().getResource("carrom.JPG");
		image = new ImageIcon(res).getImage();
		g.drawImage(image,0,0,this);
		g.setColor(Color.green);
		
		//g.fillOval(e.stri_midx-e.stri_rad,e.stri_midy-e.stri_rad,e.stri_dia,e.stri_dia);
		
		//g.setColor(Color.black);
		//g.drawRect(TABLE_MIN_X,TABLE_MIN_Y,TABLE_MAX_X,TABLE_MAX_Y);
		//g.fillOval(e.c.get(0).carm_midx-e.c.get(0).carm_rad,e.c.get(0).carm_midy-e.c.get(0).carm_rad,e.c.get(0).carm_dia,e.c.get(x).carm_dia);
		//g.fillOval(e.stri_midx,e.stri_midy,2,2);
		for(int x=0;x<e.c.size();x++)
		{
			if(e.c.get(x).carm_name=="black")
			{
			g.setColor(Color.black);
			}
			else if(e.c.get(x).carm_name=="white")
			{
				g.setColor(Color.white);
			}
			else if(e.c.get(x).carm_name=="red")
			{
				g.setColor(Color.red);
			}
			else
			{
				g.setColor(Color.pink);
			}
			g.fillOval(e.c.get(x).carm_midx-e.c.get(x).carm_rad,e.c.get(x).carm_midy-e.c.get(x).carm_rad,e.c.get(x).carm_dia,e.c.get(x).carm_dia);
			g.setColor(Color.white);
			//g.drawString(Integer.toString(x),e.c.get(x).carm_midx-3,e.c.get(x).carm_midy+5);
			//g.drawString(Integer.toString(e.c.get(x).dist_frm_h),e.c.get(x).carm_midx,e.c.get(x).carm_midy-5);
		}
		//g.fillOval(e.stri.carm_midx,e.stri.carm_midy,e.stri.carm_dia,e.stri.carm_dia);
		
		g.setColor(Color.green);
		if(set_target==true && show_target==true)
		{
		g.drawLine(stri_midx,stri_midy,targetx,targety);
		}
		g.setColor(Color.green);
		//g.drawString("ax="+Integer.toString(iax)+"/"+Integer.toString(iax)+"+"+Integer.toString(iay)+"="+double.toString((iax/(iax+iay))),20,60);
		g.drawString("x="+Integer.toString(e.tempx),20,20);
		g.drawString("y="+Integer.toString(e.tempy),20,30);
//		g.drawString("ay="+Double.toString(ay),20,30);
//		g.drawString("carmx"+Double.toString(iax),20,40);
//		g.drawString("carmy"+Double.toString(iay),20,50);
//		g.drawString("ball"+click,20,70);
		//g.drawString("ax="+,20,70);
		//g.drawString(String.valueOf(c1.dist_frm_stri),20,20);
		requestFocus();
		
	}

	public void setStri(int x,int y)
	{
		stri_midx=x;
		stri_midy=y;
		//repaint();
	}

	public void setTarget(int x,int y,boolean t,boolean s)
	{
		targetx=x;
		targety=y;
		set_target=t;
		show_target=s;
		//repaint();
	}
	public void setData(double a,double b,double x,double y,Boolean c)
	{
		ax=a;
		ay=b;
		iax=x;
		click=Boolean.toString(c);
		//iax=x;
		iay=y;

	}
	public void paint()
	{
		repaint();
	}


	public static void main(String[] args) 
	{
		board b=new board();
		JFrame f=new JFrame("board");
		b.addPaneltoFrame(f.getContentPane());
		f.setBounds(200,100,630,653);//327,653
		f.setVisible(true);
	}
}
