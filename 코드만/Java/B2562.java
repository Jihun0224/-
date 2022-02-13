package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2562 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = new int[9];
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i=0;i<numbers.length;i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i] > max) {
				index = i;
				max = numbers[i];
			}
		}
		System.out.println(max);
		System.out.println(index+1);
	}
}
