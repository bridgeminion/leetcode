public class P304_2 {

    class NumMatrix {

        int[][] prefix;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            prefix = new int[n+1][m+1];
            // prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + arr[i-1][j-1]
            for (int i=1; i <= n; i++){
                for (int j=1; j <= m; j++){
                    prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) { // 0-based
//            return prefix[row2][col2] - prefix[row2][col1-1] - prefix[row1-1][col2] + prefix[row1-1][col1-1]; // assuming 1-based
            row1++;
            col1++;
            row2++;
            col2++;
            return prefix[row2][col2] - prefix[row2][col1-1] - prefix[row1-1][col2] + prefix[row1-1][col1-1]; // assuming 1-based
        }
    }
}
