package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        String input = inputCarName();
        Map<String, Integer> racingCars = validateCarName(input);
        int count = inputMovingCount();
    }

    private static int inputMovingCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return parseInt(input);
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static Map<String, Integer> validateCarName(String input) {
        Map<String, Integer> racingCars = new HashMap<>();
        String[] cars = input.split(",");
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            racingCars.put(car, 0);
        }
        return racingCars;
    }
}
