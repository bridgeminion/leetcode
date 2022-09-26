public class P794 {

    public int convert (char c){
        if (c == 'X'){
            return 1;
        }
        if (c == 'O'){
            return 2;
        }
        return 0;
    }

    public boolean same (int[] arr){
        return arr[0] == arr[1] && arr[1] == arr[2];
    }

    public boolean validTicTacToe(String[] board) {
        int[][] arr = new int[3][3];
        int c1 = 0;
        int c2 = 0;
        for (int i=0; i < 3; i++){
            for (int j=0; j < 3; j++){
                arr[i][j] = convert(board[i].charAt(j));
                if (arr[i][j] == 1) c1++;
                if (arr[i][j] == 2) c2++;
            }
        }
        System.out.println(c1 + " " + c2);
        if (c1 < c2 || c1-c2 >= 2) return false;
        int ax = 0;
        int ao = 0;
        for (int i=0; i < 3; i++){
            if (same (arr[i])){
                if (arr[i][0] == 1){
                    ax++;
                }
                if (arr[i][1] == 2){
                    ao++;
                }
            }
        }
        for (int i=0; i < 3; i++){
            if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]){
                if (arr[0][i] == 1) ax++;
                if (arr[0][i] == 2) ao++;
            }
        }
        if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]){
            if (arr[0][0] == 1) ax++;
            if (arr[0][0] == 2) ao++;
        }
        if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]){
            if (arr[1][1] == 1) ax++;
            if (arr[1][1] == 2) ao++;
        }
        if (ax > 0 && ao > 0) return false;
        if (ao > 0 && c1 > c2) return false;
        if (ax > 0 && c1 == c2) return false;
        return true;
    }
}
