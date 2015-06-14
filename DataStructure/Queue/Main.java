import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		Queue queue = new Queue();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.Enqueue");
			System.out.println("2.Dequeue");
			System.out.println("3.Size");
			System.out.println("4.Print");
			System.out.println("5.Exit");
			
			switch(scanner.nextInt()) {
				case 1:
					System.out.print("Enter a number: ");
					queue.enqueue(scanner.nextInt());
					break;
				case 2:
					System.out.printf("Removed number is %d\n", queue.dequeue());
					break;
				case 3:
					System.out.printf("Queue size is %d\n", queue.size());
					break;
				case 4:
					queue.print();
					break;
				case 5:
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