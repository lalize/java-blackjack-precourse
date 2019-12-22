package domain.user;

import java.util.Collections;
import java.util.List;

import domain.card.Card;

public class Cards {
	private static final int ACE_BONUS = 10;
	private static final int BLACKJACK_SCORE = 21;
	private static final int BLACKJACK_SIZE = 2;

	private final List<Card> cards;

	public Cards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Card> get() {
		return Collections.unmodifiableList(cards);
	}

	public void add(Card card) {
		cards.add(card);
	}

	public int getScore() {
		int score = cards.stream().mapToInt(Card::getScore).sum();
		boolean hasAce = cards.stream().anyMatch(Card::isAce);
		if (hasAce && score + ACE_BONUS <= BLACKJACK_SCORE) {
			score += ACE_BONUS;
		}
		return score;
	}

	public boolean isBlackjack() {
		return cards.size() == BLACKJACK_SIZE && getScore() == BLACKJACK_SCORE;
	}

	public boolean isNotBlackjack() {
		return cards.size() != BLACKJACK_SIZE || getScore() != BLACKJACK_SCORE;
	}

	public boolean isBust() {
		return getScore() > BLACKJACK_SCORE;
	}

	public boolean isNotBust() {
		return getScore() <= BLACKJACK_SCORE;
	}
}
