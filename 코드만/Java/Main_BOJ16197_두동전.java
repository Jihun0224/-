import java.io.*;
import java.util.*;

public class Main_BOJ16197_두동전 {
	static int N,M,coin1X,coin1Y,coin2X,coin2Y;
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static char[][]map;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		coin1X=coin1Y=coin2X=coin2Y=-1;
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='o') {
					if(coin1X==-1&&coin1Y==-1) {
						coin1X=i;
						coin1Y=j;
					}else {
						coin2X=i;
						coin2Y=j;
					}
				}
			}
		}
		System.out.print(bfs());
	}
	static int bfs() {
		Queue<int[]>q=new LinkedList<>();
		q.add(new int[] {coin1X,coin1Y,coin2X,coin2Y});
		boolean[][][][]visited=new boolean[N][M][N][M];
		visited[coin1X][coin1Y][coin2X][coin2Y]=true;
		int depth=0;
		while(!q.isEmpty()) {
			int s=q.size();
			if(++depth>10)break;
			for(int k=0;k<s;k++) {
				int[]now = q.poll();
				int x1 = now[0];
				int y1 = now[1];
				int x2 = now[2];
				int y2 = now[3];
				for(int i=0;i<4;i++) {
					int nx1=x1+dx[i];
					int ny1=y1+dy[i];
					int nx2=x2+dx[i];
					int ny2=y2+dy[i];
					int result1=check(nx1,ny1);
					int result2=check(nx2,ny2);
					if((result1>=0&&result2==-1)||(result1==-1&&result2>=0))return depth;
					if((result1==-1&&result2==-1)||(result1==0&&result2==0))continue;
					if((result1==1&&result2==1)&&(!visited[nx1][ny1][nx2][ny2])) {
						visited[nx1][ny1][nx2][ny2]=true;
						q.add(new int[] {nx1,ny1,nx2,ny2});
					}else if((result1==1&&result2==0)&&(!visited[nx1][ny1][x2][y2])) {
						visited[nx1][ny1][x2][y2]=true;
						q.add(new int[] {nx1,ny1,x2,y2});
					}else if((result1==0&&result2==1)&&(!visited[x1][y1][nx2][ny2])) {
						visited[x1][y1][nx2][ny2]=true;
						q.add(new int[] {x1,y1,nx2,ny2});
					}
				}
			}
		}
		return -1;
	}
	static int check(int x,int y) {
		if(x<0||y<0||x>=N||y>=M)return -1;
		if(map[x][y]=='#')return 0;
		return 1;
	}
}