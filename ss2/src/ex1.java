public class ex1 {
    static void main(String[] args) {
        //1. Kiểm tra xem một User có phải là Admin hay không (trả về true/false)
        //Functional Interface: Predicate<User>
        //Lý do:Predicate dùng để kiểm tra một điều kiện và trả về boolean (true/false)

        //2. Chuyển đổi một đối tượng User thành chuỗi String chứa thông tin username
        //Functional Interface: Function<User, String>
        //Lý do:Function dùng để chuyển đổi dữ liệu từ kiểu này sang kiểu khác.
        //Input: User
        //Output: String

        //3. In thông tin chi tiết của User ra màn hình Console
        //Functional Interface: Consumer<User>
        //Lý do:Consumer dùng khi thực hiện một hành động trên đối tượng nhưng không trả về giá trị.

        //4. Khởi tạo một đối tượng User mới với các giá trị mặc định
        //Functional Interface: Supplier<User>
        //Lý do:Supplier dùng để cung cấp hoặc tạo ra một đối tượng mà không cần tham số đầu vào.
    }
}
