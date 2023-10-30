package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.GameService;
import racingcar.view.input.InputView;
import racingcar.view.input.validator.UserInputValidator;
import racingcar.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInputValidator userInputValidator = new UserInputValidator();
        InputView inputView = new InputView(userInputValidator);
        OutputView outputView = new OutputView();
        GameService gameService = new GameService();

        RacingController racingGame = new RacingController(inputView, outputView, gameService);

        try {
            racingGame.playGame();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
}
