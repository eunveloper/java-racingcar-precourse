package racingcar.model;

import racingcar.view.RacingArgument;

public class Racing {

    private final RacingArgument racingArgument = new RacingArgument();

    private RacingCars racingCars;
    private RoundNumber roundNumber;

    public void startGame() {
        initRacingCars(racingArgument.initRacingCars());
        initRacingRoundNumber(racingArgument.initRacingRoundNumber());
    }

    private void initRacingCars(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void initRacingRoundNumber(RoundNumber roundNumber) {
        this.roundNumber = roundNumber;
    }

}
