
public class Rectangle implements Measurable {
	//Instance variable(s)
	private double width;
	private double height;
	//Constructor
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	//Methods(from interface)
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return 2 * (width + height);
	}
}
