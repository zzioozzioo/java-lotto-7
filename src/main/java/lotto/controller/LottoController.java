package lotto.controller;

import static lotto.domain.Rank.findRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.CalculatorService;
import lotto.service.ConverterService;
import lotto.service.LottoGenerationService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    private final LottoGenerationService lottoGenerationService;
    private final CalculatorService calculatorService;
    private final ConverterService converterService;

    public LottoController(InputView inputView, OutputView outputView,
                           LottoGenerationService lottoGenerationService,
                           CalculatorService calculatorService,
                           ConverterService converterService) {

        this.inputView = inputView;
        this.outputView = outputView;

        this.lottoGenerationService = lottoGenerationService;
        this.calculatorService = calculatorService;
        this.converterService = converterService;
    }


    public void run() {
        String inputBuyAmount = inputView.readBuyAmount();
        long buyAmount = converterService.convertBuyAmount(inputBuyAmount);

        int lottoCount = lottoGenerationService.getLottoCount(buyAmount);
        outputView.printLottoCount(lottoCount);

        List<Lotto> lottos = lottoGenerationService.generateLotto(lottoCount);
        outputView.printLottoNumbers(lottos);

        String inputWinningNumbers = inputView.readWinningNumbers();
        Lotto winningLottoNumbers = converterService.convertWinningNumbers(inputWinningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        String inputBonusNumber = inputView.readBonusNumber();
        int bonusNumber = converterService.convertBonusNumber(inputBonusNumber);
        winningLotto.checkDuplicateBonusNumber(bonusNumber);

        Map<Rank, Integer> winningResult = initialMap();
        for (Lotto userLotto : lottos) {
            int score = winningLotto.countMatchingNumbers(userLotto);
            boolean isBonusMatches = false;
            if (userLotto.getNumbers().contains(bonusNumber)) {
                isBonusMatches = true;
            }
            Rank rank = findRank(score, isBonusMatches);
            winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
        }
        outputView.printWinningStatistics();
        outputView.printWinningResult(winningResult);

        long prize = calculatorService.calculateWinnings(winningResult);
        outputView.printRateOfReturn(calculatorService.calculateRateOfReturn(buyAmount, prize));
    }

    private Map<Rank, Integer> initialMap() {
        Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            winningResult.put(rank, 0);
        }
        return winningResult;
    }
}
