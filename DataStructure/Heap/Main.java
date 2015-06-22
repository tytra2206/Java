import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		Heap heap = new Heap();
		while(true) {
			System.out.println("1.Add");
			System.out.println("2.Get Max");
			System.out.println("3.Remove");
			System.out.println("4.Exit");
			
			switch(scanner.nextInt()) {
				case 1:
					System.out.print("Enter a number: ");
					heap.add(scanner.nextInt());
					break;
				case 2:
					System.out.println("Max is " + heap.getMax());
					break;
				case 3:
					heap.remove();
					break;
				case 4:
					scanner.close();
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice!");
					break;
			}
		}
	}
}