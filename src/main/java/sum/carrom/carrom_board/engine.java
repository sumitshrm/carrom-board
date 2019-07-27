package sum.carrom.carrom_board;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
public class engine extends carrom implements Runnable, MouseMotionListener, MouseListener, KeyListener, variables
{
	
	int tempx;
	int tempy;
	String s="not pressed" ;
	boolean hit=false;
		
	///-------------------------------------------data---
	String click=" not clicked";


	public engine(board b2)
	{
		
		b=b2;
		c=new ArrayList<carrom>();
		//stri=new carrom(TABLE_MID_X,TABLE_MID_Y,0);
		//stri=new carrom(STRI_START_X,STRI_START_Y,100);
		carrom stri=new carrom(TABLE_MID_X,TABLE_MID_Y+150,"pink");
		c.add(stri);
		c.add(new carrom(TABLE_MID_X,TABLE_MID_Y,"red"));
		c.add(new carrom(310,276,"black"));
		c.add(new carrom(310,TABLE_MID_Y+22,"black"));
		c.add(new carrom(310,362,"black"));
		c.add(new carrom(291,311,"black"));
		c.add(new carrom(329,311,"black"));
		c.add(new carrom(272,300,"black"));
		c.add(new carrom(350,300,"black"));
		c.add(new carrom(270,345,"black"));
		c.add(new carrom(351,340,"black"));
		c.add(new carrom(310,298,"white"));
		c.add(new carrom(290,287,"white"));
		c.add(new carrom(330,287,"white"));
		c.add(new carrom(291,333,"white"));
		c.add(new carrom(329,333,"white"));
		c.add(new carrom(272,322,"white"));
		c.add(new carrom(350,322,"white"));
		c.add(new carrom(290,355,"white"));
		c.add(new carrom(331,355,"white"));
		//c.add(new carrom(TABLE_MID_X,TABLE_MID_Y+43,"black"));
		//c.add(new carrom(TABLE_MID_X,TABLE_MID_Y+60,0));
		//c.add(new carrom(TABLE_MID_X+63,TABLE_MID_Y+43,0));


		Thread th=new Thread(this);
		th.start();
	}

	//---------------------------mouse events---------------------

	public void mouseDragged(MouseEvent e) 
	{
		int x=e.getX();
		int y=e.getY();
		targetx=x;
		targety=y;
		
		if(set_stri)
		{
			c.get(0).carm_midx=x;
			c.get(0).carm_midy=y;
			c.get(0).iax=c.get(0).carm_midx;
			c.get(0).iay=c.get(0).carm_midy;
			b.setStri(c.get(0).carm_midx,c.get(0).carm_midy);
			set_target=true;
			show_target=false;
		}
		//Point p=e.getPoint();
		

	}

	public void mouseMoved(MouseEvent e) 
	{
		tempx=e.getX();
		tempy=e.getY();
		int x=e.getX();
		int y=e.getY();
		if(set_target)
		{
			show_target=true;
			c.get(0).pow=min_pow;
			hit=false;
			targetx=x;
			targety=y;
			b.setTarget(targetx,targety,set_target,show_target);
			
			c.get(0).ax=(double)(targetx-c.get(0).carm_midx)/(Math.abs(targetx-c.get(0).carm_midx)+Math.abs(c.get(0).carm_midy-targety));
			c.get(0).ay=(double)(c.get(0).carm_midy-targety)/(Math.abs(targetx-c.get(0).carm_midx)+Math.abs(c.get(0).carm_midy-targety));
			b.setData(c.get(0).cx,c.get(0).cy,c.get(0).carm_midx,c.get(0).carm_midy,c.get(0).carm_hit);
			//ax=(targetx-stri_midx)/(Math.abs(targetx-stri_midx)+Math.abs(stri_midy-targety))*pow;
			//ay=(stri_midy-targety)/(Math.abs(targetx-stri_midx)+Math.abs(stri_midy-targety))*pow;
			//ax=(double)(targetx-stri_midx)/(Math.abs(targetx-stri_midx)+Math.abs(stri_midy-targety));
	//can b calc here		//ay=(double)(stri_midy-targety)/(Math.abs(targetx-stri_midx)+Math.abs(stri_midy-targety));
			//for(int a=0;a<c.length;a++)
			//{
			//c[a].ax=(double)(targetx-c[a].carm_midx)/(Math.abs(targetx-c[a].carm_midx)+Math.abs(c[a].carm_midy-targety));
			//c[a].ay=(double)(c[a].carm_midy-targety)/(Math.abs(targetx-c[a].carm_midx)+Math.abs(c[a].carm_midy-targety));
			//}
			
		}
	}

	public void mousePressed(MouseEvent e) 
		{
		
	
		}

    public void mouseReleased(MouseEvent e) 
		{
		
		}

