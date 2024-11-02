package lotto.service;

import static lotto.constants.ExceptionMessages.ILLEGAL_NUMBER_FORMAT;
import static lotto.constants.StringConstants.COMMA;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class ConverterService {

    public Lotto convertWinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers;

        try {
            winningNumbers = Arrays.stream(inputWinningNumbers.split(COMMA))
                    .map(number -> Integer.parseInt(number.trim()))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_FORMAT);
        }

        return new Lotto(winningNumbers);
    }

}
