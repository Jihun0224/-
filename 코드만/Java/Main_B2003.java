package _0423;
import java.util.*;
public class Main_B2003 {
	public static void main(String[]t) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt(),a=0,arr[]=new int[n],s=0,e=0,sum=0;
		for(int i=0;i<n;i++)arr[i]=sc.nextInt();
		sum=arr[s];
		while(e<n) {
			if(sum==m) a++;
			if(sum<m&&++e<n)sum+=arr[e];
			else if(sum>=m) {
				sum-=arr[s++];
				if(s>e&&++e<n)sum+=arr[e];
			}
		}
		System.out.println(a);
	}
}

