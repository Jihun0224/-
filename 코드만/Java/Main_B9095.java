import java.util.Scanner;
//백준 9095 1,2,3 더하기
public class Main_B9095 {
	static int[]dp=new int[11];
	static int f(int x) {
		if(dp[x]!=0) {
			return dp[x];
		}
		return dp[x]=f(x-3)+f(x-2)+f(x-1);
	}
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int T=sc.nextInt();
		 dp[1]=1;dp[2]=2;dp[3]=4;
		 for(int t=0;t<T;t++) {
			 System.out.println(f(sc.nextInt()));
		 }
	}
}