package lotto.io.parser;

import static lotto.constants.NumberConstants.LOTTO_TICKET_PRICE;
import static lotto.constants.NumberConstants.MAXIMUM_BUY_AMOUNT;
import static lotto.constants.NumberConstants.MINIMUM_BUY_AMOUNT;
import static lotto.util.Utils.parseStringToInt;
import static lotto.util.Utils.validateEmptyInput;

import lotto.exception.InvalidInputException;

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
            throw new InvalidInputException();
        }
    }

    private void validateHasChange(Long buyAmount) {
        if (buyAmount % LOTTO_TICKET_PRICE != 0) {
            throw new InvalidInputException();
        }
    }
}
