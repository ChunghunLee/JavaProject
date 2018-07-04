package getcard;

import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class awd {

	public static void main(String args[]) {

		// ---------------------------------------------------------

		// 카드 모양과 숫자를 입력받기위한 함수 및 변수선언

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

		// 카드 게임을 계속하기위한 do-while 게임값의 초기화 필요

		// ---------------------------------------------------------
			System.out.println("     This is your Card!!");
			System.out.println("");

			// -------------------52장 카드한벌을 만든다-------------------

			Random card = new Random();

					for (i = 0; i < 14; i++)
						gamer[i] = Math.abs(card.nextInt() % 52);
						
					for (i = 0; i < 14; i++) {
						for (j = 0; j <14 ; j++) {
							// -------------------서로 다른카드가 나올때까지
							// 반복한다-------------------
							if( (i != j) && (gamer[i] == gamer[j]) ){
								gamer[j] = card.nextInt(52) + 1;
					}
	
			
			
				for (i = 0; i < 14; i++){ // 어떤 수를 받았는지 출력한다
					System.out.print("     " + gamer[i]);
				System.out.println("");
				}
			 }
			}
	}
}
			