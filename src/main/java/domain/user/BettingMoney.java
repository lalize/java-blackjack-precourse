package domain.user;

public class BettingMoney {
	private static final double MIN = 1;
	private static final String MIN_ERROR = "베팅 금액이 " + MIN + "보다 작습니다.";

	private final double bettingMoney;

	public BettingMoney(double bettingMoney) {
		validate(bettingMoney);
		this.bettingMoney = bettingMoney;
	}

	public static void validate(double bettingMoney) {
		if (bettingMoney < MIN) {
			throw new IllegalArgumentException(MIN_ERROR);
		}
	}

	public double get() {
		return bettingMoney;
	}
}
