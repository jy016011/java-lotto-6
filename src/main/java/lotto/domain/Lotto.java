package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.utils.ArgumentValidator;

public class Lotto {
    private static final int COUNT_OF_NUMBERS = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
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
        ArgumentValidator.isEqual(numbers.size(), COUNT_OF_NUMBERS);
        ArgumentValidator.isUniqueNumbersInRange(numbers, MIN_NUMBER, MAX_NUMBER);
    }

    private void sortNumbersByNaturalOrder() {
        numbers.sort(Comparator.naturalOrder());
    }

}
