package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class Movable extends GameObject{
	
	protected int heading;
	protected int speed;
	
	// Constructor Movable() sets size, location, color, heading and speed of objects.
	public Movable(int size, Point location, int color, int heading, int speed) {
		super(size, location, color);
		this.heading = heading;
		this.speed = speed;
		
	}
	protected Movable() {
		super();
	}

	public int getHeading() {
		return heading;
	}

	public void setHeading(int heading) {
		this.heading = heading;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	// toString() method converts color of the objects to specific text format. 
	@Override
	public String ColorToString() {
		String myDesc = "color=" + "[" + ColorUtil.red(this.getColor()) + ","
				+ ColorUtil.green(this.getColor()) + ","
				+ ColorUtil.blue(this.getColor()) + "]";
		
		return myDesc;
	}
//	 round() method rounds numbers to 1 decimal point
	public String round() {
		double roundLocX = Math.round(this.getLocation().getX()*10.0)/10.0;
		double roundLocY = Math.round(this.getLocation().getY()*10.0)/10.0;
		String roundNum = roundLocX + ", " + roundLocY;
		return roundNum;
	}
	public void move(int elapsedMilliSecs) {
		
			float oldX = location.getX();
			float oldY = location.getY();
			
			float dist = speed*(elapsedMilliSecs/1000);
			float deltaX = (float) (Math.cos(Math.toRadians(90 - heading))*dist);
			float deltaY = (float) (Math.sin(Math.toRadians(90 - heading))*dist);
			Point newLocation = new Point(deltaX+oldX, deltaY+oldY);
			
			location = newLocation;	
	}


	
}
