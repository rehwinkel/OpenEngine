package engine.util;

public class Vector2f {
	public float x;
	public float y;
	
	public Vector2f(){
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2f(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public Vector2f(double x, double y) {
		this.x = (float)x;
		this.y = (float)y;
	}

	public static Vector2f add(Vector2f a, Vector2f b){
		Vector2f vec;
		float x = a.x + b.x;
		float y = a.y + b.y;
		vec = new Vector2f(x, y);
		return vec;
	}
	
	public float length(){
		float x = this.x;
		float y = this.y;
		
		float l = (float) Math.sqrt(x * x + y * y);
		
		return l;
	}
	
	public static Vector2f average(Vector2f v1, Vector2f v2, float f){
		float x1 = v1.x;
		float y1 = v1.y;
		float x2 = v2.x;
		float y2 = v2.y;
		
		float x = 0;
		float y = 0;

		x = x1*f + x2*(1-f);
		y = y1*f + y2*(1-f);
		
		return new Vector2f(x, y);
	}
	
	public static Vector2f norm(Vector2f left){
		Vector2f vec;
		float l = left.length();
		float x = left.x / l;
		float y = left.y / l;
		vec = new Vector2f(x, y);
		return vec;
	}
	
	public static Vector2f sub(Vector2f left, Vector2f right){
		Vector2f vec;
		float x = left.x - right.x;
		float y = left.y - right.y;
		vec = new Vector2f(x, y);
		return vec;
	}
	
	public static Vector2f mult(Vector2f a, Vector2f b){
		Vector2f vec;
		float x = a.x * b.x;
		float y = a.y * b.y;
		vec = new Vector2f(x, y);
		return vec;
	}
	
	public static Vector2f mult(Vector2f a, float b){
		Vector2f vec;
		float x = a.x * b;
		float y = a.y * b;
		vec = new Vector2f(x, y);
		return vec;
	}
	
	public static Vector2f randomU(){
		double length = 1;
		double deg = Math.random()*360;
		double x = 0;
		double y = 0;
		x = length * Math.cos(Math.toRadians(deg));
		y = length * Math.sin(Math.toRadians(deg));
		return new Vector2f(x, y);
	}
	
	public static Vector2f random(){
		double length = Math.random();
		double deg = Math.random()*360;
		double x = 0;
		double y = 0;
		x = length * Math.cos(Math.toRadians(deg));
		y = length * Math.sin(Math.toRadians(deg));
		return new Vector2f(x, y);
	}
}
