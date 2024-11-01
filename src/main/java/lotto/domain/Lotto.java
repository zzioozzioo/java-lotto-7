package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicatedNumber(numbers);
        validateNumbersOutOfRange(numbers);
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }

    private void validateNumbersOutOfRange(List<Integer> numbers) {
        numbers.stream().forEach(number -> {
                    if (number > 45 || number < 1) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1부터 45까지입니다.");
                    }
                }
        );
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
