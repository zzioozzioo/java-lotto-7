package lotto.constants;

import static lotto.constants.NumberConstants.MAXIMUM_BUY_AMOUNT;
import static lotto.constants.NumberConstants.MINIMUM_BUY_AMOUNT;
import static lotto.constants.StringConstants.NEW_LINE;

public class ErrorMessages {

    public static final String ERROR_MESSAGES_PREFIX = "[ERROR] ";


    public static final String BUY_AMOUNT_OUT_OF_RANGE_ERROR =
            ERROR_MESSAGES_PREFIX + "구입 금액은 " + MINIMUM_BUY_AMOUNT + "원 이상 " + MAXIMUM_BUY_AMOUNT + "원 이하여야 합니다."
                    + NEW_LINE;
    public static final String BUY_AMOUNT_HAS_CHANGE_ERROR =
            ERROR_MESSAGES_PREFIX + "구입 금액은 로또 한 장의 가격으로 나누어 떨어져야 합니다." + NEW_LINE;
    public static final String BUY_AMOUNT_NOT_NUMERIC_ERROR = ERROR_MESSAGES_PREFIX + "구입 금액은 숫자만 입력해야 합니다." + NEW_LINE;


    public static final String NUMBER_OUT_OF_RANGE_ERROR =
            ERROR_MESSAGES_PREFIX + "번호는 1 이상 45 이하의 자연수여야 합니다." + NEW_LINE;
    public static final String INVALID_LOTTO_NUMBER_COUNT_ERROR = ERROR_MESSAGES_PREFIX + "로또 번호는 6개여야 합니다." + NEW_LINE;
    public static final String DUPLICATED_LOTTO_NUMBER_ERROR =
            ERROR_MESSAGES_PREFIX + "중복된 번호가 있습니다. 다시 입력해 주세요." + NEW_LINE;
}
