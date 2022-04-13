package _0413;

import java.io.*;
import java.util.*;
// bfs
public class Main_B9205_맥주_마시면서_걸어가기 {
	static int home[],store[][],fes[],n;
	static boolean bfs() {
		boolean[]visited=new boolean[n];
		Queue<int[]>q=new LinkedList<>();
		q.add(home);
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			int x=temp[0],y=temp[1];
			//현 위치에서 페스티벌까지 이동가능하면 true리턴
			if(Math.abs(x-fes[0])+Math.abs(y-fes[1])<=1000)return true;
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					int nx=store[i][0];
					int ny=store[i][1];
					//아직 방문하지 않은 편의점이 현 위치에서 방문 가능하면 편의점으로 이동
					if(Math.abs(x-nx)+Math.abs(y-ny)<=1000) {
						q.add(new int[] {nx,ny});
						visited[i]=true;
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0) {
			n=Integer.parseInt(br.readLine());
			home=new int[2];
			fes=new int[2];
			StringTokenizer st =new StringTokenizer(br.readLine());
			home[0]=Integer.parseInt(st.nextToken());
			home[1]=Integer.parseInt(st.nextToken());
			store=new int[n][2];
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				store[i][0]=Integer.parseInt(st.nextToken());
				store[i][1]=Integer.parseInt(st.nextToken());
			}
			st =new StringTokenizer(br.readLine());
			fes[0]=Integer.parseInt(st.nextToken());
			fes[1]=Integer.parseInt(st.nextToken());
			if(bfs())System.out.println("happy");
			else System.out.println("sad");
		}
	}
}
