package lotto.views;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private OutputView() {
    }

    public static void printUserLotteries(List<Lotto> lotteries) {
        StringBuilder formOfLotteries = new StringBuilder(lotteries.size() + "개를 구매했습니다.");
        for (Lotto lotto : lotteries) {
            formOfLotteries.append(LINE_SEPARATOR)
                    .append(lotto.getNumbers());
        }
        System.out.println(formOfLotteries);
    }
}
