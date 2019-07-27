package sum.carrom.carrom_board;

import java.util.*;
public class  carrom implements variables
{
	public board b;
	String carm_name;
	int cmidx;
	int cmidy;
	ArrayList<carrom> c;
	carrom stri;
	int carm_midx;
	int carm_midy;
	int carm_dia=20;
	int carm_rad=carm_dia/2;
	int carm_id;
	double cx;
	double cy;
	double icx=carm_midx;
	double icy=carm_midy;
	int distance;
	
	boolean is_moving;
	boolean carm_hit=false;
	double carm_pow;
	public int x;

	int targetx;
	int targety;
	double min_pow=1;
	double max_pow=5;
	double pow=min_pow;
	double powd=0.010;
	boolean set_stri=true;
	boolean set_target=false;
	boolean show_target=true;
	double ax;
	double ay;
	double iax=carm_midx;
	double iay=carm_midy;

	public carrom(int x,int y,String name)
	{
		carm_name=name;
		carm_midx=x;
		carm_midy=y;
	}
	public carrom()
	{
	}
	public void carm_move(double power,int targetx,int targety,int rad)
	{
		if(carm_midx<=carm_rad+TABLE_MIN_X+pow  || carm_midx>TABLE_MAX_X+40-carm_rad-pow-1)///------prob
		{
			ax=-ax;
		}
		if(carm_midy<TABLE_MIN_Y+carm_rad+pow+1|| carm_midy>TABLE_MAX_Y+40-carm_rad-pow-1)
		{
			ay=-ay;
		}
		if(is_moving==true)
		{
		//carm_dia=40;
		if(pow>0)
			{
			//-----might 
		
			pow=pow-powd;
			iax=iax+ax*pow*2;
			carm_midx=(int)iax;
			iay=iay-ay*pow*2;
			carm_midy=(int)iay;
			//carm_hit=false;
			}

		else 
			set_stri=true;
		
		
		}
	}
	public void carm_in_h(int a,double p)
	{
		if(a>0)
		c.remove(a);
	}

}
		
		/*x=carm;
		c.get(x).carm_rad=rad;
		c.get(x).cmidx=cmx;
		c.get(x).cmidy=cmy;
		c.get(x).pow=power;
		int x2=0;
		if(x2!=x)
		{
			for(;x2<c.size();x2++)
			{
			//c.get(x).distance=(int)Math.sqrt((c.get(x).carm_midx-c.get(x2).carm_midx)*(c.get(x).carm_midy-c.get(x).carm_midx)+(c.get(x).carm_midx-c.get(x).carm_midx)*(c.get(x).carm_midx-c.get(x).carm_midx));
			c.get(x).distance=(int)Math.sqrt((c.get(x).carm_midx-c.get(x2).carm_midx)*(c.get(x).carm_midy-c.get(x2).carm_midx)+(c.get(x2).carm_midx-c.get(x).carm_midx)*(c.get(x2).carm_midx-c.get(x).carm_midx));

			if(c.get(x).distance<=30)
				{
				carm_move(c.get(x2).carm_id,c.get(x2).pow,c.get(x2).carm_midx,c.get(x2).carm_midy,c.get(x2).carm_rad);
				c.get(x2).pow=c.get(x2).pow/2;
					//change own direction;
				}
			}
			//c.get(x).ax=(double)(c.get(x).cmidx-c.get(x).carm_midx)/(Math.abs(c.get(x).cmidx-c.get(x).carm_midx)+Math.abs(c.get(x).carm_midy-c.get(x).cmidy));
			//c.get(x).ay=(double)(c.get(x).carm_midy-c.get(x).cmidy)/(Math.abs(c.get(x).cmidx-c.get(x).carm_midx)+Math.abs(c.get(x).carm_midy-c.get(x).cmidy));
		}
		if(x!=0)
		{
		c.get(x).ax=(double)(c.get(x).cmidx-c.get(x).carm_midx)/(Math.abs(c.get(x).cmidx-c.get(x).carm_midx)+Math.abs(c.get(x).carm_midy-c.get(x).cmidy));
		c.get(x).ay=(double)(c.get(x).carm_midy-c.get(x).cmidy)/(Math.abs(c.get(x).cmidx-c.get(x).carm_midx)+Math.abs(c.get(x).carm_midy-c.get(x).cmidy));
		}
		if(c.get(x).pow>0)
			{
			//-----might 
			c.get(x).pow=c.get(x).pow-c.get(x).powd;
			c.get(x).iax=c.get(x).iax+c.get(x).ax*c.get(x).pow;
			c.get(x).carm_midx=(int)c.get(x).iax;
			c.get(x).iay=c.get(x).iay-c.get(x).ay*c.get(x).pow;
			c.get(x).carm_midy=(int)c.get(x).iay;
			}
		if(c.get(x).carm_midx<=c.get(x).carm_rad+TABLE_MIN_X || c.get(x).carm_midx>=580-c.get(x).carm_rad-pow)///------prob
		{
			c.get(x).ax=-c.get(x).ax;
		}
		if(c.get(x).carm_midy<=TABLE_MIN_Y+c.get(x).carm_rad|| c.get(x).carm_midy>=610-c.get(x).carm_rad-33)
		{
			c.get(x).ay=-c.get(x).ay;
		}
		b.paint();
	}
}*/

		
