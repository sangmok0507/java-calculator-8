package domain;

public class StringCalculator {
    public int add(String input) {

        int result = 0;

        if (!input.isEmpty()) { // 빈 문자열이 아닐 시

            char[] words = input.toCharArray(); // 각 문자를 담은 배열
            int num = 0; // 처음 분리될 숫자의 값 초기화

            if (input.startsWith("//") && input.startsWith("\\n", 3)) { // 커스텀 구분자가 지정될 경우
                char custom = input.charAt(2);
                for (int i = 5; i < words.length; i++) {
                    if (words[i] >= '0' && words[i] <= '9') { // 숫자 추출
                        num *= 10;
                        num += words[i] - '0';
                    } else if (words[i] == custom) { // 구분자 기준으로 숫자 분리
                        result += num;
                        num = 0;
                    } else { // 잘못된 값 입력
                        throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
                    }
                }
            } else { // 커스텀 구분자가 지정되지 않을 경우
                for (char w : words) {
                    if (w >= '0' && w <= '9') { // 숫자 추출
                        num *= 10;
                        num += w - '0';
                    } else if (w == ',' || w == ':') {  // 기본 구분자 기준으로 숫자 분리
                        result += num;
                        num = 0;
                    } else { // 잘못된 값 입력
                        throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
                    }
                }
            }
            result += num; // 마지막으로 분리된 숫자의 값 초기화
        }
        return result;
    }
}
