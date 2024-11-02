package lotto.io;

import lotto.dto.UserLotto;
import lotto.dto.WinningResult;
import lotto.io.writer.Writer;

public class OutputHandler {

    private final Writer writer;

    private final UserLotto userLotto;
    private final WinningResult winningResult;

    private final UserLottoParser userLottoParser;
    private final WinningResultParser winningResultParser;

    public OutputHandler(Writer writer,
                         UserLotto userLotto, WinningResult winningResult,
                         UserLottoParser userLottoParser,
                         WinningResultParser winningResultParser) {
        this.writer = writer;

        this.userLotto = userLotto;
        this.winningResult = winningResult;

        this.userLottoParser = userLottoParser;
        this.winningResultParser = winningResultParser;
    }

    public void userLottoHandle() {
        String resultString = userLottoParser.parseUserLotto(userLotto);
        writer.write(resultString);
    }

    public void winningResultHandle() {
        String resultString = winningResultParser.parseWinningResult(winningResult);
        writer.write(resultString);
    }
}
