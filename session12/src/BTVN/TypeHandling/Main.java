// Phân tích : Khi dùng cộng chuỗi (String sql = "..." + temp), Java sẽ gọi hàm toString() của biến temp.
// Hàm này phụ thuộc vào thiết lập khu vực (Locale) của hệ điều hành.
// Nếu máy cài tiếng Pháp hoặc Việt, 37.5 sẽ biến thành chuỗi "37,5", khiến SQL bị sai cú pháp (SQL tiêu chuẩn dùng dấu chấm).

package BTVN.TypeHandling;

import BTVN.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    static void main(String[] args) {
        try (Connection conn = ConnectDB.getConnection()) {
            try (PreparedStatement pstmt = conn.prepareStatement("UPDATE Vitals SET temperature = ?, heart_rate = ? WHERE p_id = ?")) {
                pstmt.setDouble(1, 25);
                pstmt.setInt(2, 35);
                pstmt.setInt(3, 33);
                int rs =  pstmt.executeUpdate();
                if(rs > 0){
                    System.out.println("Update thành công!");
                }else{
                    System.out.println("Update thất bại!");
                }
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
