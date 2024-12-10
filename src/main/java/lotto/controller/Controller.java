package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Winning;
import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.io.handler.InputHandler;
import lotto.io.parser.InputParser;
import lotto.io.parser.ResultParser;
import lotto.service.LottoService;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    private final InputParser inputParser;
    private final ResultParser resultParser;
    private final InputHandler inputHandler;

    private final LottoService lottoService;

    public Controller(InputView inputView, OutputView outputView,
                      InputParser inputParser, ResultParser resultParser,
                      InputHandler inputHandler,
                      LottoService lottoService) {

        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
        this.resultParser = resultParser;
        this.inputHandler = inputHandler;
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            play();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void play() {
        // 구입 금액 입력
        Long buyAmount = getValidBuyAmount();

        // 로또 발행
        List<Lotto> purchasedLotto = lottoService.buyLotto(buyAmount);
        String purchasedResult = inputParser.parsePurchasedLotto(purchasedLotto);
        outputView.printPurchasedLotto(purchasedResult);

        // 당첨 번호 + 보너스 번호 입력 및 처리
        // TODO: 당첨 번호 입력 후 모든 유효성 검사 마친 뒤에 보너스 번호 입력받도록 수정
        Winning winning = getWinning();

        // 당첨 확인
        Map<Rank, Integer> winningResult = lottoService.checkWinning(purchasedLotto, winning);
        double rateOfReturn = lottoService.calculateRateOfReturn(winningResult, buyAmount);
        String result = resultParser.parseWinningResult(winningResult, rateOfReturn);
        outputView.printWinningResult(result);
    }

    private Winning getWinning() {
        return inputHandler.handleInputWithRetry(() -> {
            List<Integer> winningNumber = getValidWinningNumber();
            int bonusNumber = getValidBonusNumber();
            return lottoService.getValidWinningNumbers(winningNumber, bonusNumber);
        });
    }

    private Long getValidBuyAmount() {
        return inputHandler.handleInputWithRetry(() -> {
            String input = inputView.readBuyAmount();
            return inputParser.parseBuyAmount(input);
        });
    }

    private List<Integer> getValidWinningNumber() {
        String input = inputView.readWinningNumber();
        return inputParser.parseWinningNumber(input);
    }

    private int getValidBonusNumber() {
        String input = inputView.readBonusNumber();
        return inputParser.parseBonusNumber(input);
    }
}
