package lotto.domain;

import java.util.List;
import lotto.utils.ArgumentValidator;

public class Lotto {
    private static final int COUNT_OF_NUMBERS = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ArgumentValidator.validateSize(numbers.size(), COUNT_OF_NUMBERS);
        ArgumentValidator.validateUniqueNumbersInRange(numbers, MIN_NUMBER, MAX_NUMBER);
    }

}
