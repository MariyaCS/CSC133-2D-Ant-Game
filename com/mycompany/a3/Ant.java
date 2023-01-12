package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Ant extends Movable implements ISteerable, IDrawable{

	private  int heading;
	private  int speed;
	private static Ant ant;
	private int foodConsumptionRate=1;
	private int lastFlagReached=1;
	private int maximumSpeed=100;
	private int healthLevel=10;
	private int foodLevel=100;
	
	
 //Constructor Ant() sets size, location, color, heading and speed of the object (ant).
	public Ant(int size, Point location, int color, int heading, int speed) {
		super(size, location, color, heading, speed);
	}
	
	private Ant() {
		super();
	}
	
	public static Ant getAnt() {
		if(ant == null) 
			ant = new Ant();
			
		return ant;
	}
	
	
	public int getSize() {
		return size;
	}
	
	public int getHeading() {
		return heading;
	}
	public void setHeading(int heading) {
		this.heading = heading;
	}
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}																						
	
	
	public int getFoodConsumptionRate() {
		return foodConsumptionRate;
	}
	public void setFoodConsumptionRate(int foodConsumptionRate) {
		this.foodConsumptionRate = foodConsumptionRate;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMaximumSpeed() {
		return maximumSpeed;
	}
	public void setMaximumSpeed(int maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}
	public int getFoodLevel() {
		return foodLevel;
	}
	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}
	public int getHealthLevel() {
		return healthLevel;
	}
	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}
	public int getLastFlagReached() {
		return lastFlagReached;
	}
	public void setLastFlagReached(int lastFlagReached) {
		this.lastFlagReached = lastFlagReached;
	}
	//move() causes the ant to update its location based on its current heading and speed
	public void move(int elapsedMilliSecs) {
		
		if(foodLevel>0 && healthLevel>0) {
			super.move(elapsedMilliSecs);
		}	
	}
	//accelerate() updates object's speed based on its current health level and food level
	public void accelerate() {
		if((this.healthLevel==0) ||(this.foodLevel==0)) {
			super.setSpeed(0);
		}
		else if((this.healthLevel<10) && (this.healthLevel>0)) {
			super.setSpeed(this.maximumSpeed*this.healthLevel/10);
		}
		else{
			super.setSpeed(this.maximumSpeed);
		}
	}
	
	// decelerate() decreases object's speed by one when brake command is applied
	public void decelerate() {
		
		if(this.speed>0) {
			super.setSpeed(this.speed - 10);
			//this.speed = this.speed-10;
		}
	}
	public int decreaseFoodLvl() {
		
		int newFoodLvl=this.foodLevel-this.foodConsumptionRate; 
		if(newFoodLvl>=0) {
			this.setFoodLevel(newFoodLvl);
		}
		return newFoodLvl;
	}
	
	// changeHeading() changes heading of the ant by 5 degrees to the left or to the right. It accepts char parameter and if parameter is 'l' 
	// the heading is changed to the left, if parameter is 'r' the heading is changed to the right. 
	public void changeHeadingLeft() {
		
			super.heading=super.heading-10;
	}
	
	public void changeHeadingRight() {	

		super.heading=super.heading+10;
	}
	
	@Override 
	public String toString() {
		return ("Ant : loc=" + super.round()+ " "+
				super.ColorToString() + " heading="+ this.getHeading() +
				" speed="+ this.getSpeed() + " size="+ this.getSize()+
				" maxSpeed="+this.getMaximumSpeed()+
				" foodConsumptionRate="+ this.getFoodConsumptionRate()+
				" Food level " + this.getFoodLevel()
				);

	}

	@Override
	public void draw(Graphics g, Point pPtrRelPrnt) {
		  g.setColor(this.getColor());
		  int px = (int) pPtrRelPrnt.getX();
		  int py = (int) pPtrRelPrnt.getY();
		  int x = (int) (this.getLocation().getX() + px) + size/2;
		  int y = (int) (this.getLocation().getY() + py) + size/2;

	        g.setColor(this.getColor());
	        g.fillArc(x, y, this.size, this.size, 360, 360);

	}
	
}
