package getcard;

import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class awd {

	public static void main(String args[]) {

		// ---------------------------------------------------------

		// ī�� ���� ���ڸ� �Է¹ޱ����� �Լ� �� ��������

		// ---------------------------------------------------------

		String[][] suit = new String[2][10];

		int[] gamer = new int[14];

		String number = "NA23456789TJQK";

		int i, j, k, temp, a2 = 0, a = 0, winnum, win = 0, z = 0;
		int[] winner = new int[2];
		int[] count = new int[2];
		int[] flush = new int[2];
		int[] straight = new int[2];
		int[][] num = new int[2][2];
		int[] straightnum = new int[2];

		String temp_s;
		String key;

		// ---------------------------------------------------------

		// ī�� ������ ����ϱ����� do-while ���Ӱ��� �ʱ�ȭ �ʿ�

		// ---------------------------------------------------------
			System.out.println("     This is your Card!!");
			System.out.println("");

			// -------------------52�� ī���ѹ��� �����-------------------

			Random card = new Random();

					for (i = 0; i < 14; i++)
						gamer[i] = Math.abs(card.nextInt() % 52);
						
					for (i = 0; i < 14; i++) {
						for (j = 0; j <14 ; j++) {
							// -------------------���� �ٸ�ī�尡 ���ö�����
							// �ݺ��Ѵ�-------------------
							if( (i != j) && (gamer[i] == gamer[j]) ){
								gamer[j] = card.nextInt(52) + 1;
					}
	
			
			
				for (i = 0; i < 14; i++){ // � ���� �޾Ҵ��� ����Ѵ�
					System.out.print("     " + gamer[i]);
				System.out.println("");
				}
			 }
			}
	}
}
			