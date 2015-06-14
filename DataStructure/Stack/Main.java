public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		int j = stack.size();
		for(int i = 0; i < j; i++) {
			System.out.println(stack.pop() + "");
		}		
	}
}