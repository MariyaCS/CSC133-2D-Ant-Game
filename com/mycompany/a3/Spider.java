package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;

public class Spider extends Movable implements IDrawable{

	// constructor Spider sets size, location, color, heading and speed of the spiders. 
	public Spider(int size, Point location, int color, int heading, int speed) {
		super(size, location, color, heading, speed);
		
	}
	public int getSize() {
		return size;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		
	}
	
	public int getHeading() {
		return super.getHeading();
	}
	public void setHeading(int heading) {
		super.heading = heading;
	}
	public int getSpeed() {
		return super.getSpeed();
	}
	public void setSpeed(int speed) {
		super.speed = speed;
	}
	
	// move() method updates location of the spiders based of heading and speed. 
	public void move(int elapsedMilliSecs, Dimension dCmpSize) {
		
		float oldX = location.getX();
		float oldY = location.getY();
		float dist = speed*(elapsedMilliSecs/1000);
		float deltaX = (float) (Math.cos(Math.toRadians(90 - heading))*dist);
		float deltaY = (float) (Math.sin(Math.toRadians(90 - heading))*dist);
		
		float newX = oldX+deltaX;
		float newY = oldY+deltaY;

		
		if((newX + size/2 >= dCmpSize.getWidth()) || newX-size/2 < 0) {
			newX = -newX;
		}
		if((newY+size/2 >= dCmpSize.getHeight()) || newY-size/2< 0){
			newY = -newY;
		
		}
		Point newLocation = new Point(newX, newY);
		location = newLocation;	
		
	}
	public String toString() {
//		return super.toString();
		return ("Spider : loc=" + super.round()+ " "+
				super.ColorToString() + " heading="+ this.getHeading() +
				" speed="+ this.getSpeed() + " size="+ this.getSize()
				);
	}
	@Override
	public void draw(Graphics g, Point pPtrRelPrnt) {
		  g.setColor(this.getColor());
		  int px = (int) pPtrRelPrnt.getX();
		  int py = (int) pPtrRelPrnt.getY();
		  int x = (int) (this.getLocation().getX() + px)+size/2;
		  int y = (int) (this.getLocation().getY() + py)+size/2;
		  int[] xPoints = { x, (x - size), (x + size), x };
		  int[] yPoints = { (y + size), (y - size), (y - size), (y + size) };
		  int nPoints = 3;
		 
		  g.drawPolygon(xPoints, yPoints, nPoints);
		
	}

}
