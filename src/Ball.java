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

}
