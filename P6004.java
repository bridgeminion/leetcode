public class P6004 {

    public int countOperations(int num1, int num2) {
        int ans = 0;
        if (num2 > num1){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        while (num2 != 0){
            int dif = num1-num2;
            num1 = num2;
            num2 = dif;
            ans++;
            if (num2 > num1){
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
        }
        return ans;
    }
}
