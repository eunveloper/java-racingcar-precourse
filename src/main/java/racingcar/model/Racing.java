package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.RacingArgument;
import racingcar.view.RacingProgress;

public class Racing {

    private final RacingArgument racingArgument = new RacingArgument();
    private final RacingProgress racingProgress = new RacingProgress();

    private final int ADVANCE_COUNT = 4;

    private final int RANDOM_MIN_COUNT = 0;
    private final int RANDOM_MAX_COUNT = 9;

    private RacingCars racingCars;
    private RoundNumber roundNumber;

    public void startGame() {
        initRacingCars(racingArgument.initRacingCars());
        initRacingRoundNumber(racingArgument.initRacingRoundNumber());
        startRacing();
    }

    private void initRacingCars(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void initRacingRoundNumber(RoundNumber roundNumber) {
        this.roundNumber = roundNumber;
    }

    private void startRacing() {
        racingProgress.executionResult();
        for (int i = 1; i <= roundNumber.getRoundNumber(); i++) {
            startRacingEachRacingCars();
            racingProgress.racingResult(this.racingCars);
        }
    }

    private void startRacingEachRacingCars() {
        for (Car car : racingCars.getRacingCars()) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_COUNT, RANDOM_MAX_COUNT);
            calcAdvanceCountByRandomNumber(car, randomNumber);
        }
    }

    public void calcAdvanceCountByRandomNumber(Car car, int number) {
        if (number >= ADVANCE_COUNT) {
            car.addedAdvanceCount();
        }
    }
}
