package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import domain.card.CardDeck;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.WhetherAddCard;
import view.InputView;
import view.OutputView;

public class BlackjackController {
	private static final int ONE = 1;
	private static final int TWO = 2;

	private final CardDeck cardDeck;
	private final Dealer dealer;
	private final List<Player> players;

	public BlackjackController() {
		cardDeck = new CardDeck();
		dealer = new Dealer();
		players = createPlayers();
	}

	public List<Player> createPlayers() {
		List<Player> players = new ArrayList<>();
		String[] names = InputView.getPlayerNames();
		for (final String name : names) {
			Player player = new Player(name, InputView.getBettingMoney(name));
			players.add(player);
		}
		return players;
	}

	private void firstGiveTwoCard() {
		IntStream.of(ONE, TWO).forEach(i -> dealer.giveCard(cardDeck, dealer));
		IntStream.of(ONE, TWO).forEach(i -> dealer.giveCard(cardDeck, players));
		OutputView.printFirstGiveTwoCard(dealer, players);
	}

	private void addMoreCardPlayer(Player player) {
		while (WhetherAddCard.of(InputView.getWhetherAddCard(player.getName())).isYes()
				&& player.isNotBust()) {
			dealer.giveCard(cardDeck, player);
			OutputView.printCards(player.getName(), player.getCards());
		}
	}

	private void addMoreCardPlayers() {
		for (Player player : players) {
			addMoreCardPlayer(player);
		}
	}
}
