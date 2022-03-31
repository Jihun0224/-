import java.io.*;
import java.util.StringTokenizer;

public class Main_B1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		int[][]color=new int[n][3];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				color[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int[][]dp=new int[n+1][3];
		for(int i=1;i<=n;i++) {
			dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+color[i-1][0];
			dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+color[i-1][1];
			dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+color[i-1][2];
		}
		int a=Integer.MAX_VALUE;
		for(int i=0;i<3;i++)a=dp[n][i]<a?dp[n][i]:a;
		System.out.println(a);
	}
}
