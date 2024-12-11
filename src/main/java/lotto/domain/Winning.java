package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Winning {

    private final Lotto winningLotto;
    private int bonusNumber;

    public Winning(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Map<Rank, Integer> checkWinning(List<Lotto> purchasedLotto) {
        Map<Rank, Integer> winningResult = new HashMap<>();
        for (Lotto lotto : purchasedLotto) {
            // TODO: map에 put이 정상적으로 작동하지 않는 문제 해결(개수가 모두 null로 출력됨)
            setWinningResult(lotto, winningResult);
        }
        return winningResult;
    }

    private void setWinningResult(Lotto lotto, Map<Rank, Integer> winningResult) {
        List<Integer> purchasedNumber = lotto.getNumbers();
        List<Integer> winningNumber = winningLotto.getNumbers();

        int count = getCount(purchasedNumber, winningNumber);
        boolean isBonusMatch = purchasedNumber.contains(bonusNumber);
        Rank rank = Rank.getRank(count, isBonusMatch);

        winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
    }

    private int getCount(List<Integer> purchasedNumber, List<Integer> winningNumber) {
        return (int) purchasedNumber.stream()
                .filter(p -> winningNumber.stream().anyMatch(Predicate.isEqual(p)))
                .count();
    }

    public boolean isDuplicatedNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber; // TODO: 결국 얘도 setter이랑 똑같나?
        return winningLotto.getNumbers().contains(bonusNumber);
    }
}
