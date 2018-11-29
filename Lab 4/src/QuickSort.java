// Java program for implementation of QuickSort 
public class QuickSort {
	/*
	 * Select the first item of the partition as the pivot. Treat partitions of size
	 * one and two as stopping cases.
	 * 
	 * WORKS
	 */
	public int firstPartition(int arr[], int low, int high) {
		int pivot = arr[low];
		int i = (high + 1); // index of larger element
		for (int j = high; j > low; j--) {
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] >= pivot) {
				i--;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i-1] and arr[low] (or *pivot*)
		int temp = arr[i - 1];
		arr[i - 1] = arr[low];
		arr[low] = temp;

		return i - 1;
	}

	public int oneHundPart(int arr[], int low, int high) {
		int pivot = arr[low];
		int i = (high + 1);
		for (int j = high; j > low; j--) {
			if (i >= j - 99) {
				return i - 1;
			}
			// If current element is smaller than or
			// equal to pivot
			else if (arr[j] >= pivot) {
				i--;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i - 1];
		arr[i - 1] = arr[low];
		arr[low] = temp;

		return i - 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	public void sort(int arr[], int low, int high, int sortKind) {
		if (low < high && sortKind == 0) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = firstPartition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1, 0);
			sort(arr, pi + 1, high, 0);
		}
		else if(low < high && sortKind == 1) {
			int pi = oneHundPart(arr, low, high);
			
			sort(arr, low, pi - 1, 1);
			sort(arr, pi + 1, high, 1);
		}
	}

	/* A utility function to print array of size n */
	public static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
/* This code is contributed by Rajat Mishra */