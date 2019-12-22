package controller;

import java.util.ArrayList;
import java.util.List;

import domain.card.CardDeck;
import domain.user.Dealer;
import domain.user.Player;
import view.InputView;

public class BlackjackController {
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
}