    public void mouseEntered(MouseEvent e) 
		{
      
		 }

    public void mouseExited(MouseEvent e) {
      
		}

    public void mouseClicked(MouseEvent e) {
			
     
		 }


	//---------------------------key events-----------------------

	public void keyPressed(KeyEvent e)
	{
		if(c.get(0).pow<=max_pow && c.get(0).pow>=min_pow)
		c.get(0).pow=c.get(0).pow+0.50;

	}
	public void keyReleased(KeyEvent e)
		{
		char key=e.getKeyChar();
		if(set_target)
		{
		if('h'==key);
		set_stri=false;
		set_target=false;
		hit=true;
		
		}
		}

	public void keyTyped(KeyEvent e){}
	/*for(int a=0;a<c.length;a++)
			{
			c[a].cx=(double)(c[a].carm_midx-stri_midx)/(Math.abs(c[a].carm_midx-stri_midx)+Math.abs(stri_midy-c[a].carm_midy));
			c[a].cy=(double)(stri_midy-c[a].carm_midy)/(Math.abs(c[a].carm_midx-stri_midx)+Math.abs(stri_midy-c[a].carm_midy));
			}*/


	public void run()
	{
		
		while (true)
		{
			if(hit==true)
			{
			c.get(0).is_moving=true;
//				for(int x=0;x<c.size();x++)
//				{
//
//				}

				for(int x=0;x<c.size();x++)
				{
					if(c.get(x).is_moving==true)
					{
						c.get(x).carm_move(1,1,1,1);
						for(int y=0 ;y<c.size();y++)
						{
							
							distance=(int)Math.sqrt((c.get(x).carm_midx-c.get(y).carm_midx)*(c.get(x).carm_midx-c.get(y).carm_midx)+(c.get(x).carm_midy-c.get(y).carm_midy)*(c.get(x).carm_midy-c.get(y).carm_midy));
							if(distance<=18+c.get(x).pow && distance!=0)//changed here8888888888888888888888888
							{
								//if(c.get(x).pow>c.get(y).pow)
								//{
								
								c.get(y).is_moving=true;
								c.get(y).pow=c.get(x).pow;
								c.get(x).pow=c.get(x).pow/2;
								c.get(y).iax=c.get(y).carm_midx;
								c.get(y).iay=c.get(y).carm_midy;
								c.get(y).ax=-(double)(c.get(x).carm_midx-c.get(y).carm_midx)/(Math.abs(c.get(x).carm_midx-c.get(y).carm_midx)+Math.abs(c.get(y).carm_midy-c.get(x).carm_midy));
								c.get(y).ay=-(double)(c.get(y).carm_midy-c.get(x).carm_midy)/(Math.abs(c.get(x).carm_midx-c.get(y).carm_midx)+Math.abs(c.get(y).carm_midy-c.get(x).carm_midy));
								c.get(y).is_moving=true;
								
								//}
								
								
								
							}
						}
						int dist_frm_h1=(int)Math.sqrt((c.get(x).carm_midx-HOLE1_X)*(c.get(x).carm_midx-HOLE1_X)+(c.get(x).carm_midy-HOLE1_Y)*(c.get(x).carm_midy-HOLE1_Y));
						int dist_frm_h2=(int)Math.sqrt((c.get(x).carm_midx-HOLE2_X)*(c.get(x).carm_midx-HOLE2_X)+(c.get(x).carm_midy-HOLE2_Y)*(c.get(x).carm_midy-HOLE2_Y));
						int dist_frm_h3=(int)Math.sqrt((c.get(x).carm_midx-HOLE3_X)*(c.get(x).carm_midx-HOLE3_X)+(c.get(x).carm_midy-HOLE3_Y)*(c.get(x).carm_midy-HOLE3_Y));
						int dist_frm_h4=(int)Math.sqrt((c.get(x).carm_midx-HOLE4_X)*(c.get(x).carm_midx-HOLE4_X)+(c.get(x).carm_midy-HOLE4_Y)*(c.get(x).carm_midy-HOLE4_Y));
						if(dist_frm_h1<=17 || dist_frm_h2<=17 || dist_frm_h3<=17 || dist_frm_h4<=17)
						{
							carm_in_h(x,c.get(x).pow);
						}
						

					}
					if(c.get(0).pow>0.00)
						set_stri=false;
					else
						set_stri=true;
						//
				}
					
		
				
			}
			try
				{
					Thread.sleep(10);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			//b.setStri(stri_midx,stri_midy);
			b.setData(c.get(0).ax,c.get(0).ay,c.get(0).carm_midx,c.get(0).carm_midy,set_stri);
			b.setTarget(targetx,targety,set_target,show_target);
			b.paint();
		}
	}
}






/*
1.hide target while draging stri 
*/