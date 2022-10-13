import java.io.*;
import java.util.*;
public class Main_BOJ20056_마법사상어와파이어볼 {
	static int N,M;
	static int[][]map;
	static int[] dx={-1,-1,0,1,1,1,0,-1};
	static int[] dy={0,1,1,1,0,-1,-1,-1};
	static List<Ball>ball;
	public static void main(String[] args)throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		ball=new ArrayList<>();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			int m=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			ball.add(new Ball(r, c, m, s, d));
			map[r][c]++;
		}
		while(K-->0) {
			move();
			merge();
		}
		System.out.print(getAns());
	}
	static void move() {
		for(Ball b:ball) {
			int x=b.r,y=b.c;
			int nx=((x+N)+((b.s*dx[b.d])%N))%N;
			int ny=((y+N)+((b.s*dy[b.d])%N))%N;
			b.r=nx;
			b.c=ny;
			map[x][y]--;
			map[nx][ny]++;
		}
	}
	static void merge() {
		int count,sumM,sumS,isOdd,isEven,start;
		Ball tmpBall[];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>=2) {
					tmpBall=new Ball[map[i][j]];
					count=sumM=sumS=isOdd=isEven=0;
					for(Ball b:ball) {
						if(count==map[i][j])break;
						if(b.r==i&&b.c==j) {
							tmpBall[count++]=b;
							sumM+=b.m;
							sumS+=b.s;
							if(b.d%2==0||b.d==0)isEven++;
							else isOdd++;
						}
					}
					if(sumM/5<=0)map[i][j]=0;
					else {
						if(isEven==count||isOdd==count)start=0;
						else start=1;
						for(;start<8;start+=2) {
							Ball newBall = new Ball(i, j, sumM/5, sumS/count, start);
							ball.add(newBall);
						}
						map[i][j]=4;
					}
					for(Ball b:tmpBall)ball.remove(b);
				}
			}
		}
	}
	static int getAns() {
		int a=0;
		for(Ball b:ball)a+=b.m;
		return a;
	}
	static class Ball{
		int r;
		int c;
		int m;
		int s;
		int d;
		Ball(int r,int c,int m,int s,int d){
			this.r=r;
			this.c=c;
			this.m=m;
			this.s=s;
			this.d=d;
		}
	}
}