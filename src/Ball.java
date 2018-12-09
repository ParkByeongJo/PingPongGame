import java.awt.*;
import javax.swing.*;

public class Ball {
	private static final int RADIUS=20;//Ź������ ������ ����(���� ���)
	int x=0;//���� ��ġ�ϴ� x��
	int y=0;//���� ��ġ�ϴ� y��
	int x_speed=1;//���� x������ �̵��ϴ� �ӵ�
	int y_speed=1;//���� y������ �̵��ϴ� �ӵ�
	private GameBoard game;//GameBoard�� ����(���� Ź���� ������ �����̱� ���� �ʿ��� ����)
	Color color;//���� ���� ���� ���� ����
	
	public Ball(GameBoard game, Color color) {//������
		this.game=game;
		this.color=color;
	}
	
	public void move() {//���� �����̵��� �ϴ� �޼ҵ�
		if(x+x_speed<0)
			x_speed=1;
		if(x+x_speed>game.getWidth()-2 * RADIUS)
			x_speed=-1;
		if(y+y_speed<0)
			y_speed=1;
		if(y+y_speed>game.getHeight()-2 * RADIUS)
			y_speed=-1;
		x=x+x_speed;
		y=y+y_speed;
	}
	
	public void draw(Graphics2D g) {//Ź������ Ź���뿡 �׷��ִ� �޼ҵ�
		g.setColor(color);
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
	}

}
