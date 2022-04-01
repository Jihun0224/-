package _0401;

import java.io.*;
import java.util.*;
//백준 1194 달이 차오른다, 가자 -> bfs
public class Main_B1194 {
	static class Point{
		int x,y,cnt;
		boolean[] keys;
		Point(int x,int y,int cnt, boolean[] keys){
			this.x=x;
			this.y=y;
			this.cnt=cnt;
			this.keys=keys;
		}
	}
	
	static int n,m;
	static char map[][];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static int covert(boolean[]c) {
		int result=0;
		for(int i=0;i<6;i++) {
			if(c[i])
				result+=(int)Math.pow(2, i);
		}
		return result;
	}
	static int bfs(int x,int y) {
		Queue<Point>q=new LinkedList<>();
		Point p = new Point(x,y,0,new boolean[6]);
		q.offer(p);
		boolean[][][]visited=new boolean[n][m][64];
		visited[x][y][0]=true;
		int cnt;
		boolean[] key;
		while(!q.isEmpty()) {
			p=q.poll();
			x=p.x;
			y=p.y;
			cnt=p.cnt;
			key=p.keys;
			if(map[x][y]=='1')return cnt;
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]!='#'&&!visited[nx][ny][covert(key)]) {
					boolean temp[]=new boolean[6];
					System.arraycopy(key, 0, temp, 0, 6);
					if(map[nx][ny]>='a'&&map[nx][ny]<='f') {
						temp[(int)map[nx][ny]-97]=true;
						q.add(new Point(nx,ny,cnt+1,temp));
					}
					else if(map[nx][ny]>='A'&&map[nx][ny]<='F') {
						if(key[(int)map[nx][ny]-65]) {
							q.add(new Point(nx,ny,cnt+1,temp));
						}
					}
					else{
						q.add(new Point(nx,ny,cnt+1,temp));
					}
					visited[nx][ny][covert(temp)]=true;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		int[]curP= {0,0}; 
		map=new char[n][m];
		for(int i=0;i<n;i++) {
			char[]temp=br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				map[i][j]=temp[j];
				if(map[i][j]=='0') {
					curP[0]=i;
					curP[1]=j;
				}
			}
		}
		System.out.println(bfs(curP[0],curP[1]));
		
	}
}
