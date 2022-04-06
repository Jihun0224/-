package _0406;

import java.io.*;
import java.util.StringTokenizer;
//플로이드–와샬
public class SWEA5643_키순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			int answer=0;
			boolean[][]arr=new boolean[n][n];
			for(int i=0;i<n;i++)arr[i][i]=true;
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken())-1;
				int b=Integer.parseInt(st.nextToken())-1;
				arr[a][b]=true;
			}
			for(int k=0;k<n;k++) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						//k를 통해서라도 비교가능 하면 true;
						if(arr[i][k]&&arr[k][j])arr[i][j]=true;
					}
				}
			}
			for(int i=0;i<n;i++) {
				boolean flag=true;
				for(int j=0;j<n;j++) {
					//둘 다 연결이 안 된 경우 정보를 알 수 없음
					if(!arr[i][j]&&!arr[j][i]) {
						flag=false;
						break;
					}
				}
				if(flag)answer++;
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}
