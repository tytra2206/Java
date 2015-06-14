public class Queue {
	private int[] array;
	private int front;
	private int rear;
	private int nItems;
	private int size = 100;
	
	public Queue() {
		array = new int[size];
		front = 0;
		rear = 0;
		nItems = 0;
	}
	
	public void enqueue(int item) {
		if(nItems == size)
			return;
		
		array[rear] = item;
		rear = (rear+1) % size;
		nItems++;
	}
	
	public int dequeue() throws Exception {
		if(nItems == 0)
			throw new Exception("Queue is empty");
		
		int result = array[front];
		front = (front+1) % size;
		nItems--;
		return result;
	}
	
	public void print() {
		for(int i = front; i != rear; i = (i + 1) % size){
			System.out.print(array[i]+ " ");
		}
		System.out.println();
	}
	
	public int size() { return nItems;}
}