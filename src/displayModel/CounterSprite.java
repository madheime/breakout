package displayModel;

import gameHelper.Commons;

import java.util.Calendar;
import java.awt.Graphics2D;

import dataModel.Counter;
import observerModel.Observer;

public class CounterSprite implements Observer {


//	private int currentHour;
	private int currentMinute;
	private int currentSecond;
	String storedTime;
	public boolean isStart = true;

	public CounterSprite() {
		this.setcurrentSecond(0);
		this.setcurrentMinute(0);
	}
	

//	public int getcurrentHour() {
//		return this.currentHour;
//	}


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


//	public void setcurrentHour(int hr) {
//		this.currentHour = hr;
//	}

	
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

	public void update(Graphics2D gameImage, int second, int minute) {
//		this.setcurrentHour(currTime.get(Calendar.HOUR_OF_DAY));
		this.setcurrentMinute(minute);
		this.setcurrentSecond(second);
		
		String displayTime;



//		if (this.getcurrentHour() < 10)
//			displayTime = "0" + currentHour + ":";
//		else
//			displayTime = currentHour + ":";

		if (this.getcurrentMinute() < 10)
			displayTime = "0" + currentMinute + ":";
		else
			displayTime = currentMinute + ":";

		if (this.getcurrentSecond() < 10)
			displayTime = displayTime + "0" + currentSecond;
		else
			displayTime = displayTime + currentSecond;

		if (this.getisStart() == true)
			this.setstoredTime(displayTime);
		
		this.displayCounter(gameImage);
	}
	
	private void displayCounter(Graphics2D gameImage) {
		
		gameImage.drawString(this.getstoredTime(), 490, 20);
	}
	
	public void update(){
		this.isStart = false;
	}

}