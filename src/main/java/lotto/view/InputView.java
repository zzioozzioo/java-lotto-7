package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {
    public long readBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String inputBuyAmount;
        long buyAmount;

        try {
            inputBuyAmount = Console.readLine().trim();
            if (inputBuyAmount.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 값을 입력해야 합니다.");
            }
            buyAmount = Long.parseLong(inputBuyAmount);

        } catch (NumberFormatException | NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        return buyAmount;
    }

    public String readWinningNumbers() {
        // TODO: 여기서 숫자로 변환하는 건 좀 그렇지 않아?? view 레이어인데...
        System.out.println("당첨 번호를 입력해 주세요.");

        String inputWinningNumbers;

        try {
            inputWinningNumbers = Console.readLine().trim();
            if (inputWinningNumbers.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 값을 입력해야 합니다.");
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해야 합니다.");
        }

        return inputWinningNumbers;
    }

    public void readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        String inputBonusNumber;

        try {
            inputBonusNumber = Console.readLine().trim();
            if (inputBonusNumber.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 값을 입력해야 합니다.");
            }
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}
