package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRangeNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또안에 있으면 참이다.")
    @Test
    void lottoContainsBonusNumber() {
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lotto.contains(bonusNumber)).isEqualTo(true);
    }

    @DisplayName("당첨 번호와 구매한 로또의 일치하는 번호갯수 확인")
    @Test
    void getCountOfMatchedWithWinningLotto() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lotto.getCountOfMatched(winningLotto)).isEqualTo(5);
    }

    @DisplayName("로또의 번호는 오름차순 정렬이어야 한다.")
    @Test
    void checkNumbersInLottoIsSorted() {
        Lotto lotto = new Lotto(List.of(6, 5, 3, 4, 1, 2));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}