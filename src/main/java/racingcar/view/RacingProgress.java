package racingcar.view;

import racingcar.model.Car;
import racingcar.model.RacingCars;

import static racingcar.constant.GuideMessage.EXECUTION_RESULT;

public class RacingProgress {

    public void executionResult() {
        System.out.println();
        System.out.println(EXECUTION_RESULT);
    }

    public void racingResult(RacingCars racingCars) {
        for (Car car : racingCars.getRacingCars()) {
            racingResultEachCar(car);
        }
        System.out.println();
    }

    private void racingResultEachCar(Car car) {
        String racingResultMessage =
                new StringBuilder(car.getName())
                        .append(" : ")
                        .append(car.getRacingRoad())
                        .toString();
        System.out.println(racingResultMessage);
    }
}
