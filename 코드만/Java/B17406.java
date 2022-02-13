package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17406 {
	static int[][]command;
	static int[][]map;
	static int min = Integer.MAX_VALUE;
	static int N,M,K;
	static void search(int depth,boolean[] visited) {
		//회전 명령 수행 완료
		if(depth==K) {
			int sum;
			for(int[]row:map) {
				sum=0;
				for(int n:row) {
					sum+=n;
				}
				min=Math.min(min, sum);
			}
			return;
		}
		//회전 명령 수행
		for(int i=0;i<K;i++) {
			if(!visited[i]) {
				visited[i]=true;
				int[] start= {command[i][0]-command[i][2],command[i][1]-command[i][2]};
				int[] end= {command[i][0]+command[i][2],command[i][1]+command[i][2]};
				
				int[][]back = new int[N][M];
				for(int j=0;j<N;j++) {
					System.arraycopy(map[j], 0, back[j],0,M);
				}
				rotate(start,end,map);
				search(depth+1,visited);
				visited[i]=false;
				for(int j=0;j<N;j++) {
					System.arraycopy(back[j], 0, map[j],0,M);
				}
			}
		}		
	}
	//회전 메서드
	static void rotate(int[]start, int[]end,int map[][]) {
		int[][]d = {{0,1},{1,0},{0,-1},{-1,0}};
		int index,x,y,save,cur,nx,ny;
		
		int N=end[0]-start[0]+1;
		int M=end[1]-start[1]+1;
		int square=Math.min(N, M)/2;
		//회전할 부분 배열을 기존 배열에서 복사
		int[][]temp = new int[N][M];
		for(int i=0;i<N;i++) {
			System.arraycopy(map[start[0]+i-1],start[1]-1, temp[i],0,M);
		}

		for(int i=0;i<square;i++) {
			x=i;
			y=i;
			index=0;
			save=temp[x][y];
			while(index<4) {
				cur=temp[x][y];
				nx=x+d[index][0];
				ny=y+d[index][1];
				if(nx>=i&& nx<N-i&&ny>=i&&ny<M-i) {
					cur=temp[nx][ny];
					temp[nx][ny]=save;
					save=cur;
					x=nx;
					y=ny;
				}
				else index++;
			}
		}

		for(int i=0;i<N;i++) {
			System.arraycopy(temp[i],0, map[start[0]-1+i],start[1]-1,M);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		command=new int[K][3];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				command[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		search(0, new boolean[K]);
		System.out.println(min);
	}
}
