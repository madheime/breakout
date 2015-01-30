package dataModel;

public class Coordinate {
	// coordinate
	private int x;
	private int y;
	private int width;
	private int height;

	public Coordinate() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return this.width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return this.height;
	}
}
