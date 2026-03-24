package BTVN.RHMS.Dao;

import BTVN.ConnectDB;
import BTVN.RHMS.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {
    public List<Patient> getAllPatients(){
        String sql = "select * from patients";
        List<Patient> patients = new ArrayList<>();
        try(Connection conn = ConnectDB.getConnection()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String department = rs.getString("department");
                patients.add(new Patient(id,name,age,department));
            }
            return patients;
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return null;
    }

    public boolean addPatient(Patient patient){
        String sql = "insert into patients values(?,?,?,?)";
        try(Connection conn = ConnectDB.getConnection()){
            try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1,patient.getId());
                pstmt.setString(2,patient.getName());
                pstmt.setInt(3,patient.getAge());
                pstmt.setString(5,patient.getDepartment());
                return pstmt.executeUpdate() == 1;
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return false;
    }

    public boolean updatePatient(Patient patient){
        String sql = "update patients set name=?,age=?,department=? where id=?";
        try(Connection conn = ConnectDB.getConnection()){
            try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(4,patient.getId());
                pstmt.setString(1,patient.getName());
                pstmt.setInt(2,patient.getAge());
                pstmt.setString(3,patient.getDepartment());
                return pstmt.executeUpdate() == 1;
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return false;
    }

    public double calculateDischargeFee(int id){
        String sql = "{call CALCULATE_DISCHARGE_FEE(?, ?)}";
        try(Connection conn = ConnectDB.getConnection()){
            try(CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setInt(1, id);
                cstmt.registerOutParameter(2, Types.DECIMAL);

                cstmt.execute();
                return cstmt.getDouble(2);
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return 0;
    }



}
