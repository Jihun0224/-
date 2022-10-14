import java.io.*;
import java.util.*;
public class Main_BOJ_19238_스타트택시 {
	static int N,M,fuel,map[][],pos[];
	static int[]dx= {-1,0,0,1};
	static int[]dy= {0,-1,1,0};
	static List<Person>person;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		fuel=Integer.parseInt(st.nextToken());
		map = new int[N][N];
		pos=new int[2];
		person = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine());
		pos[0]=Integer.parseInt(st.nextToken())-1;
		pos[1]=Integer.parseInt(st.nextToken())-1;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int start[]=new int[2];
			int end[]=new int[2];
			for(int j=0;j<2;j++)start[j]=Integer.parseInt(st.nextToken())-1;
			for(int j=0;j<2;j++)end[j]=Integer.parseInt(st.nextToken())-1;
			person.add(new Person(start, end));
		}
		while(person.size()>0) {
			if(bfs(0,0,0)==-1) {
				fuel=-1;
				break;
			}
		}
		System.out.print(fuel);
	}
	static int bfs(int x,int y,int mode) {
		if(mode==0) {
			for(Person p:person) {
				if(p.start[0]==pos[0]&&p.start[1]==pos[1]) {
					int used = bfs(p.end[0],p.end[1],1);
					if(used==-1)return -1;
					fuel+=used;
					person.remove(p);
					return 0;
				}
			}
		}
		if(mode==1&&pos[0]==x&&pos[1]==y) {
			return 0;
		}
		Queue<int[]>q = new LinkedList<>();
		boolean[][]visited=new boolean[N][N];
		q.add(new int[] {pos[0],pos[1]});
		visited[pos[0]][pos[1]]=true;
		int depth=0;
		Person findP=null;
		while(!q.isEmpty()) {
			if(findP!=null) {
				pos[0]=findP.start[0];
				pos[1]=findP.start[1];
				int used = bfs(findP.end[0],findP.end[1],1);
				if(used==-1)return -1;
				fuel+=used;
				person.remove(findP);
				return 0;
			}
			int s=q.size();
			if(fuel<++depth)break;
			for(int k=0;k<s;k++) {
				int[]now = q.poll();
				for(int i=0;i<4;i++) {
					int nx=now[0]+dx[i];
					int ny=now[1]+dy[i];
					if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]||map[nx][ny]==1)continue;
					if(mode==0) {
						for(Person p:person) {
							if(p.start[0]==nx&&p.start[1]==ny) {
								if(findP==null) {
									findP=p;
									fuel-=depth;
								}
								else {
									if(findP.start[0]>p.start[0])findP=p;
									else if(findP.start[0]==p.start[0]&&findP.start[1]>p.start[1])findP=p;
								}
							}
						}
					}else if(mode==1&&x==nx&&y==ny) {
						pos[0]=nx;
						pos[1]=ny;
						return depth;
					}
					q.add(new int[] {nx,ny});
					visited[nx][ny]=true;
				}
			}
		}
		return -1;
	}
	static class Person{
		int start[];
		int end[];
		Person(int[]start,int[]end){
			this.start=start;
			this.end=end;
		}
	}
}