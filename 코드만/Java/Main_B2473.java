import java.io.*;
import java.util.*;

//백준 2473. 세 용액
public class Main_B2473 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[]arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)arr[i]=Long.parseLong(st.nextToken());
		Arrays.sort(arr);
		int start,end;
		long a;
		long[]answer=new long[3];
		long min=Long.MAX_VALUE;
		for(int l=0;l<n-2;l++) {
			a=arr[l];
			start=l+1;
			end=n-1;
			while(start<end) {
				long cur=arr[start]+a+arr[end];
				if(min>Math.abs(cur)) {
					min=Math.abs(cur);
					answer= new long[]{a,arr[start],arr[end]};
				}
				if(cur>0)end--;
				else if(cur<0)start++;
				else break;
			}
			if(min==0)break;
		}
		for(long i:answer) {
			System.out.print(i+" ");
		}
	}
}