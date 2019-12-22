package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final Name name;
    private final BettingMoney bettingMoney;
    private final Cards cards;

    public Player(String name, double bettingMoney) {
        this.name = new Name(name);
        this.bettingMoney = new BettingMoney(bettingMoney);
        this.cards = new Cards(new ArrayList<>());
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name.get();
    }

    public double getBettingMoney() {
        return bettingMoney.get();
    }

    public List<Card> getCards() {
        return cards.get();
    }

    public int getScore() {
        return cards.getScore().get();
    }

    public boolean isBlackjack() {
        return cards.isBlackjack();
    }

    public boolean isNotBlackjack() {
        return cards.isNotBlackjack();
    }

    public boolean isBust() {
        return cards.isBust();
    }

    public boolean isNotBust() {
        return cards.isNotBust();
    }
}
