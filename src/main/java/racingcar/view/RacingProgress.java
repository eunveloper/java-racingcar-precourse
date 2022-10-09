package racingcar.view;

import racingcar.constant.CompareResult;
import racingcar.model.Car;
import racingcar.model.RacingCars;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.CompareResult.*;
import static racingcar.constant.GuideMessage.EXECUTION_RESULT;
import static racingcar.constant.GuideMessage.FINAL_WINNER;

public class RacingProgress {

    private CompareResult compareResult;

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

    public void allRacingResult(RacingCars racingCars) {
        List<Car> winCars = getMaxAdvanceCountCars(racingCars);
        finalRacingResult(winCars);
    }

    private List<Car> getMaxAdvanceCountCars(RacingCars racingCars) {
        List<Car> winCars = new ArrayList<>();
        Car maxCar = new Car();
        maxCar.initAdvanceCount();
        winCars.add(maxCar);
        for (Car car : racingCars.getRacingCars()) {
            compareWithCars(maxCar, car);
            maxCar = reSettingMaxCar(maxCar, car);
            winCars = resettingWinCars(winCars, car);
        }
        return winCars;
    }

    private void compareWithCars(Car maxCar, Car car) {
        int maxCount = maxCar.getNowAdvanceCount();
        int compareCount = car.getNowAdvanceCount();
        if (maxCount == compareCount) {
            this.compareResult = SAME;
        }
        if (maxCount > compareCount) {
            this.compareResult = LITTLE;
        }
        if (maxCount < compareCount) {
            this.compareResult = MANY;
        }
    }

    private Car reSettingMaxCar(Car maxCar, Car car) {
        if (compareResult == MANY) {
            return car;
        }
        return maxCar;
    }

    private List<Car> resettingWinCars(List<Car> winCars, Car car) {
        if (compareResult == MANY) {
            winCars = new ArrayList<>();
            winCars.add(car);
            return winCars;
        }
        if (compareResult == SAME) {
            winCars.add(car);
            return winCars;
        }
        return winCars;
    }

    private void finalRacingResult(List<Car> winCars) {
        System.out.print(FINAL_WINNER);
        StringBuilder resultMessage = new StringBuilder();
        boolean first = true;
        for (Car car : winCars) {
            resultMessage.append(appendResultMessage(first, car));
            first = false;
        }
        System.out.print(resultMessage.toString());
    }

    private String appendResultMessage(boolean first, Car car) {
        if (first) {
            return car.getName();
        }
        return new StringBuilder(", ").append(car.getName()).toString();
    }

}
