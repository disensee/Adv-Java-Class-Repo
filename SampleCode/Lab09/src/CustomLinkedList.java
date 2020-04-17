import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList<T> implements List<T> {
	//Instance variable(s)
	private ListNode<T> head;
	
	//Constructor(s)
	public CustomLinkedList() {
		head = null;
	}
	
	public CustomLinkedList(T data) {
		head.data = data;
		head.nextNode = null;
	}
	
	//Methods
	@Override
	public int size() {
		int nodeCount = 0;
		//Not sure if null pointer should be thrown if head is null, or if method should return 0
		ListNode<T> node = head;
		while(node != null) {
			nodeCount++;
			node = node.nextNode;
		}
		
		return nodeCount;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(Object o) {
		if(o == null) {
			throw new NullPointerException("The list is empty");
		}
		
		if(head == null) {
			return false;
		}
		
		ListNode<T> node = head;
		
		if(node.data.equals(o)) {
			return true;
		}
		
		while(node.nextNode != null) {
			node = node.nextNode;
			
			if (node.data.equals(o)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public Object[] toArray() {
		if(head == null) {
			throw new NullPointerException("The list is empty");
		}
		
		int count = 0;
		Object[] returnArr = new Object[this.size()];
		
		ListNode<T> current = head;
		returnArr[count] = head.data;
		
		while(current.nextNode != null) {
			current = current.nextNode;
			count++;
			
			returnArr[count] = current.data;
		}
		
		
		return returnArr;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean add(T e) {
		if(head == null) {
			head = new ListNode<T>(e, null);
			return true;
		}
		
		if(e == null) {
			return false;
		}
		
		ListNode<T> cNode = head;
		while(cNode.nextNode != null) {
			cNode = cNode.nextNode;
		}
		
		cNode.nextNode = new ListNode<T>(e, null);
		if(cNode.nextNode.data.equals(e)) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean remove(Object o) {
		if(head == null) {
			throw new NullPointerException("The list is empty");
		}
		
		ListNode<T> cNode = head;
		ListNode<T> prev = head;
		
		if(cNode.data.equals(o)) {
			head = cNode.nextNode;
			return true;
		}

		while(cNode != null && !cNode.data.equals(o)) {
			prev = cNode;
			cNode = cNode.nextNode;
		}
		
		if(cNode != null && cNode.data.equals(o)) {
			if(cNode.nextNode != null) {
				cNode.data = cNode.nextNode.data;
				cNode.nextNode = cNode.nextNode.nextNode;
			}else {
				prev.nextNode = null;
			}
			return true;
		}
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public void clear() {
		if(this.isEmpty()) {
			throw new NullPointerException("The list is empty");
		}
		
		while(head.nextNode != null) {
			head = head.nextNode;
		}
		
		head = null;	
	}

	@Override
	public T get(int index) {
		int count = 0;
		
		if(head == null) {
			throw new NullPointerException("The list is empty");
		}else if(index > this.size() - 1) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}if(index == 0 && head != null) {
			return head.data;
		}
		
		ListNode<T> current = head;
		while(current.nextNode != null) {
			current = current.nextNode;
			count++;
			
			if(count == index) {
				break;
			}
		}
		
		return current.data;
	}

	@Override
	public T set(int index, T element) {
		int count = 0;
		T oldData = null;
		
		if(head == null && index > 0) {
			throw new NullPointerException("The list is empty");
		}
		
		if(head == null && index == 0){
			throw new UnsupportedOperationException("The list is empty. CustomLinkedList.add() should be used.");
		}
		
		if(index > this.size() - 1) {
			throw new IndexOutOfBoundsException("Specified index is out of bounds");
		}
		
		if(head != null && index == 0) {
			oldData = head.data;
			head.data = element;
			return oldData;
		}
		
		ListNode<T> current = head;
		while(current.nextNode != null) {
			current = current.nextNode;
			count ++;
			
			if(count == index) {
				oldData = current.data;
				current.data = element;
			}
		}
		
		return oldData;
	}

	@Override
	public void add(int index, T element) {
		int count = 0;
		ListNode<T> prev = null;
		ListNode<T> toAdd = new ListNode<T>(element, null);
		
		if(head == null) {
			throw new NullPointerException("The list is empty. Please add an element to the 0 index using CustomLinkedList.add(T object)");
		}
		
		if(index > this.size() - 1) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		
		if(index == 0 && head != null) {
			ListNode<T> oldHead = head;
			head = toAdd;
			head.nextNode = oldHead;
			return;
		}
		
		ListNode<T> cNode = head;
		while(cNode != null && count != index) {
			prev = cNode;
			cNode = cNode.nextNode;
			count++;
		}
		
		prev.nextNode = toAdd;
		toAdd.nextNode = cNode;	
	}

	@Override
	public T remove(int index) {
		int count = 0;
		if(head == null) {
			throw new NullPointerException("The list is empty");
		}
		
		if(index > this.size() - 1) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		
		ListNode<T> current = head;
		ListNode<T> prev = head;
		while(current != null && count != index) {
			prev = current;
			current = current.nextNode;
			count++;
		}
		
		ListNode<T> hold = new ListNode<T>(current.data, current.nextNode);
		
		if(current.nextNode != null) {
			current.data = current.nextNode.data;
			current.nextNode = current.nextNode.nextNode;
		}else {
			prev.nextNode = null;
		}
		
		
		return hold.data;
	}

	@Override
	public int indexOf(Object o) {
		int count = 0;
		if(head == null) {
			throw new NullPointerException("The list is empty");
		}
		
		ListNode<T> current = head;
		while (current.nextNode != null && !current.data.equals(o)) {
			current = current.nextNode;
			count++;
		}
		
		if(current.data.equals(o)) {
			return count;
		}
		
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		int count = 0;
		int found = -1;
		if(head == null) {
			throw new NullPointerException("The list is empty");
		}
		
		ListNode<T> current = head;
		while(count < this.size()){
			if(current.data.equals(o)) {
				found = count;
			}
			count++;
			current = current.nextNode;
		}
		
		return found;	
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	private class ListNode<T>{
		//Instance variables
		private T data;
		private ListNode<T> nextNode;
		
		//Constructor(s)
		public ListNode(){
			data = null;
			nextNode = null;
		}
		
		public ListNode(T data, ListNode<T> nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}
	}
}
