import java.util.Scanner;

class MyExp{
	int base;
	int exp;
	
	int getValue(int base, int exp)
	{		
		int num=1;
		for(int i=1;i<=exp;i++)
		num *= base;
		
		return num;
	}
}
public class ClassExpEx {

	public static void main(String[] args) {
		MyExp Expnum = new MyExp();
		Scanner stdin = new Scanner(System.in);
		Scanner stdout = new Scanner(System.in);
		
		System.out.println("밑을 입력하세요");
		int base = stdin.nextInt();
		
		System.out.println("지수를 입력하세요");
		int exp = stdout.nextInt();
		
		System.out.println("이 수는 "+Expnum.getValue(base, exp)+"입니다");
	}

}
