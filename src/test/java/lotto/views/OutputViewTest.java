package lotto.views;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream captor;

    @BeforeEach
    public void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void reset() {
        System.setOut(standardOut);
        captor.reset();
    }

    private String output() {
        return captor.toString();
    }

    @DisplayName("구매한 로또 출력 확인")
    @Test
    void printAllLotteries() {
        List<Lotto> lotteries = new ArrayList<>(
                List.of(
                        new Lotto(List.of(1, 2, 3, 6, 5, 4)),
                        new Lotto(List.of(7, 8, 12, 10, 11, 9))
                )
        );
        OutputView.printUserLotteries(lotteries);
        assertThat(output()).contains(
                "2개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]"
        );
    }

    @DisplayName("당첨 통계 출력 확인")
    @Test
    void printAllResult() {
        Map<Rank, Integer> winningDetails = new HashMap<>();
        winningDetails.put(Rank.FIFTH, 1);
        winningDetails.put(Rank.NO_RANK, 7);
        double profit = 62.5;
        OutputView.printWinningStatistics(winningDetails, profit);
        assertThat(output()).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 62.5%입니다."
        );
    }
}
