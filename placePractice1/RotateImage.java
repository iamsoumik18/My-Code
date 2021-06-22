package placePractice1;

import java.io.*;

public class RotateImage {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int n = Integer.parseInt(br.readLine());
				int matrix[][] = new int[n][n];
				for(int i=0; i<n; i++) {
					String s1[] = br.readLine().split(" ");
					for(int j=0; j<n; j++) {
						matrix[i][j] = Integer.parseInt(s1[j]);
					}
				}
				solution(matrix);
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						bw.write(matrix[i][j]+" ");
					}
					bw.write("\n");
				}
			}
			bw.flush();
		}catch(Exception e) {
			return;
		}

	}
	
	static void solution(int matrix[][]) {
		
		//transpose matrix in-place
		for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
		
		//reverse every row of matrix
		for(int r=0; r<matrix.length; r++){
            int i = 0; 
            int j = matrix[r].length - 1;
            while(i<j){
                int temp = matrix[r][i];
                matrix[r][i] = matrix[r][j];
                matrix[r][j] = temp;
                i++;
                j--;
            }
        }
		
	}
	
}
