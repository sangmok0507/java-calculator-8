package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();
        int total = 0;

        char[] words = s.toCharArray(); // 각 문자를 담은 배열
        int num = 0; // 처음 분리될 숫자의 값 초기화

        for (char w : words) {
            if (w >= '0' && w <= '9') { // 숫자 추출
                num *= 10;
                num += w - '0';
            } else if (w == ',' || w == ':') {  // 구분자 기준으로 숫자 분리
                total += num;
                num = 0;
            }
        }
        total += num; // 마지막으로 분리된 숫자의 값 초기화

        System.out.println("결과: " + total); // 결과 출력
    }
}
