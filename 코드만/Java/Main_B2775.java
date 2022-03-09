import java.io.*;

public class Main_B2775 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int k,n,a,arr[][];
		for(int t=0;t<T;t++) {
			k=Integer.parseInt(br.readLine());
			n=Integer.parseInt(br.readLine());
			arr=new int[k+1][n+1];
			for(int i=1;i<=n;i++)arr[0][i]=i;
			
			for(int i=0;i<k;i++){
				for(int j=1;j<=n;j++){
					for(int l=1;l<=j;l++) {
						arr[i+1][j]+=arr[i][l];
					}
				}
			}
			System.out.println(arr[k][n]);
		}
	}
}
