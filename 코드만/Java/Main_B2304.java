import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_B2304 {
	static int [][]arr;
	static int sum,maxValue,start,end;
	
	static void up() {
		while(maxValue!=arr[start][1]) {
			if(arr[start][1]<arr[end][1]) {
				sum+=(arr[end][0]-arr[start][0])*arr[start][1];
				start=end;
				end++;
			}
			else end++;
		}
	}
	static void down() {
		while(maxValue!=arr[start][1]) {
			if(arr[start][1]<arr[end][1]) {
				sum+=(arr[start][0]-arr[end][0])*arr[start][1];
				start=end;
				end--;
			}
			else end--;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		
		sum=maxValue=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			if(maxValue<=arr[i][1]) {
				if(maxValue<arr[i][1])maxValue=arr[i][1];
				

			}
		}
		Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));
		
		start=0;end=1;
		up();
		start=N-1;end=start-1;
		down();
		
		int first=-1,last=0;
		for(int i=0;i<N;i++) {
			if(arr[i][1]==maxValue) {
				if(first==-1)first=i;
				else last=i;
			}
		}
		if(last==0)sum+=maxValue;
		else sum+=(arr[last][0]-arr[first][0]+1)*maxValue;
			
		System.out.println(sum);
		
	}
}
