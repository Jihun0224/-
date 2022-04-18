package _0418;
import java.io.*;
import java.util.*;
public class Main_B10971 {
	static int n,arr[][],dp[][],answer,MAX=999999999;
	static int TSP(int state,int now) {
		state|=(1<<now);
		if(dp[state][now]>0)return dp[state][now];
		if(state==(1<<n)-1) {
			if(arr[now][0]==0)return MAX;
			return arr[now][0];
		}
		dp[state][now]=MAX;
		for(int i=0;i<n;i++) {
			if((state&(1<<i))==0&&arr[now][i]>0)
				dp[state][now]=Math.min(TSP(state,i)+arr[now][i],dp[state][now]);
		}
		return dp[state][now];
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		dp=new int[1<<n][n];
		answer=MAX;
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(TSP(0,0));
	}
}
