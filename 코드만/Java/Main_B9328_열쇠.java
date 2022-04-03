package _0402;

import java.io.*;
import java.util.*;

public class Main_B9328_열쇠 {
	static int n,m,a;
	static char map[][];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static boolean[][]visited;
	static boolean[]key;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			a=0;
			map=new char[n][m];
			key=new boolean[26];
			for(int i=0;i<n;i++)map[i]=br.readLine().toCharArray();
			
			char[] temp=br.readLine().toCharArray();
			if(temp[0]!='0') {
				for(char c:temp)key[c-'a']=true;
			}
			boolean flag=false;
			while(true) {
				flag=false;
				visited=new boolean[n][m];
				for(int i=0;i<m;i++) {
					flag=bfs(0,i);
					if(flag)break;
					flag=bfs(n-1,i);
					if(flag)break;
				}
				if(!flag) {
					for(int i=0;i<n;i++) {
						flag=bfs(i,0);
						if(flag)break;
						flag=bfs(i,m-1);
						if(flag)break;
					}
				}
				if(!flag)break;
			}
			System.out.println(a);
		}
	}

	static boolean bfs(int x,int y) {
		if(map[x][y]=='*'||visited[x][y])return false;
		if('a'<=map[x][y]&&map[x][y]<='z') {
			key[map[x][y]-'a']=true;
			map[x][y]='.';
			return true;
		}
		else if(map[x][y]=='$'){
			a++;
			map[x][y]='.';
		}
		else if(map[x][y]=='.'||key[map[x][y]-'A']){}
		else return false;
		Queue<int[]>q=new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		while(!q.isEmpty()) {
			int[]temp=q.poll();
			x=temp[0];y=temp[1];
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]!='*'&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					if(map[nx][ny]=='.') q.add(new int[] {nx,ny});
					else if(map[nx][ny]=='$') {
						a++;
						q.add(new int[] {nx,ny});
						map[nx][ny]='.';
					}
					else if('a'<=map[nx][ny]&&map[nx][ny]<='z') {
						key[map[nx][ny]-'a']=true;
						map[nx][ny]='.';
						return true;
					}
					else {
						if(key[map[nx][ny]-'A']) {
							q.add(new int[] {nx,ny});
							map[nx][ny]='.';
						}
					}

				}
			}
		}
		return false;
	}
}
