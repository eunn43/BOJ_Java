import java.util.Scanner;

public class BOJ_2659 {

	static int isClockNum(String n) {
		int arr[] = new int[4];
		int min = 10000;
		for(int i = 0; i < 4; i++)
			arr[i] = n.charAt(i) - '0';
		
		min = Math.min(min, arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3]);
		min = Math.min(min, arr[1] * 1000 + arr[2] * 100 + arr[3] * 10 + arr[0]);
		min = Math.min(min, arr[2] * 1000 + arr[3] * 100 + arr[0] * 10 + arr[1]);
		min = Math.min(min, arr[3] * 1000 + arr[0] * 100 + arr[1] * 10 + arr[2]);
		
		return min;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = "";
		for(int i = 0; i < 4; i++)
			str += input.nextInt();
		
		int n = isClockNum(str);
		int cnt = 0;
		for(int i = 1111; i <= n; i++) {
			if(isClockNum(Integer.toString(i)) == i)
				cnt++;
		}
		System.out.println(cnt);
		input.close();
	}

}
