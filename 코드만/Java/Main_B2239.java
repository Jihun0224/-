package _0406;
import java.io.*;
import java.util.ArrayList;
public class Main_B2239 {
	//입력배열, 입력된 배열에서 0의 수
	static int map[][],zeroCnt;
	//0의 위치를 저장
	static ArrayList<int[]>zero;
	static void dfs(int depth) {
		//모든 0을 다 채웠을 때 출력 후 시스템 종료
		if(depth==zeroCnt) {
			for(int[]a:map) {
				for(int i:a) {
					System.out.print(i);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		int[]temp=zero.get(depth);
		int i=temp[0],j=temp[1];
		for(int k=1;k<=9;k++) {
			//k를 i,j에 넣을 수 있으면 다음 탐색
			if(check(i,j,k)) {
				map[i][j]=k;
				dfs(depth+1);
				map[i][j]=0;
			}
		}
	}
	//x,y 위치에 num가 들어 갈 수 있는지 체크
	static boolean check(int x,int y,int num) {
		for(int i=0;i<9;i++) {
			if(map[x][i]==num)return false;
			if(map[i][y]==num)return false;
		}
		int row,col;
		
		if(x<3)row=0;
		else if(x<6)row=3;
		else row=6;
		if(y<3)col=0;
		else if(y<6)col=3;
		else col=6;
		
		for(int i=row;i<row+3;i++) {
			for(int j=col;j<col+3;j++) {
				if(map[i][j]==num)return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map=new int[9][9];
		zero=new ArrayList<>();
		for(int i=0;i<9;i++) {
			char[]temp=br.readLine().toCharArray();
			for(int j=0;j<9;j++) {
				map[i][j]=temp[j]-48;
				if(map[i][j]==0) {
					zero.add(new int[] {i,j});
				}
			}
		}
		
		zeroCnt=zero.size();
		dfs(0);
	}
}
