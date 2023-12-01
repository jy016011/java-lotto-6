package lotto.views;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream captor;

    @BeforeEach
    public void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void reset() {
        System.setOut(standardOut);
        captor.reset();
        Console.close();
    }

    private String output() {
        return captor.toString();
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @DisplayName("구임금액 입력 확인")
    @Test
    void requestAmountInput() {
        String userInput = "8000";
        command(userInput);
        String systemReceived = InputView.requestAmount();
        assertThat(output()).contains("구입금액을 입력해 주세요.");
        assertThat(systemReceived).isEqualTo(userInput);
    }

    @DisplayName("당첨번호 입력 확인")
    @Test
    void requestWinningLotto() {
        String userInput = "1,2,3,4,5,6";
        command(userInput);
        String systemReceived = InputView.requestWinningLotto();
        assertThat(output()).contains("당첨 번호를 입력해 주세요.");
        assertThat(systemReceived).isEqualTo(userInput);
    }
}
