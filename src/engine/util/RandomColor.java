package engine.util;

import java.awt.Color;

public class RandomColor {
	public static Color getRandomColor(){
		int r = (int) (Math.random()*255);
		int g = (int) (Math.random()*255);
		int b = (int) (Math.random()*255);
		return new Color(r,g,b);
	}
}
