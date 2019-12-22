package domain.user;

import domain.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private static final int ACE_BONUS = 10;
    private static final int BLACKJACK_SCORE = 21;
    private static final int BLACKJACK_SIZE = 2;

    private final Name name;
    private final BettingMoney bettingMoney;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = new Name(name);
        this.bettingMoney = new BettingMoney(bettingMoney);
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
        return Collections.unmodifiableList(cards);
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
