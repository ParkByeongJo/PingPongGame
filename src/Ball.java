import java.awt.*;
import javax.swing.*;

public class Ball {
	private static final int RADIUS=20;//탁구공의 반지름 설정(전역 상수)
	int x=0;//공이 위치하는 x축
	int y=0;//공이 위치하는 y축
	int x_speed=1;//공이 x축으로 이동하는 속도
	int y_speed=1;//공이 y축으로 이동하는 속도
	private GameBoard game;//GameBoard형 변수(공이 탁구대 위에서 움직이기 위해 필요한 변수)
	Color color;//공의 색깔 설정 위한 변수
	
	public Ball(GameBoard game, Color color) {//생성자
		this.game=game;
		this.color=color;
	}
	
	public void move() {//공을 움직이도록 하는 메소드
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
	
	public void draw(Graphics2D g) {//탁구공을 탁구대에 그려주는 메소드
		g.setColor(color);
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
	}

}
