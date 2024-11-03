package lotto.domain;

import static lotto.constants.ExceptionMessages.DUPLICATED_LOTTO_NUMBER;
import static lotto.constants.ExceptionMessages.LOTTO_NUMBER_COUNT_OUT_OF_RANGE;
import static lotto.constants.ExceptionMessages.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumbersOutOfRange(numbers);
        validateDuplicatedNumber(numbers);
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_OUT_OF_RANGE);
        }
    }

    private void validateNumbersOutOfRange(List<Integer> numbers) {
        numbers.stream().forEach(number -> {
                    if (number > 45 || number < 1) {
                        throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE);
                    }
                }
        );
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != 6) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
