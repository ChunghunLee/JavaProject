import java.util.Scanner;

class OddSum {
	int sum,i;
	int cal(int n) {
		for (i = 1; i <= n; i=i+2)
			sum += i;
		return sum;
	}
}

class evenSum extends OddSum{
	int cal1(int n){
	for(i=2;i<=n;i+=2)
			 sum+=i;
	return sum;
	}
	int j=cal(3);
}

public class MidEx3 {

	public static void main(String[] args) {
		OddSum ob2 = new OddSum();
		evenSum ob3 = new evenSum();
		
	System.out.print("������ ���� ���ΰ� ");
	Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		System.out.println("Ȧ�� ����"+ob2.cal(n)+"�̴�");
		System.out.println("¦�� ����"+ob3.cal(n)+"�̴�");
		System.out.println(ob3.j);
	}

}