package com.mycompany.a3;



import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;


public class FoodStation extends Fixed implements IDrawable {
	
	private int capacity = size;
	private GameWorld gw;
	private boolean selected = false;

	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public FoodStation(int size, Point location, int color) {
		

		super(size, location, color);
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String toString() {
//		return super.toString();
		return ("Food Station : loc=" + super.round()+ " "+
				super.ColorToString() + " size="+ this.getSize() +" capacity="+ this.getCapacity()
				);
	}

	@Override
	public void draw(Graphics g, Point pPtrRelPrnt) {
		 
		int px = (int) pPtrRelPrnt.getX();
		int py = (int) pPtrRelPrnt.getY();
		int x = (int) (this.getLocation().getX() + px)+size/2;
		int y = (int) (this.getLocation().getY() + py)+size/2;
		 if(selected) {
			 g.drawRect(x, y, this.getSize(), this.getSize());
		  }
		 else {
			 g.setColor(this.getColor());
			 g.fillRect(x, y, this.getSize(), this.getSize());
			 g.setColor(ColorUtil.BLACK);
			 g.drawString("" + this.capacity, x, y);
		 }
		
	}
	@Override
	public void setSelected(boolean b) {
		selected = b;
		
	}
	@Override
	public boolean isSelected() {
		return selected;
	}
	@Override
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int x = (int) (this.getLocation().getX() + pCmpRelPrnt.getX());
		int y = (int) (this.getLocation().getY() + pCmpRelPrnt.getY());
		
		if(pPtrRelPrnt.getX() >= (x - this.getSize()/2) &&  pPtrRelPrnt.getX() <= (x + this.getSize()/2)
				&&  pPtrRelPrnt.getY() >= (y - (this.getSize()/2)) && pPtrRelPrnt.getY() <= (y + (this.getSize()/2))) {
				
				return true;
		}
		else {
				return false;
		}
	}


	
	
}
