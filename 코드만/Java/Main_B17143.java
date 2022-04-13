package _0413;

import java.io.*;
import java.util.StringTokenizer;
// map에 상어의 번호를 표시, 잡아 먹힌 상어는 null
public class Main_B17143 {
	static class Shark {
		int r,c,s,d,z;
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static int R,C,M,map[][],answer;
	static int[]dx= {0,-1,1,0,0};
	static int[]dy= {0,0,0,1,-1};
	static Shark[]shark;
	static void eat(int depth) {
		for(int i=0;i<R;i++) {
			if(map[i][depth]>0) {
				answer+=shark[map[i][depth]].z;
				shark[map[i][depth]]=null;
				break;
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]=0;
			}
		}
	}

	static void move() {
		for(int i=1;i<=M;i++) {
			if(shark[i]==null)continue;
			int cycle;
			//제자리에 돌아오는 카운트는 버림
			if(shark[i].d==1||shark[i].d==2)cycle=shark[i].s%((R-1)*2);
			else cycle=shark[i].s%((C-1)*2);
			
			int x=shark[i].r;
			int y=shark[i].c;
			int d=shark[i].d;
			int nx=x,ny=y;
			for(int j=0;j<cycle;j++) {
				nx=x+dx[d];
				ny=y+dy[d];
				if(nx<0||nx>=R) {
					if(d==1)d=2;
					else d=1;
					nx=x+dx[d];
				}
				if(ny<0||ny>=C) {
					if(d==3)d=4;
					else d=3;
					ny=y+dy[d];
				}
				x=nx;
				y=ny;
			}
			shark[i].r=x;
			shark[i].c=y;
			shark[i].d=d;
			
			if(map[shark[i].r][shark[i].c]==0) {
				map[shark[i].r][shark[i].c]=i;
			}
			else {
				if(shark[map[shark[i].r][shark[i].c]].z>shark[i].z) {
					shark[i]=null;
				}
				else {
					shark[map[shark[i].r][shark[i].c]]=null;
					map[shark[i].r][shark[i].c]=i;
				}
			}
		}
	}
	static void solve(int depth) {
		if(depth==C)return;
		eat(depth);
		move();
		solve(depth+1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[R][C];
		shark=new Shark[M+1];
		answer=0;
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			shark[i]=new Shark(Integer.parseInt(st.nextToken())-1, 
							   Integer.parseInt(st.nextToken())-1, 
							   Integer.parseInt(st.nextToken()), 
							   Integer.parseInt(st.nextToken()), 
							   Integer.parseInt(st.nextToken()));
			map[shark[i].r][shark[i].c]=i;
		}
		solve(0);
		System.out.println(answer);
		
	}
}
