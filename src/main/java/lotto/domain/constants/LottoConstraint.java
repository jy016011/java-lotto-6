package lotto.domain.constants;

public enum LottoConstraint {
    UNIT_PRICE(1_000),
    MAX_AMOUNT(100_000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    COUNT_OF_NUMBERS(6);

    private final int value;

    LottoConstraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
