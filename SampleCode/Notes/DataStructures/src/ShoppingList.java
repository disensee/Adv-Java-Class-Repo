import java.util.ArrayList;
import java.util.Scanner;


//ARRAYS DEMO
public class ShoppingList {
	
//	private String[] items;
//	private int size = 0;
	
	private ArrayList<String> items;
	
	public static void main(String[] args) {
		ShoppingList list = new ShoppingList();
		list.addItemsToList();
		list.printList();
	}
	
	public ShoppingList() {
		items = new ArrayList();
	}
	
	public void addItemsToList() {
		Scanner s = new Scanner(System.in);
		addItemsToList(s, "Y");
	}
	
	public void addItemsToList(Scanner s, String response) {
		if(!response.equalsIgnoreCase("Y")) {
			//stop prompting for items
			return;
		}
		
//		if(size >= items.length) {
//			//resize
//			resize();
//		}
		
		System.out.println("Enter the next item to the list");
		
		String item = s.nextLine();
		items.add(item);
		
		System.out.println("Add another item to the list? (Y/N)");
		response = s.nextLine();
		
		addItemsToList(s, response);
	}
	
//	private void resize() {
//		String[] arr = new String[items.length * 2];
//		for(int i = 0; i < items.length; i++) {
//			arr[i] = items[i];
//		}
//		
//		items = arr;
//	}
	
	public void printList() {
		System.out.println("\nYour shopping list ...");
		for(int i = 0; i < items.size(); i++) {
			System.out.printf("Shopping list item %d: %s%n", i, items.get(i));
		}
	}
}
