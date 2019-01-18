package gameDeveloptment;

import java.awt.Graphics;

public class Main extends GameLoop {

		public void init(){
			setSize(1920,1080);
			Thread th= new Thread(this);
			th.start();
			offscreen= createImage(1920, 1080);
			d=offscreen.getGraphics();
			addKeyListener(this);
		}
		public void paint(Graphics g){
			d.clearRect(0,0,1920,1080);
			d.drawImage(background, 0, 0,this);
			d.drawImage(player1,x,y,this);
			
			g.drawImage(offscreen,  0,  0, this);
		}
		public void update(Graphics g){
			paint(g);
		}

}
