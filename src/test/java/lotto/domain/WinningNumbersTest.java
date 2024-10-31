package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 로또_번호와_당첨_번호_비교_테스트() {
        //given
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int winningBonusNumber = 7;

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, winningBonusNumber);

        //when
        int matchCount = winningNumbers.countMatchingNumbers(userLotto);
        boolean matchBonusNumber = winningNumbers.isBonusNumberEqual(winningBonusNumber);

        //then
        assertThat(matchCount).isEqualTo(5);
        assertThat(matchBonusNumber).isTrue();
    }
}
