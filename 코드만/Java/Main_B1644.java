import java.util.*;
//백준 1644 소수의 연속합
public class Main_B1644 {
	static boolean isPrime(int x){
		if(x==1)return false;
		for(int i=2;i<(int)Math.sqrt(x)+1;i++) 
			if(x%i==0)return false;
		return true;
	}
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		List<Integer>list = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			if(isPrime(i))list.add(i);
		}
		int start=0,end=0,len=list.size(),answer=0,sum=0;
		if(len!=0){
			while(end<len) {
				if(sum>=n) {
					if(sum==n)answer++;
					sum-=list.get(start++);
				}
				else sum+=list.get(end++);
			}
			if(list.get(end-1)==n)answer++;
		}
		System.out.println(answer);
	}
}
