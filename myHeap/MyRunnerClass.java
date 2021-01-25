package myHeap;

public class MyRunnerClass {

	public static void main(String[] args) throws Exception{
		
		int a[] = {2,8,5,9,4,3,1,6,78,25,46};
		
		HeapSort ob = new HeapSort();
		ob.sort(a);
		
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
		

	}

}
