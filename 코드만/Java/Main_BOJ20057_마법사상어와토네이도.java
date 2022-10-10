import java.io.*;
import java.util.*;
public class Main_BOJ20057_마법사상어와토네이도 {
	static int N,map[][],answer,total,init;
	static int[]dx= {0,1,0,-1};
	static int[]dy= {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		answer=0;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		rotate();
		System.out.println(answer);
	}
	static void rotate() {
		int now=1,count=0,d=0,pos[]= {N/2,N/2};
		while(true) {
			for(int i=0;i<now;i++) {
				move(pos, d);
				pos[0]=pos[0]+dx[d];
				pos[1]=pos[1]+dy[d];
				if(pos[0]==0&&pos[1]==0)return;
			}
			count++;
			d=(d+5)%4;
			if(count==2) {
				now++;
				count=0;
			}
		}
	}
	static void move(int[]now,int d) {
		total=0;
		int[]next= {now[0]+dx[d],now[1]+dy[d]};
		init=map[next[0]][next[1]];
		if(init==0)return;
		map[next[0]][next[1]]=0;
		int sand,nx,ny;
		int[]sand_step1= {1,-1};
		int[]sand_step2= {0,1,2};
		int[]sand_step3= {2,-2};
		int[]sand_step4= {1,2};
		switch (d) {
		case 0:
		case 2:
			for(int i=0;i<2;i++) {
				nx = now[0]+sand_step1[i];
				for(int j=0;j<3;j++) {
					ny=now[1]+sand_step2[j];
					if(d==0) {
						ny=now[1]-sand_step2[j];
					}
					switch (j) {
					case 0:
						sand=(int) (init*0.01);
						break;
					case 1:
						sand=(int) (init*0.07);
						break;
					default:
						sand=(int) (init*0.1);
					}
					boundCheck(nx,ny,sand);
				}
			}
			for(int i=0;i<2;i++) {
				nx = next[0]+sand_step3[i];
				boundCheck(nx, next[1], (int) (init*0.02));
			}
			for(int i=1;i>=0;i--) {
				ny=next[1]+sand_step4[i];
				if(d==0) ny=next[1]-sand_step4[i];
				if(i==1)boundCheck(next[0], ny, (int) (init*0.05));
				else boundCheck(next[0], ny, init-total);
			}
			break;

		default:
			for(int i=0;i<2;i++) {
				ny = now[1]+sand_step1[i];
				for(int j=0;j<3;j++) {
					nx=now[0]+sand_step2[j];
					if(d==3) {
						nx=now[0]-sand_step2[j];
					}
					switch (j) {
					case 0:
						sand=(int) (init*0.01);
						break;
					case 1:
						sand=(int) (init*0.07);
						break;
					default:
						sand=(int) (init*0.1);
					}
					
					boundCheck(nx,ny,sand);
				}
			}
			for(int i=0;i<2;i++) {
				ny = next[1]+sand_step3[i];
				boundCheck(next[0], ny, (int) (init*0.02));
			}
			for(int i=1;i>=0;i--) {
				nx=next[0]+sand_step4[i];
				if(d==3) nx=next[0]-sand_step4[i];
				if(i==1)boundCheck(nx, next[1], (int) (init*0.05));
				else boundCheck(nx, next[1], init-total);
			}
			break;
		}
	}
	static void boundCheck(int nx,int ny,int sand) {
		total+=sand;
		if(nx<0||ny<0||nx>=N||ny>=N) {
			answer+=sand;
		}else {
			map[nx][ny]+=sand;
		}
	}
}