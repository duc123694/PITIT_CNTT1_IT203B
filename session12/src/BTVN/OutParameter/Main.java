// Phân tích : Khi gọi một Stored Procedure có tham số OUT, JDBC cần biết trước kiểu dữ liệu của giá trị mà cơ sở dữ liệu sẽ trả về tại vị trí đó.

package BTVN.OutParameter;

import BTVN.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class Main {
    static void main(String[] args) {
        try(Connection conn = ConnectDB.getConnection()){
            try(CallableStatement st = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}")) {
                st.setInt(1, 505);
                st.registerOutParameter(2, Types.INTEGER);
                st.execute();

                double surgery = st.getDouble(2);
                System.out.println("Chi phí : " + surgery);
            }
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
}
