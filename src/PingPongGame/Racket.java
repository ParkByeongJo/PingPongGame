package PingPongGame;
import java.awt.*;
import java.awt.event.*;

public class Racket {
	private static final int WIDTH=13;//라켓의 가로를 나타내는 전역상수
	private static final int HEIGHT=85;//라켓의 세로를 나타내는 전역상수
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

	public void move(String s) {//각자의 라켓을 움직이게 하는 메소드
		if(s.equals("플레이어")) {//플레이어 라켓
			if(y+y_speed > 0 && y+y_speed < game.getHeight() - HEIGHT) {//라켓이 위아래로 부딪칠때
				y+=y_speed;//라켓이 움직인다.
			}
		}
		if(s.equals("컴퓨터")) {//컴퓨터 라켓
			if(y+y_speed<0) {//라켓이 아랫쪽에 부딪칠때
				y_speed=2;//라켓 속도
			}
			if(y+y_speed > game.getHeight() - HEIGHT) {//라켓이 위쪽에 부딪칠때
				y_speed=-2;//라켓 속도
			}
		}
		y+=y_speed;//y축으로 이동
	}
	
	public void draw(Graphics2D g) {//라켓을 그려주는 메소드
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void MouseDragged(MouseEvent e) {//마우스를 드래그할 때 플레이어 라켓이 위아래로 움직이게하는 메소드
		y=e.getY();
	}
	
	public void MouseMoved(MouseEvent e) {//마우스를 움직일 때 플레이어 라켓이 위아래로 움직이게하는 메소드
		y=e.getY();
	}
	
	public Rectangle getBounds() {//라켓을 그려주는 메소드
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}
