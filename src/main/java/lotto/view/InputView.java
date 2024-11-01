package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {

    // TODO: trim()과 strip()의 차이 알아보기
    public String readBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String inputBuyAmount;

        try {
            inputBuyAmount = Console.readLine().trim();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        if (inputBuyAmount.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해야 합니다.");
        }

        return inputBuyAmount;
    }

    public String readWinningNumbers() {
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

    public String readBonusNumber() {
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

        return inputBonusNumber;
    }
}
