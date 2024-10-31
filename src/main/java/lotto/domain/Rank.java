package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int score;
    private final long prize;

    Rank(int score, long prize) {
        this.score = score;
        this.prize = prize;
    }

    public int getScore() {
        return score;
    }

    public long getPrize() {
        return prize;
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
}
