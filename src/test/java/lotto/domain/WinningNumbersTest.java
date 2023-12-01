package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.StringParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersTest {
    @DisplayName("중복되거나 범위 밖의 보너스 번호 입력시 예외 발생")
    @ValueSource(strings = {"6", "0", "46"})
    @ParameterizedTest
    void createWinningNumbersWithInvalidBonusNumber(String userInput) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = StringParser.toInteger(userInput);
        assertThatThrownBy(() -> new WinningNumbers(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("등수 없음")
    @Test
    void getNoRank() {
        WinningNumbers winningNumbers = getWinningNumbers();
        Lotto lotto = new Lotto(List.of(2, 3, 7, 8, 9, 10));
        assertThat(winningNumbers.getRankOf(lotto)).isEqualTo(Rank.NO_RANK);
    }

    @DisplayName("5등")
    @Test
    void getFifth() {
        WinningNumbers winningNumbers = getWinningNumbers();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(winningNumbers.getRankOf(lotto)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("4등")
    @Test
    void getFourth() {
        WinningNumbers winningNumbers = getWinningNumbers();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        assertThat(winningNumbers.getRankOf(lotto)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3등")
    @Test
    void getThird() {
        WinningNumbers winningNumbers = getWinningNumbers();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(winningNumbers.getRankOf(lotto)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("2등")
    @Test
    void getSecond() {
        WinningNumbers winningNumbers = getWinningNumbers();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningNumbers.getRankOf(lotto)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("1등")
    @Test
    void getFirst() {
        WinningNumbers winningNumbers = getWinningNumbers();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningNumbers.getRankOf(lotto)).isEqualTo(Rank.FIRST);
    }

    private WinningNumbers getWinningNumbers() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        return new WinningNumbers(winningLotto, bonusNumber);
    }
}
