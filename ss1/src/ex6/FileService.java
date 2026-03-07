package ex6;

import java.io.IOException;
public class FileService {
    public static void saveToFile(User user) throws IOException {
        System.out.println("Đang lưu dữ liệu vào file...");
        throw new IOException("Không thể ghi dữ liệu vào file!");
    }
}