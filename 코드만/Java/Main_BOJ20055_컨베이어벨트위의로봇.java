import java.util.*;
import java.io.*;

public class Main_BOJ20055_컨베이어벨트위의로봇 {
	static int N,K,arr[],s,answer;
	static List<Integer>robots;
	static boolean[]isRobot;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();K=sc.nextInt();
		arr=new int[2*N];
		isRobot=new boolean[2*N];
		robots=new ArrayList<Integer>();
		s=answer=0;
		for(int i=0;i<2*N;i++)arr[i]=sc.nextInt();
		
		while(true) {
			answer++;
			s--;
			if(s<0)s=2*N-1;
			if(isRobot[(s+N-1)%(2*N)])checkN();
			move();
			if(isRobot[(s+N-1)%(2*N)])checkN();
			if(arr[s]>0) {
				robots.add(s);
				isRobot[s]=true;
				arr[s]--;
			}
			if(get0()>=K)break;
		}
		System.out.print(answer);
	}
	static void checkN() {
		for(int i=0,size=robots.size();i<size;i++) {
			int now=robots.get(i);
			if(now==(s+N-1)%(2*N)) {
				robots.remove(i);
				isRobot[now]=false;
				return;
			}
		}
	}
	static void move() {
		for(int i=0,size=robots.size();i<size;i++) {
			int now=robots.get(i);
			int next=now+1;
			if(next>=2*N)next=0;
			if(arr[next]>0&&!isRobot[next]) {
				arr[next]--;
				robots.set(i, next);
				isRobot[now]=false;
				isRobot[next]=true;
			}			
		}
	}
	static int get0() {
		int tmp=0;
		for(int i=0;i<2*N;i++) {
			if(arr[i]==0)tmp++;
		}
		return tmp;
	}
}