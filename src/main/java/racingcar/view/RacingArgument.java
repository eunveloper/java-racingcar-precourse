package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.GuideMessage.INPUT_CAR_NAME;

public class RacingArgument {

    public List<Car> initRacingCars() {
        String carNames = inputCarNameText();
        return initRacingCarsByInputCarNames(carNames);
    }

    private String inputCarNameText() {
        System.out.println(INPUT_CAR_NAME);
        return Console.readLine();
    }

    private List<Car> initRacingCarsByInputCarNames(String carNames) {
        List<Car> racingCars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            try {
                racingCars.add(new Car(carName));
            } catch (IllegalArgumentException exception) {
                retryInitRacingCars(exception.getMessage());
            }
        }
        return racingCars;
    }

    private void retryInitRacingCars(String message) {
        printErrorMessage(message);
        initRacingCars();
    }

    private void printErrorMessage(String message) {
        System.out.println(message);
    }

}
