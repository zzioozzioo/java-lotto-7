package lotto.util;

import static lotto.constants.ErrorMessages.BUY_AMOUNT_NOT_NUMERIC_ERROR;
import static lotto.constants.StringConstants.COMMA;

public class Utils {
    public static void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static int parseStringToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BUY_AMOUNT_NOT_NUMERIC_ERROR);
        }
    }

    public static String[] splitInputWithComma(String input) {
        return input.split(COMMA, -1);
    }
}
