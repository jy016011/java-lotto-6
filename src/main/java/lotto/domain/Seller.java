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
        ArgumentValidator.isNotLessThan(amount, LOTTO_PRICE);
        ArgumentValidator.isNotGreaterThan(amount, MAX_AMOUNT);
        ArgumentValidator.isDivisor(amount, LOTTO_PRICE);
    }

}
