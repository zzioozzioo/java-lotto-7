package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class ConverterService {
    public long convertBuyAmount(String inputBuyAmount) {
        long buyAmount;

        try {
            buyAmount = Long.parseLong(inputBuyAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        return buyAmount;
    }

    public Lotto convertWinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers;

        try {
            winningNumbers = Arrays.stream(inputWinningNumbers.split(","))
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
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        return bonusNumber;
    }
}
