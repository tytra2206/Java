
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BST {
	private Node root;

	public BST() {
		root = null;
	}

	public void add(int item) {
		Node newNode = new Node(item);
		if(root == null){
			root = newNode;
			return;
		}

		Node cur = root;
		Node parent = null;
		boolean isLeft = false;
		while(cur != null) {
			parent = cur;
			if(item > cur.data) {
				cur = cur.right;
				isLeft = false;
			}else if(item < cur.data) {
				cur = cur.left;
				isLeft = true;
			}
			else
				return;
		}

		if(isLeft)
			parent.left = newNode;
		else
			parent.right = newNode;
	}

	public void remove(int key) {
		if(root == null)
			return;

		Node cur = root;
		Node parent = null;
		boolean isLeft = false;

		//Find target node
		while(cur != null) {
			if(cur.data == key)
				break;

			parent = cur;
			if(key > cur.data) {			
				cur = cur.right;
				isLeft = false;
			}else {
				cur = cur.left;
				isLeft = true;
			}
		}

		//Target not found.
		if(cur == null)
			return;

		//Target found.
		//Case 1: target not is a leaf node.
		if(cur.left == null && cur.right == null) {
			if(root == cur){
				root = null;
				return;
			}
			if(isLeft)
				parent.left = null;
			else
				parent.right = null;
		}
		//Case 2: target node has one child.
		else if (cur.right == null) {
			if(root == cur) {
				root = cur.left;
				return;
			}
			if(isLeft){
				parent.left = cur.left;
			}else {
				parent.right = cur.left;
			}
		}
		else if(cur.left == null) {
			if(root == cur) {
				root = cur.right;
				return;
			}
			if(isLeft){
				parent.left = cur.right;
			}else {
				parent.right = cur.right;
			}
		}
		//Case 3: target node has both left and right children.
		else {
			Node replace = cur.left;
			parent = cur;
			while(replace.right != null) {
				parent = replace;
				replace = replace.right;
			}
			if(parent == cur) {
				cur.data = replace.data;
				parent.left = replace.left;
			}else {
				cur.data = replace.data;
				parent.right = replace.left;
			}
		}
	}

	public boolean find(int key) {
		if(root == null)
			return false;

		Node cur = root;
		while(cur != null) {
			if(cur.data == key)
				return true;
			if(key > cur.data)
				cur = cur.right;
			else
				cur = cur.left;
		}

		return false;
	}

	public void inorderTraverse() {
		Node cur = root;
		traverse(cur);
		System.out.println();
	}

	public void bfs() {
		if(root == null)
			return;
		Node cur = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			System.out.print(node.data + " ");
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
		}
		System.out.println();
	}

	public void dfs() {
		if(root == null)
			return;
		Node cur = root;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.print(node.data + " ");
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}
		System.out.println();
	}

	private void traverse(Node cur) {
		if(cur == null)
			return;
		traverse(cur.left);
		System.out.print(cur.data + " ");
		traverse(cur.right);
	}
}