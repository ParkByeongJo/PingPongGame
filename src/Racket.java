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

}
