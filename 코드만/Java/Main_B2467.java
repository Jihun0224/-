import java.io.*;
import java.util.*;

//백준 2467 용액
public class Main_B2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[]arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)arr[i]=Long.parseLong(st.nextToken());
		Arrays.sort(arr);
		int start=0,end=n-1;
		long min=Long.MAX_VALUE;;
		long[]answer=new long[2];
		while(start<end) {
			long cur=arr[start]+arr[end];
			if(min>Math.abs(cur)) {
				min=Math.abs(cur);
				answer= new long[]{arr[start],arr[end]};
			}
			if(cur>0)end--;
			else if(cur<0)start++;
			else break;
		}
		for(long i:answer) {
			System.out.print(i+" ");
		}
	}
}
