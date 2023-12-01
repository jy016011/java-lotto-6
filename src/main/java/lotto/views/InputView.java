package lotto.views;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private InputView() {
    }

    public static String requestAmount() {
        System.out.println(LINE_SEPARATOR + "구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String requestWinningLotto() {
        System.out.println(LINE_SEPARATOR + "당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String requestBonusNumber() {
        System.out.println(LINE_SEPARATOR + "보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
