package dataModel;

import gameHelper.Commons;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick extends Coordinate {
	private boolean vanished;

	public boolean getVanished() {
		return this.vanished;
	}

	public void setVanished(boolean flag) {
		this.vanished = flag;
	}

	public Brick(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setHeight(Commons.BRICK_HEIGHT);
		this.setWidth(Commons.BRICK_WIDTH);

		this.setVanished(false);
	}

	public void paint(Graphics2D g) {
		int x = this.getX();
		int y = this.getY();

		g.fillRect(x, y, this.getHeight(), this.getWidth());
	}

	// return the brick is destroyed or not
	public boolean isDestroyed() {
		return this.getVanished();
	}

	// set the brick to destroy
	public void destroy() {
		this.setVanished(true);
	}

	// get the bounds of the brick
	public Rectangle getBounds() {
		return new Rectangle(this.getX(), this.getY(), Commons.BRICK_HEIGHT,
				Commons.BRICK_WIDTH);
	}
}
