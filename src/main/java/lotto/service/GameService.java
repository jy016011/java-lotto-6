package lotto.service;

import static lotto.domain.constants.LottoConstraint.UNIT_PRICE;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Seller;
import lotto.domain.WinningNumbers;

public class GameService {
    private static final int COUNT_ONE = 1;
    private static final int TO_PERCENTAGE = 100;
    private WinningNumbers winningNumbers;
    private List<Lotto> lotteries;
    private Map<Rank, Integer> winningDetails;

    public void setLotteries(String userInput) {
        Seller seller = new Seller();
        lotteries = seller.sellLotto(userInput);
    }

    public List<Lotto> getLotteries() {
        return Collections.unmodifiableList(lotteries);
    }

    public void setWinningNumbers(Lotto winningLotto, int bonusNumber) {
        winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
    }

    public void setWinningDetails() {
        winningDetails = new HashMap<>();
        for (Lotto lotto : lotteries) {
            recordEachScore(lotto);
        }
    }

    public Map<Rank, Integer> getWinningDetails() {
        return Collections.unmodifiableMap(winningDetails);
    }

    public double calculateProfit() {
        int amount = lotteries.size() * UNIT_PRICE.getValue();
        return (double) getTotalPrize() / amount * TO_PERCENTAGE;
    }

    private long getTotalPrize() {
        long totalPrize = 0;
        for (Rank rank : winningDetails.keySet()) {
            totalPrize += winningDetails.get(rank) * rank.getPrize();
        }
        return totalPrize;
    }

    private void recordEachScore(Lotto lotto) {
        Rank rank = winningNumbers.getRankOf(lotto);
        if (winningDetails.containsKey(rank)) {
            winningDetails.put(rank, winningDetails.get(rank) + COUNT_ONE);
            return;
        }
        winningDetails.put(rank, COUNT_ONE);
    }
}
