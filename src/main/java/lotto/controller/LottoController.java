package lotto.controller;

import static lotto.validator.Validator.validateBonusNumberRange;
import static lotto.validator.Validator.validateBuyAmount;

import java.util.EnumMap;
import java.util.Map;
import lotto.config.LottoConfig;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.winning.Winning;
import lotto.dto.LottoRequest;
import lotto.dto.UserLotto;
import lotto.dto.WinningResult;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.service.LottoService;

public class LottoController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private final LottoService lottoService;


    public LottoController(LottoConfig lottoConfig,
                           LottoService lottoService) {

        this.inputHandler = lottoConfig.getInputHandler();
        this.outputHandler = lottoConfig.getOutputHandler();

        this.lottoService = lottoService;
    }

    public void run() {

        long buyAmount = getValidBuyAmount();

        UserLotto userLotto = lottoService.getUserLotto(buyAmount);
        outputHandler.userLottoHandle(userLotto);

        LottoRequest lottoRequest = inputHandler.handleWinningNumber();
        WinningLotto winningLotto = lottoService.convertWinningNumbers(lottoRequest.getWinningNumbers());

        int bonusNumber = getValidBonusNumber(lottoRequest, winningLotto);

        WinningResult result = calculateWinningResult(userLotto, buyAmount, winningLotto, bonusNumber);
        outputHandler.winningResultHandle(result);
    }


    public static Map<Rank, Integer> initializeResultMap() {
        Map<Rank, Integer> initialMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            initialMap.put(rank, 0);
        }
        return initialMap;
    }

    private long getValidBuyAmount() {
        long buyAmount = inputHandler.readBuyAmount();
        validateBuyAmount(buyAmount);
        return buyAmount;
    }

    private int getValidBonusNumber(LottoRequest lottoRequest, WinningLotto winningLotto) {
        int bonusNumber = lottoRequest.getBonusNumber();
        validateBonusNumberRange(bonusNumber);
        winningLotto.checkDuplicateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private WinningResult calculateWinningResult(UserLotto userLotto,
                                                 long buyAmount,
                                                 WinningLotto winningLotto,
                                                 int bonusNumber) {
        return new Winning().calculate(userLotto, buyAmount, winningLotto, bonusNumber);
    }
}
