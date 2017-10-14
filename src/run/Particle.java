package run;

import java.awt.Color;  
import java.awt.Graphics2D;
import java.util.List;

import engine.util.DrawMethod;
import engine.util.Vector2f;

public class Particle {
	public static final float gravity = 9.807F/5;
	Vector2f pos;
	Vector2f vel;
	Color col;
	int life;
	int time;
	
	public Particle(Vector2f pos, Vector2f vel, Color c, int life) {
		this.pos = pos;
		this.vel = vel;
		this.col = c;
		this.life = life;
	}
	
	public void update(List<Particle> parts, int i){
		time++;
		vel.y += gravity;
		
		pos = Vector2f.add(pos, vel);
		if(time > life){
			kill(parts, i);
		}
	}
	
	protected void kill(List<Particle> parts, int i) {
		parts.remove(i);
	}

	public void render(Graphics2D g){
		g.setColor(col);
		DrawMethod.drawDot((int) pos.x, (int) pos.y, 2, g);
	}
}
