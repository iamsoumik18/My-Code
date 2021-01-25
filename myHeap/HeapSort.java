package myHeap;

public class HeapSort {
	
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
	
	public void sort(int a[]) {
		for(int i = (a.length/2)-1; i>=0; i--)
			maxHeapify(a,a.length,i);
		
		for(int i = a.length-1; i>0; i--) {
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			maxHeapify(a,i,0);
		}
	}

}
