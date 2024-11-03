//package lotto.view;
//
//import static lotto.domain.Rank.FIFTH;
//import static lotto.domain.Rank.FIRST;
//import static lotto.domain.Rank.FOURTH;
//import static lotto.domain.Rank.NONE;
//import static lotto.domain.Rank.SECOND;
//import static lotto.domain.Rank.THIRD;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import lotto.domain.Lotto;
//import lotto.domain.Rank;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class OutputViewTest {
//
//    private static ByteArrayOutputStream outputMessage;
//
//    @BeforeEach
//    void setUpStreams() {
//        outputMessage = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputMessage));
//    }
//
//    @AfterEach
//    void restoresStreams() {
//        System.setOut(System.out);
//    }
//
//    @Test
//    void 발행한_로또_수량_출력_테스트() {
//        //given
//        int lottoCount = 3;
//
//        OutputView outputView = new OutputView();
//
//        //when
//        outputView.printLottoCount(lottoCount);
//
//        //then
//        assertThat(outputMessage.toString()).isEqualTo("3개를 구매했습니다.\n");
//    }
//
//    @Test
//    void 발행한_로또_번호_출력_테스트() {
//        //given
//        List<Lotto> lottos = List.of(
//                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),
//                new Lotto(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12)))
//        );
//
//        OutputView outputView = new OutputView();
//
//        //when
//        outputView.printLottoNumbers(lottos);
//
//        //then
//        assertThat(outputMessage.toString())
//                .isEqualTo("[1, 2, 3, 4, 5, 6]\n"
//                        + "[7, 8, 9, 10, 11, 12]\n");
//    }
//
//    @Test
//    void 당첨_내역_출력_테스트() {
//        //given
//        Map<Rank, Integer> winningResult = Map.of(
//                FIRST, 0,
//                SECOND, 0,
//                THIRD, 1,
//                FOURTH, 0,
//                FIFTH, 1,
//                NONE, 2
//        );
//        OutputView outputView = new OutputView();
//
//        //when
//        outputView.printWinningResult(winningResult);
//
//        //then
//        assertThat(outputMessage.toString())
//                .isEqualTo("3개 일치 (5,000원) - 1개\n"
//                        + "4개 일치 (50,000원) - 0개\n"
//                        + "5개 일치 (1,500,000원) - 1개\n"
//                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
//                        + "6개 일치 (2,000,000,000원) - 0개\n");
//    }
//
//    @Test
//    void 수익률_출력_테스트() {
//        //given
//        double rateOfReturn = 50.0;
//        OutputView outputView = new OutputView();
//
//        //when
//        outputView.printRateOfReturn(rateOfReturn);
//
//        //then
//        assertThat(outputMessage.toString())
//                .isEqualTo("총 수익률은 50.0%입니다.\n");
//    }
//}
