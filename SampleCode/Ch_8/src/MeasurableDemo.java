import java.util.ArrayList;
import java.util.Collections;

public class MeasurableDemo {

	public static void main(String[] args) {
		Measurable mr = new Rectangle(10,10);
		display(mr);
		
		ArrayList<Circle> list = new ArrayList();
		list.add(new Circle(100));
		list.add(new Circle(50));
		list.add(new Circle(200));
		
		Collections.sort(list);
		System.out.println(list);
	}
	
	public static void display(Measurable figure) {
		System.out.println("Perimeter: " + figure.getPerimeter());
		System.out.println("Area: " + figure.getArea());
	}
}
