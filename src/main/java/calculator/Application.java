package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();
        int total = 0;

        char[] words = s.toCharArray(); // 각 문자를 담은 배열
        int num = 0; // 처음 분리될 숫자의 값 초기화

        if (s.substring(0, 2).equals("//") && s.substring(3, 5).equals("\\n")) { // 커스텀 구분자가 지정될 경우
            char custom = s.charAt(2);
            for (int i = 5; i < words.length; i++) {
                if (words[i] >= '0' && words[i] <= '9') { // 숫자 추출
                    num *= 10;
                    num += words[i] - '0';
                } else if (words[i] == custom) { // 구분자 기준으로 숫자 분리
                    total += num;
                    num = 0;
                }
            }
        } else { // 커스텀 구분자가 지정되지 않을 경우
            for (char w : words) {
                if (w >= '0' && w <= '9') { // 숫자 추출
                    num *= 10;
                    num += w - '0';
                } else if (w == ',' || w == ':') {  // 기본 구분자 기준으로 숫자 분리
                    total += num;
                    num = 0;
                }
            }
        }
        total += num; // 마지막으로 분리된 숫자의 값 초기화

        System.out.println("결과: " + total); // 결과 출력
    }
}
