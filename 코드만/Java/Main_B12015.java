import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

//백준 12015. 가장 긴 증가하는 부분 수열2,3
public class Main_B12015 {
	static Vector<Integer>v;
	static int search(int x) {
		int start=0,end=v.size()-1,mid;
		while(start<end) {
			mid=(start+end)/2;
			if(x>v.get(mid))start=mid+1;
			else end=mid;
		}
		return end;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int num;
		int[]order=new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		v=new Vector<>();
		v.add(0);
		for(int i=0;i<n;i++) {
			num=Integer.parseInt(st.nextToken());
			if(v.lastElement()>=num) {
				int temp=search(num);
				v.set(temp, num);
			}
			else v.add(num);
			order[i]=num;
		}
		
		System.out.println(v.size()-1);
		for(int i:order) {
			if(v.contains(i))System.out.print(i+" ");
		}
	}
}
