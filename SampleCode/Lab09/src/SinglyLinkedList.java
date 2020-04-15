import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SinglyLinkedList<T> implements List<T> {
	//Instance variable(s)
	private ListNode<T> head;
	
	//Constructor
	public SinglyLinkedList() {
		head = null;
	}
	
	//Implemented/Inherited Methods
	@Override
	public int size() {
		int nodeCount = 0;
		
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
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
			return false;
		}
		
		ListNode<T> cNode = head;
		while(cNode.nextNode != null) {
//			if(cNode.data.equals(o)) {
//				ListNode<T> holdNext = new ListNode(cNode.nextNode.data, cNode.nextNode.nextNode);
//				cNode.data = holdNext.data;
//				cNode.nextNode = holdNext.nextNode;
//				return true;
//			}
			
			cNode = cNode.nextNode;
			if(cNode.data.equals(o)) {
				cNode.data = null;
				cNode.nextNode = null;
				return true;
			}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
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
