package lotto;

import lotto.controller.LottoController;
import lotto.service.CalculatorService;
import lotto.service.ConverterService;
import lotto.service.LottoGenerationService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoGenerationService lottoGenerationService = new LottoGenerationService();
        CalculatorService calculatorService = new CalculatorService();
        ConverterService converterService = new ConverterService();

        LottoController controller = new LottoController(
                inputView, outputView,
                lottoGenerationService,
                calculatorService,
                converterService);

        controller.run();
    }

}
