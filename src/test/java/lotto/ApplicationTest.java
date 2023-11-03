package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import lotto.userInterface.InputViewer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

//    @Test
//    void 기능_테스트() {
//        assertRandomUniqueNumbersInRangeTest(
//                () -> {
//                    run("8000", "1,2,3,4,5,6", "7");
//                    assertThat(output()).contains(
//                            "8개를 구매했습니다.",
//                            "[8, 21, 23, 41, 42, 43]",
//                            "[3, 5, 11, 16, 32, 38]",
//                            "[7, 11, 16, 35, 36, 44]",
//                            "[1, 8, 11, 31, 41, 42]",
//                            "[13, 14, 16, 38, 42, 45]",
//                            "[7, 11, 30, 40, 42, 43]",
//                            "[2, 13, 22, 32, 38, 45]",
//                            "[1, 3, 5, 14, 22, 45]",
//                            "3개 일치 (5,000원) - 1개",
//                            "4개 일치 (50,000원) - 0개",
//                            "5개 일치 (1,500,000원) - 0개",
//                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
//                            "6개 일치 (2,000,000,000원) - 0개",
//                            "총 수익률은 62.5%입니다."
//                    );
//                },
//                List.of(8, 21, 23, 41, 42, 43),
//                List.of(3, 5, 11, 16, 32, 38),
//                List.of(7, 11, 16, 35, 36, 44),
//                List.of(1, 8, 11, 31, 41, 42),
//                List.of(13, 14, 16, 38, 42, 45),
//                List.of(7, 11, 30, 40, 42, 43),
//                List.of(2, 13, 22, 32, 38, 45),
//                List.of(1, 3, 5, 14, 22, 45)
//        );
//    }

//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() -> {
//            runException("1000j");
//            assertThat(output()).contains(ERROR_MESSAGE);
//        });
//    }

    @DisplayName("구매 금액 입력 테스트")
    @Test
    void 구매금액_입력_테스트() {
        command("1000");
        String userInput = InputViewer.requestAmountInput();
        assertThat(output()).contains("구입금액을 입력해 주세요.");
        assertThat(userInput).contains("1000");
        Console.close();
    }

    @DisplayName("당첨번호 입력 테스트")
    @Test
    void 당첨번호_입력_테스트() {
        command("1,2,3,4,5,6");
        String userInput = InputViewer.requestWinningNumberInput();
        assertThat(output()).contains("당첨 번호를 입력해 주세요.");
        assertThat(userInput).contains("1,2,3,4,5,6");
        Console.close();
    }

    @DisplayName("입력한 금액에 맞는 갯수만큼 로또 번호를 출력한다.")
    @Test
    @SuppressWarnings("unchecked")
    void 자동_로또_출력테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
