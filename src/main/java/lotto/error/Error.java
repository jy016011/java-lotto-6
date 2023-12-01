package lotto.error;

public enum Error {
    HEADER("[ERROR]"),
    INVALID_AMOUNT(HEADER.message + " 1000원 단위 이상, 10만원 이하의 금액을 입력하세요."),
    INVALID_WINNING_LOTTO(HEADER.message + " 1이상 45이하의 중복없는 수 6개를 입력하세요."),
    INVALID_BONUS_NUMBER(HEADER.message + "당첨 번호와 중복되지 않는 1이상 45이하의 수를 입력하세요.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
