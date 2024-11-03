package lotto.io;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.dto.LottoRequest;
import lotto.testutil.ReaderFake;
import lotto.testutil.WriterFake;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @DisplayName("당첨 번호와 보너스 번호를 입력하면 LottoRequest Dto 객체가 반환된다.")
    @Test
    void 객체_반환_테스트() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        InputHandler handler = new InputHandler(
                readerFake,
                writerFake,
                new InputValidator()
        );
        readerFake.setInput("1,2,3,4,5,6", "7");

        //when
        LottoRequest result = handler.handleWinningNumber();

        //then
        assertThat(result.getWinningNumbers()).isEqualTo("1,2,3,4,5,6");
        assertThat(result.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("구입 금액 입력을 요청하는 메시지가 정상 출력된다.")
    @Test
    void 구입_금액_입력_요청_메시지_출력_테스트() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        InputHandler handler = new InputHandler(
                readerFake,
                writerFake,
                new InputValidator()
        );
        readerFake.setInput("1000");

        //when
        handler.readBuyAmount();

        //then
        Assertions.assertThat(writerFake.getOutputs()).containsExactlyInAnyOrder(
                "구입금액을 입력해 주세요.\n"
        );
    }

    @DisplayName("당첨 번호, 보너스 번호 입력을 요청하는 메시지가 정상 출력된다.")
    @Test
    void 당첨_번호와_보너스_번호_입력_요청_메시지_출력_테스트() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        InputHandler handler = new InputHandler(
                readerFake,
                writerFake,
                new InputValidator()
        );
        readerFake.setInput("1,2,3,4,5,6", "7");

        //when
        handler.handleWinningNumber();

        //then
        Assertions.assertThat(writerFake.getOutputs()).containsExactlyInAnyOrder(
                "당첨 번호를 입력해 주세요.\n",
                "\n보너스 번호를 입력해 주세요.\n"
        );
    }

    @DisplayName("구입 금액을 입력하지 않으면 예외가 발생한다.")
    @Test
    void 구입_금액_예외_테스트() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        InputHandler handler = new InputHandler(
                readerFake,
                writerFake,
                new InputValidator()
        );
        readerFake.setInput("");

        //when & then
        assertThatThrownBy(handler::readBuyAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 입력하지 않으면 예외가 발생한다.")
    @Test
    void 당첨_번호_예외_테스트() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        InputHandler handler = new InputHandler(
                readerFake,
                writerFake,
                new InputValidator()
        );
        readerFake.setInput("", "32");

        //when & then
        assertThatThrownBy(handler::handleWinningNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 입력하지 않으면 예외가 발생한다.")
    @Test
    void 보너스_번호_예외_테스트() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        InputHandler handler = new InputHandler(
                readerFake,
                writerFake,
                new InputValidator()
        );
        readerFake.setInput("1,11,21,31,34,35", "");

        //when & then
        assertThatThrownBy(handler::handleWinningNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

}