import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // 입력 배열과 동일한 크기의 결과 배열 선언
        String[] answer = new String[files.length];
        
        // files 배열을 정렬하는 커스텀 Comparator 정의
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String file1, String file2) {
                // HEAD, NUMBER 분리
                String[] file1Parts = splitFile(file1);
                String[] file2Parts = splitFile(file2);

                // HEAD 부분 대소문자 구분 없이 비교
                int headCompare = file1Parts[0].toLowerCase().compareTo(file2Parts[0].toLowerCase());
                if (headCompare != 0) {
                    return headCompare; // HEAD가 다르면 HEAD 기준으로 정렬
                }

                // NUMBER 부분을 숫자로 변환하여 비교
                int num1 = Integer.parseInt(file1Parts[1]);
                int num2 = Integer.parseInt(file2Parts[1]);
                return Integer.compare(num1, num2); // NUMBER 비교
            }
        });

        // 정렬된 결과를 answer 배열에 저장
        for (int i = 0; i < files.length; i++) {
            answer[i] = files[i];
        }

        return answer;
    }

    // 파일명을 HEAD, NUMBER, TAIL로 분리하는 함수
    private String[] splitFile(String file) {
        String head = "";
        String number = "";
        int i = 0;

        // HEAD 부분 추출 (숫자가 나올 때까지)
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i);
            i++;
        }

        // NUMBER 부분 추출 (최대 5자리 숫자까지)
        while (i < file.length() && Character.isDigit(file.charAt(i)) && number.length() < 5) {
            number += file.charAt(i);
            i++;
        }

        // TAIL 부분은 필요하지 않음 (남은 부분은 무시)
        return new String[]{head, number};
    }
}
