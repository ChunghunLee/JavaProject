import java.util.Arrays;

public class ClassEx1 {

	public static void main(String[] args) {
		int[] a= { 1,2,3,4 };
		int[] b= {4,5,6 };
		int[] c= new int[5];
		System.arraycopy(a, 0, b, 0, 2);  // a에서 인덱스0(처음) 부터 3rㅐ의 요소를
						// b배열에 복사
		System.out.println(Arrays.toString(b));
		System.arraycopy(a,0,c,0,3);
		System.out.println(Arrays.toString(c));

	}

}
