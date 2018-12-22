package PingPongGame;
import java.awt.*;

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
	
	void move() {//공을 움직이도록 하는 메소드
		if(x+x_speed<0) {//왼쪽 벽에 부딪쳤을때
			x_speed=3;//움직일 때 공이 x축으로 이동하는 속도
			/*공을 중앙에 위치시킴*/
			x=600/2-RADIUS;
			y=400/2-RADIUS;
			game.computer_score++;//컴퓨터의 점수 증가
		}
		if(x+x_speed> 600-2 * RADIUS) {//오른쪽 벽에 부딪쳤을때
			x_speed=-3;//움직일 때 공이 x축으로 이동하는 속도
			/*공을 중앙에 위치시킴*/
			x=600/2-RADIUS;
			y=400/2-RADIUS;
			game.player_score++;//플레이어의 점수 증가
		}
		if(y+y_speed<0)//아랫쪽 벽에 부딪쳤을때
			y_speed=3;//움직일 때 공이 y축으로 이동하는 속도
		if(y+y_speed>game.getHeight()-2 * RADIUS)//위쪽 벽에 부딪쳤을때
			y_speed=-3;//움직일 때 공이 y축으로 이동하는 속도
		if(collision()) {//라켓과 공이 충돌하였을 시
			x_speed=-x_speed;//반대방향으로 움직이게 한다.
		}
		x=x+x_speed;//x축으로 이동
		y=y+y_speed;//y축으로 이동
	}
	
	public void draw(Graphics2D g) {//탁구공을 탁구대에 그려주는 메소드
		g.setColor(color);
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
	}
	
	public Rectangle getBounds() {//탁구공 생성 메소드
		return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
	}
	
	private boolean collision() {//라켓과 공이 충돌하였는지 확인해주는 메소드
		return game.racket1.getBounds().intersects(getBounds())
				|| game.racket2.getBounds().intersects(getBounds());
	}

}
