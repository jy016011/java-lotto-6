package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.StringParser;
import org.junit.jupiter.api.DisplayName;
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
}
