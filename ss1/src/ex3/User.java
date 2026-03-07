package ex3;

public class User {
    private int age;

    public void setAge(int age) throws IllegalAccessException {
        if(age<0){
            throw new IllegalAccessException("Tuổi ko thể âm");
        }
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
