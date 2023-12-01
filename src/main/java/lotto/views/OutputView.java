package lotto.views;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private OutputView() {
    }

    public static void printUserLotteries(List<Lotto> lotteries) {
        StringBuilder formOfLotteries = new StringBuilder(
                LINE_SEPARATOR + lotteries.size() + "개를 구매했습니다."
        );
        for (Lotto lotto : lotteries) {
            formOfLotteries.append(LINE_SEPARATOR)
                    .append(lotto.getNumbers());
        }
        System.out.println(formOfLotteries);
    }

    public static void printWinningStatistics(Map<Rank, Integer> winningDetails, double profit) {
        printPrefaceOfResult();
        for (Rank rank : Rank.values()) {
            if (winningDetails.containsKey(rank)) {
                printEachRankResult(rank, winningDetails.get(rank));
                continue;
            }
            printEachRankResult(rank, 0);
        }
        printProfit(profit);
    }

    private static void printPrefaceOfResult() {
        System.out.println(
                LINE_SEPARATOR + "당첨 통계" +
                        LINE_SEPARATOR + "---"
        );
    }

    private static void printEachRankResult(Rank rank, int count) {
        if (rank != Rank.NO_RANK) {
            System.out.println(rank.getCondition() + String.format(" (%,d원) - %d개", rank.getPrize(), count));
        }
    }

    private static void printProfit(double profit) {
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }
}
