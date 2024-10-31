package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    // TODO: 일단 보너스 번호 일치 여부 확인은 findRank()에서 담당

    private final Lotto winningLottoNumbers;

    public WinningLotto(Lotto winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public int countMatchingNumbers(Lotto userLotto) {
        List<Integer> userLottoList = userLotto.getNumbers();
        List<Integer> winningLottoNumbersList = winningLottoNumbers.getNumbers();

        List<Integer> matchNumbersList = new ArrayList<>(userLottoList);
        matchNumbersList.retainAll(winningLottoNumbersList);

        return matchNumbersList.size();
    }
}
