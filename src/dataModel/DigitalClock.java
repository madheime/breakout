package dataModel;

import java.util.Calendar;
import java.awt.Graphics2D;

import observerModel.Observer;

public class DigitalClock implements Observer {

	private Calendar currentTime;
	private int currentHour;
	private int currentMinute;
	private int currentSecond;
	String storedTime;
	public boolean isStart = true;

	public Calendar getcurrentTime() {
		return this.currentTime;
	}

	public int getcurrentHour() {
		return this.currentHour;
	}

	public int getcurrentMinute() {
		return this.currentMinute;
	}

	public int getcurrentSecond() {
		return this.currentSecond;
	}

	public String getstoredTime() {
		return this.storedTime;
	}

	public boolean getisStart() {
		return this.isStart;
	}

	public void setcurrentTime(Calendar currTime) {
		this.currentTime = currTime;
	}

	public void setcurrentHour(int hr) {
		this.currentHour = hr;
	}

	public void setcurrentMinute(int min) {
		this.currentMinute = min;
	}

	public void setcurrentSecond(int sec) {
		this.currentSecond = sec;
	}

	public void setstoredTime(String storedTme) {
		this.storedTime = storedTme;
	}

	public void setisStart(boolean flag) {
		this.isStart = flag;
	}

	public void displayClock(Graphics2D gameImage) {
		String displayTime;

		// currentTime = Calendar.getInstance();
		setcurrentTime(Calendar.getInstance());

		Calendar currTime = this.getcurrentTime();

		this.setcurrentHour(currTime.get(Calendar.HOUR_OF_DAY));
		this.setcurrentMinute(currTime.get(Calendar.MINUTE));
		this.setcurrentSecond(currTime.get(Calendar.SECOND));

		if (this.getcurrentHour() < 10)
			displayTime = "0" + currentHour + ":";
		else
			displayTime = currentHour + ":";

		if (this.getcurrentMinute() < 10)
			displayTime = displayTime + "0" + currentMinute + ":";
		else
			displayTime = displayTime + currentMinute + ":";

		if (this.getcurrentSecond() < 10)
			displayTime = displayTime + "0" + currentSecond;
		else
			displayTime = displayTime + currentSecond;

		if (this.getisStart() == true)
			this.setstoredTime(displayTime);

		gameImage.drawString(this.getstoredTime(), 530, 20);
	}
	
	public void update(){
		this.isStart = false;
	}

}
