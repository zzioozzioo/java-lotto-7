package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoGenerationServiceTest {

    @Test
    void 로또_발행_테스트() {
        //given
        long buyAmount = 1000;
        LottoGenerationService lottoGenerationService = new LottoGenerationService();
        List<Lotto> lottos;

        //when
        int lottoCount = lottoGenerationService.getLottoCount(buyAmount);
        lottos = lottoGenerationService.generateLotto(lottoCount);

        //then
        assertThat(lottos.size()).isEqualTo(1);
    }

    @Test
    void 로또_번호_오름차순_정렬_테스트() {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(3, 1, 4, 2, 6, 5));
        LottoGenerationService service = new LottoGenerationService();

        //when
        List<Integer> sortedNumbers = service.sortNumbers(numbers);

        //then
        Assertions.assertThat(List.of(1, 2, 3, 4, 5, 6)).isEqualTo(sortedNumbers);
    }
}
