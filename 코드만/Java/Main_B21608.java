package _0414;

import java.io.*;
import java.util.*;

public class Main_B21608 {
	static class Point implements Comparable<Point>{
		int x,y,like,blank;
		public Point(int x, int y, int like, int blank) {
			this.x = x;
			this.y = y;
			this.like = like;
			this.blank = blank;
		}
		@Override
		public int compareTo(Point p) {
	        if(this.blank < p.blank) {
	            return 1; 
	        }
	        else if(this.blank==p.blank) {
	            if(this.x > p.x) {
	                return 1;
	            }
	            else if(this.x==p.x) {
		            if(this.y > p.y) {
		                return 1;
		            }
	            }
	        }
			return -1;
		}
	}
	static int N,map[][][];
	static int[]dx= {1,-1,0,0};
	static int[]dy= {0,0,1,-1};
	static PriorityQueue<Point>candidates;
	static void search(int[]arr) {
		candidates.clear();
		int max=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j][0]==0) {
					int like=0;
					int blank=0;
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						if(nx>=0&&nx<N&&ny>=0&&ny<N) {
							if(map[nx][ny][0]==0)blank++;
							else {
								for(int n:arr) {
									if(n==map[nx][ny][0]) {
										like++;
										break;
									}
								}
							}
						}
					}
					if(like>=max) {
						if(like>max) {
							candidates.clear();
							max=like;
						}
						candidates.add(new Point(i,j,like,blank));
					}
				}
			}
		}
	}
	static int getAnswer() {
		int result=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int cnt=0;
				for(int k=0;k<4;k++) {
					int nx=i+dx[k];
					int ny=j+dy[k];
					if(nx>=0&&nx<N&&ny>=0&&ny<N) {
						for(int l=1;l<5;l++) {
							if(map[i][j][l]==map[nx][ny][0]) {
								cnt++;
								break;
							}
						}
					}
				}
				System.out.println(cnt);
				switch (cnt) {
				case 1:
					result+=1;
					break;
				case 2:
					result+=10;
					break;
				case 3:
					result+=100;
					break;
				case 4:
					result+=1000;
					break;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N][5];
		candidates=new PriorityQueue<>();
		for(int i=0,total=N*N;i<total;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int cur=Integer.parseInt(st.nextToken());
			int[]arr=new int[4];
			for(int j=0;j<4;j++) arr[j]=Integer.parseInt(st.nextToken());
			search(arr);
			Point p=candidates.peek();
			map[p.x][p.y][0]=cur;
			for(int j=0;j<4;j++) {
				map[p.x][p.y][j+1]=arr[j];
			}
		}
		System.out.println(getAnswer());
	}
}
