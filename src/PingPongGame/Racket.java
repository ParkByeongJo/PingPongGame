package PingPongGame;
import java.awt.*;
import java.awt.event.*;

public class Racket {
	private static final int WIDTH=13;//������ ���θ� ��Ÿ���� �������
	private static final int HEIGHT=85;//������ ���θ� ��Ÿ���� �������
	int x=0;//������ x�� ��ġ
	int y=0;//������ y�� ��ġ
	int x_speed=0;//������ x������ �̵��ϴ� �ӵ�
	int y_speed=0;//������ y������ �̵��ϴ� �ӵ�
	private GameBoard game;//GameBoard�� ����(������ Ź���� ������ �����̱� ���� �ʿ��� ����)
	Color color;//������ ������ ��Ÿ���� ���� ����
	
	public Racket(GameBoard game, int x, int y, Color color) {//������
		this.game=game;
		this.x=x;
		this.y=y;
		this.color=color;
	}

	public void move(String s) {//������ ������ �����̰� �ϴ� �޼ҵ�
		if(s.equals("�÷��̾�")) {//�÷��̾� ����
			if(y+y_speed > 0 && y+y_speed < game.getHeight() - HEIGHT) {//������ ���Ʒ��� �ε�ĥ��
				y+=y_speed;//������ �����δ�.
			}
		}
		if(s.equals("��ǻ��")) {//��ǻ�� ����
			if(y+y_speed<0) {//������ �Ʒ��ʿ� �ε�ĥ��
				y_speed=2;//���� �ӵ�
			}
			if(y+y_speed > game.getHeight() - HEIGHT) {//������ ���ʿ� �ε�ĥ��
				y_speed=-2;//���� �ӵ�
			}
		}
		y+=y_speed;//y������ �̵�
	}
	
	public void draw(Graphics2D g) {//������ �׷��ִ� �޼ҵ�
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void MouseDragged(MouseEvent e) {//���콺�� �巡���� �� �÷��̾� ������ ���Ʒ��� �����̰��ϴ� �޼ҵ�
		y=e.getY();
	}
	
	public void MouseMoved(MouseEvent e) {//���콺�� ������ �� �÷��̾� ������ ���Ʒ��� �����̰��ϴ� �޼ҵ�
		y=e.getY();
	}
	
	public Rectangle getBounds() {//������ �׷��ִ� �޼ҵ�
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}
