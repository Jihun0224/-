import java.io.*;
public class Solution_SWEA5603 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int arr[],sum=0,avg,diff=0;
			int n=Integer.parseInt(br.readLine());
			arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(br.readLine());
				sum+=arr[i];
			}
			avg=sum/n;
			for(int i=0;i<n;i++)diff+=Math.abs(avg-arr[i]);
			sb.append("#"+t+" "+diff/2+"\n");
		}
		System.out.println(sb.toString());
	}
}
