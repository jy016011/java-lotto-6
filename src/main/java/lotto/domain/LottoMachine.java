package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int COUNT_OF_NUMBERS = 6;
    private static final int LOTTO_PRICE = 1_000;

    private LottoMachine() {
    }

    public static List<Lotto> getRandomLotteries(int amount) {
        int countOfLotto = amount / LOTTO_PRICE;
        List<Lotto> lotteries = new ArrayList<>();
        for (int count = 1; count <= countOfLotto; count++) {
            lotteries.add(getRandomLotto());
        }
        return lotteries;
    }

    public static Lotto getRandomLotto() {
        List<Integer> numbers = pickRandomNumbers();
        return new Lotto(numbers);
    }

    private static List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_OF_NUMBERS);
    }
}
