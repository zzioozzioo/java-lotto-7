package lotto.constants;

import static lotto.constants.NumberConstants.MAXIMUM_BUY_AMOUNT;
import static lotto.constants.NumberConstants.MINIMUM_BUY_AMOUNT;

public class ErrorMessages {

    public static final String ERROR_MESSAGES_PREFIX = "[ERROR] ";

    public static final String BUY_AMOUNT_OUT_OF_RANGE_ERROR =
            ERROR_MESSAGES_PREFIX + "구입 금액은 " + MINIMUM_BUY_AMOUNT + "원 이상 " + MAXIMUM_BUY_AMOUNT + "원 이하여야 합니다.";
    public static final String BUY_AMOUNT_HAS_CHANGE_ERROR =
            ERROR_MESSAGES_PREFIX + "구입 금액은 로또 한 장의 가격으로 나누어 떨어져야 합니다.";
    public static final String WINNING_NUMBER_OUT_OF_RANGE_ERROR = "[ERROR] 당첨 번호는 1 이상 45 이하의 자연수여야 합니다.";
}
