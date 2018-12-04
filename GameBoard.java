import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class GameBoard extends JPanel implements KeyListener {
	
	Ball ball;
	Racket racket1;
	Racket racket2;
	
	public GameBoard() {
		ball=new Ball(this, Color.red);
		this.setBackground(Color.green);
		racket1=new Racket(this, 10, 150, Color.orange);
		racket2=new Racket(this, 560, 150, Color.pink);
		this.setFocusable(true);
		this.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		JFrame f=new JFrame("Ping-Pong ∞‘¿”");
		f.setSize(600, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameBoard game=new GameBoard();
		f.add(game);

	}

}
