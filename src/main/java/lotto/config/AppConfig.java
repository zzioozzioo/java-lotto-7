package lotto.config;

import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.io.handler.InputHandler;
import lotto.io.parser.InputParser;
import lotto.io.parser.ResultParser;
import lotto.io.reader.MissionUtilsReader;
import lotto.io.reader.Reader;
import lotto.io.writer.SystemWriter;
import lotto.io.writer.Writer;
import lotto.service.LottoService;

public class AppConfig {
    private final Reader reader;
    private final Writer writer;

    public AppConfig() {
        this.reader = getReader();
        this.writer = getWriter();
    }

    public Reader getReader() {
        return new MissionUtilsReader();
    }

    public Writer getWriter() {
        return new SystemWriter();
    }

    public InputView getInputView() {
        return new InputView(this.reader, this.writer);
    }

    public OutputView getOutputView() {
        return new OutputView(this.writer);
    }

    public InputParser getInputParser() {
        return new InputParser();
    }

    public ResultParser getResultParser() {
        return new ResultParser();
    }

    public InputHandler getInputHandler() {
        return new InputHandler(this.getOutputView());
    }

    public LottoService getLottoService() {
        return new LottoService();
    }
}
