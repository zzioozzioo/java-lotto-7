package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoGenerationService {

    private static final long LOTTO_PRICE = 1000;


    public List<Lotto> generateLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            numbers = sortNumbers(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public int getLottoCount(long buyAmount) {
        return (int) (buyAmount / LOTTO_PRICE);
    }

    public List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
