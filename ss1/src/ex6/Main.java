package ex6;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhập tên người dùng: ");
            String name = sc.nextLine();
            User user = new User(name);
            if (user.getName() != null) {
                System.out.println("Xin chào: " + user.getName());
            }
            System.out.print("Nhập năm sinh: ");
            String yearStr = sc.nextLine();
            int year = Integer.parseInt(yearStr);
            int age = 2026 - year;
            user.setAge(age);
            System.out.println("Tuổi: " + user.getAge());
            System.out.print("Nhập tổng số người: ");
            int total = sc.nextInt();
            System.out.print("Nhập số nhóm: ");
            int groups = sc.nextInt();
            int result = total / groups;
            System.out.println("Mỗi nhóm có: " + result + " người");
            FileService.saveToFile(user);
        }
        catch (NumberFormatException e) {
            Logger.logError("Sai định dạng số: " + e.getMessage());

        }
        catch (ArithmeticException e) {
            Logger.logError("Không thể chia cho 0");

        }
        catch (InvalidAgeException e) {
            Logger.logError(e.getMessage());

        }
        catch (IOException e) {
            Logger.logError("Lỗi ghi file: " + e.getMessage());

        }
        finally {
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");

        }

    }

}