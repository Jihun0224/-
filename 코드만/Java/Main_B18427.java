import java.io.*;
import java.util.StringTokenizer;

//백준 18427 함께 블록 쌓기 -> DP
public class Main_B18427 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		int h =Integer.parseInt(st.nextToken());
		int[][]dp=new int[n+1][h+1];
		int[][]arr=new int[n+1][m];
		int temp=0,j;
		for(int i=1;i<=n;i++){
			st = new StringTokenizer(br.readLine());
			j=0;
			while(st.hasMoreTokens()){
				temp=Integer.parseInt(st.nextToken());
				if(temp>h)continue;
				arr[i][j++]=temp;
			}
		}
		//i명이 0을 쌓는 경우를 1로 초기화
		for(int i=0;i<=n;i++)dp[i][0]=1;
		
		for(int i=1;i<=n;i++) {
			for(j=1;j<=h;j++) {
				for(int l=0;l<m;l++) {
					//i명이 j의 무게를 쌓는 것은 (i-1명이 j-현재 쌓으려는 블럭의 무게)를 쌓는 경우와 같음
					if(arr[i][l]!=0&&j-arr[i][l]>=0) {
						dp[i][j]+=dp[i-1][j-arr[i][l]];
						dp[i][j]%=10007;
					}
				}
				//i차례에 블럭을 쌓지 않는 경우
				dp[i][j]+=dp[i-1][j];
				dp[i][j]%=10007;
			}
		}
		System.out.println(dp[n][h]);
	}
}
