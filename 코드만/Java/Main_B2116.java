import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B2116 {
	
	static int[][]dice;
	static int N,answer=0;
	static int[]rule =new int[]{5,3,4,1,2,0};
	
	static int getMax(int[]arr) {
		int max = 0;
		for(int n:arr) {
			max=Math.max(max, n);
		}
		return max;
	}
	static int searchIndex(int num,int index) {
		for(int i=0;i<6;i++) {
			if(dice[index][i]==num) 
				return i;
		}
		return 0;
	}
	static void search(int number) {
		int[]temp;
		int sum=0;
		for(int i=0;i<N;i++) {
			int index = searchIndex(number, i);
			temp=new int[6];
			for(int j=0;j<6;j++) {
				if(rule[index]!=j&&index!=j) {
					temp[j]=dice[i][j];
				}
			}
			number=dice[i][rule[index]];
			sum+=getMax(temp);
		}
		answer=Math.max(answer,sum);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				dice[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=6;i++) {
			search(i);
		}
		System.out.println(answer);
	}
}
