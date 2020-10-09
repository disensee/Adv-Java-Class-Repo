import java.util.ArrayList;
import java.util.HashMap;

public class Test {
		
	public static void main(String[] args) {
		
		ArrayList<String> friendList = new ArrayList<String>();
		
		friendList.add("Joe");
		friendList.add("Sam");
		
		for(int i = 0; i < friendList.size(); i++) {
			System.out.println(friendList.get(i));
		}
		
		
		HashMap<String, String> friendPhone = new HashMap<String, String>();
		friendPhone.put("Joe", "555-123-4567");
		friendPhone.put("Sam", "555-987-6543");
		
		if(friendPhone.containsKey("Joe")) {
			System.out.println(friendPhone.get("Joe"));
		}else {
			System.out.println("Friend is not stored");
		}
	}

}
