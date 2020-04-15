
public class LinkedListDemo {
	
	private SinglyLinkedList list;
	
	public static void main(String[] args) {
		LinkedListDemo demo = new LinkedListDemo();
		demo.createList();
		//demo.showList();
		//demo.remove();
		//demo.length();
		//demo.onList();
		demo.removeObject("Larry");
		demo.showList();

	}
	
	public void createList() {
		list = new SinglyLinkedList();
		
		list.add("Spongebob");
		list.add("Patrick");
		list.add("Sandy");
	}
	
	public void showList() {
		list.showList();
	}
	
	public void remove() {
//		System.out.println("Remove test");
//		
//		while(!list.isEmpty()) {
//			//print out the next item removed
//			String nextData = list.remove();
//			System.out.println(nextData);
//		}
	}
	
	public void length() {
		System.out.println(list.length());
	}
	
	public void onList() {
		//Spongebob
		if(!list.onList("Spongebob")) {
			System.out.println("ERROR: Spongebob not found");
		}
		//Sandy
		if(!list.onList("Sandy")) {
			System.out.println("ERROR: Sandy not found");
		}
		//Patrick
		if(!list.onList("Patrick")) {
			System.out.println("ERROR: Patrick not found");
		}
		//make something not on list returns false
		if(list.onList("Larry")) {
			System.out.println("ERROR: Larry should not be found on list");
		}
	}
	
	public void addToStart(String data) {
		list.addToStart(data);
		showList();
	}
	
	public void removeObject(String data) {
		System.out.println(list.remove(data));
	}

}
