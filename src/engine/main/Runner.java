package engine.main;

import java.awt.Color; 
import java.awt.Graphics2D;

import engine.display.Display;

public abstract class Runner{
	public int width = 0;
	public int height = 0;
	public static int FPS = 0;
	public static int TPS = 0;
	
	protected MainEngine main;
	protected Display display;
	protected Graphics2D g;
	protected Color bgcolor;
	
	protected Runner(boolean full, int width, int height, String title, int fps, int tps){
		main = new MainEngine(full, width, height, title, fps);
		this.width = width;
		this.height = height;
		FPS = fps;
		TPS = tps;
		display = main.getDisplay();
		g = display.getPen();
	}

	public void start() {
		Thread t = new MainTicker(this);
		t.start();
		display.start();
		display.setBgColor(Color.black);
		while(!main.isClosed()){
			display.setBgColor(bgcolor);
			display.preUpdate(g);
			
			render();
			
			display.update();
		}
		main.stop();
	}

	public abstract void tick();
	
	public abstract void render();
}
