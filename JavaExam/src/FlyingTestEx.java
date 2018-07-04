
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlyingTestEx extends JFrame{
	JPanel contentPane = new JPanel();
	JLabel la = new JLabel("HELLO");
	final int FLYING_UNIT =10;
	
	FlyingTestEx(){
		setTitle("상하좌우 키 이용해 텍스트 움직임");
		setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
	setContentPane(contentPane);
	contentPane.setLayout(null);
	contentPane.addKeyListener(new MyKeyListner());
	la.setLocation(50,50);
	la.setSize(100,20);
	contentPane.add(la);
	setSize(300,300);
	setVisible(true);
	contentPane.requestFocus();
	}
	
	class MyKeyListner extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode();
			switch(keyCode){
			case KeyEvent.VK_UP:
			la.setLocation(la.getX(),la.getY()+FLYING_UNIT);
			break;
			case KeyEvent.VK_LEFT:
			la.setLocation(la.getX()-FLYING_UNIT,la.getY());
			break;
			case KeyEvent.VK_RIGHT:
			la.setLocation(la.getX()+FLYING_UNIT, la.getY());
			break;
			}
		}
	}
	

	public static void main(String[] args) {
		new FlyingTestEx();
	}

}
