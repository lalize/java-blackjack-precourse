package domain.card;

import java.util.Stack;

public class CardDeck {
	private final Stack<Card> cards = new Stack<>();

	public CardDeck() {
		cards.addAll(CardFactory.create());
	}
}
