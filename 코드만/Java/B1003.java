import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1003 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k,t = Integer.parseInt(br.readLine());
		int count0[] = new int [41];
		int count1[] = new int [41];
		count1[0]=0;
		count0[0]=1;
		count1[1]=1;
		count0[1]=0;
		for(int i=2;i<41;i++){
			count1[i]=count1[i-1]+count1[i-2];
			count0[i]=count0[i-1]+count0[i-2];
		}
		for(int i=0;i<t;i++) {
			k=Integer.parseInt(br.readLine());
			System.out.println(count0[k]+" "+count1[k]);
		}
	}
}