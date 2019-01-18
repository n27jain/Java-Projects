package gameDeveloptment;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameLoop extends Applet implements Runnable, KeyListener {
	public int x,y;
	public Image offscreen;
	public Graphics d;
	public boolean up, down, left, right;
	public BufferedImage background, player1,
	f0,f1,f2,f3,f4,f5,f6,
	b1,b2,b3,b4,b5;
	public int i;
	public void run() {
		x=100;
		y=100;
		try {
			background = ImageIO.read(new File("background.png"));
			f0=ImageIO.read(new File("player.png"));
			f1=ImageIO.read(new File("final 1.png"));
			f2=ImageIO.read(new File("Final 2.png"));
			f3=ImageIO.read(new File("final 3.png"));
			f4=ImageIO.read(new File("final 4.png"));
			f5=ImageIO.read(new File("final 5.png"));
			f6=ImageIO.read(new File("final 6.png"));
			b1=ImageIO.read(new File("back 1.png"));
			b2=ImageIO.read(new File("back 2.png"));
			b3=ImageIO.read(new File("back 3.pmg"));
			b4=ImageIO.read(new File("back 4.png"));
			b5=ImageIO.read(new File("back 5.png"));
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while(true){
			i++;
			if(i >=35){
				i=0;
			}
			if (i<=5 && right == true){
				player1=f0;
			}
			if (i>=5&&i<=10 && right == true){
				player1=f1;
			}
			if (i>=10&&i<=15 && right == true){
				player1=f2;
			}
			if (i>=15&&i<=20 && right == true){
				player1=f3;
			}
			if (i>=20&&i<=25 && right == true){
				player1=f4;
			}
			if (i>=25&&i<=30 && right == true){
				player1=f5;
			}
			if (i>=30&&i<=35 && right == true){
				player1=f6;
			}

			if(left==true){
				x-=8;
			}
			if(right==true){
				x+=8;
			}
			if(up==true){
				y-=8;
			}
			if(down==true){
				y+=8;
			}
			 repaint();
			 try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}
		}
		
		
	}

	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==37){
			left= true;
		}
		if(e.getKeyCode()==38){
			up= true;
		}
		if(e.getKeyCode()==39){
			right= true;
		}
		if(e.getKeyCode()==40){
			down= true;
		}
		
	}


	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==37){
			left= false;
		}
		if(e.getKeyCode()==38){
			up= false;
		}
		if(e.getKeyCode()==39){
			right= false;
		}
		if(e.getKeyCode()==40){
			down= false;
		}
		
	}
	public void keyTyped(KeyEvent e) {
	
		
	}

}
