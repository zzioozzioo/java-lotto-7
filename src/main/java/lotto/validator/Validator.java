package lotto.validator;

import static lotto.constants.ExceptionMessages.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.constants.ExceptionMessages.BUY_AMOUNT_HAS_CHANGE;
import static lotto.constants.ExceptionMessages.LOTTO_COUNT_OUT_OF_RANGE;
import static lotto.constants.NumberConstants.LOTTO_END_NUM;
import static lotto.constants.NumberConstants.LOTTO_START_NUM;
import static lotto.constants.NumberConstants.MAX_TICKET_BUY_AMOUNT;
import static lotto.constants.NumberConstants.TICKET_PRICE;
import static lotto.constants.NumberConstants.ZERO;

public class Validator {

    public static void validateBuyAmount(long buyAmount) {
        validateLottoCount(buyAmount);
        validateBuyAmountHasChange(buyAmount);
    }

    private static void validateLottoCount(long buyAmount) {
        if (buyAmount < TICKET_PRICE || buyAmount > MAX_TICKET_BUY_AMOUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_OUT_OF_RANGE);
        }
    }

    private static void validateBuyAmountHasChange(long buyAmount) {
        if (buyAmount % TICKET_PRICE != ZERO) {
            throw new IllegalArgumentException(BUY_AMOUNT_HAS_CHANGE);
        }
    }

    public static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LOTTO_START_NUM || bonusNumber > LOTTO_END_NUM) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE);
        }
    }
}
