package engine.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Display extends JPanel{
	private static final long serialVersionUID = -2848474222924458021L;

	private double FPS = 0;
	
	private int width;
	private int height;

	private BufferedImage img;
	
	private long pre;
	private long post;

	private long start;
	private int frames = 0;

	public int current_fps;

	private Color bgcolor;

	public Display(int width, int height, double fps){
		this.width = width;
		this.height = height;
		this.FPS = fps;
		this.setPreferredSize(new Dimension(this.width, this.height));
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponents(g);
		render(g);
	}

	public void render(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}

	public void update(){
		this.repaint();
		post = System.currentTimeMillis();
		while((post-pre)<1000D/FPS){
			post = System.currentTimeMillis();
		}
		long now = System.currentTimeMillis()/1000L;
		if(now == start+1){
			current_fps = frames;
			start = now;
			frames = 0;
		}
	}

	public void preUpdate(Graphics2D g) {
		frames++;
		g.setColor(bgcolor);
		g.fillRect(0, 0, width, height);
		pre = System.currentTimeMillis();
	}

	public Graphics2D getPen() {
		return this.getImage().createGraphics();
	}

	public BufferedImage getImage() {
		return img;
	}

	public void start() {
		start = System.currentTimeMillis()/1000L;
	}

	public void setBgColor(Color c) {
		if(c != null){
			this.bgcolor = c;
		}
	}

	public void showFPS(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 50, 15);
		g.setColor(Color.white);
		g.drawString("FPS: " + this.current_fps, 2, 12);
	}
}
