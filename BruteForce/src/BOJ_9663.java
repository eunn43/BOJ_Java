import java.util.Scanner;

public class BOJ_9663 {
	static int n, cnt = 0;
	static int arr[];
	
	static boolean check(int piece) {
		for(int i = 0; i < piece; i++) {
			if(arr[piece] == arr[i]) //같은 열
				return false;
			if(piece - i == Math.abs(arr[piece] - arr[i])) //대각선
				return false;
		}
		return true;
	}
	
	static void nQueen(int piece) {
		if(piece == n) {
			cnt++;
			return;
		}
		for(int i = 0; i < n; i++) {
			arr[piece] = i;
			if(check(piece))
				nQueen(piece + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		arr = new int[n];
		
		nQueen(0);
		System.out.println(cnt);
		input.close();
	}

}
