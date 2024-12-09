package lotto.io.parser;

import static lotto.constants.ErrorMessages.BUY_AMOUNT_HAS_CHANGE_ERROR;
import static lotto.constants.ErrorMessages.BUY_AMOUNT_OUT_OF_RANGE_ERROR;
import static lotto.constants.ErrorMessages.WINNING_NUMBER_OUT_OF_RANGE_ERROR;
import static lotto.constants.NumberConstants.LOTTO_TICKET_PRICE;
import static lotto.constants.NumberConstants.MAXIMUM_BUY_AMOUNT;
import static lotto.constants.NumberConstants.MAXIMUM_WINNING_NUMBER;
import static lotto.constants.NumberConstants.MINIMUM_BUY_AMOUNT;
import static lotto.constants.NumberConstants.MINIMUM_WINNING_NUMBER;
import static lotto.util.Utils.parseStringToInt;
import static lotto.util.Utils.splitInputWithComma;
import static lotto.util.Utils.validateEmptyInput;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public Long parseBuyAmount(String input) {
        validateEmptyInput(input);
        Long buyAmount = Long.valueOf(parseStringToInt(input));
        validateBuyAmount(buyAmount);
        return buyAmount;
    }

    private void validateBuyAmount(Long buyAmount) {
        validateHasChange(buyAmount);
        validateBuyAmountRange(buyAmount);
    }

    private void validateBuyAmountRange(Long buyAmount) {
        if (buyAmount < MINIMUM_BUY_AMOUNT || buyAmount > MAXIMUM_BUY_AMOUNT) {
            throw new IllegalArgumentException(BUY_AMOUNT_OUT_OF_RANGE_ERROR);
        }
    }

    private void validateHasChange(Long buyAmount) {
        if (buyAmount % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(BUY_AMOUNT_HAS_CHANGE_ERROR);
        }
    }

    public List<Integer> parseWinningNumber(String input) {
        validateEmptyInput(input);
        return parseStringWinningNumber(input);
    }

    private List<Integer> parseStringWinningNumber(String input) {
        List<Integer> parsedNumbers = new ArrayList<>();
        String[] numbers = splitInputWithComma(input);
        for (String number : numbers) {
            int parsedNumber = parseStringToInt(number);
            validateWinningNumber(parsedNumber);
            parsedNumbers.add(parsedNumber);
        }
        return parsedNumbers;
    }

    private void validateWinningNumber(int parsedNumber) {
        if (parsedNumber < MINIMUM_WINNING_NUMBER || parsedNumber > MAXIMUM_WINNING_NUMBER) {
            throw new IllegalArgumentException(WINNING_NUMBER_OUT_OF_RANGE_ERROR);
        }
    }
}