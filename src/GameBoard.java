import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class GameBoard extends JPanel implements KeyListener {//Ź���� Ŭ����(ȭ�� â�̹Ƿ� JPanelŬ������ ��ӹް� KeyListener�������̽��� ������)
	
	Ball ball;//Ź����
	Racket racket1;//����1
	Racket racket2;//����2
	
	public GameBoard() {//������
		ball=new Ball(this, Color.red);//Ź���� ���� �������� Ź���� ����
		this.setBackground(Color.green);//Ź���� ���� �ʷϻ����� ����
		racket1=new Racket(this, 10, 150, Color.blue);//(10, 150)�� ��ġ�� �Ķ��� ����1�� ����
		racket2=new Racket(this, 560, 150, Color.yellow);//(560, 150)�� ��ġ�� ����� ����1�� ����
		this.setFocusable(true);
		this.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
