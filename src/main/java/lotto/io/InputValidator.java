package lotto.io;

import static lotto.constants.ExceptionMessages.EMPTY_WINNING_NUMBER_INPUT;
import static lotto.constants.ExceptionMessages.ILLEGAL_NUMBER_FORMAT;

public class InputValidator {

    public Long validateBuyAmount(String buyAmount) {
        try {
            return Long.parseLong(buyAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_FORMAT);
        }
    }

    public void validateWinningNumbers(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_WINNING_NUMBER_INPUT);
        }
    }

    public int validateBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_FORMAT);
        }
    }
}
