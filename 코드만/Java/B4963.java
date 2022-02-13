package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4963 {
	static int[][]map;
	static int w,h;
	static int[][] visited;
	static int count;
	static int[][]d= {{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
	static boolean boundCheck(int i, int j) {
		if(i>=0&&i<h&&j>=0&&j<w) 
			return true;
		else
			return false;
	}
	static void search(int i,int j) {
		int dx,dy;
		for(int k=0;k<8;k++) {
			dx=i+d[k][0];
			dy=j+d[k][1];
			if(boundCheck(dx, dy)&&map[dx][dy]==1&&visited[dx][dy]==0) {
				visited[dx][dy]=1;
				search(dx,dy);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp;
		while(true) {
			temp=br.readLine().split(" ");
			w= Integer.parseInt(temp[0]);
			h=Integer.parseInt(temp[1]);
			if(w==0&&h==0) 
				break;
			else {
				map=new int[h][w];
				visited=new int[h][w];
				count=0;
				for(int i=0;i<h;i++) {
					temp=br.readLine().split(" ");
					for(int j=0;j<w;j++) {
						map[i][j]=Integer.parseInt(temp[j]);
					}
				}
				for(int i=0;i<h;i++) {
					for(int j=0;j<w;j++) {
						if(map[i][j]==1&&visited[i][j]==0) {
							search(i,j);
							count++;
						}
					}
				}
				System.out.println(count);
			}
		}
	}
}
