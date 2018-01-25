package engine.util;

import java.awt.Color;

public class RandomColor {
	public static Color getRandomHSV(){
		return getHSVColor((int) (Math.random() * 360));
	}
	
	public static Color getRandomColor(){
		int r = (int) (Math.random()*255);
		int g = (int) (Math.random()*255);
		int b = (int) (Math.random()*255);
		return new Color(r,g,b);
	}
	
	public static Color getHSVColor(int deg) {
		int r = 0;
		int g = 0;
		int b = 0;
		
		if(deg >= 0 && deg <= 60){
			r = 255;
			b = 0;
			g = (int) ((deg % 60 / 60.0f) * 255);
		}
		if(deg > 60 && deg <= 120){
			r = 255 - (int) ((deg % 60 / 60.0f) * 255);
			g = 255;
			b = 0;
		}
		if(deg > 120 && deg <= 180){
			r = 0;
			g = 255;
			b = (int) ((deg % 60 / 60.0f) * 255);
		}
		if(deg > 180 && deg <= 240){
			r = 0;
			b = 255;
			g = 255 - (int) ((deg % 60 / 60.0f) * 255);
		}
		if(deg > 240 && deg <= 300){
			g = 0;
			b = 255;
			r = (int) ((deg % 60 / 60.0f) * 255);
		}
		if(deg > 300 && deg <= 360){
			g = 0;
			r = 255;
			b = 255 - (int) ((deg % 60 / 60.0f) * 255);
		}
		
		return new Color(r, g, b);
	}
}
