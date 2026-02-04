import java.util.Arrays;

public class GRADEEE {


    public static int[] GradeStudents (char[][] answers , char[] keys ) {

        int[] grades = new int[answers.length] ; //// ?????
        int trueA = 0 ;
        for (int i = 0 ; i < grades.length ; i++ ) {
            trueA = 0 ;

            for (int x = 0 ; x < keys.length ; x++ ) {
                if (answers[i][x] == keys[x]) {
                    trueA++;
                }
            }
            grades[i] = trueA ;

        }
        return grades ;



    }

    public static int[] gradeQuestions(char[][] answers , char[] keys)  {

        int [] grades = new int[keys.length] ;
        for (int qNumber = 0 ; qNumber < keys.length ; qNumber++ ) {
            int trueA = 0 ;
            for (int i = 0 ; i < answers.length ; i++ ) {

                if (answers[i][qNumber] == keys[qNumber]) {
                    trueA++;
                }
            }
            grades[qNumber ] = trueA ;
        }

        return grades ;
    }
    public static void main(String[] args) {
        char[][] answers = {
            {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
            {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
            {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
            {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

            char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

            int [] Sgrades = GradeStudents(answers, keys) ;
            int [] Qgrades = gradeQuestions(answers, keys) ;

            System.out.println(Arrays.toString(Sgrades));
            System.out.println(Arrays.toString(Qgrades));
            System.out.println(answers.length);

            



    }
}
