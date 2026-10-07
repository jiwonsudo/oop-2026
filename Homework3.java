import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("몇 개의 수를 입력할 예정인가요? ");
        int count = scanner.nextInt();

        // 배열의 크기를 입력받을 정수 개수로 지정
        int[] arr = new int[count];

        System.out.print("수를 입력하세요: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        // 최소값/최대값을 배열의 0번째 요소로 초기화
        int max = arr[0];
        int min = arr[0];

        // 배열을 탐색하며 최소값/최대값 갱신
        for (int n : arr) {
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }

        System.out.println("최대값: " + max);
        System.out.println("최소값: " + min);
    }
}
