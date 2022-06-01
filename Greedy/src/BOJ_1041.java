import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class BOJ_1041 {

	public static void main(String[] args) throws IOException {
		int plane[][] = {{1, 2}, {1, 3}, {3, 4}, {2, 4}};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dice[] = new int[6];
		String str[] = br.readLine().split(" ");
		int min = 51;
		for(int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(str[i]);
			if(min > dice[i])
				min = dice[i];
		}
		
		if(n == 1) {
			int result = 0;
			Arrays.sort(dice);
			for(int i = 0; i < 5; i++)
				result += dice[i];
			System.out.println(result);
			return;
		}
		
		BigInteger result = new BigInteger("0");
		int minCorner = Integer.MAX_VALUE;
		int minEdge = Integer.MAX_VALUE;
		int top = dice[0] < dice[5] ? dice[0] : dice[5];
		int corner, edge;
		for(int i = 0; i < 4; i++) {
			//corner : 3���� ���� �𼭸� �κ��� ��
			corner = top + dice[plane[i][0]] + dice[plane[i][1]];
			//edge : 2���� ���� �׵θ� �κ��� ��
			edge = top + dice[i+1] > dice[plane[i][0]] + dice[plane[i][1]] ? 
					dice[plane[i][0]] + dice[plane[i][1]] : top + dice[i+1];
			if(minCorner > corner)
				minCorner = corner;
			if(minEdge > edge)
				minEdge = edge;
		}
		BigInteger tmp = BigInteger.valueOf(4 * minCorner);	//�𼭸��� �׻� ���� 4���� ����
		result = result.add(tmp);
		
		tmp = BigInteger.valueOf((8*n - 12) * minEdge);		//�׵θ��� �� �κ�(n-2) * 4�� �Ʒ��� (n-1) * 4�� ����
		result = result.add(tmp);							//(n-2)*4+(n-1)*4 = 8*n - 12
		
		tmp = BigInteger.valueOf(n);						//������ü �� �鿡 n*n�� �ֻ������� �����ϰ� �̰� 5�� �����ϹǷ� n*n*5
		tmp = tmp.multiply(BigInteger.valueOf(n*5));
		tmp = tmp.add(BigInteger.valueOf(-16*n + 12));		//�𼭸��� 3���� �ֻ��� ���� �����Ƿ� -12 �׵θ��� 2���� �ֻ��� ���� �����Ƿ�
															//2*(8*n-12) = 16*n-24 �� ���� ���ؼ� ���־�� �ϹǷ� -16*n+12�� ����
		tmp = tmp.multiply(BigInteger.valueOf(min));		//�̷��� ���� ������ ����� �ֻ����� ���� �ּڰ����� ������
		result = result.add(tmp);
		
		System.out.println(result);
	}

}
