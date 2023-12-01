package lotto.domain;

import static lotto.domain.constants.LottoConstraint.MAX_AMOUNT;
import static lotto.domain.constants.LottoConstraint.UNIT_PRICE;

import java.util.List;
import lotto.service.ParseService;
import lotto.utils.ArgumentValidator;

public class Seller {
    private int amount;

    public List<Lotto> sellLotto(String userInput) {
        int amount = ParseService.toNumber(userInput);
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
        ArgumentValidator.isNotLessThan(amount, UNIT_PRICE.getValue());
    }

    private void validateMaxAmount(int amount) {
        ArgumentValidator.isNotGreaterThan(amount, MAX_AMOUNT.getValue());
    }

    private void validateUnitPrice(int amount) {
        ArgumentValidator.isDivisor(amount, UNIT_PRICE.getValue());
    }

}
