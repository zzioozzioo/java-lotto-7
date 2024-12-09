package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constants.NumberConstants.LOTTO_TICKET_PRICE;
import static lotto.constants.NumberConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.constants.NumberConstants.MINIMUM_LOTTO_NUMBER;
import static lotto.constants.NumberConstants.NUMBER_OF_LOTTO_NUMBERS;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {
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
}
