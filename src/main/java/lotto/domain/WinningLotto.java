package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.BonusNumberDuplicatedLottoNumberException;

public class WinningLotto {

    private final Lotto winningLottoNumbers;
    // TODO: 필드에 bonusNumber 추가하는 거 고민해 보기

    public WinningLotto(Lotto winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public int countMatchingNumbers(Lotto lotto) {
        List<Integer> userLottoList = lotto.getNumbers();
        List<Integer> winningLottoNumbersList = winningLottoNumbers.getNumbers();

        List<Integer> matchNumbersList = new ArrayList<>(userLottoList);
        matchNumbersList.retainAll(winningLottoNumbersList);

        return matchNumbersList.size();
    }

    public void validateDuplicateBonusNumber(int bonusNumber) {
        if (winningLottoNumbers.getNumbers().contains(bonusNumber)) {
            throw new BonusNumberDuplicatedLottoNumberException();
        }
    }
}
