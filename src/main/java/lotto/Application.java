package lotto;

import lotto.config.Config;
import lotto.config.LottoConfig;
import lotto.controller.LottoController;
import lotto.service.CalculatorService;
import lotto.service.ConverterService;
import lotto.service.LottoGenerationService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoConfig lottoConfig = new LottoConfig(new Config());

        LottoGenerationService lottoGenerationService = new LottoGenerationService();
        CalculatorService calculatorService = new CalculatorService();
        ConverterService converterService = new ConverterService();

        LottoController controller = new LottoController(
                lottoConfig,
                lottoGenerationService,
                calculatorService,
                converterService
        );

        controller.run();
    }

}
