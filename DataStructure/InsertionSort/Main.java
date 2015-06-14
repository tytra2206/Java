import java.util.Random;

class Main {
	public static void main(String[] args) {
		Random random = new Random();
		final int SIZE = 11;
		int[] array = new int[SIZE];
		for(int i = 0; i < SIZE; i++)
			array[i] = random.nextInt(100);

		print(array);
		insertionSort(array);
		print(array);
	}

	public static void print(int[] array) {
		for(int i: array)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void insertionSort(int[] array) {
		if(array.length <= 1)
			return;
		for(int i = 1; i < array.length; i++) {
			int toBeInserted = array[i];
			int j;
			for(j = i; j > 0 && array[j-1] > toBeInserted; j--)
				array[j] = array[j-1];
			array[j] = toBeInserted;
		}
	}

	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}