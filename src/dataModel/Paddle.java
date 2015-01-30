package dataModel;

import gameHelper.Commons;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Rectangle;

import dataModel.Coordinate;

public class Paddle extends Coordinate implements Commons, KeyListener {

	private int xOffset;

	public int getxOffset() {
		return this.xOffset;
	}

	public void setxOffset(int offset) {
		this.xOffset = offset;
	}

	// set initial X and Y coordinate for paddle
	public Paddle() {
		this.resetPaddle();
	}
	public void resetPaddle(){
		this.setX(Commons.PADDLE_X);
		this.setY(Commons.PADDLE_Y);
		this.setxOffset(0);
	}
	// return xcordinate
	public int returnXcoordinate() {
		return this.getX();
	}

	// return Y coordinate
	public int returnYcoordinate() {
		return this.getY();
	}

	// adjust paddle coordinates as per key movement
	public void movePaddle() {
		int X = this.getX();
		int offset = this.xOffset;

		// Change y coordinate
		if (X + offset > 0
				&& X + offset < (Commons.WIDTH - Commons.PADDLE_HEIGHT)) {

			this.setX(X + offset);
		}
	}

	// Draw paddle with new coordinates after movement
	public void paint(Graphics2D peddleImage) {
		peddleImage.fillRect(this.getX(), this.getY(), Commons.PADDLE_HEIGHT,
				Commons.PADDLE_WIDTH);
	}
	public Rectangle getBounds() {
		return new Rectangle(this.getX(), this.getY(), Commons.PADDLE_HEIGHT,
				Commons.PADDLE_WIDTH);
	}

	// Do nothing when key released
	@Override
	public void keyReleased(KeyEvent e) {
		this.setxOffset(0);
	}

	// Get the values of key pressed for paddle movement
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		// Up key
		if (key == KeyEvent.VK_RIGHT)
			this.setxOffset(Commons.BRICK_MOVE_OFFSET);

		// Down key
		else if (key == KeyEvent.VK_LEFT)
			this.setxOffset(-Commons.BRICK_MOVE_OFFSET);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		//other keys do nothing for now
		
	}
	
}
