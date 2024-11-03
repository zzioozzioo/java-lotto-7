//package lotto.view;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
//
//import java.io.ByteArrayInputStream;
//import org.junit.jupiter.api.Test;
//
//class InputViewTest {
//
//    @Test
//    void 구입_금액_입력_시_입력값이_존재하지_않는_경우() {
//        //given
//        InputView inputView = new InputView();
//        System.setIn(new ByteArrayInputStream("".getBytes()));
//
//        //when & then
//        assertThatThrownBy(inputView::readBuyAmount)
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void 구입_금액_입력_시_입력값이_숫자가_아닌_경우() {
//        //given
//        InputView inputView = new InputView();
//        System.setIn(new ByteArrayInputStream("1000j".getBytes()));
//
//        //when & then
//        assertThatThrownBy(inputView::readBuyAmount)
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void 당첨_번호_입력_시_입력값이_존재하지_않는_경우() {
//        //given
//        InputView inputView = new InputView();
//        System.setIn(new ByteArrayInputStream("".getBytes()));
//
//        //when & then
//        assertThatThrownBy(inputView::readWinningNumbers)
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void 보너스_번호_입력_시_입력값이_존재하지_않는_경우() {
//        //given
//        InputView inputView = new InputView();
//        System.setIn(new ByteArrayInputStream("".getBytes()));
//
//        //when & then
//        assertThatThrownBy(inputView::readBonusNumber)
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//}