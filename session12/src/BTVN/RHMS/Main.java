package BTVN.RHMS;

import BTVN.RHMS.Dao.PatientDao;
import BTVN.RHMS.model.Patient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientDao dao = new PatientDao();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ BỆNH NHÂN NỘI TRÚ ===");
            System.out.println("1. Danh sách bệnh nhân");
            System.out.println("2. Tiếp nhận bệnh nhân mới");
            System.out.println("3. Cập nhật bệnh án");
            System.out.println("4. Xuất viện & Tính phí");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    for (Patient p : dao.getAllPatients()) {
                        System.out.println(p.toString());
                    }
                    break;
                case 2:
                    System.out.print("Nhập ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên : ");
                    String name = sc.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập khoa: ");
                    String dep = sc.nextLine();
                    if (dao.addPatient(new Patient(id, name, age, dep))) {
                        System.out.println("Thêm thành công!");
                    }
                    break;
                case 3:
                    System.out.print("Nhập ID bệnh nhân cần cập nhật: ");
                    int uId = Integer.parseInt(sc.nextLine());
                    System.out.print("Tên mới: ");
                    String uName = sc.nextLine();
                    System.out.print("Tuổi mới: ");
                    int uAge = Integer.parseInt(sc.nextLine());
                    System.out.print("Khoa mới: ");
                    String uDep = sc.nextLine();
                    if (dao.updatePatient(new Patient(uId, uName, uAge, uDep))) {
                        System.out.println("Cập nhật thành công!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập ID bệnh nhân xuất viện: ");
                    int disId = Integer.parseInt(sc.nextLine());
                    double fee = dao.calculateDischargeFee(disId);
                    if (fee >= 0) {
                        System.out.println("Tổng viện phí phải thanh toán: " + fee + " VND");
                    }
                    break;
                case 5:
                    System.out.println("Tạm biệt!");
                    break;
            }
        } while (choice != 5);
    }
}
