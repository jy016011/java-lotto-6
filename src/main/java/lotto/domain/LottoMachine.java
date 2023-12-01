package lotto.domain;

import static lotto.domain.constants.LottoConstraint.COUNT_OF_NUMBERS;
import static lotto.domain.constants.LottoConstraint.MAX_NUMBER;
import static lotto.domain.constants.LottoConstraint.MIN_NUMBER;
import static lotto.domain.constants.LottoConstraint.UNIT_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private LottoMachine() {
    }

    public static List<Lotto> getRandomLotteries(int amount) {
        int countOfLotto = amount / UNIT_PRICE.getValue();
        List<Lotto> lotteries = new ArrayList<>();
        for (int count = 1; count <= countOfLotto; count++) {
            lotteries.add(getRandomLotto());
        }
        return lotteries;
    }

    private static Lotto getRandomLotto() {
        List<Integer> numbers = pickRandomNumbers();
        return new Lotto(numbers);
    }

    private static List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER.getValue(), MAX_NUMBER.getValue(),
                COUNT_OF_NUMBERS.getValue()
        );
    }
}
