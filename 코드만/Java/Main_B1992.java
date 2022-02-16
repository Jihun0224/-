import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//백준 1992 쿼드 트리 -> 재귀
public class Main_B1992 {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	static void makeQuadTree(int x,int y,int N){
		if(check(x,y,N)) {
			sb.append(arr[x][y]);
			return;
		}
		sb.append("(");
		//왼쪽 위
		makeQuadTree(x, y, N/2);
		//오른쪽 위
		makeQuadTree(x, y+N/2, N/2);
		//왼쪽 아래
		makeQuadTree(x+N/2, y, N/2);
		//오른쪽 아래
		makeQuadTree(x+N/2, y+N/2, N/2);
		sb.append(")");
	}
	//같은 색이 나오는지 확인
	public static boolean check(int x,int y,int N) {
		int temp = arr[x][y];
		for(int i=x;i<x+N;i++) {
			for(int j=y;j<y+N;j++) {
				if(temp!=arr[i][j]) 
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		char[]temp;
		for(int i=0;i<N;i++) {
			temp=br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				arr[i][j]=(int)(temp[j]-48);
			}
		}
		makeQuadTree(0,0,N);
		bw.write(sb.toString());
		bw.flush();
	}
}
