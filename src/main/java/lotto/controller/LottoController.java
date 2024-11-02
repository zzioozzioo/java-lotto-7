package lotto.controller;

import static lotto.constants.ExceptionMessages.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.constants.ExceptionMessages.BUY_AMOUNT_HAS_CHANGE;
import static lotto.constants.ExceptionMessages.LOTTO_COUNT_OUT_OF_RANGE;
import static lotto.constants.NumberConstants.LOTTO_END_NUM;
import static lotto.constants.NumberConstants.LOTTO_START_NUM;
import static lotto.constants.NumberConstants.MAX_TICKET_BUY_AMOUNT;
import static lotto.constants.NumberConstants.TICKET_PRICE;
import static lotto.constants.NumberConstants.ZERO;
import static lotto.domain.Rank.findRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.config.LottoConfig;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.dto.LottoRequest;
import lotto.dto.UserLotto;
import lotto.dto.WinningResult;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.service.CalculatorService;
import lotto.service.ConverterService;
import lotto.service.LottoGenerationService;

public class LottoController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private final LottoGenerationService lottoGenerationService;
    private final CalculatorService calculatorService;
    private final ConverterService converterService;

    public LottoController(LottoConfig lottoConfig,
                           LottoGenerationService lottoGenerationService,
                           CalculatorService calculatorService,
                           ConverterService converterService) {

        this.inputHandler = lottoConfig.getInputHandler();
        this.outputHandler = lottoConfig.getOutputHandler();

        this.lottoGenerationService = lottoGenerationService;
        this.calculatorService = calculatorService;
        this.converterService = converterService;
    }

    public void run() {
        long buyAmount = inputHandler.readBuyAmount();

        // TODO: validation은 다른 클래스에 책임 할당하기
        validateLottoCount(buyAmount);
        validateBuyAmountHasChange(buyAmount);

        // TODO: dto랑 연결해서 사용자가 구매한 로또 출력되게 하기..
        int lottoCount = lottoGenerationService.getLottoCount(buyAmount);
        List<Lotto> lottos = lottoGenerationService.generateLotto(lottoCount);
        outputHandler.userLottoHandle(new UserLotto(lottoCount, lottos));

        LottoRequest lottoRequest = inputHandler.LottoNumberHandle();

        Lotto winningLottoNumbers = converterService.convertWinningNumbers(lottoRequest.getWinningNumbers());
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        int bonusNumber = lottoRequest.getBonusNumber();

        // TODO: validation은 다른 클래스에 책임 할당하기
        validateBonusNumberRange(bonusNumber);
        winningLotto.checkDuplicateBonusNumber(bonusNumber);

        // TODO: winningResult -> dto로 변경
        Map<Rank, Integer> winningResult = initialMap();
        for (Lotto lotto : lottos) {
            int score = winningLotto.countMatchingNumbers(lotto);
            boolean isBonusMatches = false;
            if (lotto.getNumbers().contains(bonusNumber)) {
                isBonusMatches = true;
            }
            Rank rank = findRank(score, isBonusMatches);
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
//        outputView.printWinningResult(winningResult);

        long prize = calculatorService.calculateWinnings(winningResult);
        double rateOfReturn = calculatorService.calculateRateOfReturn(buyAmount, prize);
//        outputView.printRateOfReturn(rateOfReturn);

        outputHandler.winningResultHandle(new WinningResult(winningResult, prize, rateOfReturn));
    }


    private static void validateLottoCount(long buyAmount) {
        if (buyAmount < TICKET_PRICE || buyAmount > MAX_TICKET_BUY_AMOUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_OUT_OF_RANGE);
        }
    }

    private static void validateBuyAmountHasChange(long buyAmount) {
        if (buyAmount % TICKET_PRICE != ZERO) {
            throw new IllegalArgumentException(BUY_AMOUNT_HAS_CHANGE);
        }
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LOTTO_START_NUM || bonusNumber > LOTTO_END_NUM) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE);
        }
    }

    private Map<Rank, Integer> initialMap() {
        Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            winningResult.put(rank, 0);
        }
        return winningResult;
    }
}
