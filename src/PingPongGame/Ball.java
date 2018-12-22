package PingPongGame;
import java.awt.*;

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
	
	void move() {//���� �����̵��� �ϴ� �޼ҵ�
		if(x+x_speed<0) {//���� ���� �ε�������
			x_speed=3;//������ �� ���� x������ �̵��ϴ� �ӵ�
			/*���� �߾ӿ� ��ġ��Ŵ*/
			x=600/2-RADIUS;
			y=400/2-RADIUS;
			game.computer_score++;//��ǻ���� ���� ����
		}
		if(x+x_speed> 600-2 * RADIUS) {//������ ���� �ε�������
			x_speed=-3;//������ �� ���� x������ �̵��ϴ� �ӵ�
			/*���� �߾ӿ� ��ġ��Ŵ*/
			x=600/2-RADIUS;
			y=400/2-RADIUS;
			game.player_score++;//�÷��̾��� ���� ����
		}
		if(y+y_speed<0)//�Ʒ��� ���� �ε�������
			y_speed=3;//������ �� ���� y������ �̵��ϴ� �ӵ�
		if(y+y_speed>game.getHeight()-2 * RADIUS)//���� ���� �ε�������
			y_speed=-3;//������ �� ���� y������ �̵��ϴ� �ӵ�
		if(collision()) {//���ϰ� ���� �浹�Ͽ��� ��
			x_speed=-x_speed;//�ݴ�������� �����̰� �Ѵ�.
		}
		x=x+x_speed;//x������ �̵�
		y=y+y_speed;//y������ �̵�
	}
	
	public void draw(Graphics2D g) {//Ź������ Ź���뿡 �׷��ִ� �޼ҵ�
		g.setColor(color);
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
	}
	
	public Rectangle getBounds() {//Ź���� ���� �޼ҵ�
		return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
	}
	
	private boolean collision() {//���ϰ� ���� �浹�Ͽ����� Ȯ�����ִ� �޼ҵ�
		return game.racket1.getBounds().intersects(getBounds())
				|| game.racket2.getBounds().intersects(getBounds());
	}

}
