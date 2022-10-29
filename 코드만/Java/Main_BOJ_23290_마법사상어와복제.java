import java.io.*;
import java.util.*;

public class Main_BOJ_23290_마법사상어와복제 {
	static int M,S,shakeX,shakeY,smell[][],fish[][][],save[][][],selected[],total,count[][];
	static int[] dx={0,-1,-1,-1,0,1,1,1};
	static int[] dy={-1,-1,0,1,1,1,0,-1};
	static int[] shakeD = {2,0,6,4};
	static boolean[][]visited;
	static ShakeMoveInfo shakeMoveInfo;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		fish = new int[4][4][8];
		smell = new int[4][4];
		save = new int[4][4][8];
		count = new int[4][4];
		selected = new int[3];
		visited = new boolean[4][4];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int d=Integer.parseInt(st.nextToken())-1;
			count[x][y]++;
			fish[x][y][d]++;
		}
		st = new StringTokenizer(br.readLine());
		shakeX=Integer.parseInt(st.nextToken())-1;
		shakeY=Integer.parseInt(st.nextToken())-1;
		while(S-->0) {
			copy();
			fishMove();
			shakeMoveInfo = new ShakeMoveInfo();
			shakeMoveCase(0, 0, shakeX, shakeY, 0);
			shakeMove();
			removeSmell();
			append();
		}
		System.out.print(total);
	}
	static void copy() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(int k=0;k<8;k++) {
					save[i][j][k]=fish[i][j][k];
				}
			}
		}
	}
	static void append() {
		total = 0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				int tmp=0;
				for(int k=0;k<8;k++) {
					fish[i][j][k]+=save[i][j][k];
					total+=fish[i][j][k];
					tmp+=save[i][j][k];
				}
				count[i][j]+=tmp;
			}
		}
	}
	static void fishMove() {
		int[][][]tmp = new int[4][4][8];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(int k=0;k<8;k++) {
					int nd=0,nx=0,ny=0,d;
					for(d=0;d<8;d++) {
						nd = (k-d+8)%8;
						nx = i+dx[nd];
						ny = j+dy[nd];
						if(nx<0||ny<0||nx>=4||ny>=4||smell[nx][ny]>0||(shakeX==nx&&shakeY==ny))continue;
						break;
					}
					if(d==8) {
						nd=k;
						nx=i;
						ny=j;
					}
					tmp[nx][ny][nd]+=fish[i][j][k];
					count[i][j]-=fish[i][j][k];
				}
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				count[i][j]=0;
				for(int k=0;k<8;k++) {
					fish[i][j][k]=tmp[i][j][k];
					count[i][j]+=tmp[i][j][k];
				}
			}
		}
	}
	static void change(int fishCount, int dicVal) {
		shakeMoveInfo.fishCount = fishCount;
		shakeMoveInfo.dicVal = dicVal;
		for(int i=0;i<3;i++) shakeMoveInfo.direction[i]=selected[i];
	}
	static void shakeMove() {
		for(int i=0;i<3;i++) {
			shakeX+=dx[shakeD[shakeMoveInfo.direction[i]]];
			shakeY+=dy[shakeD[shakeMoveInfo.direction[i]]];
			if(count[shakeX][shakeY]>0) {
				smell[shakeX][shakeY]=3;
				count[shakeX][shakeY]=0;
				for(int j=0;j<8;j++) {
					fish[shakeX][shakeY][j]=0;
				}
			}
		}
	}
	static void shakeMoveCase(int depth, int dicVal, int x, int y, int fishCount) {
		if(depth==3) {
			if(shakeMoveInfo.fishCount>fishCount)return;
			else if(shakeMoveInfo.fishCount<fishCount)change(fishCount,dicVal);
			else if(shakeMoveInfo.dicVal>dicVal)change(fishCount,dicVal);
			return;
		}
		for(int i=0;i<4;i++) {
			int nx = x+dx[shakeD[i]];
			int ny = y+dy[shakeD[i]];
			if(nx<0||ny<0||nx>=4||ny>=4)continue;
			
			selected[depth]=i;
			int newFishCount=fishCount;
			int newDicVal = dicVal+(int)Math.pow(10, 2-depth)*(i+1);

			if(!visited[nx][ny]){
				newFishCount+=count[nx][ny];
				visited[nx][ny]=true;
				shakeMoveCase(depth+1,newDicVal,nx,ny,newFishCount);
				visited[nx][ny]=false;
			}
			else shakeMoveCase(depth+1,newDicVal,nx,ny,newFishCount);

		}
	}
	static void removeSmell() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(smell[i][j]>0)smell[i][j]--;
			}
		}
	}
	static class ShakeMoveInfo{
		int[]direction;
		int fishCount;
		int dicVal;
		ShakeMoveInfo(){
			this.direction = new int[3];
			this.fishCount=-1;
		}
	}
}