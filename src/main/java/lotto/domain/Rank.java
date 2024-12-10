package lotto.domain;

public enum Rank {

    NONE(0, 0L, "0"),
    FIFTH(3, 5_000L, "5,000"),
    FOURTH(4, 50_000L, "50,000"),
    THIRD(5, 1_500_000L, "1,500,000"),
    SECOND(5, 30_000_000L, "30,000,000"),
    FIRST(6, 2_000_000_000L, "2,000,000,000");

    private final int matchCount;
    private final Long prize;
    private final String stringPrize;

    Rank(int matchCount, Long prize, String stringPrize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.stringPrize = stringPrize;
    }

    // 일치 개수에 따라 순위 반환하는 메서드
    public static Rank getRank(int matchCount, boolean bonusMatch) {
        // TODO: 로직 리팩토링하기
        if (matchCount == FIRST.getMatchCount()) {
            return FIRST;
        }
        if (matchCount == SECOND.getMatchCount() && bonusMatch) {
            return SECOND;
        }
        if (matchCount == THIRD.getMatchCount()) {
            return THIRD;
        }
        if (matchCount == FOURTH.getMatchCount()) {
            return FOURTH;
        }
        if (matchCount == FIFTH.getMatchCount()) {
            return FIFTH;
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Long getPrize() {
        return prize;
    }

    public String getStringPrize() {
        return stringPrize;
    }
}
