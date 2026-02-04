import java.util.Scanner ;
public class Lab03_Q2 {

    public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                System.out.print("GPA: ");
                double gpa1 = in.nextDouble() ;
                double gpa = Math.round(gpa1 * 10) / 10.0 ;
                System.out.print("First reference score: ");
                double firstreference = in.nextDouble() ;
                System.out.print("Second reference score: ");
                double secondreference = in.nextDouble() ;
                System.out.print("Number of papers: ") ;
                double papernumber = in.nextDouble() ;
                System.out.print("Number of failed courses: ");
                int failedcourse = in.nextInt() ;
                System.out.print("Bilkent professor’s score: ");
                double profscore ;
                if (in.hasNextDouble()) {
                    profscore = in.nextDouble() ;
                }
                else {
                    profscore = 10101010 ;
                }
                if (profscore == 10101010) {
                    System.out.println("The score given by Bilkent’s professors must not be empty");
                }
                else {

                System.out.print("IELTS score: ");
                double ielts = in.nextDouble() ;
                double gpa2 ;
                if (gpa < 3.3) {
                gpa2 = 3.3 ;
                }
                else {
                    gpa2 = gpa ;
                } 

                double ielts2 ;
                if (ielts < 6.5) {
                ielts2 = 6.5 ;
                }
                else {
                    ielts2 = ielts ;
                } 
            double score = (20 * ((gpa2 - 3.3) / 0.1 )) + (10 * (firstreference + secondreference )) + (100 * ( papernumber - 1)) - (30 * failedcourse) + (30 * profscore) + (10 * (int)((ielts2 - 6.5) / 0.5 )) ;
            System.out.printf("Calculated Score: %.0f%n" , score ) ;
            if (  gpa < 3.3 || firstreference < 6 || secondreference < 6 || papernumber < 1 || failedcourse > 3 || profscore < 5 || ielts < 6.5) {   // BURADAKŞ PROF SCORE BOŞ OLABİLİR ONU DÜZELT
                    System.out.println("The candidate is NOT eligible.");
                    System.out.println("Reasons: ");
                    if ( gpa < 3.3  )
                    System.out.println("- GPA is below the required threshold.");
                    if (firstreference < 6 )
                    System.out.println("- The second reference score is below the required threshold.");
                    if (secondreference < 6 )
                    System.out.println("- The first reference score is below the required threshold.");
                    if (papernumber < 1)
                    System.out.println("- Candidate must have at least one research paper.");
                    if ( failedcourse > 3 )
                    System.out.println("- The number of failed courses exceeds the limit.");     
                    if ( profscore < 5 )             
                    System.out.println("- The score given by Bilkent professors is below the required threshold.");
                    if (ielts < 6.5 )
                    System.out.println("- IELTS score is below the required threshold.");
                }
                else {
                    System.out.println("The candidate is eligible for admission.");
                }
                

                

                
                in.close();
            }
        } }