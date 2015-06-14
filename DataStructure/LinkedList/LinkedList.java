import java.util.Hashtable;

public class LinkedList {
	private Node head;
	private Node tail;
	private int nItems;
	
	public LinkedList() {
		head = null;
		tail = null;
		nItems = 0;
	}
	
	public void addHead(int item) {
		Node node = new Node(item, null);
		if(head == null) {
			head = node;
			tail = node;
		}
		else{
			node.next = head;
			head = node;
		}
		nItems++;
	}

	public void removeDups() {
		if(head == null || head.next == null)
			return;

		Node cur = head;
		while(cur != null) {
			Node runner = cur;
			while(runner.next != null){
				if(runner.next.data == cur.data){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			cur = cur.next;
		}
	}

	public void removeDupsHash() {
		if(head == null || head.next == null)
			return;
		Node cur = head;
		Node pre = null;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		while(cur != null) {
			if(table.containsKey(cur.data)){
				pre.next = cur.next;
			}else{
				table.put(cur.data, true);
				pre = cur;
			}
			cur = cur.next;
		}
	}
	
	public void addTail(int item) {
		Node node = new Node(item, null);
		if(tail == null){
			head = node;
			tail = node;
		}
		else {
			tail.next = node;
			tail = node;
		}
		nItems++;
	}
	
	public void print() {
		Node cur = head;
		while(cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public Node removeHead() {
		if(head == null)
			return null;
			
		Node result = head;
		if(head.next == null){
			head = null;
			tail = null;
			nItems = 0;
			return result;
		}
		head = head.next;
		nItems--;
		return result;
	}

	public void reverse() {
		Node cur = head;
		reverseRecursive(cur);
	}	
	private void reverseRecursive(Node cur) {
		if(cur== null)
			return;

		if(cur.next == null){
			head = cur;
			return;
		}

		reverseRecursive(cur.next);
		Node node = cur.next;
		node.next = cur;
		cur.next = null;
	}

	public void reverseIterative() {
		if(head == null || head.next == null)
			return;

		Node cur = head;
		Node pre = null;
		while(cur != null) {
			Node next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		head = pre;
	}
	
	public Node getHead(){
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public int size() { return nItems;}
}