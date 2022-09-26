public class P85 {

    public boolean check (int r, int start, int end, int[][] prefix){
        return prefix[r][end+1]-prefix[r][start] == end-start+1;
    }

    public int solve (int rows, int start, int end, int[][] prefix){
        int w = end-start+1;
        int max = 0;
        int cur = 0;
        for (int i=0; i < rows; i++){
            if (check (i, start, end, prefix)){
                cur++;
            }
            else {
                cur = 0;
            }
            max = Math.max(max, cur);
        }
        return max*w;
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] prefix = new int[rows][cols+1];
        for (int i=0; i < rows; i++){
            for (int j=0; j < cols; j++){
                int val = matrix[i][j] - '0';
                prefix[i][j+1] = prefix[i][j] + val;
            }
        }
        int ans = 0;
        for (int i=0; i < cols; i++){
            for (int j=i; j < cols; j++){
                ans = Math.max(ans, solve (rows, i, j, prefix));
            }
        }
        return ans;
    }
}
