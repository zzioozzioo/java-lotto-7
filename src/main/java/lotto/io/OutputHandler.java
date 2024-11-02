package lotto.io;

import lotto.dto.WinningResult;
import lotto.io.writer.Writer;

public class OutputHandler {

    // TODO: printLottoCount, printLottoNumbers 역할 담당하는 메서드도 만들기

    private final Writer writer;
    private final WinningResult winningResult;
    private final WinningResultParser winningResultParser;

    public OutputHandler(Writer writer, WinningResult winningResult, WinningResultParser winningResultParser) {
        this.writer = writer;
        this.winningResult = winningResult;
        this.winningResultParser = winningResultParser;
    }

    public void handle() {
        String resultString = winningResultParser.parse(winningResult);
        writer.write(resultString);
    }
}
