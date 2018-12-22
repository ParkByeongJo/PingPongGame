package PingPongGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")

public class GameBoard extends JPanel implements MouseMotionListener {//Ź���� Ŭ����(ȭ�� â�̹Ƿ� JPanelŬ������ ��ӹް� KeyListener�������̽��� ������)
	
	Ball ball;//Ź����
	Racket racket1;//����1
	Racket racket2;//����2
	int player_score=0;//�÷��̾� ����
	int computer_score=0;//��ǻ�� ����
	
	public GameBoard() {//������
		ball=new Ball(this, Color.red);//Ź���� ���� �������� Ź���� ����
		this.setBackground(Color.green);//Ź���� ���� �ʷϻ����� ����
		racket1=new Racket(this, 10, 150, Color.blue);//(10, 150)�� ��ġ�� �Ķ��� ����1�� ����
		racket2=new Racket(this, 560, 150, Color.yellow);//(560, 150)�� ��ġ�� ����� ����1�� ����
		this.setFocusable(true);
		this.addMouseMotionListener(this);//MouseMotionListener��� �߰�
	}

	private void move() {//���� ������ �̵������ִ� �޼ҵ�
		ball.move();
		racket1.move("�÷��̾�");
		racket2.move("��ǻ��");
	}
	
	private void judgment() {//���� �̰���� ������ִ� �޼ҵ�(20�� ����)
		if(player_score>20) {//�÷��̾ 20�� �Ѿ��� ��
			JOptionPane.showMessageDialog(this, "You Win");
		}
		if(computer_score>20) {//��ǻ�Ͱ� 20�� �Ѿ��� ��
			JOptionPane.showMessageDialog(this, "Game Over");
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);//â���� �׷��ش�.
		Graphics2D gd2=(Graphics2D)g;//Graphics�� Graphics2D�� �θ� Ŭ�����̹Ƿ� Graphics���� g�� Graphics2D������ �ٿ�ĳ����
		ball.draw(gd2);//���� �׸���.
		racket1.draw(gd2);//�÷��̾� ������ �׸���.
		racket2.draw(gd2);//��ǻ�� ������ �׸���.
		g.setColor(Color.BLACK);//������ �˷��ִ� ���ڸ� ǥ��
		gd2.drawString(("�÷��̾�:"+player_score+"��ǻ��:"+computer_score), 250, 10);//���� ǥ��
	}

	@Override
	public void mouseDragged(MouseEvent e) {//�÷��̾� ������ ���콺�� �巡�����ش�.
		racket1.MouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {//�÷��̾� ������ ���콺�� �������ش�.
		racket1.MouseMoved(e);
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
			game.judgment();//���� 20���� �Ѱ���� �޽����� �˷��ش�.
		}
	}
}
