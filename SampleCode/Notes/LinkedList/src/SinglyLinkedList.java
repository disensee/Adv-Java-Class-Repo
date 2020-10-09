
public class SinglyLinkedList {
	private ListNode head;
	
	
	public SinglyLinkedList() {
		head = null;
	}
	
	//add will append a node to the list
	//recall, lists are FIFO
	public void add(String data) {
		//if the head is null, this is the first item on the list
		//make data param the head
		if(head == null) {
			head = new ListNode(data, null);
			return;
		}
		
		//find the last node (tail)
		ListNode cNode = head;
		while(cNode.getNextNode() != null) {
			cNode = cNode.getNextNode();
		}
		
		//add new node as the new tail
		cNode.setNextNode(new ListNode(data, null));
	}
	
	
	//adds an item to the start of the list
	public void addToStart(String data) {
		if(head == null) {
			head = new ListNode(data, null);
		}
		
		ListNode oldHead = new ListNode(head.getData(), head.getNextNode());
		head.setData(data);
		head.setNextNode(oldHead);
	}
	
	//remove will delete the node
	//at the front of the list
	//returns null if the list is empty
	public String remove() {
		if(head == null) {
			return null;
		}
		
		ListNode oldHead = head;
		head = oldHead.getNextNode();
		
		return oldHead.getData();
	}
	
	//remove specific object
	public boolean remove (String data) {
		if(head == null) {
			return false;
		}
		
		ListNode currentNode = head;
		while(currentNode.getNextNode() != null) {
			if(currentNode.getData().equals(data)) {
				ListNode holdNext = new ListNode(currentNode.getNextNode().getData(), currentNode.getNextNode().getNextNode());
				currentNode.setData(holdNext.getData());
				currentNode.setNextNode(holdNext.getNextNode());
				return true;
			}
			
			currentNode = currentNode.getNextNode();
			if(currentNode.getNextNode().getData().equals(data)) {
				currentNode.getNextNode().setData(null);
				currentNode.setNextNode(null);
				return true;
			}
		}
			
		return false;
	}
	
	//display all the data on the list
	public void showList() {
		ListNode cNode = head;
		while(cNode != null) {
			System.out.print(cNode.getData() + " --> ");
			cNode = cNode.getNextNode();
		}
		
		System.out.println("NULL");
	}
	
	//return the number of nodes on the list
	public int length() {
		int nodeCount = 0;
		ListNode cNode = head;
		while(cNode != null) {
			nodeCount++;
			cNode = cNode.getNextNode();
		}
		
		return nodeCount;
	}
	
	//Returns whether an item is on the list or not
	public boolean onList(String data) {
		ListNode cNode = head;
		while(cNode != null) {
			if(cNode.getData().equals(data)) {
				return true;
			}
			
			cNode = cNode.getNextNode();
		}
		
		return false;
	}
	
	//Return whether the list is empty or not
	public boolean isEmpty() {
		return head == null;
	}
}
