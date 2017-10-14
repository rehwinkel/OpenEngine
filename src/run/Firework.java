package run;

import java.awt.Graphics2D;
import java.util.List;

import engine.util.DrawMethod;
import engine.util.RandomColor;
import engine.util.Vector2f;

public class Firework extends Particle{

	public Firework(Vector2f pos, Vector2f vel) {
		super(pos, vel, RandomColor.getRandomColor(), 10000);
	}

	public void update(List<Firework> parts, int i, List<Particle> sparks){
		super.update(null, 0);
		if(this.vel.y > 0){
			this.explode(parts, i, sparks);
		}
	}

	private void explode(List<Firework> parts, int i, List<Particle> sparks) {
		for(int e = 0; e < 200; e++){
			sparks.add(new Particle(pos, Vector2f.mult(Vector2f.random(), 10), col, 8 + (int)(Math.random()*6D)));
		}
		killS(parts, i);
	}
	
	private void killS(List<Firework> parts, int i) {
		parts.remove(i);
	}
	
	@Override
	public void render(Graphics2D g){
		g.setColor(col);
		DrawMethod.fillCircle((int) pos.x, (int) pos.y, 3, g);
	}

}
