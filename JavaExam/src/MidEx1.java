
import java.util.Scanner;

public class MidEx1 {
	public static void main(String[] args) {
		Scanner std1 = new Scanner(System.in);
		System.out.print("������ �Է�(�ʴ���): ");
		double sec = std1.nextInt();
		 
		double min , hour ;
		min = sec / 60;
		hour = min / 60;
		
		System.out.println(sec+"�ʴ� "+min+"�� "+hour+"�ð��Դϴ�.");
}
}