package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Dialog;
import com.codename1.ui.Graphics;



public class Flag extends Fixed implements IDrawable{
	
	private int seqNum;
	private GameWorld gw;
	private boolean selected = false;
	
	public Flag(int size, Point location, int color) {
		super(size, location, color);
		
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
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
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	@Override
	public String toString() {
//		return super.toString();
		return ("Flag : loc=" + super.round()+ " "+
				super.ColorToString() + " size="+ this.getSize() +
				" seqNum="+ this.getSeqNum() 
				);
	}
	public String round() {
		return super.round();
	}
	@Override
	public void draw (Graphics g, Point pPtrRelPrnt) {
		
			g.setColor(this.getColor());
		  int px = (int) pPtrRelPrnt.getX();
		  int py = (int) pPtrRelPrnt.getY();
		  int x = (int) (this.getLocation().getX() + px)+size/2;
		  int y = (int) (this.getLocation().getY() + py)+size/2;
		  int[] xPoints = { x, (x - size), (x + size), x };
		  int[] yPoints = { (y + size), (y - size), (y - size), (y + size) };
		  int nPoints = 3;
		 
		  if(selected) {
			  g.drawPolygon(xPoints, yPoints, nPoints);
		  }
		  else {
			   g.fillPolygon(xPoints, yPoints, nPoints);
			   g.setColor(ColorUtil.BLACK);
			   g.drawString("" + this.seqNum, x-5, y-30);	  
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
			&&  pPtrRelPrnt.getY() >= (y - this.getSize()/2) && pPtrRelPrnt.getY() <= (y + this.getSize()/2)) {
			
			return true;
		}
		else {
			return false;
		}
		
	}


}
