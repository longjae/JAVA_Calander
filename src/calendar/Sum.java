package calendar;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
//		System.out.println("두 수를 입력하세요");
//		Scanner scanner = new Scanner(System.in);
//		String inputValue = scanner.nextLine();
//		
//		String[] splitedValue = inputValue.split(" ");
//		int first = Integer.parseInt(splitedValue[0]);
//		int second = Integer.parseInt(splitedValue[1]);
//		
//		System.out.println("두 수의 합은 " + (first + second) + " 입니다.");
		
		int a,b;
		System.out.println("두 수를 입력해 주세요");
		Scanner scanner = new Scanner(System.in);
		String s1, s2;
		s1 = scanner.next();
		s2 = scanner.next();

		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
		//System.out.println(a + ", " + b);
//		int c = a + b;
//		System.out.println("두 수의 합은 " + c + "입니다.");
		//System.out.printf("두 수의 합은 %d 입니다.", a+b);
		System.out.printf("%d와 %d의 합은 %d입니다.", a, b, a+b);
		scanner.close();
	}

}
