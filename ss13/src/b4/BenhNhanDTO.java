package b4;

import java.util.*;

public class BenhNhanDTO {
    public int id;
    public String ten;
    public List<String> dsDv = new ArrayList<>();

    public BenhNhanDTO(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }
}
