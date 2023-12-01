package lotto.views;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String requestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
}
