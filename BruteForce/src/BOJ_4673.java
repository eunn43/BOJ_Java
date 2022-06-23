
public class BOJ_4673 {

	public static void main(String[] args) {
		int arr[] = new int[10001];
		int num, sum;
		for(int i = 1; i <= 10000; i++) {
			sum = num = i;
			while(num != 0) {
				sum += num % 10;
				num /= 10;
			}
			if(sum < 10001)
				arr[sum] = 1;
		}
		
		for(int i = 1; i <= 10000; i++)
			if(arr[i] == 0)
				System.out.println(i);
	}

}
