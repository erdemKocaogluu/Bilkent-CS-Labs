import java.util.Scanner ;
public class Lab04_Q4 {

    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in) ;
        System.out.print("Course 1 credits: ") ;
        int credits = in.nextInt();
        int grade = 300  ;
        int totalContribution = 0 ;
        double courseGrade = 0 ;
        int courseGpa ;
        int courseNumberCounter = 1 ;
        int totalCourseCredit = 0 ;
        double sumOfCreditTimesGpas = 0 ;
        while (credits > 0 ) {
            courseGrade = 0 ;
            totalCourseCredit += credits ;
        while (totalContribution != 100 ) {
            System.out.print("Enter the grade: ");
            grade = in.nextInt() ;
        while (grade < 0 || grade > 100 ) {
            System.out.println("The grade you entered is invalid");
            System.out.print("Enter the grade: ");
            grade = in.nextInt() ;
            

        }

        int contribution = 300 ;
        System.out.print("Enter the contribution (in %): ");
        contribution = in.nextInt() ;
        while (contribution < 0 || contribution > 100 ) {
            System.out.println("The contribution you entered is invalid");
            System.out.print("Enter the contribution (in %): ");
            contribution = in.nextInt() ;

        }
        totalContribution += contribution ;

        courseGrade += grade * (contribution/100.0) ; 


        }
        System.out.printf("%n");
        System.out.println("Total contribution has reached 100% for this course") ;
        System.out.printf("Course grade out of 100: %.2f%n" , courseGrade);
        totalContribution = 0 ;

        if (courseGrade >= 80 && courseGrade <= 100 ) {
        courseGpa = 4 ;
        }

        else if (courseGrade >= 60 && courseGrade < 80 ) {
            courseGpa = 3 ;
            }
        
        else if (courseGrade >= 40 && courseGrade < 60 ) {
            courseGpa = 2 ;
        }
        
        else if (courseGrade >= 20 && courseGrade < 40 ) {
            courseGpa = 1 ;
        }

        else {
            courseGpa = 0 ; // ALL COURSE GRADES ARE OUT OF 100 FALAN DİYOR O NEDENLE ELSE KULLANDIM
        }
        System.out.println("Course GPA: " + courseGpa );
        double creditTimesGpa = credits * courseGpa ;
        sumOfCreditTimesGpas += creditTimesGpa ;


        courseNumberCounter++;
        System.out.printf("%n");
        System.out.printf("Course %d credits: " , courseNumberCounter);
        credits = in.nextInt() ;
        System.out.printf("%n");

     }
     int courseNumber = courseNumberCounter - 1 ;
     System.out.println("Total courses: " + courseNumber);
     System.out.println("Total credits: " + totalCourseCredit);
     double totalGpa = sumOfCreditTimesGpas / totalCourseCredit ;
     System.out.printf("Total GPA: %.2f%n", totalGpa) ;
     in.close();
}
}