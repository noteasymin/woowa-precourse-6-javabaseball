package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playBaseballGame();
    }

    private static void playBaseballGame() {
        while(true) {
            List<Integer> randomNumber = createRandomNumber();
            checkUserNumber(randomNumber);
        }
    }

    private static void checkUserNumber(List<Integer> randomNumber) {
        while (true) {
            List<Integer> userNumber = getUserNumber();
            int ball = 0;
            int strike = 0;

            for (int i = 0; i < 3; i++) {
                if (randomNumber.get(i).equals(userNumber.get(i))) {
                    strike += 1;
                } else if (randomNumber.contains(userNumber.get(i))) {
                    ball += 1;
                }
            }

            if (strike == 3) {
                break;
            }
        }
    }
    private static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> getUserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        String Number;
        String[] tempNumber;
        boolean isValid;

        System.out.println("숫자를 입력해주세요 : ");
        Number = Console.readLine();
        isValid = isValidNumber(Number);

        if (isValid) {
            tempNumber = Number.split("");
            for (String s : tempNumber) {
                userNumber.add(Integer.parseInt(s));
            }
        } else if (!isValid) {
            throw new IllegalArgumentException();
        }

        return userNumber;
    }

    private static boolean isValidNumber(String input) {
        if (input.length() != 3) {
            return false;
        }

        for (char ch : input.toCharArray()) {
            if (ch < 1 || ch > 9) {
                return false;
            }
        }

        if (input.charAt(0) == input.charAt(1)
                || input.charAt(0) == input.charAt(2)
                || input.charAt(1) == input.charAt(2)) {
            return false;
        }

        return true;
    }
}