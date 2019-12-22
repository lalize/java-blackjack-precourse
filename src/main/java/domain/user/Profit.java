package domain.user;

public class Profit {
	private static final double BLACKJACK_RATE = 1.5;
	public static final Profit ZERO = new Profit(0);

	private final double profit;

	public Profit(double profit) {
		this.profit = profit;
	}

	public double get() {
		return profit;
	}

	public Profit calculate(Profit profit) {
		return new Profit(this.profit - profit.profit);
	}

	public Profit ifBlackjack() {
		return new Profit(profit * BLACKJACK_RATE);
	}

	public Profit ifLose() {
		return new Profit(-profit);
	}
}
