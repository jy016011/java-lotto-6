package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ArgumentValidator;
import lotto.utils.StringParser;

public class ParseService {
    private static final String NUMBER_SEPARATOR = ",";

    private ParseService() {
    }

    public static List<Integer> toNumbers(String userInput) {
        List<String> separatedInput = StringParser.toTrimmedStringList(userInput, NUMBER_SEPARATOR);
        return separatedInput.stream()
                .map(ParseService::toNumber)
                .collect(Collectors.toList());
    }

    public static int toNumber(String userInput) {
        ArgumentValidator.isNumber(userInput);
        return StringParser.toInteger(userInput);
    }
}
