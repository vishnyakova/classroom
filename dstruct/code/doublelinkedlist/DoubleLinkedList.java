package doublelinkedlist;


public class DoubleLinkedList<E> {
	private int size;
	Node<E> head;
	Node<E> tail;
	

	
	public DoubleLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	public int size() {
		return size;
	}
	
	
	public boolean add(E item) {
		this.add(size, item);
		return true;
	}
	
	public void add(int index, E item) {
		
		
		// out of bounds
		if(index<0 || index > size) {
			System.err.println("My hovercraft is full of eels!");
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		Node<E> temp = new Node<E>(item);
		// adding to empty list
		if(size == 0) {
			head = temp;
			tail = temp;
			
		} else if(index == 0) { // adding new head
			temp.next = head;
			head.prev = temp;
			head = temp;
		} else if(index == size) {// adding new tail
			temp.prev = tail;
			tail.next = temp;
			tail = temp;
		} else {  // adding anywhere else!
			Node<E> node =  getNode(index -1);
			temp.next = node.next;
			temp.prev = node;
			node.next = temp;
			temp.next.prev =  temp;
		}
		size++;
	}
	
	
	
	public E remove(int index) {
		E retval = null;
		
		// out of bounds
		
		// removing would make list empty
		
		
		// removing the head
		
		
		// removing the tail
		
		
		// removing anywhere else
		
		size--;
		return retval;
	}
	
	
	
	private Node<E> getNode(int index){
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		Node<E> current = head;
		for(int i = 0 ; i < index; i++) {
			current = current.next;
		}
		return current;
		
	}
	
	public E get(int index) {
		return getNode(index).item;
	}
	
	
	public String toString() {
		String  retval = "";
		Node<E> current = head;
		
		while(current != null) {
			retval =  retval + current.item.toString() +"->";
			current = current.next;
		}
		
		
		return retval ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedList<String> list =  new DoubleLinkedList<String>();
		list.add( "Alice");
		list.add("Carl");
		list.add(1, "Bob");
		list.add(0, "0");
		System.out.println(list);
		
	}

}
