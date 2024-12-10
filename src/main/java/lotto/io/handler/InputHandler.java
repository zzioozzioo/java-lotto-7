package lotto.io.handler;

import java.util.function.Supplier;
import lotto.io.OutputView;

public class InputHandler {
    private final OutputView outputView;

    public InputHandler(OutputView outputView) {
        this.outputView = outputView;
    }

    // 유효한 입력이 들어올 때까지 재입력받는 메서드
    public <T> T handleInputWithRetry(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
