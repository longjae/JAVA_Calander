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
		
		String PROMPT = "cal> ";
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		
		int month = 1;
		
		while (true) {
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if (month == -1) {
				break;
			} else if (month > 12) {
				continue;
			}
			System.out.printf("%d월은  %d일까지 있습니다. \n", month, cal.getMaxDaysOfMonth(month));
		}
	
		System.out.println("Bye~");
		scanner.close();
	}
}