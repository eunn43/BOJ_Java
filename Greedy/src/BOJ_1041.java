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
			//corner : 3면을 가진 모서리 부분의 합
			corner = top + dice[plane[i][0]] + dice[plane[i][1]];
			//edge : 2면을 가진 테두리 부분의 합
			edge = top + dice[i+1] > dice[plane[i][0]] + dice[plane[i][1]] ? 
					dice[plane[i][0]] + dice[plane[i][1]] : top + dice[i+1];
			if(minCorner > corner)
				minCorner = corner;
			if(minEdge > edge)
				minEdge = edge;
		}
		BigInteger tmp = BigInteger.valueOf(4 * minCorner);	//모서리는 항상 위의 4개만 존재
		result = result.add(tmp);
		
		tmp = BigInteger.valueOf((8*n - 12) * minEdge);		//테두리는 윗 부분(n-2) * 4와 아래의 (n-1) * 4가 존재
		result = result.add(tmp);							//(n-2)*4+(n-1)*4 = 8*n - 12
		
		tmp = BigInteger.valueOf(n);						//정육면체 한 면에 n*n의 주사위면이 존재하고 이가 5개 존재하므로 n*n*5
		tmp = tmp.multiply(BigInteger.valueOf(n*5));
		tmp = tmp.add(BigInteger.valueOf(-16*n + 12));		//모서리는 3개의 주사위 면을 가지므로 -12 테두리는 2개의 주사위 면을 가지므로
															//2*(8*n-12) = 16*n-24 이 둘을 더해서 빼주어야 하므로 -16*n+12를 더함
		tmp = tmp.multiply(BigInteger.valueOf(min));		//이렇게 구한 나머지 면들을 주사위의 가장 최솟값으로 더해줌
		result = result.add(tmp);
		
		System.out.println(result);
	}

}
