package lotto.dto;

import java.util.Map;
import lotto.domain.Rank;

public class WinningResult {

    private final Map<Rank, Integer> result;
    private final double rateOfReturn;

    public WinningResult(Map<Rank, Integer> result, double rateOfReturn) {
        this.result = result;
        this.rateOfReturn = rateOfReturn;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
