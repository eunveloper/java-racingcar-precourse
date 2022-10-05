package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constant.ErrorMessage.CAR_NAME_NOT_MORE_THAN_5;

public class IllegalArgumentCheckTest {

    private final String LONG_NAME = "morethan5";
    private final String SHORT_NAME = "short";

    @Test
    void 자동자_이름은_다섯자_이하() {
        // 여섯자 이상인 경우에는 IllegalArgumentException가 발생한다.
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new Car(LONG_NAME);
                });
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_NOT_MORE_THAN_5);

        // 다섯자 이하인 경우에는 객체에 이름 필드에 정상적으로 이름이 저장된다.
        assertThat(new Car(SHORT_NAME).isSameNameCar(SHORT_NAME)).isTrue();
    }
}
