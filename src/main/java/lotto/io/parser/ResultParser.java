package lotto.io.parser;

import static lotto.constants.OutputMessages.MATCH_FIVE_TIMES;
import static lotto.constants.OutputMessages.MATCH_FIVE_TIMES_WITH_BONUS;
import static lotto.constants.OutputMessages.MATCH_FOUR_TIMES;
import static lotto.constants.OutputMessages.MATCH_SIX_TIMES;
import static lotto.constants.OutputMessages.MATCH_THREE_TIMES;
import static lotto.constants.OutputMessages.TOTAL_RATE_OF_RETURN_FORMAT;
import static lotto.constants.OutputMessages.WINNING_RESULT_FORMAT;
import static lotto.constants.OutputMessages.WINNING_STATISTICS;
import static lotto.constants.StringConstants.DASH;
import static lotto.constants.StringConstants.NEW_LINE;

import java.util.Map;
import lotto.domain.Rank;

public class ResultParser {

    public String parseWinningResult(Map<Rank, Integer> winningResult, double rateOfReturn) {
        //당첨 통계
        //---
        //3개 일치 (5,000원) - 1개
        //4개 일치 (50,000원) - 0개
        //5개 일치 (1,500,000원) - 0개
        //5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
        //6개 일치 (2,000,000,000원) - 0개
        //총 수익률은 62.5%입니다.

        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_STATISTICS).append(NEW_LINE).append(DASH.repeat(3)).append(NEW_LINE);
        appendResultDetails(sb, winningResult);
        sb.append(String.format(TOTAL_RATE_OF_RETURN_FORMAT, rateOfReturn)).append(NEW_LINE);

        return sb.toString();
    }

    private void appendResultDetails(StringBuilder sb, Map<Rank, Integer> winningResult) {

        sb.append(String.format(WINNING_RESULT_FORMAT, MATCH_THREE_TIMES, Rank.FIFTH.getStringPrize(),
                        winningResult.get(Rank.FIFTH)))
                .append(NEW_LINE)
                .append(String.format(WINNING_RESULT_FORMAT, MATCH_FOUR_TIMES, Rank.FOURTH.getStringPrize(),
                        winningResult.get(Rank.FOURTH))).append(NEW_LINE)
                .append(String.format(WINNING_RESULT_FORMAT, MATCH_FIVE_TIMES, Rank.THIRD.getStringPrize(),
                        winningResult.get(Rank.THIRD)))
                .append(NEW_LINE)
                .append(String.format(WINNING_RESULT_FORMAT, MATCH_FIVE_TIMES_WITH_BONUS, Rank.SECOND.getStringPrize(),
                        winningResult.get(Rank.SECOND))).append(NEW_LINE)
                .append(String.format(WINNING_RESULT_FORMAT, MATCH_SIX_TIMES, Rank.FIRST.getStringPrize(),
                        winningResult.get(Rank.FIRST))).append(NEW_LINE);
    }
}
