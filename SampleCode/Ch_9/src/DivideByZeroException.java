
public class DivideByZeroException extends Exception {
	public DivideByZeroException() {
		super("Dividing by zero!!!");
	}
	
	public DivideByZeroException(String message) {
		super(message);
	}
}
