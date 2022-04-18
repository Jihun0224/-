package _0418;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B1956 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v=Integer.parseInt(st.nextToken());
		int e=Integer.parseInt(st.nextToken());
		int INF=999999999;
		int[][]arr=new int[v][v];
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				arr[i][j]=INF;
			}
		}
		while(e-->0){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken());
			arr[a][b]=Math.min(arr[a][b], c);
		}
		for(int k=0;k<v;k++) {
			for(int i=0;i<v;i++) {
				for(int j=0;j<v;j++) {
					arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		int answer=INF;
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				if(arr[i][j]!=INF&&arr[j][i]!=INF)answer=Math.min(answer, arr[i][j]+arr[j][i]);
			}
		}
		if(answer==INF)System.out.println(-1);
		else System.out.println(answer);
	}
}
