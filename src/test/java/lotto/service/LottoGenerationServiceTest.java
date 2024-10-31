package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

public class LottoGenerationServiceTest {

    @Test
    void 로또_발행_테스트() {
        //given
        long buyAmount = 1000;
        LottoGenerationService lottoGenerationService = new LottoGenerationService(buyAmount);
        List<Lotto> lottos;

        //when
        lottos = lottoGenerationService.generateLotto();

        //then
        assertThat(lottos.size()).isEqualTo(1);
    }
}
