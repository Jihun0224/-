package _0412;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_5604_구간합 {
	static long cnt[],point;
	static void cal(long x) {
	    while(x>0) {
	    	cnt[(int)(x%10)]+=point;
	        x/=10;
	    }
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			cnt=new long[10];
			StringTokenizer st=new StringTokenizer(br.readLine());
			long A=Long.parseLong(st.nextToken());
			long B=Long.parseLong(st.nextToken());
			point=1;
			if(A==0)A=1;
			while(A<=B) {
				while(B%10!=9&&A<=B) {
					cal(B);
					B--;
				}
				if(B<A)break;
				while(A%10!=0&&A<=B) {
					cal(A);
					A++;
				}
				A/=10;B/=10;
				for(int i=0;i<10;i++)cnt[i]+=(B-A+1)*point;
				point*=10;
			}
			long result=0;
			for(int i=1;i<10;i++)result+=(i*cnt[i]);
			System.out.println("#"+t+" "+result);
		}
	}
}