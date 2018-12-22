package PingPongGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")

public class GameBoard extends JPanel implements MouseMotionListener {//탁구대 클래스(화면 창이므로 JPanel클래스를 상속받고 KeyListener인터페이스를 구현함)
	
	Ball ball;//탁구공
	Racket racket1;//라켓1
	Racket racket2;//라켓2
	int player_score=0;//플레이어 점수
	int computer_score=0;//컴퓨터 점수
	
	public GameBoard() {//생성자
		ball=new Ball(this, Color.red);//탁구대 위에 빨간색의 탁구공 생성
		this.setBackground(Color.green);//탁구대 색을 초록색으로 설정
		racket1=new Racket(this, 10, 150, Color.blue);//(10, 150)의 위치에 파란색 라켓1을 생성
		racket2=new Racket(this, 560, 150, Color.yellow);//(560, 150)의 위치에 노란색 라켓1을 생성
		this.setFocusable(true);
		this.addMouseMotionListener(this);//MouseMotionListener기능 추가
	}

	private void move() {//공과 라켓을 이동시켜주는 메소드
		ball.move();
		racket1.move("플레이어");
		racket2.move("컴퓨터");
	}
	
	private void judgment() {//누가 이겼는지 출력해주는 메소드(20점 내기)
		if(player_score>20) {//플레이어가 20점 넘었을 때
			JOptionPane.showMessageDialog(this, "You Win");
		}
		if(computer_score>20) {//컴퓨터가 20점 넘었을 때
			JOptionPane.showMessageDialog(this, "Game Over");
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);//창에다 그려준다.
		Graphics2D gd2=(Graphics2D)g;//Graphics가 Graphics2D의 부모 클래스이므로 Graphics변수 g를 Graphics2D형으로 다운캐스팅
		ball.draw(gd2);//공을 그린다.
		racket1.draw(gd2);//플레이어 라켓을 그린다.
		racket2.draw(gd2);//컴퓨터 라켓을 그린다.
		g.setColor(Color.BLACK);//점수를 알려주는 글자를 표시
		gd2.drawString(("플레이어:"+player_score+"컴퓨터:"+computer_score), 250, 10);//점수 표시
	}

	@Override
	public void mouseDragged(MouseEvent e) {//플레이어 라켓을 마우스로 드래그해준다.
		racket1.MouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {//플레이어 라켓을 마우스로 움직여준다.
		racket1.MouseMoved(e);
	}
	
	public static void main(String[] args) {
		JFrame f=new JFrame("Ping-Pong GAME");//탁구 게임 창 생성
		f.setSize(600, 400);//창 사이즈 설정
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameBoard game=new GameBoard();//탁구 게임판 생성
		f.add(game);//창에 탁구 게임판 생성시킴
		
		while(true) {//루프문을 이용하여 공과 라켓을 이동시키고 탁구대 화면을 다시 그려준다.
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {//오류 처리
				e.printStackTrace();
			}
			game.judgment();//누가 20점을 넘겼는지 메시지로 알려준다.
		}
	}
}
