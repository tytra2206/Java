import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		LinkedList list = new LinkedList();
		while(true) {
			System.out.println("1.AddHead");
			System.out.println("2.AddTail");
			System.out.println("3.Size");
			System.out.println("4.Print");
			System.out.println("5.Reverse");
			System.out.println("6.RemoveDups");
			System.out.println("7.Exit");
			
			switch(scanner.nextInt()) {
				case 1:
					System.out.print("Enter a number: ");
					list.addHead(scanner.nextInt());
					break;
				case 2:
					System.out.print("Enter a number: ");
					list.addTail(scanner.nextInt());
					break;
				case 3:
					System.out.printf("List size is %d\n", list.size());
					break;
				case 4:
					list.print();
					break;
				case 5:
					list.reverseIterative();
					break;
				case 6:
					list.removeDupsHash();
					break;
				case 7:
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