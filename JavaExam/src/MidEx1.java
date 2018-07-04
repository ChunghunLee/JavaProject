
import java.util.Scanner;

public class MidEx1 {
	public static void main(String[] args) {
		Scanner std1 = new Scanner(System.in);
		System.out.print("정수를 입력(초단위): ");
		double sec = std1.nextInt();
		 
		double min , hour ;
		min = sec / 60;
		hour = min / 60;
		
		System.out.println(sec+"초는 "+min+"분 "+hour+"시간입니다.");
}
}