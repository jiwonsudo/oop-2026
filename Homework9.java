import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Homework9 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        try (Scanner fileSc = new Scanner(new File("db.txt"))) {
            while (fileSc.hasNextLine()) {
                String line = fileSc.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\s+");
                if (parts.length >= 2) {
                    map.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("db.txt 파일이 존재하지 않습니다.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요.");
            System.out.print("id : ");
            String id = sc.nextLine().trim();

            if (!map.containsKey(id)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
                System.out.println();
                continue;
            }

            System.out.print("password : ");
            String pw = sc.nextLine().trim();

            if (map.get(id).equals(pw)) {
                System.out.println("id와 비밀번호가 일치합니다.");
                break;
            }
            System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            System.out.println();
        }

        sc.close();
    }
}
