package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 로또_번호와_당첨_번호_비교_테스트() {
        //given
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        //when
        int matchCount = winningLotto.countMatchingNumbers(userLotto);

        //then
        assertThat(matchCount).isEqualTo(5);
    }
}
