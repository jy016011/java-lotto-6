package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    void setRandomLotteries() {
        gameService = new GameService();
        gameService.setWinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt())).thenReturn(
                    List.of(8, 21, 23, 41, 42, 43),
                    List.of(3, 5, 11, 16, 32, 38),
                    List.of(7, 11, 16, 35, 36, 44),
                    List.of(1, 8, 11, 31, 41, 42),
                    List.of(13, 14, 16, 38, 42, 45),
                    List.of(7, 11, 30, 40, 42, 43),
                    List.of(2, 13, 22, 32, 38, 45),
                    List.of(1, 3, 5, 14, 22, 45)
            );
            gameService.setLotteries("8000");
        }
        gameService.setWinningDetails();
    }

    @DisplayName("로또 등수 기록 확인")
    @Test
    void checkRecordingRanks() {
        assertThat(gameService.getWinningDetails().get(Rank.FIFTH)).isEqualTo(1);
        assertThat(gameService.getWinningDetails().get(Rank.NO_RANK)).isEqualTo(7);
    }

    @DisplayName("로또 수익률 확인")
    @Test
    void checkProfitOfLotto() {
        double roundedProfit = Math.round(gameService.calculateProfit() * 10) / 10.0;
        assertThat(roundedProfit).isEqualTo(62.5);
    }
}
