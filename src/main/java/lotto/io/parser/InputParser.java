package lotto.io.parser;

import static lotto.constants.ErrorMessages.BUY_AMOUNT_HAS_CHANGE_ERROR;
import static lotto.constants.ErrorMessages.BUY_AMOUNT_OUT_OF_RANGE_ERROR;
import static lotto.constants.ErrorMessages.NUMBER_OUT_OF_RANGE_ERROR;
import static lotto.constants.NumberConstants.LOTTO_TICKET_PRICE;
import static lotto.constants.NumberConstants.MAXIMUM_BUY_AMOUNT;
import static lotto.constants.NumberConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.constants.NumberConstants.MINIMUM_BUY_AMOUNT;
import static lotto.constants.NumberConstants.MINIMUM_LOTTO_NUMBER;
import static lotto.constants.StringConstants.NEW_LINE;
import static lotto.util.Utils.parseStringToInt;
import static lotto.util.Utils.splitInputWithComma;
import static lotto.util.Utils.validateEmptyInput;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

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
        if (parsedNumber < MINIMUM_LOTTO_NUMBER || parsedNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_ERROR);
        }
    }

    public int parseBonusNumber(String input) {
        validateEmptyInput(input);
        int parsedBonusNumber = parseStringToInt(input);
        validateBonusNumber(parsedBonusNumber);
        return parsedBonusNumber;
    }

    private void validateBonusNumber(int parsedBonusNumber) {
        if (parsedBonusNumber < MINIMUM_LOTTO_NUMBER || parsedBonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_ERROR);
        }
    }

    public String parsePurchasedLotto(List<Lotto> purchasedLotto) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : purchasedLotto) {
            sb.append(lotto).append(NEW_LINE);
        }
        return sb.toString();
    }
}
