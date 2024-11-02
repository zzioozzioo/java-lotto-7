package lotto.dto;

public class LottoRequest {

    private final long buyAmount;
    private final String winningNumbers;
    private final int bonusNumber;

    public LottoRequest(long buyAmount, String winningNumbers, int bonusNumber) {
        this.buyAmount = buyAmount;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoRequest of(long buyAmount, String winningNumbers, int bonusNumber) {
        return new LottoRequest(buyAmount, winningNumbers, bonusNumber);
    }

    public long getBuyAmount() {
        return buyAmount;
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
