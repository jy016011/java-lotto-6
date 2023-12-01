package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.ArgumentValidator;

public class WinningNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(Lotto lotto, int bonusNumber) {
        this.winningLotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        List<Integer> numbers = new ArrayList<>(winningLotto.getNumbers());
        numbers.add(bonusNumber);
        ArgumentValidator.isUniqueNumbersInRange(numbers, MIN_NUMBER, MAX_NUMBER);
    }
}
