import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class GameBoard extends JPanel implements KeyListener {//탁구대 클래스(화면 창이므로 JPanel클래스를 상속받고 KeyListener인터페이스를 구현함)
	
	Ball ball;//탁구공
	Racket racket1;//라켓1
	Racket racket2;//라켓2
	
	public GameBoard() {//생성자
		ball=new Ball(this, Color.red);//탁구대 위에 빨간색의 탁구공 생성
		this.setBackground(Color.green);//탁구대 색을 초록색으로 설정
		racket1=new Racket(this, 10, 150, Color.blue);//(10, 150)의 위치에 파란색 라켓1을 생성
		racket2=new Racket(this, 560, 150, Color.yellow);//(560, 150)의 위치에 노란색 라켓1을 생성
		this.setFocusable(true);
		this.addKeyListener(this);
	}

	private void move() {//공과 라켓을 이동시켜주는 메소드
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
	public void keyPressed(KeyEvent e) {//키보드를 눌렀을 때 각 라켓들의 움직임을 호출
		racket1.keyPressed(e);
		racket2.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {//키보드가 눌리면 라켓에 이벤트 전달해줌
		racket1.keyReleased(e);
		racket2.keyReleased(e);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
		}
		
	}

}
