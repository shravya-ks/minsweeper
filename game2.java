
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
//import java.awt.event.*;
import javax.swing.*;
//import java.util.*;


public class Game {
	JButton[][] buttons;
	int[][] ar;
	JPanel jp=new JPanel(new GridBagLayout());
	public void gui()
	{
	try{	
	 JFrame fr=new JFrame("Minsweeper");
	fr.setSize(500,500);
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	GridBagConstraints c=new GridBagConstraints();
	String a=".";
	buttons=new JButton[10][10];
	ar=new int[12][12];
	for(int i=0;i<10;i++)
		for(int j=0;j<10;j++)
		{  
			buttons[i][j]=new JButton(a);
			c.gridx=i;
			c.gridy=j;
			jp.add(buttons[i][j],c);
		}
	    fr.add(jp);
		fr.setVisible(true);
		Random r=new Random();
		int z=0;
		final JButton d[]=new JButton[10];
		for(int i=0;i<10;i++)
		{
			int t=r.nextInt(100);
			int rl=t/10;
			int cl=t%10;
			ar[rl+1][cl+1]=-1;
			d[z++]=buttons[rl][cl];
		}  //mine calculation
		for(int i=1;i<=10;i++)
		{
			for(int j=1;j<=10;j++)
			{
				if(ar[i][j]==-1)
					continue;
				int count =0;
				for(int k=i-1;k<=i+1;k++)
				{
					for(int l=j-1;l<=j+1;l++)
						if(ar[k][l]==-1)
							count ++;
				}
				ar[i][j]=count;
				}
			}
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
			{
				final JButton b=buttons[i][j];
				final int ab=ar[i+1][j+1];
				b.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						if(ab==0)
						{
							b.setText(Integer.toString(ab));	
						    calc(i+1,j+1);
							
						}
						else if(ab==-1)
						{
							for(int k=0;k<10;k++)
							{
								d[k].setText("*");
								
							}
							JLabel lab1=new JLabel("Game Over");
							jp.add(lab1);
						}
						else
						{
							b.setText(Integer.toString(ab));
					  
					    }
				}});
				JLabel lab2=new JLabel("You Win");
				jp.add(lab2);
				
			}
		
	}
	catch(Exception e)
	{
		;
	}
	}
	public void calc(int i,int j)
	{
	   if(ar[i][j]!=-1||ar[i][j]!=0)
	     {
	       buttons[i-1][j-1].setText(Integer.toString(ar[i][j]));
	     }

	   else
	   {
	      calc(i,j-1);
	      calc(i,j+1);
	      calc(i-1,j);
	      calc(i+1,j);
	   }
	  
	}
	
	public static void main(String args[])
	{
		Game obj=new Game();
		obj.gui();
	}
}
