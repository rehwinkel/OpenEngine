package engine.util;

import java.awt.Graphics2D;

public class DrawMethod {
	public static void drawCircle(int x, int y, int radius, Graphics2D g){
		g.drawOval(x-radius, y-radius, (2*radius)+1, (2*radius)+1);
	}
	
	public static void fillCircle(int x, int y, int radius, Graphics2D g){
		g.fillOval(x-radius, y-radius, (2*radius)+1, (2*radius)+1);
	}

	public static void drawDot(int x, int y, int stroke, Graphics2D g) {
		switch(stroke){
			case 1:
				drawPixel(x, y, g);
				break;
			case 2:
				g.drawLine(x-1, y, x+1, y);
				g.drawLine(x, y+1, x, y-1);
				break;
			case 3:
				g.fillRect(x-1, y-1, 3, 3);
				break;
			case 4:
				g.fillRect(x-2, y-1, 5, 3);
				g.fillRect(x-1, y-2, 3, 5);
				break;
			default:
				drawPixel(x, y, g);
				break;
		}
	}
	
	public static void drawPixel(int x, int y, Graphics2D g) {
		g.drawLine(x, y, x, y);
	}
}
