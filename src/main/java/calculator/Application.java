package calculator;

import domain.StringCalculator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {

        // 문자열 입력
        String input = InputView.getInput();

        try {
            // 로직 수행
            StringCalculator calculator = new StringCalculator();
            int result = calculator.add(input);

            // 결과 출력
            OutputView.printResult(result);

        } catch (IllegalStateException e) {
            // 예외 발생 시 메시지 출력 후 종료
            System.out.println(e.getMessage());
        }
    }
}
