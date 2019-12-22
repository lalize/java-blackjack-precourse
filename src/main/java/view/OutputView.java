package view;

import java.util.List;
import java.util.stream.Collectors;

import domain.card.Card;
import domain.user.Dealer;
import domain.user.Player;

public class OutputView {
	private static final String DELIMITER = ", ";
	private static final String FIRST_GIVE_TWO_CARD_FORMAT = "%s와 %s에게 두 장의 카드를 나누었습니다.\n";
	private static final String CARDS_FORMAT = "%s 카드 : %s\n";
	private static final String CARD_RESULT_FORMAT = "%s 카드 : %s - 결과: %d\n";

	public static void printFirstGiveTwoCard(Dealer dealer, List<Player> players) {
		System.out.printf(FIRST_GIVE_TWO_CARD_FORMAT, dealer.getName(),
				players.stream().map(Player::getName).collect(Collectors.joining(DELIMITER)));
		final int FACE_UP_CARD_INDEX = 0;
		final int FACE_UP_CARD_COUNT = 1;
		printCards(dealer.getName(), dealer.getCards().subList(FACE_UP_CARD_INDEX, FACE_UP_CARD_COUNT));
		for (Player player : players) {
			printCards(player.getName(), player.getCards());
		}
	}

	public static void printAddCardDealer() {
		System.out.println("딜러는 16이하라 한 장의 카드를 더 받았습니다.");
	}

	public static void printCards(String name, List<Card> cards) {
		System.out.printf(CARDS_FORMAT, name, cards.stream().map(Card::getName).collect(Collectors.joining(DELIMITER)));
	}

	public static void printResult(Player player) {
		System.out.printf(CARD_RESULT_FORMAT, player.getName(),
				player.getCards().stream().map(Card::getName).collect(Collectors.joining(DELIMITER)),
				player.getScore());
	}

	public static void printResults(Dealer dealer, List<Player> players) {
		printResult(dealer);
		for (Player player : players) {
			printResult(player);
		}
	}
}
