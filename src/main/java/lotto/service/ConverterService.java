package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class ConverterService {

    public static final Long TICKET_PRICE = 1_000L;
    public static final Long MAX_TICKET_BUY_AMOUNT = 100_000L;
    public static final int ZERO = 0;
    public static final int LOTTO_START_NUM = 1;
    public static final int LOTTO_END_NUM = 45;
    public static final String COMMA = ",";

    public long convertBuyAmount(String inputBuyAmount) {
        long buyAmount;

        try {
            buyAmount = Long.parseLong(inputBuyAmount);

            validateLottoCount(buyAmount);
            validateBuyAmountHasChange(buyAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        return buyAmount;
    }

    private static void validateLottoCount(long buyAmount) {
        if (buyAmount < TICKET_PRICE || buyAmount > MAX_TICKET_BUY_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 로또는 한 장 이상, 백 장 이하로 구매할 수 있습니다.");
        }
    }

    private static void validateBuyAmountHasChange(long buyAmount) {
        if (buyAmount % TICKET_PRICE != ZERO) {
            throw new IllegalArgumentException("[ERROR] 로또 가격으로 나누어 떨어지지 않습니다.");
        }
    }

    public Lotto convertWinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers;

        try {
            winningNumbers = Arrays.stream(inputWinningNumbers.split(COMMA))
                    .map(number -> Integer.parseInt(number.trim()))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        return new Lotto(winningNumbers);
    }

    public int convertBonusNumber(String inputBonusNumber) {
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(inputBonusNumber);
            validateBonusNumberRange(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        return bonusNumber;
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LOTTO_START_NUM || bonusNumber > LOTTO_END_NUM) {
            throw new IllegalArgumentException();
        }
    }
}
