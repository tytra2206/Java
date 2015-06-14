import java.util.Random;

class Main {
	public static void main(String[] args) {
		Random random = new Random();
		final int SIZE = 10;
		int[] array = new int[SIZE];
		for(int i = 0; i < SIZE; i++)
			array[i] = random.nextInt(100);

		print(array);
		selectionSort(array);
		print(array);
	}

	public static void print(int[] array) {
		for(int i: array)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void selectionSort(int[] array) {
		if(array.length <= 1)
			return;
		for(int i = 0; i < array.length; i++) {
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[min])
					min = j;
			}
			swap(array, min, i);
		}
	}

	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}