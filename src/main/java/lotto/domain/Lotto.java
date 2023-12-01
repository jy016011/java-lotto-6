package lotto.domain;

import static lotto.domain.constants.LottoConstraint.COUNT_OF_NUMBERS;
import static lotto.domain.constants.LottoConstraint.MAX_NUMBER;
import static lotto.domain.constants.LottoConstraint.MIN_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.utils.ArgumentValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbersByNaturalOrder();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int getCountOfMatched(Lotto other) {
        return (int) other.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        validateCountOfNumbers(numbers);
        validateIsUniqueNumbersInRange(numbers);
    }

    private void validateCountOfNumbers(List<Integer> numbers) {
        ArgumentValidator.isEqual(numbers.size(), COUNT_OF_NUMBERS.getValue());
    }

    private void validateIsUniqueNumbersInRange(List<Integer> numbers) {
        ArgumentValidator.isUniqueNumbersInRange(numbers, MIN_NUMBER.getValue(), MAX_NUMBER.getValue());
    }

    private void sortNumbersByNaturalOrder() {
        numbers.sort(Comparator.naturalOrder());
    }

}
