import java.util.Scanner;

public class MatAverage {

	public static void main(String[] args) {
		Scanner num = new Scanner(System.in);
		int i=0;
		int sum=0;
		int dnum[]= new int[5];
		
		System.out.println("dnum �迭�� ����: "+dnum.length);
		for(i=0;i<dnum.length;i++)
		System.out.println("�ʱ�ȭ �������� dnum[]�� ��: "+dnum[i]);
		
		for(i=0;i<5;i++)
		{
			System.out.println("dnum["+i+"]��° ������ �Է�");
			dnum[i] = num.nextInt();
		}
		
		
		for(i=0;i<dnum.length;i++){
		sum+= dnum[i];
		}
		System.out.println("�迭�� ���� "+sum+"�Դϴ�.");
		
		int avg=0;
		avg = sum / dnum.length;
		System.out.println("����� "+avg+"��");
	}
	
	

}
