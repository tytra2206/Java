import java.util.*;

class Main {
	public static int[] array;

	public static void main(String[] args) {
		array = new int[args.length];
		for(int i = 0; i < array.length; i++) {
			array[i] = Integer.valueOf(args[i]);
		}
		findTwoSumUnSortedRotated(9);
	}

	//Find largest pair in an unsorted array.
	public static void findLargestPair() {
		if(array == null || array.length < 2)
			return;
		
		int first;
		int second;

		if(array[0] > array[1]){
			first = 0;
			second = 1;
		}
		else {
			first = 1;
			second = 0;
		}

		for(int i = 2; i < array.length; i++) {
			if(array[i] > array[first]){
				second = first;
				first = i;
			}
			else if(array[i] > array[second] && array[i] != array[first])
				second = i;
		}

		System.out.println("The largest pair is " + array[first] + " and " + array[second]);
		
	}

	//Find largest sum in an array.
	public static void findLargestSum() {
		if(array == null || array.length < 1)
			return;

		int sum = array[0];
		int maxSum = array[0];

		for(int i = 1; i < array.length; i++) {
			if(array[i] > sum + array[i])
				sum = array[i];
			else 
				sum = array[i] + sum;

			if(sum > maxSum)
				maxSum = sum;
		}

		System.out.println("Max sum is " + maxSum);
	}

	//Find twosum in a sorted array.
	public static void findTwoSumSorted(int sum) {
		if(array == null || array.length < 2)
			return;

		int right = array.length - 1;
		int left = 0;
		while(left < right) {
			if(array[left] + array[right] == sum) {
				System.out.println("Sum is formed at " + left + " and " + right);
				break;
			}
			else if (array[left] + array[right] < sum)
				left++;
			else
				right--;
		}
	}

	//Find two sum in an unsorted array.
	public static void findTwoSumUnSorted(int sum) {
		if(array == null || array.length < 2)
			return;

		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		for(int i = 0; i < array.length; i++) {
			if(table.containsKey(array[i])){
				int a = array[i];
				int b = array[table.get(array[i])];
				System.out.printf("%d + %d = %d\n", a, b, sum);
				break;
			}else {
				table.put(sum - array[i], i);
			}
		}
	}

	//Remove duplicates from an array.
	public static void removeDups() {
		if(array == null || array.length < 2)
			return;
		Set<Integer> set = new HashSet<Integer>();
		for(int i : array)
			set.add(i);

		int[] newArray = new int[set.size()];
		Iterator<Integer> iterator = set.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			newArray[i++] = iterator.next();
		}
		array = newArray;
	}

	//Find twosum in rotated sorted array.
	public static void findTwoSumUnSortedRotated(int sum) {
		if(array == null || array.length < 2)
			return;

		int left = -1;
		int right = -1;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i+1] < array[i]) {
				left = i;
				right = i + 1;
				break;
			}
		}
		if(left < 0)
			return;

		while(left != right) {
			if(array[left] + array[right] == sum) {
				System.out.println("Sum is formed at " + left + " and " + right);
				break;
			}
			else if(array[left] + array[right] < sum)
				right = (right+1)%array.length;
			else
				left = (array.length + left - 1)% array.length;
		}

	}

	//Print array.
	public static void print() {
		if(array == null)
			return;
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
	}
}