import java.util.ArrayList;

public class Q6 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student s = new Student(1) ;
        list.add(s);

        System.out.println(list.contains(s));
    }
}