import java.util.Scanner;

class Sum{
	int sum;
	public int oddsum(int x,int y)
	{
		if(x%2==0) x++;
		for(int i=x;i<=y;i=i+2)
		{
			sum=sum+i;
		}
		return sum;
	}
	
	public int evensum(int x,int y){
		if(x%2==1) x++;
		for(int i=x;i<=y;i=i+2)
		{
			sum=sum+i;
		}
		return sum;
	}
}
public class ClassEx2 {
	public static void main(String[] args) {
		
		Scanner std1 = new Scanner(System.in);
		Scanner std2 = new Scanner(System.in);
		
		int n = std1.nextInt();
		int m = std2.nextInt();
		
		Sum a = new Sum();
		
		System.out.println(n+"부터"+m+"까지 홀수의 합: "
		+a.oddsum(n, m));
		

	}
	

}
