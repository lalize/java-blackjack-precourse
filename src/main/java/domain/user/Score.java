package domain.user;

public class Score {
	private static final int BLACKJACK_SCORE = 21;
	private static final int ACE_BONUS = 10;

	public static final Score ZERO = new Score(0);

	private final int score;

	public Score(int score) {
		this.score = score;
	}

	public int get() {
		return score;
	}

	public boolean isBlackjack() {
		return score == BLACKJACK_SCORE;
	}

	public boolean isNotBlackjack() {
		return score != BLACKJACK_SCORE;
	}

	public boolean isBust() {
		return score > BLACKJACK_SCORE;
	}

	public boolean isNotBust() {
		return score <= BLACKJACK_SCORE;
	}

	public Score plus(int score) {
		return new Score(this.score + score);
	}

	public Score plusAceBonusIfNotBust() {
		Score bonus = plus(ACE_BONUS);
		if (bonus.isNotBust()) {
			return bonus;
		}
		return this;
	}

	public boolean isGreaterThan(Score score) {
		return this.score > score.score;
	}
}
