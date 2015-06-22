class Heap {
	private int[] data;
	private int size = 100;
	private int nItems;

	public Heap() {
		data = new int[size];
		nItems = 0;
	}

	public void add(int item) {
		if(nItems >= size)
			return;

		data[nItems] = item;
		heapUp(nItems++);
	}

	public int remove() throws Exception{
		if(nItems <= 0)
			throw new Exception("Heap is empty");
		int removed = data[0];
		data[0] = data[--nItems];
		heapDown(0);
		System.out.println("Removed " + removed);
		return removed;
	}

	private void heapDown(int position) {
		int item = data[position];
		int larger;
		while(position < nItems/2) {
			int leftChild = position*2 + 1;
			int rightChild = leftChild + 1;
			if(rightChild < nItems && data[rightChild] > data[leftChild])
				larger = rightChild;
			else
				larger = leftChild;

			if(item >= data[larger])
				break;

			data[position] = data[larger];
			position = larger;
		}
		data[position] = item;
	}

	private void heapUp(int position) {
		int item = data[position];
		int parent = (position - 1)/2;
		while(position > 0 && data[parent] < item) {
			data[position] = data[parent];
			position = parent; 
			parent = (parent - 1)/2;
		}
		data[position] = item;
	}

	public int getMax() throws Exception{ 
		if(nItems > 0)
			return data[0];
		else
			throw new Exception("Heap is empty");
	}

	public int size() { return nItems;}
}