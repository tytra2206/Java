public class Array {
	private int[] array;
	private int nItems;
	private static final int SIZE = 10;
	
	public Array() {
		array = new int[SIZE];
		nItems = 0;
	}
	
	public Array(int size) {
		array = new int[size];
		nItems = 0;
	}
	
	public void add(int item) {
		if(nItems == array.length)
			return;
		
		array[nItems++] = item;
	}
	
	public void bubbleSort() {
		for(int i = nItems - 1; i > 1; i--) {
			for(int j = 0; j < i; j++) {
				if(array[j+1] < array[j])
					swap(j, j+1);
			}
		}
	}
	
	private void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public void print() {
		for(int i = 0; i < nItems; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}