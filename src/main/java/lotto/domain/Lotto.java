package lotto.domain;

import static lotto.constants.ErrorMessages.DUPLICATED_LOTTO_NUMBER_ERROR;
import static lotto.constants.ErrorMessages.INVALID_LOTTO_NUMBER_COUNT_ERROR;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers); // 오름차순 정렬
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateDuplication(numbers);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_ERROR);
        }
    }

    // TODO: 추가 기능 구현
    
    public List<Integer> getNumbers() {
        return numbers;
    }
}
