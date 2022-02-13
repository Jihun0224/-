package Beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B16926 {
	static int N,M,R;
	//이동 방향
	static int[][] d= {{1,0},{0,1},{-1,0},{0,-1}};
	//회전 시킬 배열
	static int[][] map;

	static void rotate() {
			//회전시킬 사각형 수
		int square=Math.min(N, M)/2,x,y,save,cur,index;
		for(int i=0; i<square; i++){
            x=i;y=i;
            //각 사각형의 시작 지점 저장
            save=map[x][y];
            index=0;     
            //4방향으로 돌때까지
            while(index < 4){
            	//x,y이동
                int nx=x+d[index][0];
                int ny=y+d[index][1];
                //각 사각형의 범위 안
                if(nx>=i&& nx<N-i&&ny>=i&&ny<M-i){
                	//이동한 지점의 값 저장
                	cur=map[nx][ny];
                	//이동하기 전 값으로 현재(이동한 지점)값 갱신
                	map[nx][ny]=save;
                	//이동한 지점의 기존 값으로 save값 갱신 -> 다음 이동 후 이 값으로 이동한 좌표 값 갱신을 위해
                	save=cur;
                	//x,y 이동한 좌표로 갱신
                    x=nx;
                    y=ny;
                }
                //범위를 벗어난 경우 방향 변경을 위해 +1
                else index++;
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
		for(int i=0;i<R;i++) {
			rotate();
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
