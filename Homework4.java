import java.util.Scanner;

public class Homework4 {
    // 뺄셈을 이용한 유클리드 호제법 (수업 시간 예제)
    int gcd(int a, int b) {
        if (a == b) { return a; }
        else if (a > b) { return gcd(a - b, b); }
        else { return gcd(a, b - a); }
    }

    // 나머지 연산을 이용한 재귀호출 버전
    int gcdRecursive(int m, int n) {
        if (n == 0) { return m; }
        int small = (m < n) ? m : n;
        int large = (m < n) ? n : m;
        if (small == 0) { return large; } // 0으로 나누는 것을 방지
        return gcdRecursive(small, large % small);
    }

    // 나머지 연산을 이용한 반복문 버전
    int gcdLoop(int m, int n) {
        while (n != 0) {
            int small = (m < n) ? m : n;
            int large = (m < n) ? n : m;
            if (small == 0) { return large; } // 0으로 나누는 것을 방지
            m = small;
            n = large % small;
        }
        return m;
    }

    public static void main(String[] args) {
        Homework4 hw = new Homework4();
        Scanner scanner = new Scanner(System.in);

        System.out.print("두 수를 입력하세요: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // 세 가지 구현의 결과는 항상 같아야 함
        int result = hw.gcdRecursive(a, b);
        if (result != hw.gcdLoop(a, b) || (a > 0 && b > 0 && result != hw.gcd(a, b))) {
            System.out.println("구현 간 결과가 일치하지 않습니다.");
        }

        System.out.println("두 수의 최대공약수는 " + result + "입니다.");
    }
}
