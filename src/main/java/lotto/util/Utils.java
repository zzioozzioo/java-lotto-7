package lotto.util;

import lotto.exception.InvalidInputException;

public class Utils {
    public static void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException();
        }
    }

    public static int parseStringToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }
}
