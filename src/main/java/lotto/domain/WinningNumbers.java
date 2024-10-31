package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    // TODO: 클래스명 WinningLotto 고민해보기

    private final Lotto winningLottoNumbers;
    private final int winningBonusNumber;

    public WinningNumbers(Lotto winningLottoNumbers, int winningBonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.winningBonusNumber = winningBonusNumber;
    }

    public int countMatchingNumbers(Lotto userLotto) {
        List<Integer> userLottoList = userLotto.getNumbers();
        List<Integer> winningLottoNumbersList = winningLottoNumbers.getNumbers();

        List<Integer> matchNumbersList = new ArrayList<>(userLottoList);
        matchNumbersList.retainAll(winningLottoNumbersList);

        return matchNumbersList.size();
    }


    public boolean isBonusNumberEqual(int bonusNumber) {
        return bonusNumber == winningBonusNumber;
    }
}
