package _0403;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B11404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int[][]arr=new int[n][n];
		int INF=9999999;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++){
				if(i!=j&&arr[i][j]==0)arr[i][j]=INF;
			}
		}
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			arr[s][e]=Math.min(arr[s][e], w);
		}
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		for(int[]a:arr) {
			for(int i:a) {
				if(i==INF)i=0;
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
