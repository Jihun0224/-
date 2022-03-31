import java.util.*;
//dp
public class Main_B1463_1로만들기 {
	public static void main(String[] args) {
		int n=new Scanner(System.in).nextInt(),dp[]=new int[n+1];
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+1;
			dp[i]=i%2==0?Math.min(dp[i],dp[i/2]+1):dp[i];
			dp[i]=i%3==0?Math.min(dp[i],dp[i/3]+1):dp[i];
		}
		System.out.println(dp[n]);
	}
}
//bfs
//import java.util.*;
//public class Main {
//	public static void main(String[] args) {
//		int n=new Scanner(System.in).nextInt();
//		int[] count=new int[n+1];
//		Queue<Integer>q=new LinkedList<>();
//		q.add(n);
//		while(true) {
//			n=q.poll();
//			if(n==1) {
//				System.out.println(count[1]);
//				break;
//			}
//			if(n%3==0&&count[n/3]==0) {
//				q.add(n/3);
//				count[n/3]=count[n]+1;
//			}
//			if(n%2==0&&count[n/2]==0) {
//				q.add(n/2);
//				count[n/2]=count[n]+1;
//			}
//			if(n>2&&count[n-1]==0) {
//				q.add(n-1);
//				count[n-1]=count[n]+1;
//			}
//		}
//	}
//}