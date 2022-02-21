import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_B1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine()),temp;
		for(int i=0;i<N;i++) {
			temp = Integer.parseInt(br.readLine());
			if(temp==0) {
				if(!heap.isEmpty())
					System.out.println(heap.poll());
				else
					System.out.println(0);
			}
			else {
				heap.add(temp);
			}
		}
	}

}
