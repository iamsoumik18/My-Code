package myHeap;

public class BuildHeap {

	private void maxHeapify(int a[], int n, int i) {
		
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if(left<n && a[left]>a[largest])
			largest = left;
		
		if(right<n && a[right]>a[largest])
			largest = right;
		
		if(largest!=i) {
			int temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;
			maxHeapify(a,n,largest);
		}
		
	}
	
	public void buildHeap(int a[]) {
		for(int i = (a.length/2) -1; i>=0; i--)
			maxHeapify(a, a.length, i);
	}
	
	public void printHeap(int a[]) {
		System.out.print("Array representation of heap: ");
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}

}
