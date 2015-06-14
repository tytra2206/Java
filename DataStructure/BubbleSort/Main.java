public class Main {
	public static void main(String[] args) {
		final int SIZE = 100000;
		Array array = new Array(SIZE);
		for(int i = SIZE; i >= 0; i--) {
			array.add(i);
		}
		array.bubbleSort();
	}
}