import java.util.Random;

class Main {
	public static void main(String[] args) {
		Random random = new Random();
		final int SIZE = 11;
		int[] array = new int[SIZE];
		for(int i = 0; i < SIZE; i++)
			array[i] = random.nextInt(100);

		quicksort(array);
		print(array);
		int k = 5;
		System.out.printf("%dth smallest is %d\n", k, findKthSmallest(array, k));
	}

	public static int findKthSmallest(int[] array, int k){
		return quickSelect(array, 0, array.length-1, k);
	}

	private static int quickSelect(int[] array, int left, int right, int k) {
		if(left == right)
			return array[left];

		int pivot = partitionIt(array, left, right, array[right]);
		if(k == pivot)
			return array[k];
		else if (k < pivot)
			return quickSelect(array, left, pivot-1, k);
		else
			return quickSelect(array, pivot+1, right, k);
	}

	public static void print(int[] array) {
		for(int i: array)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void quicksort(int[] array) {
		sort(array, 0, array.length-1);
	}

	private static void sort(int[] array, int low, int high) {
		if(low >= high)
			return;

		int partition = partitionIt(array, low, high, array[high]);
		sort(array, low, partition-1);
		sort(array, partition + 1, high);
	}

	private static int partitionIt(int[] array, int low, int high, int pivot) {
		int left = low - 1;
		int right = high;
		while(true) {
			while(array[++left] < pivot)
				;
			while(right > 0 && array[--right] > pivot)
				;
			if(left > right)
				break;
			swap(array, left, right);
		}
		swap(array, left, high);
		return left;
	}

	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}