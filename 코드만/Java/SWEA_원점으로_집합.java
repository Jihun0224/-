package _0411;

import java.io.*;
import java.util.StringTokenizer;
//2차원을 1차원으로 바꿔서 생각
public class SWEA_원점으로_집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int n=Integer.parseInt(br.readLine());
			boolean pos=true;
			int[]arr=new int[n];
			int max=0,index=-1;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				arr[i]=Math.abs(x)+Math.abs(y);
				max=Math.max(max, arr[i]);
			}
			//좌표의 절댓값 합이 모두 홀수이거나 모두 짝수가 아닐때는 불가능
			for(int i=1;i<n;i++) {
				if(arr[i-1]%2!=arr[i]%2) {
					pos=false;
					break;
				}
			}
			
			if(pos) {
				int sum=0;
				index=0;
				while(true) {
					//누적합이 max보다 크고 누적합과 max값이 홀수나 짝수로 같은 때 종료
					if(sum>=max&&sum%2==max%2)break;
					sum+=++index;
				}
			}
			sb.append("#"+t+" "+index+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
