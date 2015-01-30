package gameHelper;

import java.util.LinkedList;
import java.util.Stack;

import commandModel.Command;
import dataModel.Ball;

public class Replay implements Command{
	private Ball ball;//target
	//private int samelocatonX, samelocationY;
	
	//store all collision and essential events
	private LinkedList replay;
	
	public void Move(Ball ball){
		this.ball = ball;
	}

	@Override
	public void Do() {
		//same appropriate variabables
				//acturally move the ball
		
	}

	@Override
	public void unDo() {
		//reinstate same variables
				//unmove the ball
	}
}
