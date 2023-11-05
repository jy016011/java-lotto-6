package lotto.domain;

import java.util.List;
import lotto.constants.Rank;

public class LottoScoreChecker {
    private final WinningNumbers winningNumbers = new WinningNumbers();

    public void setFirstRankNumbers(List<String> inputNumbers) {
        winningNumbers.setFirstRankLotto(inputNumbers);
    }

    public void setBonusNumber(String userInput) {
        winningNumbers.setBonusNumber(userInput);
    }

    public Rank getRank(Lotto lotto) {
        int matchedCount = compareToFirstRankNumber(lotto);
        boolean isMatchedWithBonusNumber = compareToBonusNumber(lotto);
        Rank rank = Rank.getRankByMatchCount(matchedCount);
        if (rank == Rank.FIVE_MATCH && isMatchedWithBonusNumber) {
            return Rank.FIVE_AND_BONUS_MATCH;
        }
        return rank;
    }

    public int compareToFirstRankNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> firstRankNumbers = winningNumbers.getFirstRankLotto().getNumbers();
        return numbers.stream().filter(firstRankNumbers::contains).toList().size();
    }

    public boolean compareToBonusNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();
        return numbers.contains(bonusNumber);
    }
}
