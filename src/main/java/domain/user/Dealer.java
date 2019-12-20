package domain.user;

import domain.card.CardDeck;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer extends Player {
    private static final String NAME = "딜러";
    private static final double BETTING_MONEY = 0;

    public Dealer() {
        super(NAME, BETTING_MONEY);
    }

    public void giveCard(CardDeck cardDeck, Player player) {
        player.addCard(cardDeck.pop());
    }
}
