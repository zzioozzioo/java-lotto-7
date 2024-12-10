package lotto;

import lotto.config.AppConfig;
import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig config = new AppConfig();
        Controller controller = new Controller(
                config.getInputView(), config.getOutputView(),
                config.getInputParser(), config.getResultParser(),
                config.getInputHandler(),
                config.getLottoService()
        );
        controller.run();
    }
}
