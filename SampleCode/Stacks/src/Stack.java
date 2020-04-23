import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<E> {
	
	private ArrayList<E> data;
	
	public Stack() {
		data = new ArrayList<E>();
	}
	
	public E push(E item) {
		data.add(item);
		return item;
	}
	
	public E pop() throws EmptyStackException {
		if (empty()) {
			throw new EmptyStackException();
		}
		
		return data.remove(data.size() - 1);
	}
	
	public E peek() throws EmptyStackException {
		if (empty()) {
			throw new EmptyStackException();
		}
		
		return data.get(data.size() - 1);
	}
	
	public boolean empty() {
		return data.isEmpty();
	}
	
	public int size() {
		return data.size();
	}
	
	public void clear() {
		data = new ArrayList<E>();
	}
}
