package calender;

import java.util.Scanner;

public class Calender {
	
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month-1];
		/*
		 * switch (month){
		 * case 2:
		 *     return 28;
		 * case 4:
		 *     return 30;
		 * case 6:
		 *     return 30;
		 * case 9:
		 *     return 30;
		 * case 11:
		 *     return 30;
		 * default:
		 *     return 31;    
		 * }
		 */
		
	}
	
	public void printSampleCalender() {
		System.out.println(" 일    월    화    수    목    금    토");
		System.out.println("--------------------");
		System.out.println("30 31  1  2  3  4  5");
		System.out.println(" 6  7  8  9 10 11 12");
		System.out.println("13 14 15 16 17 18 19");
		System.out.println("20 21 22 23 24 25 26");
		System.out.println("27 28 29 30  1  2  3"); // ctrl + shift + f를 누르면 자동 정렬
	}
	
	public static void main(String[] args) {
		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		// 1,3,5,7,8,10,12 -> 31일
		// 4,6,9,11 -> 30일
		// 2 -> 28일
		/*System.out.println("달을 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		String month_str;
		month_str = scanner.next();
		int month = scanner.nextInt();
		if (month == 1||month == 3||month == 5||month == 7||month == 8||month == 10||month == 12) {
			System.out.printf("%d월은 31일까지 있습니다.", month);
		} else if (month == 4||month == 6||month == 9||month == 11) {
			System.out.printf("%d월은 30일까지 있습니다.", month);
		} else {
			System.out.printf("&d월은 28일까지 있습니다.", month);
		}
		scanner.close();*/
		
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		System.out.println("달을 입력하세요.");
		int month = scanner.nextInt();
		
		System.out.printf("%d월은  %d일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
		scanner.close();
	}

}
