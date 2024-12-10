package lotto.io;

import lotto.io.writer.Writer;

public class OutputView {

    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    // TODO: 구매한 로또 출력 시 객체가 출력되는 문제 해결하기
    public void printPurchasedLotto(String purchasedResult) {
        writer.write(purchasedResult);
    }

    public void printErrorMessage(String errorMessage) {
        writer.write(errorMessage);
    }

    public void printWinningResult(String result) {
        writer.write(result);
    }
}
