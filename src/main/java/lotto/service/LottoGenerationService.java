package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerationService {

    private static final long LOTTO_PRICE = 1000;
    private final long buyAmount;

    public LottoGenerationService(long buyAmount) {
        this.buyAmount = buyAmount;
    }

    public List<Lotto> generateLotto() {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < getLottoCount(); count++) {
            lottos.add(new Lotto(pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    private long getLottoCount() {
        return buyAmount / LOTTO_PRICE;
    }
}
