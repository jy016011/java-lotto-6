package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    private static final int INCLUDING_LAST_BLANK = -1;

    private StringParser() {
    }

    public static List<Integer> toIntegers(List<String> strings) {
        return strings.stream()
                .map(StringParser::toInteger)
                .collect(Collectors.toList());
    }

    public static List<String> toTrimmedStringList(String input, String separator) {
        return Arrays.stream(
                        input.split(separator, INCLUDING_LAST_BLANK))
                .map(String::trim).collect(Collectors.toList()
                );
    }

    public static int toInteger(String input) {
        ArgumentValidator.isNumber(input);
        return Integer.parseInt(input);
    }
}
