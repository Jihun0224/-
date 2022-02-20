import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1182 {
	static int[]arr;
	static int N,S,answer=0;
	
	static void search(int depth,int sum,boolean empty) {
		if(depth==N) {
			if(S==sum&&!empty) answer++;
			return;
		}
		search(depth+1,sum+arr[depth],false);
		search(depth+1,sum,empty);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		search(0, 0, true);
		System.out.println(answer);
	}
}
