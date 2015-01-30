package dataModel;

import gameHelper.Commons;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;

import observerModel.Observable;
import observerModel.Observer;

public class Ball extends Coordinate implements Commons, Observable {
	private int xDirection = 1;
	private int yDirection = -1;

	public Ball() {
		this.setWidth(Commons.BALL_DIAMETER);
		this.setHeight(Commons.BALL_DIAMETER);

		resetState();
	}

	public void paint(Graphics2D g) {
		int x = this.getX();
		int y = this.getY();

		g.fillOval(x, y, this.getHeight(), this.getWidth());
	}

	// move the ball
	public void move() {
		int x = this.getX();
		int y = this.getY();
		x += this.getxDirection();
		y += this.getyDirection();

		if (x == 0) {
			this.setDirectionX(1);
		}

		if (x == BALL_RIGHT) {
			this.setDirectionX(-1);
		}

		if (y == 0) {
			this.setDirectionY(1);
		}
		this.setX(x);
		this.setY(y);
	}

	// check the collision with paddle
	public void collisionPaddle(Paddle paddle) {
		if ((this.getBounds()).intersects(paddle.getBounds())) {

			int paddleLPos = (int) paddle.getBounds().getMinX();
			int thisLPos = (int) this.getBounds().getMinX();

			int first = paddleLPos + 8;
			int second = paddleLPos + 16;
			int third = paddleLPos + 24;
			int fourth = paddleLPos + 32;

			if (thisLPos < first) {
				this.setDirectionX(-1);
				this.setDirectionY(-1);
			}

			if (thisLPos >= first && thisLPos < second) {
				this.setDirectionX(-1);
				this.setDirectionY(-1 * this.getyDirection());
			}

			if (thisLPos >= second && thisLPos < third) {
				this.setDirectionX(0);
				this.setDirectionY(-1);
			}

			if (thisLPos >= third && thisLPos < fourth) {
				this.setDirectionX(1);
				this.setDirectionY(-1 * this.getyDirection());
			}

			if (thisLPos > fourth) {
				this.setDirectionX(1);
				this.setDirectionY(-1);
			}
		}
	}

	// check the collision with brick
	public void collisionBrick(Brick brick) {
		if ((this.getBounds()).intersects(brick.getBounds())) {

			int thisLeft = (int) this.getBounds().getMinX();
			int thisHeight = (int) this.getBounds().getHeight();
			int thisWidth = (int) this.getBounds().getWidth();
			int thisTop = (int) this.getBounds().getMinY();

			Point pointRight = new Point(thisLeft + thisWidth + 1, thisTop);
			Point pointLeft = new Point(thisLeft - 1, thisTop);
			Point pointTop = new Point(thisLeft, thisTop - 1);
			Point pointBottom = new Point(thisLeft, thisTop + thisHeight + 1);

			if (!brick.isDestroyed()) {
				if (brick.getBounds().contains(pointRight)) {
					this.setDirectionX(-1);
				}

				else if (brick.getBounds().contains(pointLeft)) {
					this.setDirectionX(1);
				}

				if (brick.getBounds().contains(pointTop)) {
					this.setDirectionY(1);
				}

				else if (brick.getBounds().contains(pointBottom)) {
					this.setDirectionY(-1);
				}

				brick.destroy();
			}
		}
	}

	public int getxDirection() {
		return this.xDirection;
	}

	public int getyDirection() {
		return this.yDirection;
	}

	public void setDirectionX(int x) {
		this.xDirection = x;
	}

	public void setDirectionY(int y) {
		this.yDirection = y;
	}

	// set the original position of th ball
	public void resetState() {
		this.setX(250);
		this.setY(470);
	}

	// get the bounds of the ball
	public Rectangle getBounds() {
		return new Rectangle(this.getX(), this.getY(), Commons.BALL_DIAMETER,
				Commons.BALL_DIAMETER);
	}

	@Override
	public void register(Observer obsvr) {
		obsvrCollection.add(obsvr);

	}

	@Override
	public void deRegister(Observer obsvr) {
		obsvrCollection.remove(obsvr);

	}

	public void notifyObservers() {
		// TODO: make call to stop the clock here.
		Iterator<Observer> itr = obsvrCollection.iterator();
		while (itr.hasNext()) {
			Observer obj = itr.next();
			if (obj instanceof DigitalClock) {
				((DigitalClock) obj).update();
			}
		}

	}
}
