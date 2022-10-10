import java.io.*;
import java.util.*;
public class Main_BOJ3190_뱀 {
	static int N,answer,map[][],now_direction;
	static Snake Head,Tail;
	static int[]dx = {0,1,0,-1};
	static int[]dy = {1,0,-1,0};
	static Map<Integer, Character> direction;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		answer=now_direction=0;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Head = new Snake(null, null, new int[] {0,0});
		Tail = Head;
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=-1;
		}
		int L = Integer.parseInt(br.readLine());
		direction = new HashMap<>();
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			direction.put(x, c);
		}
		while(true) {
			if(!play())break;
		}
		System.out.print(answer+1);
	}
	static boolean play() {
		int nx = Head.pos[0]+dx[now_direction];
		int ny = Head.pos[1]+dy[now_direction];
		if(nx<0||ny<0||nx>=N||ny>=N||map[nx][ny]==1)return false;
		Snake next = new Snake(null, Head, new int[]{nx,ny});
		Head.next = next;
		Snake temp = Head;
		Head = next;
		Head.pre = temp;
		if(map[nx][ny]!=-1) {
			map[Tail.pos[0]][Tail.pos[1]]=0;
			temp = Tail;
			Tail = Tail.next;
			temp=null;
		}else {
			map[Head.pre.pos[0]][Head.pre.pos[1]]=1;
		}
		map[nx][ny]=1;
		if(direction.get(++answer)!=null) {
			char c = direction.get(answer);
			if(c=='D')now_direction=(now_direction+5)%4;
			else now_direction=(now_direction+3)%4;
		}
		return true;
	}
	static class Snake{
		Snake next;
		Snake pre;
		int[]pos;
		Snake(Snake next, Snake pre,int[] pos){
			this.next=next;
			this.pre=pre;
			this.pos=pos;
		}
	}
}