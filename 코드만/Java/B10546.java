package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.Map;
public class B10546 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String name;
		Map<String, Integer> map = new TreeMap<>();
		for(int i=0;i<N*2-1;i++) {
			name = br.readLine();
			map.put(name, map.get(name)==null ? 1 : map.get(name)+1);
		}
		for (String n :map.keySet()) {
			if (map.get(n)%2==1) {
				System.out.println(n);
				break;
			}
		}
	}
}
