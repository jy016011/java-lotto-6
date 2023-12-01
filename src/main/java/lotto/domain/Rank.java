package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NO_RANK(0, 0L, ""),
    FIFTH(3, 5_000L, "3개 일치"),
    FOURTH(4, 50_000L, "4개 일치"),
    THIRD(5, 1_500_000L, "5개 일치"),
    SECOND(5, 30_000_000L, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000L, "6개 일치");
    private final int countOfMatch;
    private final long prize;
    private final String condition;

    Rank(int countOfMatch, long prize, String condition) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
        this.condition = condition;
    }

    public static Rank getBy(int countOfMatch, boolean bonusMatched) {
        Rank rank = Arrays.stream(values())
                .filter(r -> r.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(NO_RANK);
        if (rank == THIRD && bonusMatched) {
            return SECOND;
        }
        return rank;
    }

    public long getPrize() {
        return prize;
    }

    public String getCondition() {
        return condition;
    }
}
