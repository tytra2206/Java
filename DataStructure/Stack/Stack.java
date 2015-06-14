public class Stack <T>
{
    private static final int DEFAULT_SIZE = 100;
    private T[] data;
    private int top;
    private int nElements;

    public Stack(int initSize) {	
		data = (T[]) new Object[initSize];
		top = 0;
		nElements = 0;
    }

    public Stack() {
		data = (T[]) new Object[DEFAULT_SIZE];
		top = 0;
		nElements = 0;
    }

    public void push(T item) {
		data[top++] = item;
		nElements++;
    }

    public <T> T pop() {
    	nElements--;
		return (T) data[--top];
    }
    
    public int size() { return nElements; }
}