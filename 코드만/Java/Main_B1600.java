import java.io.*;
import java.util.*;
//백준 1600 말이 되고픈 원숭이
public class Main_B1600 {
	static int k,w,h,map[][];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static int[]dx2= {2,2,1,1,-2,-2,-1,-1};
	static int[]dy2= {1,-1,-2,2,1,-1,2,-2};
	static boolean[][][]visited;
	static int bfs() {
		Queue<int[]>q=new LinkedList<int[]>();
		q.add(new int[] {0,0,k,0});
		visited[0][0][k]=true;
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			int x=temp[0];
			int y=temp[1];
			int k=temp[2];
			int c=temp[3];
			if(x==h-1&&y==w-1)return c;
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0&&nx<h&&ny>=0&&ny<w&&!visited[nx][ny][k]&&map[nx][ny]!=1) {
					visited[nx][ny][k]=true;
					q.add(new int[] {nx,ny,k,c+1});
				}
			}
			if(k>0) {
				for(int i=0;i<8;i++) {
					int nx=x+dx2[i];
					int ny=y+dy2[i];
					if(nx>=0&&nx<h&&ny>=0&&ny<w&&!visited[nx][ny][k-1]&&map[nx][ny]!=1) {
						visited[nx][ny][k-1]=true;
						q.add(new int[] {nx,ny,k-1,c+1});
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k=Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		w=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());
		map=new int[h][w];
		visited=new boolean[h][w][k+1];
		for(int i=0;i<h;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}
}