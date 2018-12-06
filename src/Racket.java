import java.awt.*;
import javax.swing.*;

public class Racket {
	private static final int WIDTH=10;//라켓의 가로를 나타내는 전역상수
	private static final int HEIGHT=80;//라켓의 세로를 나타내는 전역상수
	int x=0;//라켓의 x축 위치
	int y=0;//라켓의 y축 위치
	int x_speed=0;//라켓이 x축으로 이동하는 속도
	int y_speed=0;//라켓이 y축으로 이동하는 속도
	private GameBoard game;//GameBoard형 변수(라켓이 탁구대 위에서 움직이기 위해 필요한 변수)
	Color color;//라켓의 색깔을 나타내기 위한 변수
	
	public Racket(GameBoard game, int x, int y, Color color) {//생성자
		this.game=game;
		this.x=x;
		this.y=y;
		this.color=color;
	}

	public void move() {//라켓을 움직이게 하는 메소드
		if(y+y_speed > 0 && y+y_speed < game.getHeight() - HEIGHT)
			y+=y_speed;
	}
	
	public void draw(Graphics2D g) {//라켓을 그려주는 메소드
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
}
