import java.util.Scanner ;

public class Lab02_Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        System.out.print("Enter your weight(kg), height(cm) and age: ");
        double carbs , protein , fat  ;
        double weight = in.nextDouble() ;
        double height = in.nextDouble() ;
        double age = in.nextDouble() ;
        double PAL = 1.4 ;
        double bmr ;
        bmr = 10 * weight + 6.25 * height - 5 * age - 161 ;
        double calories = bmr * PAL ;
        carbs = calories * 45 / 100 / 4 ;
        protein = calories * 25 / 100 / 4 ;
        fat = calories * 30 / 100 / 9 ;
        System.out.printf("Calories Required: %20.2f%n" , calories);
        System.out.printf("GRAMS PROTEİN: %24.2f%n" , protein); 
        System.out.printf("GRAMS FAT: %28.2f%n" , fat);
        System.out.printf("GRAMS CARBS: %26.2f%n" , carbs);
        in.close();
    }
}