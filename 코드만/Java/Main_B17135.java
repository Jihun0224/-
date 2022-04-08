package _0408;

import java.io.*;
import java.util.StringTokenizer;
//백준 캐슬 디펜스
// 1. 조합으로 궁수를 배치
// 2. 조건에 맞는 타겟 위치를 찾음
// 3. 타겟을 0으로 바꾸고 1인 칸을 아래로 이동
// 4. 2~3과정을 맵이 모두 0이 될 때까지 반복
public class Main_B17135 {
	static int n,m,d,answer=0,map[][];
	static boolean visited[],save[][];
	static void comb(int depth) {
		if(depth==3) {
			play();
			return;
		}
		for(int i=depth;i<m;i++) {
			if(!visited[i]) {
				visited[i]=true;
				comb(depth+1);
				visited[i]=false;
			}
		}
	}
	
	static void play() {
		int[][]target=new int[3][2];
		int cnt=0;
		while(true) {
			int index=0;
			boolean gameOver=true;
			for(int i=0;i<m;i++){
				if(visited[i])target[index++]=getTarget(n, i);
			}
			
			for(int[]a:target) {
				if(a[0]!=-1) map[a[0]][a[1]]++;
			}
		
			for(int i=0;i<m;i++) {
				for(int j=n;j>0;j--) {
					if(map[j-1][i]>1) {
						cnt++;
						map[j-1][i]=0;
					}
					int temp=map[j][i];
					map[j][i]=map[j-1][i];
					map[j-1][i]=temp;
					if(map[j][i]==1)gameOver=false;
				}
				map[n][i]=0;
			}
			if(gameOver)break;
		}		
		answer=Math.max(answer, cnt);
		back();
	}
	static int[]getTarget(int x,int y){
		int[]temp=new int[2];
		temp[0]=-1;
		int min=n*m;
		for(int i=0;i<m;i++) {
			for(int j=n-1;j>=0;j--) {
				if(map[j][i]==1) {
					int dis=getDis(x, y, j, i);
					if(dis<=d&&min>dis) {
						min=dis;
						temp[0]=j;
						temp[1]=i;
						break;
					}
				}
			}
		}
		return temp;
	}
	static int getDis(int x1,int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	static void back() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=0;
				if(save[i][j])map[i][j]=1;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		map=new int[n+1][m];
		save=new boolean[n][m];
		visited=new boolean[m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)save[i][j]=true;
			}
		}
		comb(0);
		System.out.println(answer);
	}
}