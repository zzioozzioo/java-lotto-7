package lotto.io;

import lotto.io.reader.Reader;
import lotto.io.writer.Writer;

public class InputView {
    private final Reader reader;
    private final Writer writer;

    public InputView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String readBuyAmount() {
        writer.write("구입금액을 입력해 주세요.");
        String input = reader.readLine();
        writer.write("\n");
        return input;
    }

    public String readWinningNumber() {
        writer.write("당첨 번호를 입력해 주세요.");
        String input = reader.readLine();
        writer.write("\n");
        return input;
    }

    public String readBonusNumber() {
        writer.write("보너스 번호를 입력해 주세요.");
        String input = reader.readLine();
        writer.write("\n");
        return input;
    }
}
