/* 문제
– Student 클래스를 코드로 구현하세요. 이 클래스는 학번, 이름, 전공, 전화번호를 속성으로 가지고,
메소드로는 각 멤버 변수의 값을 읽는 getter와 설정하는 setter를 구현합니다 (예: setMajor(), getMajor())
– 3명의 학생 정보를 키보드로부터 입력받아 Student 객체를 생성하고,
입력이 끝나면 입력된 학생 정보를 모두 출력하는 Homework2 클래스를 작성하세요.
– 파일명은 Homework2.java로 지정하여 github에 업로드
• 요구사항
– 학번, 이름, 전공, 전화번호 순서로, 띄어쓰기로 구분하여 학생 정보 입력
– 전공과 이름은 문자열로, 학번과 전화번호는 숫자로 저장 (즉, 전화번호 입력시 ‘-’가 없고, 맨 앞 0은 삭제)
다만 전화번호는 출력시 010-xxxx-xxxx 형태로 앞자리 0을 복구하고 중간 중간 하이픈(‘-’)을 삽입
• 문자열 관련 힌트
– 문자열→정수: Integer.parseInt(숫자로 구성된 문자열) 또는 Long.parseLong(숫자로 구성된 문자열)
정수 → 문자열: Integer.toString(숫자) 또는 Long.toString(숫자) */

import java.util.Scanner;

class Student {
    int id;
    String name;
    String major;
    long phoneNumber;

    void setID(int id) { this.id = id; }
    void setName(String name) { this.name = name; }
    void setMajor(String major) { this.major = major; }
    void setPhoneNumber(long phoneNumber) { this.phoneNumber = phoneNumber; }

    int getID() { return id; }
    String getName() { return name; }
    String getMajor() { return major; }
    long getPhoneNumber() { return phoneNumber; }  // 실제 저장된 phonenumber 조회시에만 사용

    String getFormattedPhoneNumber() {
        String str = Long.toString(phoneNumber);
        return "0" + str.substring(0, 2) + "-" + str.substring(2, 6) + "-" + str.substring(6, 10);
    }
}

public class Homework2 {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student();
        students[1] = new Student();
        students[2] = new Student();
        Scanner input = new Scanner(System.in);
        for (Student student : students) {
            System.out.println("학생의 학번, 이름, 전공, 전화번호를 입력하세요: ");
            student.setID(Integer.parseInt(input.next()));
            student.setName(input.next());
            student.setMajor(input.next());
            student.setPhoneNumber(Long.parseLong(input.next()));
        }

        System.out.println("입력된 학생들의 정보는 다음과 같습니다.");

        for (int i = 0; i < students.length; i++) {
            System.out.printf("%d번째 학생: %d %s %s %s\n", i + 1, students[i].getID(), students[i].getName(), students[i].getMajor(), students[i].getFormattedPhoneNumber());
        }
    }
}
