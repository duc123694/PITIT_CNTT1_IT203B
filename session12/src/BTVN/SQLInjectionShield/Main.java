// phân tích : PreparedStatement ngăn chặn điều này bằng cách tách biệt hoàn toàn cấu trúc lệnh và dữ liệu

package BTVN.SQLInjectionShield;

import BTVN.ConnectDB;

import java.sql.*;

public class Main {
    static void main(String[] args){
        String code = "1";
        String pass = "123";
        try(Connection conn = ConnectDB.getConnection()) {
            try(PreparedStatement stmp = conn.prepareStatement("SELECT * FROM Doctors WHERE code = ? AND pass = ?");
            ){
                stmp.setString(1, code);
                stmp.setString(2, pass);

                ResultSet rs = stmp.executeQuery();
                if(rs.next()){
                    System.out.println("Đăng nhập thành công!");
                }else{
                    System.out.println("Đăng nhập thất bại");
                }
            }
        } catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }

    }
}
