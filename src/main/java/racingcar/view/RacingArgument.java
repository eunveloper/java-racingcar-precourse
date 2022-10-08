package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.RoundNumber;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.GuideMessage.INPUT_CAR_NAME;
import static racingcar.constant.GuideMessage.INPUT_RACING_ROUND_NUMBER;

public class RacingArgument {

    public RacingCars initRacingCars() {
        String carNames = inputCarNameText();
        return initRacingCarsByInputCarNames(carNames);
    }

    public RoundNumber initRacingRoundNumber() {
        String roundNumber = inputRoundNumberText();
        return initRacingRoundNumberByNumber(roundNumber);
    }

    private String inputCarNameText() {
        System.out.println(INPUT_CAR_NAME);
        return Console.readLine();
    }

    private String inputRoundNumberText() {
        System.out.println(INPUT_RACING_ROUND_NUMBER);
        return Console.readLine();
    }

    private RacingCars initRacingCarsByInputCarNames(String carNames) {
        RacingCars racingCars = new RacingCars();
        racingCars.initRacingCars(generatorRacingCarsByCarName(carNames));
        return racingCars;
    }

    private RoundNumber initRacingRoundNumberByNumber(String number) {
        RoundNumber roundNumber = new RoundNumber();
        try {
            roundNumber.initRoundNumber(number);
        } catch (IllegalArgumentException exception) {
            retryInitRacingRoundNumber(exception.getMessage());
        }
        return roundNumber;
    }

    private List<Car> generatorRacingCarsByCarName(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            try {
                cars.add(generatorEachRacingCar(carName));
            } catch (IllegalArgumentException exception) {
                retryInitRacingCars(exception.getMessage());
            }
        }
        return cars;
    }

    private Car generatorEachRacingCar(String carName) {
        Car car = new Car();
        car.initCarName(carName);
        return car;
    }

    private void retryInitRacingCars(String message) {
        printErrorMessage(message);
        initRacingCars();
    }

    private void retryInitRacingRoundNumber(String message) {
        printErrorMessage(message);
        initRacingRoundNumber();
    }

    private void printErrorMessage(String message) {
        System.out.println(message);
    }

}
