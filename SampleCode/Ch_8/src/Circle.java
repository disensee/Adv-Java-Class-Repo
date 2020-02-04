
public class Circle implements Measurable, Comparable<Circle> {
	//Instance variables
	private double radius;
	
	//Constructor
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getCircumfrence() {
		return getPerimeter();
	}
	
	@Override
	public double getPerimeter() {
		return Math.PI*(radius*2);
	}

	@Override
	public double getArea() {
		return Math.PI * (radius * radius);
	}

	@Override
	public int compareTo(Circle o) {
		
		Circle other = (Circle)o;
		return (int)(this.radius - other.radius);
	}
	
	public String toString() {
		return "Radius: " + this.radius;
	}
	
}
