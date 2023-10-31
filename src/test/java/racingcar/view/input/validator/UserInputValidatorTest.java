package racingcar.view.input.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.validator.UserInputValidator;

class UserInputValidatorTest {

    private final UserInputValidator userInputValidator = new UserInputValidator();

    @Test
    @DisplayName("자동차이름: 정상 입력")
    public void correctInput() {
        String rawInput = "가";

        userInputValidator.validateCarNames(rawInput);
    }

    @Test
    @DisplayName("자동차이름: 정상 입력")
    public void correctInput2() {
        String rawInput = "가,나,다";

        userInputValidator.validateCarNames(rawInput);
    }

    @Test
    @DisplayName("자동차이름: ,사이 이름 없음")
    public void wrongInput() {
        String rawInput = ",,,";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateCarNames(rawInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차이름: ,사이 이름 없음2")
    public void wrongInput2() {
        String rawInput = "가,,,";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateCarNames(rawInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차이름: 다섯 글자가 넘는 이름")
    public void wrongInput3() {
        String rawInput = "가나다라마바사";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateCarNames(rawInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 횟수: 정상 입력")
    public void moveCountCorrectInput() {
        String number = "5";

        userInputValidator.validateRoundCount(number);
    }

    @Test
    @DisplayName("이동 횟수: 정상 입력2")
    public void moveCountCorrectInput2() {
        String number = "0";

        userInputValidator.validateRoundCount(number);
    }

    @Test
    @DisplayName("이동 횟수: 숫자가 아닌 문자")
    public void moveCountWrongInput() {
        String number = "A";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateRoundCount(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 횟수: 음수")
    public void moveCountWrongInput2() {
        String number = "-5";

        Assertions.assertThatThrownBy(() -> userInputValidator.validateRoundCount(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}