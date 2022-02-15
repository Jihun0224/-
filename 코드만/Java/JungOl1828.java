import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JungOl1828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][]arr=new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		//최저 오름차순, 최고는 내림차순
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1];
			}
		});
		//각각 냉장고의 최고와 최저온도를 저장할 리스트
		ArrayList<Integer>max = new ArrayList<Integer>();
		ArrayList<Integer>min = new ArrayList<Integer>();
		
		//초기에 최저온도의 물질을 넣음
		min.add(arr[0][0]);
		max.add(arr[0][1]);
		//앞에서 냉장고 하나 썼으므로 시작 개수 1개
		int answer=1;
		//기존 냉장고에 넣은 지 체크
		boolean flag;
		for(int i=1;i<N;i++) {
			flag = true;
			for(int j=0,size=min.size();j<size;j++) {
				int tempMin=min.get(j),tempMax=max.get(j);
				//화학물질이 기존 냉장고에서 보관할 수 있는지 체크
				if((arr[i][0]>=tempMin&&arr[i][0]<=tempMax)||(arr[i][1]>=tempMin&&arr[i][1]<=tempMax)){
					min.set(j, Math.max(tempMin, arr[i][0]));
					max.set(j, Math.min(tempMax, arr[i][1]));
					flag=false;
					break;
				}
			}
			//새로운 냉장고에 저장
			if(flag){
				min.add(arr[i][0]);
				max.add(arr[i][1]);
				answer++;
			}
		}
		System.out.println(answer);
	}
}
