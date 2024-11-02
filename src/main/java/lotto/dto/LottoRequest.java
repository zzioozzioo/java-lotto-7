package lotto.dto;

public class LottoRequest {

    private final String winningNumbers;
    private final int bonusNumber;

    public LottoRequest(String winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoRequest of(String winningNumbers, int bonusNumber) {
        return new LottoRequest(winningNumbers, bonusNumber);
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
