import java.io.File;

// Java program for implementation of QuickSort
public class QuickSort {
	/*
	 * Select the first item of the partition as the pivot. Treat partitions of
	 * size one and two as stopping cases.
	 * 
	 * WORKS
	 */
	/**
	 * "Select the first item of the partition as the pivot. Treat partitions of
	 * size one and two as stopping cases."
	 * 
	 * @param arr Array being sorted
	 * @param low Low index of array/partition
	 * @param high High index of array/partition
	 * @return Pivot index
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

	/**
	 * "Select the first item of the partition as the pivot. Treat a partition
	 * of size 100 as a stopping case. Use an insertion sort to finish."
	 * 
	 * @param arr Array to be sorted
	 * @param low Lowest index of array/partition
	 * @param high Highest index of array/partition
	 * @return Pivot index
	 */
	public int oneHundPart(int arr[], int low, int high) {
		int pivot = arr[low];
		int i = (high + 1);
		for (int j = high; j > low; j--) {
			if (high - low <= 100) {
				InsertionSort iS = new InsertionSort();
				arr = iS.sort(arr);
				break;
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

	/**
	 * "Select the first item of the partition as the pivot. Treat a partition
	 * of size 50 as a stopping case. Use an insertion sort to finish."
	 * 
	 * @param arr Array to be sorted
	 * @param low Lowest index of array/partition
	 * @param high Highest index of array/partition
	 * @return Pivot index
	 */
	public int fiddyPart(int arr[], int low, int high) {
		int pivot = arr[low];
		int i = (high + 1);
		for (int j = high; j > low; j--) {
			if (high - low <= 50) {
				InsertionSort iS = new InsertionSort();
				arr = iS.sort(arr);
				break;
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
	 * The main function that implements QuickSort() arr[] --> Array to be
	 * sorted, low --> Starting index, high --> Ending index
	 */
	public void sort(int arr[], int low, int high, int sortKind) {
		// QuickSort type 1; Pivot at first element, stopping case partitions of
		// 1 and 2
		if (low < high && sortKind == 0) {
			int pi = firstPartition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1, 0);
			sort(arr, pi + 1, high, 0);
		}
		// Quicksort type 2: stop at partitions of 100, then do insertion sort
		else if (low < high && sortKind == 1) {
			int pi = oneHundPart(arr, low, high);
			if (100 - pi >= 100) {
				sort(arr, low, pi - 1, 1);
				sort(arr, pi + 1, high, 1);
			}

		}
		// Quicksort type 3: stop at partitions of 50, then do insertion sort
		else if (low < high && sortKind == 2) {
			int pi = fiddyPart(arr, low, high);
			if (100 - pi >= 100) {
				sort(arr, low, pi - 1, 1);
				sort(arr, pi + 1, high, 1);
			}
		}
	}

	/* A utility function to print array of size n */
	public void printArray(int arr[], String fileArr, int sortType) {
		int n = arr.length;
		if (sortType == 0) {
			System.out.println("QuickSort Standard");
		} else if (sortType == 1) {
			System.out.println("QuickSort 100");
		} else if (sortType == 2) {
			System.out.println("QuickSort 50");
		}
		System.out.print("Name of data file: " + fileArr + "\n");
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
/* This code is contributed by Rajat Mishra */