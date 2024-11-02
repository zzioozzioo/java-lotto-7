package lotto.controller;

import static lotto.constants.ExceptionMessages.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.constants.ExceptionMessages.BUY_AMOUNT_HAS_CHANGE;
import static lotto.constants.ExceptionMessages.LOTTO_COUNT_OUT_OF_RANGE;
import static lotto.constants.NumberConstants.LOTTO_END_NUM;
import static lotto.constants.NumberConstants.LOTTO_START_NUM;
import static lotto.constants.NumberConstants.MAX_TICKET_BUY_AMOUNT;
import static lotto.constants.NumberConstants.TICKET_PRICE;
import static lotto.constants.NumberConstants.ZERO;

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

        // 구입 금액 입력받기
        long buyAmount = inputHandler.readBuyAmount();
        // TODO: validation은 다른 클래스에 책임 할당하기
        validateLottoCount(buyAmount);
        validateBuyAmountHasChange(buyAmount);

        // 구매한 로또 번호 출력하기
        UserLotto userLotto = lottoService.getUserLotto(buyAmount);
        outputHandler.userLottoHandle(userLotto);

        // 당첨 번호, 보너스 번호 입력받기
        LottoRequest lottoRequest = inputHandler.handleWinningNumber();
        // 당첨 번호 로또 객체로 변환
        WinningLotto winningLotto = lottoService.convertWinningNumbers(lottoRequest.getWinningNumbers());

        // 보너스 번호 검증
        // TODO: validation은 다른 클래스에 책임 할당하기
        int bonusNumber = lottoRequest.getBonusNumber();
        validateBonusNumberRange(bonusNumber);
        winningLotto.checkDuplicateBonusNumber(bonusNumber);

        // 당첨 결과 계산 로직...
        WinningResult result = new Winning().calculate(userLotto, buyAmount, winningLotto, bonusNumber);

        // 당첨 결과 출력
        outputHandler.winningResultHandle(result);
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

    public static Map<Rank, Integer> initializeResultMap() {
        Map<Rank, Integer> initialMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            initialMap.put(rank, 0);
        }
        return initialMap;
    }
}
