package domain.card;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {
	private final Stack<Card> cards = new Stack<>();

	public CardDeck() {
		cards.addAll(CardFactory.create());
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card pop() {
		return cards.pop();
	}
}
