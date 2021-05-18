package placePractice1;

import java.io.*;

//Dutch National Flag Algorithm

public class SortColors {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				String s1[] = br.readLine().split(" ");
				int nums[] = new int[n];
				for(int i=0; i<n; i++) {
					nums[i] = Integer.parseInt(s1[i]);
				}
				sortColors(nums);
				for(int num: nums) {
					bw.write(num+" ");
					bw.flush();
				}
				bw.write("\n");
				bw.flush();
			}
		}catch(Exception e) {
			return;
		}

	}
	
	static void sortColors(int nums[]) {
		int low = 0;
		int mid = 0;
		int high = nums.length-1;
		
		while(mid<=high) {
			switch(nums[mid]){
				case 0:{
					int temp = nums[mid];
					nums[mid] = nums[low];
					nums[low] = temp;
					low++;
					mid++;
					break;
				}
				case 1:{
					mid++;
					break;
				}
				case 2:{
					int temp = nums[mid];
					nums[mid] = nums[high];
					nums[high] = temp;
					high--;
					break;
				}
			}
		}
	}

}
