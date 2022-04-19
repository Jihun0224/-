package _0419;
import java.io.*;
import java.util.*;
public class Main_B2513 {
	static class Point implements Comparable<Point>{
		int pos,cnt;
		Point(int pos,int cnt){
			this.pos=pos;
			this.cnt=cnt;
		}
		@Override
		public int compareTo(Point o) {
			return this.pos-o.pos;
		}
	}
	static int S,K;
	static Point[]arr;
	static int search(int start,int target,boolean left) {
		int seat=K,cur=start,ans=0,dist=0,finish=0;
		while(finish<target) {
			if(seat==0) {
				ans+=(dist*2);
				seat=K;
				dist=0;
			}
			if(arr[cur].cnt<=seat) {
				seat-=arr[cur].cnt;
				dist=Math.max(dist, Math.abs(S-arr[cur].pos));
			}
			else {
				dist=Math.max(dist,Math.abs(S-arr[cur].pos));
				arr[cur].cnt-=seat;
				ans+=(dist*2);
				dist=Math.abs(S-arr[cur].pos);
				int div=arr[cur].cnt/K;
				int mod=arr[cur].cnt%K;
				ans+=(dist*div*2);
				if(mod==0) {
					dist=0;
					seat=K;
				}
				else {
					seat=K-mod;
				}
			}
			if(left)cur++;
			else cur--;
			finish++;
		}
		ans+=(dist*2);
		return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()),left=0;
		K=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		arr=new Point[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int pos=Integer.parseInt(st.nextToken());
			int cnt=Integer.parseInt(st.nextToken());
			arr[i]=new Point(pos,cnt);
			if(pos<S)left++;
		}
		Arrays.sort(arr);
		System.out.println(search(0, left,true)+search(N-1, N-left,false));
	}
}