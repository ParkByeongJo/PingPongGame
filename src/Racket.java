import java.awt.*;
import javax.swing.*;

public class Racket {
	private static final int WIDTH=10;
	private static final int HEIGHT=80;
	int x=0;
	int y=0;
	int x_speed=0;
	int y_speed=0;
	private GameBoard game;
	Color color;
	
	public Racket(GameBoard game, int x, int y, Color color) {
		this.game=game;
		this.x=x;
		this.y=y;
		this.color=color;
	}

	public void move() {
		if(y+y_speed > 0 && y+y_speed < game.getHeight() - HEIGHT)
			y+=y_speed;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
}
