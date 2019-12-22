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

	public static void printFirstGiveTwoCard(Dealer dealer, List<Player> players) {
		System.out.printf(FIRST_GIVE_TWO_CARD_FORMAT, dealer.getName(),
				players.stream().map(Player::getName).collect(Collectors.joining(DELIMITER)));
		for (Player player : players) {
			printCards(player.getName(), player.getCards());
		}
		final int FACE_UP_CARD_INDEX = 0;
		final int FACE_UP_CARD_COUNT = 1;
		printCards(dealer.getName(), dealer.getCards().subList(FACE_UP_CARD_INDEX, FACE_UP_CARD_COUNT));
	}

	public static void printCards(String name, List<Card> cards) {
		System.out.printf(CARDS_FORMAT, name, cards.stream().map(Card::getName).collect(Collectors.joining(DELIMITER)));
	}
}
