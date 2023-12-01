package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SellerTest {
    @DisplayName("구매 금액 입력 검증 확인")
    @ValueSource(strings = {"1000j", "0", "101000", "1200"})
    @ParameterizedTest
    void checkAmountWithInvalidInput(String userInput) {
        Seller seller = new Seller();
        assertThatThrownBy(() -> seller.sellLotto(userInput)).isInstanceOf(IllegalArgumentException.class);
    }
}
