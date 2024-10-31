package lotto.service;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.SECOND;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    @Test
    void 당첨금_계산_테스트() {
        //given
        CalculatorService calculatorService = new CalculatorService();
        Rank rank = SECOND;

        //when
        long winnings = calculatorService.calculateWinnings(rank);

        //then
        assertThat(winnings).isEqualTo(30_000_000L);
    }

    @Test
    void 수익률_계산_테스트() {
        //given
        CalculatorService calculatorService = new CalculatorService();

        long buyAmount = 1_000L;
        long prize = FIFTH.getPrize();

        //when
        double rateOfReturn = calculatorService.calculateRateOfReturn(buyAmount, prize);

        //then
        assertThat(rateOfReturn).isEqualTo(500.0);
    }
}