// Java program to illustrate merge sorted
// of linkedList

public class NatMergeSort {
	node head = null;

	// node a,b;
	static class node {
		int val;
		node next;

		public node(int val) {
			this.val = val;
		}
	}

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

	public node mergeSort(node head) {
		// Base case : if head is null
		if (head == null || head.next == null) {
			return head;
		}

		// get the middle of the list
		node sorted = getMiddle(head);
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
	public node getMiddle(node head) {
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
	public void printList(node headref) {
		while (headref != null) {
			System.out.print(headref.val + " ");
			headref = headref.next;
		}
	}

	public void xFer(int[] arr, String fileName) {

		for (int i = 0; i < arr.length; i++) {
			push(arr[i]);
		}

		// Apply merge Sort
		this.head = mergeSort(this.head);
		System.out.println("Natural Merge Sort");
		System.out.println("Name of data file: " + fileName);
		printList(this.head);
	}
}

// This code is contributed by Rishabh Mahrsee
