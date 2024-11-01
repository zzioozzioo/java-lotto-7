package lotto.service;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Rank;

public class CalculatorService {


    public long calculateWinnings(Map<Rank, Integer> winningResult) {
        long sum = 0;
        for (Entry<Rank, Integer> entry : winningResult.entrySet()) {
            sum += entry.getKey().getPrize() * entry.getValue();
        }
        return sum;
    }


    public double calculateRateOfReturn(long buyAmount, long prize) {
        return ((double) prize / buyAmount) * 100.0;
    }
}
