package ex3;

public class Main {
    static void main(String[] args) {
        User user = new User();
        try {
            user.setAge(5);
            System.out.println("Tuổi: "+user.getAge());
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }
    }
}
