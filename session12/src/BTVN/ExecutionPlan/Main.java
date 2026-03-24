// Phân tích :Khi sử dụng Statement và cộng chuỗi SQL trong vòng lặp như mã nguồn lỗi, Database Server phải trải qua quy trình 4 bước cho mỗi câu lệnh đơn lẻ:
    //Parsing (Phân tích cú pháp): Kiểm tra xem câu lệnh SQL có đúng cú pháp không.
    //Validating (Xác thực): Kiểm tra xem bảng Results có tồn tại không, cột data có đúng không, user có quyền insert không.
    //Optimization (Tối ưu hóa): Tìm con đường ngắn nhất để thực thi lệnh.
    //Generating Execution Plan: Tạo ra một "kế hoạch thực thi" và lưu vào bộ nhớ đệm (Cache).

package BTVN.ExecutionPlan;

import demo.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    static void main(String[] args) {
        try(Connection conn = ConnectDB.getConnection()){
            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Results(data) VALUES(?)")){
                for (int i = 0; i < 1000; i++) {
                    pstmt.setString(1, "data " + i);
                    pstmt.executeUpdate();
                }
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
