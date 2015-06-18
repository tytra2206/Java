import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		BST bst = new BST();
		while(true) {
			System.out.println("1.Add");
			System.out.println("2.Find");
			System.out.println("3.Print");
			System.out.println("4.Remove");
			System.out.println("5.Exit");
			
			switch(scanner.nextInt()) {
				case 1:
					System.out.print("Enter a number: ");
					bst.add(scanner.nextInt());
					break;
				case 2:
					System.out.print("Enter a number: ");
					System.out.println("Target is " + 
														(bst.find(scanner.nextInt())
														 ? "found.": "not found."));
					break;
				case 3:
					bst.dfs();
					break;
				case 4:
					System.out.print("Enter a number: ");
					bst.remove(scanner.nextInt());
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