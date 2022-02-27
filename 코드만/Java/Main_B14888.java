import java.io.*;
import java.util.*;

public class Main_B14888 {
    static int MIN=Integer.MAX_VALUE,MAX=Integer.MIN_VALUE,N;
    static int[]A = new int[12];
    static int[]op = new int[4];
    
    static void search(int depth, int sum) {
        if (depth==N) {
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }
        
        for (int i=0;i<4;i++) {
            if (op[i]>0) {
                op[i]--;
                if (i==0)search(depth+1,sum+A[depth]);
                else if(i==1)search(depth+1,sum-A[depth]);
                else if (i==2)search(depth+1,sum*A[depth]);
                else search(depth+1,sum/A[depth]);
                op[i]++;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<4;i++)
            op[i] = Integer.parseInt(st.nextToken());
        search(1,A[0]);
        bw.write(MAX+"\n"+MIN);
        bw.flush();
    }
}