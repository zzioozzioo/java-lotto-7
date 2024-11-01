package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

class ConverterServiceTest {

    @Test
    void 구입_금액_형변환_테스트() {
        //given
        ConverterService converterService = new ConverterService();
        String inputBuyAmount = "3000";

        //when
        long buyAmount = converterService.convertBuyAmount(inputBuyAmount);

        //then
        assertThat(buyAmount).isEqualTo(3000L);
    }

    @Test
    void 구입_금액_형변환_예외_테스트() {
        //given
        ConverterService converterService = new ConverterService();
        String inputBuyAmount = "3000+";

        //when & then
        assertThatThrownBy(() -> converterService.convertBonusNumber(inputBuyAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_형변환_테스트() {
        //given
        ConverterService converterService = new ConverterService();
        String inputWinningNumbers = "3,5,1,7,8,2";

        //when
        Lotto actualLotto = converterService.convertWinningNumbers(inputWinningNumbers);
        Lotto expectedLotto = new Lotto(List.of(3, 5, 1, 7, 8, 2));

        //then
        assertThat(actualLotto.getNumbers()).isEqualTo(expectedLotto.getNumbers());
    }

    @Test
    void 당첨_번호_형변환_예외_테스트() {
        //given
        ConverterService converterService = new ConverterService();
        String inputWinningNumbers = "3,r,33,7,40,24";

        //when & then
        assertThatThrownBy(() -> converterService.convertWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_형변환_테스트() {
        //given
        ConverterService converterService = new ConverterService();
        String inputBonusNumber = "35";

        //when
        int bonusNumber = converterService.convertBonusNumber(inputBonusNumber);

        //then
        assertThat(bonusNumber).isEqualTo(35);
    }

    @Test
    void 보너스_번호_형변환_예외_테스트() {
        //given
        ConverterService converterService = new ConverterService();
        String inputBonusNumber = "^^";

        //when & then
        assertThatThrownBy(() -> converterService.convertBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
