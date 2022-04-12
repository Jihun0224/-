import java.io.*;
import java.util.*;

public class SWEA달리기 {
	static long dp[],player[];
	static int N;
	static long dfs(int cur) {
		if(cur==(1<<N+1)-2) return 1;
		if(dp[cur]>0)return dp[cur];
		for(int i=1;i<=N;i++) {
			if((cur&1<<i)==0&&(cur&player[i])==player[i]) {
				dp[cur]+=dfs(cur|1<<i);
			}
		}
		return dp[cur];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			player=new long[N+1];
			dp=new long[1<<(N+1)];
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken());
				player[y]=player[y]|1<<x;
			}
			System.out.println("#"+t+" "+dfs(0));
		}
	}
}