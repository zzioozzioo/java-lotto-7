package lotto.io;

import static lotto.constants.NumberConstants.DIVIDER_REPEAT_COUNT;
import static lotto.constants.OutputMessages.TOTAL_RATE_OF_RETURN_LABEL;

import java.util.Map;
import lotto.constants.OutputMessages;
import lotto.constants.StringConstants;
import lotto.domain.Rank;
import lotto.dto.WinningResult;

public class WinningResultParser {

    public String parseWinningResult(WinningResult winningResult) {
        StringBuilder sb = new StringBuilder();

        appendWinningStatistics(sb);
        appendResult(sb, winningResult.getResult());
        appendRateOfReturn(sb, winningResult.getRateOfReturn());

        return sb.toString();
    }

    private void appendWinningStatistics(StringBuilder sb) {
        sb.append(OutputMessages.WINNING_STATISTICS_LABEL)
                .append(StringConstants.DASH.repeat(DIVIDER_REPEAT_COUNT));
    }

    private void appendResult(StringBuilder sb, Map<Rank, Integer> result) {
        for (Rank rank : result.keySet()) {
            sb.append(rank).append(OutputMessages.COUNT_UNIT)
                    .append(OutputMessages.MATCH_LABEL)
                    .append(StringConstants.OPEN_PARENTHESIS)
                    .append(rank.getStringPrize())
                    .append(OutputMessages.WON)
                    .append(StringConstants.CLOSE_PARENTHESIS)
                    .append(result.get(rank))
                    .append(OutputMessages.COUNT_UNIT)
                    .append(StringConstants.NEW_LINE);
        }
    }

    private void appendRateOfReturn(StringBuilder sb, double rateOfReturn) {
        sb.append(TOTAL_RATE_OF_RETURN_LABEL)
                .append(rateOfReturn)
                .append(StringConstants.PERCENT)
                .append(OutputMessages.IS_SUFFIX)
                .append(StringConstants.ENDING_DOT);
    }

}
