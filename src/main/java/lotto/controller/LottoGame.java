package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.error.Error;
import lotto.service.GameService;
import lotto.utils.StringParser;
import lotto.views.InputView;
import lotto.views.OutputView;

public class LottoGame {
    private static final String NUMBER_SEPARATOR = ",";
    private GameService gameService;

    public void init() {
        gameService = new GameService();
    }

    public void run() {
        buyLotto();
        setWinningNumbers();
        printResult();
    }

    private void buyLotto() {
        while (true) {
            try {
                String userInput = InputView.requestAmount();
                gameService.setLotteries(userInput);
                break;
            } catch (IllegalArgumentException e) {
                Error.INVALID_AMOUNT.printMessage();
            }
        }
        OutputView.printUserLotteries(gameService.getLotteries());
    }

    private void setWinningNumbers() {
        Lotto winningLotto = requestWinningLotto();
        requestBonusNumber(winningLotto);
    }

    private Lotto requestWinningLotto() {
        while (true) {
            try {
                String userInput = InputView.requestWinningLotto();
                List<String> parsedInput = StringParser.toTrimmedStringList(userInput, NUMBER_SEPARATOR);
                List<Integer> numbers = StringParser.toIntegers(parsedInput);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                Error.INVALID_WINNING_LOTTO.printMessage();
            }
        }
    }

    private void requestBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String userInput = InputView.requestBonusNumber();
                int bonusNumber = StringParser.toInteger(userInput);
                gameService.setWinningNumbers(winningLotto, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                Error.INVALID_BONUS_NUMBER.printMessage();
            }
        }
    }

    private void printResult() {
        gameService.setWinningDetails();
        OutputView.printWinningStatistics(
                gameService.getWinningDetails(),
                gameService.calculateProfit()
        );
    }
}
