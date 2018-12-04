import java.awt.*;
import javax.swing.*;

public class Ball {
	private static final int RADIUS=20;
	int x=0;
	int y=0;
	int x_speed=1;
	int y_speed=1;
	private GameBoard game;
	Color color;
	
	public Ball(GameBoard game, Color color) {
		this.game=game;
		this.color=color;
	}
	
	public void move() {
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

}
