import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;



public class game extends JFrame implements KeyListener{
	class role extends JLabel{
		boolean isPlayer;
		ImageIcon img;
		
		public role(String s){
			if(s.equals("player")){
				isPlayer = true;
				img = new ImageIcon("mario.png");
				
			}else{
				isPlayer = false;
				img = new ImageIcon("enemy.png");
			}
			this.setIcon(img);
		}
	}
	class bmove1 extends Thread{
		private JButton b1;
		private int sec;
		private int x1;
		private int y1;
		public bmove1(JButton b, int i,int x,int y) {
			b1 = b;
			sec = i;
			x1=x;
			y1=y;
		}
		public void run() {
			while(y1>-50){
				y1-=50;
				b1.setLocation(x1,y1);
				sohot(b1);
				try {
					Thread.sleep(sec);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}

	}
	//
	class bmove2 extends Thread{
		private JButton b1;
		private int sec;
		private int x1;
		private int y1;
		public bmove2(JButton b, int i,int x,int y) {
			b1 = b;
			sec = i;
			x1=x;
			y1=y;
		}
		public void run() {
			while(x1<w){
				x1+=50;
				b1.setLocation(x1,y1);
				sohot(b1);
				try {
					Thread.sleep(sec);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}

	}
	//
	class bmove3 extends Thread{
		private JButton b1;
		private int sec;
		private int x1;
		private int y1;
		public bmove3(JButton b, int i,int x,int y) {
			b1 = b;
			sec = i;
			x1=x;
			y1=y;
		}
		public void run() {
			while(y1<h){
				y1+=50;
				b1.setLocation(x1,y1);
				sohot(b1);
				try {
					Thread.sleep(sec);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}

	}
	//
	class bmove4 extends Thread{
		private JButton b1;
		private int sec;
		private int x1;
		private int y1;
		public bmove4(JButton b, int i,int x,int y) {
			b1 = b;
			sec = i;
			x1=x;
			y1=y;
		}
		public void run() {
			while(x1>-50){
				x1-=50;
				b1.setLocation(x1,y1);
				sohot(b1);
				try {
					Thread.sleep(sec);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}

	}
	//
	class emove extends Thread{
		private ArrayList<JLabel>  lab1;
		private int sec;
		private int x1,x2,x3,x4,x5;
		
		public emove(ArrayList<JLabel>  b, int i) {
			lab1 = b;
			sec = i;
			
			
		}
		public void run() {
			
			x1 = (int)(Math.random()*600);
			x2 = (int)(Math.random()*600);
			x3 = (int)(Math.random()*600);
			x4 = (int)(Math.random()*600);
			x5 = (int)(Math.random()*600);
			gloop = true;gloop2 = true;gloop3 = true;gloop4 = true;gloop5 = true;
			
			int v=0,ca=0,cb=-150,cc=-300,cd=-450,ce=-600;
			while(true){
				if(gloop){
					lab1.get(v).setLocation(x1,ca);
					ca+=20;
				}	
				
				if(gloop2){
					lab1.get(v+1).setLocation(x2,cb);
					cb+=20;
				}
				
				if(gloop3){
					lab1.get(v+2).setLocation(x3,cc);
					cc+=20;
				}
				
				if(gloop4){
					lab1.get(v+3).setLocation(x4,cd);
					cd+=20;
				}
				
				if(gloop5){
					lab1.get(v+4).setLocation(x5,ce);
					ce+=20;
				}
				
				try {
					Thread.sleep(sec);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(ca>700||!gloop){
					ca=0;
					x1 = (int)(Math.random()*600);
					gloop=true;
				}if(cb>700||!gloop2){
					cb=-50;
					x2 = (int)(Math.random()*600);
					gloop2=true;
				}if(cc>700||!gloop3){
					cc=-100;
					x3 = (int)(Math.random()*600);
					gloop3=true;
				}if(cd>700||!gloop4){
					cd=-150;
					x4 = (int)(Math.random()*600);
					gloop4=true;
				}if(ce>700||!gloop5){
					ce=-200;
					x5 = (int)(Math.random()*600);
					gloop5=true;
				}
				
				
			}

		}

	}
	static int h=800,w=700;
	role player;
	
	static JButton[] bullet = new JButton[10]; 
	static ImageIcon[] img;
	static ArrayList<JLabel> enemy = new ArrayList<JLabel>();

	static Timer fail; 
	static boolean gloop,gloop2,gloop3,gloop4,gloop5;
	static int score;
	static JLabel scorelabel;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		game app = new game();
		
		
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.setSize(w, h);
		app.setResizable(false);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
		
	
	
	
	
	}
	public game(){
		score=0;
		scorelabel = new JLabel("Score :"+score);
		scorelabel.setFont(new Font("Serif", Font.PLAIN, 30));
		scorelabel.setForeground(Color.BLUE);
		scorelabel.setBounds(5,5,700,30);
		
		
		ImageIcon icon = new ImageIcon("back.png");
		icon.getImage().flush();
		JLabel backimg_label = new JLabel();
		backimg_label.setIcon(icon);
		setContentPane(backimg_label);
		
		img = new ImageIcon[4];
		img[0] = new ImageIcon("img.png");
		img[1] = new ImageIcon("img1.png");
		img[2] = new ImageIcon("img2.png");
		img[3] = new ImageIcon("img3.png");

		Container c = getContentPane();
		
		player = new role("player");
		c.add(scorelabel);
		for (int i = 0; i < 10; i++) {
			enemy.add(new role("monster")); //飛彈
			c.add(enemy.get(i));
		}
		player.setBounds(-100,-100,100,100);
		
		
		
		player.setBounds(w/2,h-100,70,100);
		
		for (int i = 0; i < enemy.size(); i++) {
			JLabel en = enemy.get(i);//取得第i顆飛彈
			en.setBounds(-200 ,-200, 100, 100);
			
		}
		emove e = new emove(enemy,100);
		
		
		e.start();
		
		c.setLayout(null);
		c.add(player);
		
		

		addKeyListener(this);
		
			
			
		}
		

		
	
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int x = player.getLocation().x;
		int y = player.getLocation().y;
		
		if (e.getKeyCode() == KeyEvent.VK_UP){
			y = Math.max(0, y-30);
		}if(e.getKeyCode() == KeyEvent.VK_DOWN){
			y = Math.min(h-player.getSize().height, y+30);
		}if (e.getKeyCode() == KeyEvent.VK_LEFT){
			x = Math.max(0, x-30);
		}if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			x = Math.min(w-player.getSize().width, x+30);
		}
		player.setLocation(x, y);
		if(e.getKeyCode() == KeyEvent.VK_A){
			 
								
				JButton mjb = new JButton();//取得第i顆飛彈
				mjb.setOpaque(false);
				mjb.setContentAreaFilled(false);
				mjb.setBorderPainted(false);
				mjb.setIcon(img[3]);
				mjb.setBounds(x,y, 50, 100);
				add(mjb); //加入視窗 JFrame
				
				bmove4 m = new bmove4(mjb,30,x,y);
				m.start();

		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			 
			
			JButton mjb = new JButton();//取得第i顆飛彈
			mjb.setOpaque(false);
			mjb.setContentAreaFilled(false);
			mjb.setBorderPainted(false);
			mjb.setIcon(img[1]);
			mjb.setBounds(x,y, 50, 100);
			add(mjb); //加入視窗 JFrame
			
			bmove2 m = new bmove2(mjb,30,x,y);
			m.start();

	}
		if(e.getKeyCode() == KeyEvent.VK_S){
			 
			
			JButton mjb = new JButton();//取得第i顆飛彈
			mjb.setOpaque(false);
			mjb.setContentAreaFilled(false);
			mjb.setBorderPainted(false);
			mjb.setIcon(img[2]);
			mjb.setBounds(x,y, 100, 50);
			add(mjb); //加入視窗 JFrame
			
			bmove3 m = new bmove3(mjb,30,x,y);
			m.start();

	}
		if(e.getKeyCode() == KeyEvent.VK_W){
			 
			
			JButton mjb = new JButton();//取得第i顆飛彈
			mjb.setOpaque(false);
			mjb.setContentAreaFilled(false);
			mjb.setBorderPainted(false);
			mjb.setIcon(img[0]);
			mjb.setBounds(x,y, 100, 50);
			add(mjb); //加入視窗 JFrame
			
			bmove1 m = new bmove1(mjb,30,x,y);
			m.start();

	}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

	static void sohot(JButton lbj){
		int x = lbj.getLocation().x;
		int y = lbj.getLocation().y;
		for(int i=0;i<enemy.size();i++){
			int xx=enemy.get(i).getLocation().x;
			int yy=enemy.get(i).getLocation().y;
		if(Math.abs(xx-x)<=70 && Math.abs(yy-y)<=70){
			enemy.get(i).setLocation(-200,-200);
			score+=50;
			scorelabel.setText("Score :"+score);
				if(i==0)gloop = false;
				if(i==1)gloop2 = false;
				if(i==2)gloop3 = false;
				if(i==3)gloop4 = false;
				if(i==4)gloop5 = false;
			}
		}
	}
}





