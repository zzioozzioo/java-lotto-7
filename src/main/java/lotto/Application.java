package lotto;

import java.util.List;
import java.util.Map;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.UserLotto;
import lotto.dto.WinningResult;
import lotto.io.InputHandler;
import lotto.io.InputValidator;
import lotto.io.OutputHandler;
import lotto.io.UserLottoParser;
import lotto.io.WinningResultParser;
import lotto.io.reader.MissionUtilsReader;
import lotto.io.reader.Reader;
import lotto.io.writer.SystemWriter;
import lotto.io.writer.Writer;
import lotto.service.CalculatorService;
import lotto.service.ConverterService;
import lotto.service.LottoGenerationService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int lottoCount = 0;
        List<Lotto> lottos = null;
        UserLotto userLotto = new UserLotto(lottoCount, lottos);

        Map<Rank, Integer> result = null;
        double prize = 0;
        double rateOfReturn = 0;
        WinningResult winningResult = new WinningResult(result, prize, rateOfReturn);

        UserLottoParser userLottoParser = new UserLottoParser();
        WinningResultParser winningResultParser = new WinningResultParser();

        Reader MissionUtilsReader = new MissionUtilsReader();
        Writer SystemWriter = new SystemWriter();

        InputValidator inputValidator = new InputValidator();
        InputHandler inputHandler = new InputHandler(MissionUtilsReader, SystemWriter, inputValidator);
        OutputHandler outputHandler = new OutputHandler(SystemWriter, userLotto, winningResult, userLottoParser,
                winningResultParser);

        LottoGenerationService lottoGenerationService = new LottoGenerationService();
        CalculatorService calculatorService = new CalculatorService();
        ConverterService converterService = new ConverterService();

        LottoController controller = new LottoController(
                inputHandler, outputHandler,
                lottoGenerationService,
                calculatorService,
                converterService);

        controller.run();
    }

}
