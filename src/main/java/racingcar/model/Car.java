package racingcar.model;

import static racingcar.constant.ErrorMessage.CAR_NAME_NOT_MORE_THAN_5;

public class Car {

    private final int NAME_MAX_LENGTH = 5;

    private String name;

    public Car(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_NOT_MORE_THAN_5);
        }
        this.name = name;
    }

    public boolean isSameNameCar(String name) {
        return this.name.equals(name);
    }
}
