package racingcar.model;

import java.util.List;

public class RacingCars {

    private List<Car> cars;

    public void initRacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getRacingCars() {
        return cars;
    }
}
