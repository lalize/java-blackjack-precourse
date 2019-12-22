package domain.user;

public enum WhetherAddCard {
	Y,
	N;

	public static WhetherAddCard of(String name) {
		return WhetherAddCard.valueOf(name.toUpperCase());
	}

	public boolean isYes() {
		return this == Y;
	}
}
