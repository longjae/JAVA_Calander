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

	public int parseDay(String week) {
		switch (week) {
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
		PlanItem plan;
		plan = c.searchPlan(date);
		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.out.println("일정이 없습니다.");
		}
	}

	private void cmdRegister(Scanner s, Calendar c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요. (yyyy-MM-dd)");
		String date = s.next();
		String text = "";
		System.out.println("일정을 입력해주세요. (문장 끝에 ;을 입력해주세요)");
		String word;
		while (!(word = s.next()).endsWith(";")) {
			text += word + " ";
		}
		word = word.replace(";", "");
		text += word;
		c.registerPlan(date, text);
	}
	
	public void runPrompt() throws ParseException {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령(1, 2, 3, h, q)");
			String cmd = scanner.next();
			switch (cmd) {
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

	public static void main(String[] args) throws ParseException {

		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}