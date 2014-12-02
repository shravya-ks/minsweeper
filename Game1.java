
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Game {
	public static void main(String args[])
	{
	try{
	 JFrame fr=new JFrame("Minsweeper");
	fr.setSize(200,200);
	fr.setVisible(true);
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel jp=new JPanel(new GridBagLayout());
	fr.getContentPane().add(jp);
	GridBagConstraints c=new GridBagConstraints();
	JButton[][] buttons=new JButton[10][10];
	
	for(int i=0;i<10;i++)
		for(int j=0;j<10;j++)
		{  
			c.gridx=i;
			c.gridy=j;
			jp.add(buttons[i][j],c);
			
			
		}
	}
	catch(Exception e)
	{
		;
	}
	}
}
	
