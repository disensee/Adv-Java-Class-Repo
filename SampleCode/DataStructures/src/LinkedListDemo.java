import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList<String> friendsList = new LinkedList();
		friendsList.add("Spongebob");
		friendsList.add("Sandy");
		friendsList.add("Patrick");
		
		friendsList.remove("Spongebob");
		
		System.out.println("Original list...");
		printList(friendsList);

		String node = friendsList.remove();
		System.out.println(node + " was removed");
		
		System.out.println("After first remove...");
		printList(friendsList);
		
		//add a new person to the list
		friendsList.add("Squidward");
		System.out.println("Squdward was added...");
		printList(friendsList);
		
		
		//remove everything from the list
		try {
			while(true) {
				String nextFriend = friendsList.remove();
				System.out.println("Removing " + nextFriend);
			}
		}catch(NoSuchElementException e) {
			System.out.println("List is empty");
		}
	}
	
	private static void printList(List list) {
		//print each node in the list
		for(Object f : list) {
			System.out.println(f);
		}
	}

}
