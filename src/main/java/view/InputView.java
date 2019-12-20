package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String NAME_DELIMITER = ",";
	private static final String GET_PLAYER_NAMES_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
	private static final String GET_BETTING_MONEY_FORMAT = "%s의 베팅 금액은?\n";

	public static String[] getPlayerNames() {
		System.out.println(GET_PLAYER_NAMES_MESSAGE);
		return SCANNER.nextLine().split(NAME_DELIMITER);
	}

	public static double getBettingMoney(String name) {
		System.out.printf(GET_BETTING_MONEY_FORMAT, name);
		return Double.parseDouble(SCANNER.nextLine());
	}
}
