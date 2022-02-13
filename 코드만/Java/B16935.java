package Beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16935 {	
	static int N,M,R;
	static int[][] map;

	static void c1() {
		N=map.length; M=map[0].length;
		int[][]result=new int[N][M];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				result[j][i]=map[N-j-1][i];
			}
		}
		map=result;
	}
	
	static void c2() {
		N=map.length; M=map[0].length;
		int[][]result=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				result[i][j]=map[i][M-j-1];
			}
		}
		map=result;
	}
	static void c3() {
		N=map[0].length; M=map.length;
		int[][]result=new int[N][M];
		int i=map.length-1,j=0;
		for(int[]row:map) {
			j=0;
			for(int n:row) {
				result[j++][i]=n;
			}
			i--;
	}
		map=result;
	}
	static void c4() {
		N=map[0].length; M=map.length;
		int[][]result=new int[N][M];
		int i=0,j=0;
		for(int[]row:map) {
			j=map[0].length-1;
			for(int n:row) {
				result[j--][i]=n;
			}
			i++;
	}
		map=result;
	}
	static void c5() {
		int [][]temp = new int[map.length/2][map[0].length/2];
		
		//1
		for(int i=0; i<N/2; i++) {
			temp[i]=Arrays.copyOfRange(map[i], 0, M/2);
		}
		//4->1 OK
		for(int i=0; i<N/2; i++) { 
			for(int j=0; j<M/2; j++) {
				map[i][j]=map[i+N/2][j];
			}
		}
		//3->4 OK
		for(int i=N/2; i<N; i++) { 
			for(int j=0; j<M/2; j++) {
				map[i][j]= map[i][M/2+j];
			}
		}
		//2->3 OK
		for(int i=N/2; i<N; i++) {
			for(int j=M/2; j<M; j++) {
				map[i][j] = map[i-N/2][j]; 
			}
		}
		//1->2 OK
		for(int i=0; i<N/2; i++) { 
			for(int j=M/2; j<M; j++) {
				map[i][j] = temp[i][j-M/2];
			}
		}
	}
	static void c6() {
		int [][]temp = new int[map.length/2][map[0].length/2];
		//1
		for(int i=0; i<N/2; i++) {
			temp[i]=Arrays.copyOfRange(map[i], 0, M/2);
		}
		//2->1 OK
		for(int i=0; i<N/2; i++) { 
			for(int j=0; j<M/2; j++) {
				map[i][j] = map[i][M/2+j];
			}
		}
		//3->2 OK
		for(int i=0; i<N/2; i++) { 
			for(int j=M/2; j<M; j++) {
				map[i][j]=map[i+N/2][j];
			}
		}
		//4->3 OK
		for(int i=N/2; i<N; i++) {
			for(int j=M/2; j<M; j++) {
				map[i][j] = map[i][j-M/2]; 
			}
		}		
		//1->4 OK
		for(int i=N/2; i<N; i++) { 
			for(int j=0; j<M/2; j++) {
				map[i][j] = temp[i-N/2][j];
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int[]command=new int[R];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			command[i]=Integer.parseInt(st.nextToken());
		}
		for(int i:command) {
			switch (i) {
			case 1:
				c1();
				break;
			case 2:
				c2();
				break;
			case 3:
				c3();
				break;
			case 4:
				c4();
				break;
			case 5:
				c5();
				break;
			default:
				c6();
				break;
			}

		}
		for(int[] row: map) {
			for(int n:row) {
				bw.write(n+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		
	}
}
