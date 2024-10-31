package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000L, "2,000,000,000"),
    SECOND(5, 30_000_000L, "30,000,000"),
    THIRD(5, 1_500_000L, "1,500,000"),
    FOURTH(4, 50_000L, "50,000"),
    FIFTH(3, 5_000L, "5,000"),
    NONE(0, 0L, "0");

    private final int score;
    private final long prize;

    private final String stringPrize;

    Rank(int score, long prize, String stringPrize) {
        this.score = score;
        this.prize = prize;
        this.stringPrize = stringPrize;
    }

    public static Rank findRank(int score, boolean isBonusMatches) {
        if (FIRST.getScore() == score) {
            return FIRST;
        }
        if (SECOND.getScore() == score) {
            if (isBonusMatches) {
                return SECOND;
            }
            return THIRD;
        }
        if (FOURTH.getScore() == score) {
            return FOURTH;
        }
        if (FIFTH.getScore() == score) {
            return FIFTH;
        }
        return NONE;
    }

    public int getScore() {
        return score;
    }

    public long getPrize() {
        return prize;
    }

    public String getStringPrize() {
        return stringPrize;
    }
}
