import java.util.*;
public class Main_B14501 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),a=0;
		int t[]=new int[16],p[]=new int[16],dp[]=new int[16];
		for(int i=1;i<=n;i++){
			t[i]=sc.nextInt();
			p[i]=sc.nextInt();
			if(t[i]+i-1>n)continue;
			for(int j=0;j<i;j++)
				if(t[j]+j<=i)dp[i]=Math.max(dp[i],dp[j]+p[i]);
			a=Math.max(a, dp[i]);
		}
		System.out.println(a);
	}
}