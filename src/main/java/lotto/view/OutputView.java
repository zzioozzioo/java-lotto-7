package lotto.view;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResult(Map<Rank, Integer> winningResult) {
        System.out.println(
                FIFTH.getScore() + "개 일치 (" + FIFTH.getStringPrize() + "원) - " + winningResult.get(FIFTH) + "개\n"
                        + FOURTH.getScore() + "개 일치 (" + FOURTH.getStringPrize() + "원) - " + winningResult.get(FOURTH)
                        + "개\n"
                        + THIRD.getScore() + "개 일치 (" + THIRD.getStringPrize() + "원) - " + winningResult.get(THIRD)
                        + "개\n"
                        + SECOND.getScore() + "개 일치, 보너스 볼 일치 (" + SECOND.getStringPrize() + "원) - "
                        + winningResult.get(SECOND)
                        + "개\n"
                        + FIRST.getScore() + "개 일치 (" + FIRST.getStringPrize() + "원) - " + winningResult.get(FIRST)
                        + "개");
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
