import java.io.*;
import java.util.StringTokenizer;
public class Main_B11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), target=Integer.parseInt(st.nextToken()),answer=0;
		int[]arr=new int[n];
		for (int i=n-1; i>=0; i--)
			arr[i]=Integer.parseInt(br.readLine());
		int index=0;
		while(target!=0) {
			if(target/arr[index]>0) {
				int temp=target/arr[index];
				answer+=temp;
				target-=arr[index]*temp;
			}
			index++;
		}
		System.out.println(answer);
	}
}
