package _0408;

import java.io.*;
import java.util.StringTokenizer;
//구현 문제
public class SWEA4014_활주로_건설 {
	static int n,x;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int answer=0;
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			x=Integer.parseInt(st.nextToken());
			int[][]map=new int[n][n];
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<n;i++) {
				int[]temp1=new int[n];
				int[]temp2=new int[n];
				for(int j=0;j<n;j++) {
					temp1[j]=map[i][j];
					temp2[j]=map[j][i];
				}
				if(check(temp1))answer++;
				if(check(temp2))answer++;
			}
			
			sb.append("#"+t+" "+answer+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	static boolean check(int[]arr) {
		int cnt=1;
		for(int i=1;i<n;i++) {
			//뒤의 높이와 같음
			if(arr[i]==arr[i-1])cnt++;
			//오르막에 경사로 설치
			else if(arr[i]-arr[i-1]==1&&cnt>=x)cnt=1;
			//내리막에 경사로 설치
			else if(arr[i-1]-arr[i]==1&&cnt>=0)cnt=-x+1;
			//높이 2이상 차이  or 계단이 형성된 경우
			else return false;
		}
		if(cnt>=0)return true;
		return false;
	}
}
