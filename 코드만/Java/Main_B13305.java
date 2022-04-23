package _0423;

import java.util.*;
public class Main_B13305 {
	public static void main(String[]s){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long d[]=new long[n-1],temp=1000000001,a=0;
		for(int i=0;i<n-1;i++)d[i]=sc.nextLong();
		for(int i=0;i<n-1;i++) {
			temp=Math.min(temp,sc.nextLong());
			a+=(temp*d[i]);
		}
		System.out.println(a);
	}
}