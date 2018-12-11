import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

	private void move() {//���� ������ �̵������ִ� �޼ҵ�
		ball.move();
		racket1.move();
		racket2.move();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gd2=(Graphics2D)g;
		ball.draw(gd2);
		racket1.draw(gd2);
		racket2.draw(gd2);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {//Ű���带 ������ �� �� ���ϵ��� �������� ȣ��
		racket1.keyPressed(e);
		racket2.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {//Ű���尡 ������ ���Ͽ� �̺�Ʈ ��������
		racket1.keyReleased(e);
		racket2.keyReleased(e);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		JFrame f=new JFrame("Ping-Pong GAME");//Ź�� ���� â ����
		f.setSize(600, 400);//â ������ ����
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameBoard game=new GameBoard();//Ź�� ������ ����
		f.add(game);//â�� Ź�� ������ ������Ŵ
		
		while(true) {//�������� �̿��Ͽ� ���� ������ �̵���Ű�� Ź���� ȭ���� �ٽ� �׷��ش�.
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {//���� ó��
				e.printStackTrace();
			}
		}
		
	}

}
