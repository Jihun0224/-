import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//3234. 준환이의 양팔저울
public class SWEA3234 {
 
    static int N, answer, arr[], order[];
    static boolean visited[];
    static void permutation(int depth) {
        if(depth==N) {
            check(0,0,0);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]) { 
            	  visited[i] = true;
            	  order[depth] = arr[i];
                  permutation(depth+1);
                  visited[i] = false;
            }
        }
    }
    static void check(int depth,int sumL,int sumR) {
        if(depth==N) {
        	answer++;
            return;
        }
        check(depth+1, sumL+order[depth],sumR);
        if(sumR+order[depth]<=sumL)
            check(depth+1,sumL,sumR+order[depth]);
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t=1;t<=T;t++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            order = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            visited=new boolean[N];
            permutation(0);
            sb.append("#"+t+" "+answer+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

}
