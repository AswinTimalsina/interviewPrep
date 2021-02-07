import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
// n = number of elements in an array    10^7
// m = number of operations             2*10^5
// a = left index                       10^7
// b = right index                      10^7
// k = summand                          10^9

    long[] result = new long[n+1];
    int numOfOperations = queries.length;
    long max = Long.MIN_VALUE;
    int flag = 0;
        long Pnew = 0;
        long neW = 0;
    // long Nmax = long.MIN_VALUE;
    
    for(int i =0; i<numOfOperations; i++){
        
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            
            
            result[a-1]+= k;
            if(b<=n){
                result[b]+= (-k);
            }
            
        
    }
    
    for(int i=0; i<result.length; i++){
        
        if((i+1)<result.length){
            if(flag ==0){
                Pnew = result[i];
                neW = Pnew + result[i+1];
                max = Math.max(Pnew, neW);
                Pnew = neW;
                flag =1;
            }
            else{
                neW = Pnew + result[i+1];
                max = Math.max(max, neW);
                Pnew = neW;
            }
            
        
        }
        
    }
    
    
    
   return max;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
