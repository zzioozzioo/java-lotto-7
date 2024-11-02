package lotto.domain.winning;

import static lotto.controller.LottoController.initializeResultMap;
import static lotto.domain.Rank.findRank;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.dto.UserLotto;
import lotto.dto.WinningResult;

public class Winning {


    // TODO: buyAmount, winningLotto, bonusNumber 객체 파라미터 전달 다시 고민해 보기,,
    public WinningResult calculate(UserLotto userLotto, long buyAmount, WinningLotto winningLotto, int bonusNumber) {

        Map<Rank, Integer> result = initializeResultMap();
        long prize = 0L;

        return WinningResult.of(calculateResult(userLotto, result, winningLotto, bonusNumber),
                calculateTotalPrize(result, prize),
                calculateRateOfReturn(buyAmount, prize)
        );
    }

    private Map<Rank, Integer> calculateResult(UserLotto userLotto, Map<Rank, Integer> result,
                                               WinningLotto winningLotto, int bonusNumber) {
        for (Lotto lotto : userLotto.getLottos()) {
            int score = winningLotto.countMatchingNumbers(lotto);
            boolean isBonusMatches = false;
            if (lotto.getNumbers().contains(bonusNumber)) {
                isBonusMatches = true;
            }

            Rank rank = findRank(score, isBonusMatches);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private long calculateTotalPrize(Map<Rank, Integer> result, long prize) {
        for (Entry<Rank, Integer> entry : result.entrySet()) {
            prize += entry.getKey().getPrize() * entry.getValue();
        }
        return prize;
    }

    private double calculateRateOfReturn(long buyAmount, long prize) {
        return ((double) prize / buyAmount) * 100.0;
    }
}
