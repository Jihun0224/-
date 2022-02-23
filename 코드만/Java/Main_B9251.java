import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[]arr1=br.readLine().toCharArray();
		char[]arr2=br.readLine().toCharArray();
		int[][]dp = new int[arr1.length+1][arr2.length+1];
		
		for(int i=1,size1=arr1.length;i<=size1;i++) {
			for(int j=1,size2=arr2.length;j<=size2;j++) {
				if(arr1[i-1]==arr2[j-1])
					dp[i][j]=dp[i-1][j-1]+1;
				else 
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		int answer=0;
		for(int[]a:dp) {
			for(int n:a) {
				answer=answer>n?answer:n;
			}
		}
		System.out.println(answer);
	}
}
