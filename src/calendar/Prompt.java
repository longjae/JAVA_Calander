package calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록     	        ");
		System.out.println("| 2. 일정 검색          			");
		System.out.println("| 3. 달력 보기          			");
		System.out.println("| h. 도움말  q. 종료   	    ");
		System.out.println("+----------------------+");
	}

	// @param week 요일 명
	// @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
	public int parseDay(String week) {
		switch(week) {
		case "SU":
			return 0;
		case "MO":
			return 1;
		case "TU":
			return 2;
		case "WE":
			return 3;
		case "TH":
			return 4;
		case "FR":
			return 5;
		case "SA":
			return 6;
		default:
			return 0;
		}
	}

	public void runPrompt() throws ParseException {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령(1, 2, 3, h, q)");
			String cmd = scanner.next();
			switch(cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}

		System.out.println("Thank You. Bye~");
		scanner.close();
	}
	
	private void cmdCal(Scanner s, Calendar c) {
		int month = 1;
		int year = 2021;
		
		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR> ");
		year = s.nextInt();
		
		System.out.println("월을 입력하세요.");
		System.out.print("MONTH >");
		month = s.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return; // 메소드를 종료하려면 return을 사용
		}
		
		c.printCalender(year, month);		
	}

	private void cmdSearch(Scanner s, Calendar c) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요. (yyyy-MM-dd)");
		String date = s.next();
		String plan = "";
		try {
			plan = c.searchPlan(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);
	}

	private void cmdRegister(Scanner s, Calendar c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요. (yyyy-MM-dd)");
		String date = s.next();
		String text = "";
		System.out.println("일정을 입력해주세요. (문자으이 끝에 ;을 입력해주세요)");
		while (true) {
			String word = s.next();
			text += word + " ";
			if (word.endsWith(";"));{
				break;
			}
		}
		c.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {

		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}