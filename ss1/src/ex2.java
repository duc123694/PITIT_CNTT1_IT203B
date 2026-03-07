import java.util.Scanner;

public class ex2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập toongr số người: ");
        int tongNguoi = sc.nextInt();
        System.out.println("Mời bạn nhập số nhóm: ");
        int soNhom = sc.nextInt();
        try {
            int moiNhom = tongNguoi/soNhom;
            System.out.println("Mỗi nhóm có: "+moiNhom +" người");
        }catch (AbstractMethodError e){
            System.out.println("Lỗi:ko thể chia cho 0");
        }finally {
            sc.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên");
        }
    }
}
