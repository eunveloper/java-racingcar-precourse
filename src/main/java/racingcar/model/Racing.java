package racingcar.model;

import racingcar.view.RacingArgument;

import java.util.List;

public class Racing {

    private final RacingArgument racingArgument = new RacingArgument();

    private List<Car> racingCars;

    public void startGame() {
        initRacingCars();
    }

    private void initRacingCars() {
        this.racingCars = racingArgument.initRacingCars();
    }

}
