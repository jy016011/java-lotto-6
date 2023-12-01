package lotto.domain;

import java.util.List;
import lotto.utils.ArgumentValidator;
import lotto.utils.StringParser;

public class Seller {
    private static final int LOTTO_PRICE = 1_000;
    private static final int MAX_AMOUNT = 100_000;
    private int amount;

    public List<Lotto> sellLotto(String userInput) {
        int amount = StringParser.toInteger(userInput);
        checkAmount(amount);
        this.amount = amount;
        return LottoMachine.getRandomLotteries(amount);
    }

    public int getAmount() {
        return amount;
    }

    private void checkAmount(int amount) {
        validateMinAmount(amount);
        validateMaxAmount(amount);
        validateUnitPrice(amount);
    }

    private void validateMinAmount(int amount) {
        ArgumentValidator.isNotLessThan(amount, LOTTO_PRICE);
    }

    private void validateMaxAmount(int amount) {
        ArgumentValidator.isNotGreaterThan(amount, MAX_AMOUNT);
    }

    private void validateUnitPrice(int amount) {
        ArgumentValidator.isDivisor(amount, LOTTO_PRICE);
    }

}
