
/**
 * Natural merge sort, that was almost entirely lifted from: “Merge Sort for
 * Linked Lists.”
 * 
 * My contribution converted this code from merely a merge sort to a natural
 * merge sort.
 * 
 * @author arta
 *
 */
public class NatMergeSort {
	node head = null;

	// node a,b;
	/**
	 * Node class - not using Java libraries
	 * 
	 * @author arta
	 *
	 */
	static class node {
		int val;
		node next;

		public node(int val) {
			this.val = val;
		}
	}

	/**
	 * Recursive method that does the actual merge sorting
	 * 
	 * @param leftHead First element of left substructure
	 * @param rightHead First element of right substructure
	 * @return Sorted node
	 */
	public node sortedMerge(node leftHead, node rightHead) {
		node result = null;
		/* Base cases */
		if (leftHead == null)
			return rightHead;
		if (rightHead == null)
			return leftHead;

		/* Pick either a or b, and recur */
		if (leftHead.val <= rightHead.val) {
			result = leftHead;
			result.next = sortedMerge(leftHead.next, rightHead);
		} else {
			result = rightHead;
			result.next = sortedMerge(leftHead, rightHead.next);
		}
		return result;

	}

	/**
	 * Creates the sublist for natural merge sort
	 * 
	 * @param head First call is top-most node, subsequent calls are recursive
	 * @return Cut-off point for each sublist
	 */
	public node mergeSort(node head) {
		// Base case : if head is null
		if (head == null || head.next == null) {
			return head;
		}

		// get the middle of the list
		node sorted = getComparison(head);
		node unsorted = sorted.next;

		// set the next of middle node to null
		sorted.next = null;

		// Apply mergeSort on left list (which just breaks down the data
		// structure)
		node left = mergeSort(head);

		// Apply mergeSort on right list (which just breaks down the data
		// structure)
		node right = mergeSort(unsorted);

		// Merge the left and right lists
		node sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	// Utility function to get the middle of the linked list
	public node getComparison(node head) {
		// Base case
		if (head == null)
			return head;

		node nextPtr = head.next;
		node curPtr = head;

		while (nextPtr.val > curPtr.val) {
			nextPtr = nextPtr.next;
			curPtr = curPtr.next;
		}
		return curPtr;
	}

	public void push(int new_data) {
		/* allocate node */
		node new_node = new node(new_data);

		/* link the old list off the new node */
		new_node.next = head;

		/* move the head to point to the new node */
		head = new_node;
	}

	public void naturalMerge(node head) {

	}

	// Utility function to print the linked list
	public void printList(node headref, long startTime, long endTime) {
		while (headref != null) {
			System.out.print(headref.val + " ");
			headref = headref.next;
		}
		System.out.println();
		long elapsedTime = endTime - startTime;
		System.out.println("Elapsed time of sort calculation in nanoseconds: "
				+ elapsedTime);
	}

	public void xFer(int[] arr, String fileName, long startTime) {

		for (int i = 0; i < arr.length; i++) {
			push(arr[i]);
		}

		// Apply merge Sort
		this.head = mergeSort(this.head);
		long endTime = System.nanoTime();
		System.out.println("Natural Merge Sort");
		System.out.println("Name of data file: " + fileName);
		printList(this.head, startTime, endTime);
	}
}

// This code is contributed by Rishabh Mahrsee
