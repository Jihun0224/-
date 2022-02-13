package Beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11123 {
	static char[][]map;
	static int w,h;
	static int[][] visited;
	static int count;
	static int[][]d= {{1,0},{0,1},{0,-1},{-1,0}};
	static boolean boundCheck(int i, int j) {
		if(i>=0&&i<h&&j>=0&&j<w) 
			return true;
		else
			return false;
	}
	static void dfs(int i,int j) {
		int dx,dy;
		for(int k=0;k<4;k++) {
			dx=i+d[k][0];
			dy=j+d[k][1];
			if(boundCheck(dx, dy)&&map[dx][dy]=='#'&&visited[dx][dy]==0) {
				visited[dx][dy]=1;
				dfs(dx,dy);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		String[] temp;
		for(int t=0;t<test;t++){
			temp=br.readLine().split(" ");
			h=Integer.parseInt(temp[0]);
			w= Integer.parseInt(temp[1]);
			
			map=new char[h][w];
			visited=new int[h][w];
			count=0;
			for(int i=0;i<h;i++) {
				map[i]=br.readLine().toCharArray();
	
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]=='#'&&visited[i][j]==0) {
						dfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}