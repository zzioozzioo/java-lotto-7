package lotto.service;

import lotto.domain.Rank;

public class CalculatorService {


    public long calculateWinnings(Rank rank) {
        return rank.getPrize();
    }


    public double calculateRateOfReturn(long buyAmount, long prize) {
        return ((double) prize / buyAmount) * 100.0;
    }
}
