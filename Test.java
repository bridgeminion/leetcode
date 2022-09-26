import java.io.*;

public class Test {

    int binarySearch(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int m = (low + high)/2;
            if (arr[m] == x){
                return m;
            }
            if (arr[m] < x){
                low = m + 1;
            }
            else {
                high = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    }

}
