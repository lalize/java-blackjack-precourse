package domain.user;

import java.util.Collections;
import java.util.List;

import domain.card.Card;

public class Cards {
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

	public Score getScore() {
		Score score = Score.ZERO;
		for (Card card : cards) {
			score = card.calculate(score);
		}
		if (hasAce()) {
			return score.plusAceBonusIfNotBust();
		}
		return score;
	}

	private boolean hasAce() {
		return cards.stream().anyMatch(Card::isAce);
	}

	public boolean isBlackjack() {
		return cards.size() == BLACKJACK_SIZE && getScore().isBlackjack();
	}

	public boolean isNotBlackjack() {
		return cards.size() != BLACKJACK_SIZE || getScore().isNotBlackjack();
	}

	public boolean isBust() {
		return getScore().isBust();
	}

	public boolean isNotBust() {
		return getScore().isNotBust();
	}

	public boolean isWin(Cards cards) {
		return isNotBust() && (cards.isBust() || getScore().isGreaterThan(cards.getScore()));
	}
}
