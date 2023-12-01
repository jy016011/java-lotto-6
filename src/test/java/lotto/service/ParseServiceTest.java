package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParseServiceTest {
    @DisplayName("입력이 하나라도 숫자가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5,a"})
    @ParameterizedTest
    void inputAnyNotNumber(String userInput) {
        assertThatThrownBy(() -> ParseService.toNumbers(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 숫자가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"a"})
    @ParameterizedTest
    void inputNotNumber(String userInput) {
        assertThatThrownBy(() -> ParseService.toNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
