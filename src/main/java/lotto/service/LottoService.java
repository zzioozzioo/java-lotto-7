package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constants.ErrorMessages.DUPLICATED_LOTTO_NUMBER_ERROR;
import static lotto.constants.NumberConstants.LOTTO_TICKET_PRICE;
import static lotto.constants.NumberConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.constants.NumberConstants.MINIMUM_LOTTO_NUMBER;
import static lotto.constants.NumberConstants.NUMBER_OF_LOTTO_NUMBERS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Winning;

public class LottoService {

    // 로또 발행 기능
    public List<Lotto> buyLotto(Long buyAmount) {
        int numberOfLottoTickets = (int) (buyAmount / LOTTO_TICKET_PRICE);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLottoTickets; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(
                    MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS);
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }

    // 당첨 번호(+보너스 번호) 확인
    public Winning getValidWinningNumbers(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_ERROR);
        }
        return new Winning(new Lotto(winningNumber), bonusNumber);
    }

    // 당첨 확인 기능
    public Map<Rank, Integer> checkWinning(List<Lotto> purchasedLotto, Winning winning) {
        return winning.checkWinning(purchasedLotto);
    }

    // 수익률 계산 기능
    public double calculateRateOfReturn(Map<Rank, Integer> winningResult, Long buyAmount) {
        double totalProfit = 0;
        for (Rank rank : winningResult.keySet()) {
            totalProfit += rank.getPrize() * winningResult.get(rank);
        }
        return totalProfit / buyAmount * 100.0;
    }
}
