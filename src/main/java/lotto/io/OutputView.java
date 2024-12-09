package lotto.io;

import lotto.io.writer.Writer;

public class OutputView {

    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void printPurchasedLotto(String purchasedResult) {
        writer.write(purchasedResult);
    }

    public void printErrorMessage(String errorMessage) {
        writer.write(errorMessage);
    }
}
