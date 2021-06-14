package placePractice1;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void solution(int[][] matrix) {
		boolean col = false;
		int rows = matrix.length, cols = matrix[0].length;
		
		for(int i=0; i<rows; i++) {
			if(matrix[i][0]==0)
				col = true;
			for(int j=1; j<cols; j++) {
				if(matrix[i][j]==0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i=rows-1; i>=0; i--) {
			for(int j=cols-1; j>0; j--) {
				if(matrix[i][0]==0 || matrix[0][j]==0) {
					matrix[i][j] = 0;
				}
			}
			if(col)
				matrix[i][0] = 0;
		}
	}

}
