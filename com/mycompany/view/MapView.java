package com.mycompany.view;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a3.Fixed;
import com.mycompany.a3.Flag;
import com.mycompany.a3.FoodStation;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.IDrawable;
import com.mycompany.a3.IIterator;


public class MapView extends Container implements Observer{
	
	private GameWorld gw;
	
	//sets style of the map view container. 
	public MapView() {
	
        setLayout(new BorderLayout());
		getAllStyles().setBgTransparency(255);
		getAllStyles().setBgColor(ColorUtil.WHITE);
		getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.MAGENTA));

	}

	
	//outputs the map of the game in the console window. This method is invoked when Observable(GameWorld) map has changed.
	@Override
	public void update(Observable observable, Object data) {
		gw = (GameWorld) observable;
		gw.showMap();
		this.repaint();
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		IIterator gameCollection = gw.getIterator();
		Point pCmpRelPrnt = new Point(getX(), getY());
		while(gameCollection.hasNext()) {
			GameObject gameObj = gameCollection.getNext();
			if(gameObj instanceof IDrawable) {
				((IDrawable) gameObj).draw(g, pCmpRelPrnt);
			}
			
		}
		
	 }
	
	public void pointerPressed(int x, int y) {
		
		 x = x - getParent().getAbsoluteX();
		 y = y - getParent().getAbsoluteY();
		
		if(gw.getPositionPressed()) {
			
			IIterator itr = gw.getIterator();
			
			while(itr.hasNext()) {
				GameObject currObj = itr.getNext();
					if(currObj instanceof Flag) {
						if(((Flag)currObj).isSelected()){
							int newX = x - getX();
							int newY = y - getY();
							Point newPoint = new Point(newX, newY);
							((Flag)currObj).setLocation(newPoint);
							((Flag)currObj).setSelected(false);
							gw.setPositionPressed(!gw.getPositionPressed());
						}
					}
					else if(currObj instanceof FoodStation) {
						if(((FoodStation)currObj).isSelected()) {
							int newX = x - getX();
							int newY = y - getY();
							Point newPoint = new Point(newX, newY);
							((FoodStation)currObj).setLocation(newPoint);
							((FoodStation)currObj).setSelected(false);
							gw.setPositionPressed(!gw.getPositionPressed());
						}
					}	
			}	
		}
		else {
			Point pPtrRelPrnt = new Point(x, y);
			Point pCmpRelPrnt = new Point(getX(), getY());
			
			IIterator itr = gw.getIterator();
			while(itr.hasNext()) {
				GameObject currObj = itr.getNext();
					if(currObj instanceof Flag) {
						if(((Flag) currObj).contains(pPtrRelPrnt, pCmpRelPrnt)) {
							((Flag) currObj).setSelected(true);
						}
						else {
							((Flag) currObj).setSelected(false);
						}
					}
					else if(currObj instanceof FoodStation) {
						if(((FoodStation) currObj).contains(pPtrRelPrnt, pCmpRelPrnt)) {
							((FoodStation) currObj).setSelected(true);
						}
						else {
							((FoodStation) currObj).setSelected(false);
						}
					}
			  }	
		}
		repaint();
	}

}
