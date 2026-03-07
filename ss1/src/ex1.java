import java.util.Scanner;

public class ex1 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Mời nhập năm sinh: ");
            String namSinhStr = sc.nextLine();
            int namSinh = Integer.parseInt(namSinhStr);
            int tuoi = 2026-namSinh;
            System.out.println("Tuoi cua bạn là: " +tuoi);
        }catch (NumberFormatException e){
            System.out.println("Lỗi:Bạn phải nhập năm sinh bằng số");
        }finally {
            sc.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên");
        }
    }
}
