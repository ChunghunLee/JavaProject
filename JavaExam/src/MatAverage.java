import java.util.Scanner;

public class MatAverage {

	public static void main(String[] args) {
		Scanner num = new Scanner(System.in);
		int i=0;
		int sum=0;
		int dnum[]= new int[5];
		
		System.out.println("dnum 배열의 길이: "+dnum.length);
		for(i=0;i<dnum.length;i++)
		System.out.println("초기화 하지않은 dnum[]의 값: "+dnum[i]);
		
		for(i=0;i<5;i++)
		{
			System.out.println("dnum["+i+"]번째 데이터 입력");
			dnum[i] = num.nextInt();
		}
		
		
		for(i=0;i<dnum.length;i++){
		sum+= dnum[i];
		}
		System.out.println("배열의 합은 "+sum+"입니다.");
		
		int avg=0;
		avg = sum / dnum.length;
		System.out.println("평균은 "+avg+"임");
	}
	
	

}
