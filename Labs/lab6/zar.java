import java.util.Arrays;
import java.util.Random ; 
import java.util.Scanner ;

public class zar {


        public static void scoreSheet(int roundfrom1, int totalComputerScore , int totalUserScore) {
            System.out.printf("Our scoresheet after round %d:%n", roundfrom1);
                System.out.println("=============================");
                System.out.println("My score Your score");
                System.out.printf("%-12d %d%n", totalComputerScore , totalUserScore) ;
        }
public static int rollADice () {
    Random in = new Random() ;   

    int newDiceInt ;
    newDiceInt = in.nextInt(6) + 1 ;
    return newDiceInt ;
}
        
public static int calculateScore (int dice1 , int dice2 ,int dice3 ,int dice4 , int dice5) {
    

    int count = 1 ;
         int toplam = 0 ;
         int biggest = -1 ;
         int number = 0 ;
         String str = "" ;
         String strx1;
         String strx2 ;
         int score = 0 ;
    count = 1 ;
    toplam = 0 ;
    biggest = -1 ;
    number = 0 ;
    while (count < 7) {
        toplam = 0 ;

        if (dice1 == count) { 

            toplam++;
        }
        if (dice2 == count) {

            toplam++;
        }
        if (dice3 == count) {

            toplam++;
        }
        if (dice4 == count) {

            toplam++;
        }
        if (dice5 == count) {

            toplam++;
        }
        
        



         if ( toplam >= biggest ) {
            
            biggest = toplam ;
            number = count ;

        }

        
        



        count++;
    }
    //zarn diyip n i değiştirme ve karşılaştırma mesela zarn > zar(n+1) mi falan diye

    
    int[] diceArray = {dice1, dice2, dice3, dice4, dice5};
    Arrays.sort(diceArray);

    if (diceArray[0] + 1 == diceArray[1] && diceArray[1] + 1 == diceArray[2] && diceArray[2] + 1 == diceArray[3] && diceArray[3] + 1 == diceArray[4]) { 
        
        score = 20;
    }

    else if ( biggest == 2) {
        score = biggest * number ;
    }
    else if ( biggest == 1) { // sonra bu olmalı EĞER YERLERİNİ DEĞİŞTİRİRSEN ARDIŞIK OLDUĞUNDA 
                                // ÖZATEN BİGGEST 1 OLUR VE DİĞERİNE GİRMEZHATA VERİR BU ŞUAN DOĞRU SIRALAMA
        score = 1 ;
    } 

    else if (biggest == 3) { 

            str = "" + dice1 + dice2 + dice3 + dice4 + dice5 ;
            str = str.replace(number + "", "") ; // YA CHAR A CHAR DEĞİŞCEK YA DA STRİNGE STRİNG
            strx1 = str.charAt(0) + "" ;
            strx2 = str.charAt(1) + "" ;
            if (strx1.equals(strx2)) {
                score = 30 ;
            }
            else {
                score = number * 3 ;
            }

        }
    
    else  {
        score = biggest * 10 ;
    }
    return score ;
}



    public static void main(String[] args) {
        Random in = new Random() ;
        Scanner scan = new Scanner(System.in) ;

         int zar1 = rollADice() ;
         int zar2 = rollADice() ;
         int zar3 = rollADice() ;
         int zar4 = rollADice() ;
         int zar5 = rollADice() ;
         int count = 1 ;
         int toplam = 0 ;
         int biggest = -1 ;
         int number = 0 ;
         String str = "" ;
         String strx1;
         String strx2 ;
         int score = 0 ;


        System.out.println("Welcome to Generala game. \nLet's get started! \n"); 
        //PRİNTLN VE SONDAKİ \n BİRLEŞİNCE KALAN SATIRI DOLDURUP BİR DE TAM SATIR BOŞLUK BIRAKIYOR
        //AŞAĞIDAKİ KOMUT DA PRİNT YANİ BURADA PRİNTLN DE OLSA AYNI ŞEY OLURDU ZATEN DE
        System.out.print("How many rounds would you like to play? ");
        int roundNumber = scan.nextInt() ;
        int roundfrom1 = 1 ;
        int c1 = rollADice() ;
        int  c2 = rollADice() ;
        int userdice1 = rollADice() ;
        int userdice2 = rollADice() ;
        System.out.println("I have rolled the dice and got: " + c1 + " and " + c2);
        System.out.println("I have rolled the dice for you and you got: " + userdice1 + " and " + userdice2);
        while (c1 + c2 == userdice1 + userdice2) {
             c1 = rollADice() ;
          c2 = rollADice() ;
         userdice1 = rollADice() ;
         userdice2 = rollADice() ;
        System.out.println("I have rolled the dice and got: " + c1 + " and " + c2);
        System.out.println("I have rolled the dice for you and you got: " + userdice1 + " and " + userdice2);
        }
        int totalUserScore = 0 ;
        int totalComputerScore = 0 ;

        while (roundfrom1 <= roundNumber) {
            if (c1 + c2 < userdice1 + userdice2) {
                System.out.printf("Round %d -- Your turn: %n" , roundfrom1);
                System.out.println("------------------------------------------");
                int dice1User = rollADice() ;
                int dice2User = rollADice() ;
                int dice3User = rollADice() ;
                int dice4User = rollADice() ;
                int dice5User = rollADice() ;
                System.out.printf("You got --> [Dice 1]: %d [Dice 2]: %d [Dice 3]: %d [Dice 4]: %d [Dice 5]: %d%n" , dice1User, dice2User , dice3User , dice4User , dice5User);
                int userScore = calculateScore(dice1User, dice2User, dice3User, dice4User, dice5User) ;
                totalUserScore += userScore ;
                System.out.printf("Your score: %d Total score: %d%n ", userScore , totalUserScore);
                System.out.print("Shall I roll for you (Y/N)? ");
                int sayac = 0 ;
                while (sayac < 2 && scan.next().equalsIgnoreCase("Y") ) {// ÖNCE SAYAC OLMALI ÖNEMLİ
                    System.out.print("Which ones do you want to keep? ");
                    int firstKeep = scan.nextInt() ;
                    int secondKeep = scan.nextInt() ;

                    if (firstKeep != 1 && secondKeep != 1) {
                        dice1User = rollADice() ;
                    }
                    if (firstKeep != 2 && secondKeep != 2) {
                        dice2User = rollADice() ;
                    }
                    if (firstKeep != 3 && secondKeep != 3) {
                        dice3User = rollADice() ;
                    }
                    if (firstKeep != 4 && secondKeep != 4) {
                        dice4User = rollADice() ;
                    }
                    if (firstKeep != 5 && secondKeep != 5) {
                        dice5User = rollADice() ;
                    }
                    
                    System.out.printf("You got --> [Dice 1]: %d [Dice 2]: %d [Dice 3]: %d [Dice 4]: %d [Dice 5]: %d%n" , dice1User , dice2User ,dice3User , dice4User, dice5User);
                    score = calculateScore(dice1User, dice2User, dice3User, dice4User, dice5User) ;
                    totalUserScore += score ;

                    System.out.printf("Your score: %d Total score: %d%n " , score , totalUserScore);
                    if (sayac == 0) {
                    System.out.print("Shall I roll for you (Y/N)? ");
                    }
                    sayac++ ;
                }

                if (score == 50) {
                    roundfrom1 = roundNumber + 2 ;
                    System.out.println("Generala!");
                    System.out.println("YOU ARE THE WINNER!!");

                }
                else  {
                System.out.printf("Round %d -- My turn: %n" , roundfrom1);
                System.out.println("------------------------------------------");
                System.out.println("I rolled them and I got");
                int dice1Computer = rollADice() ;
                int dice2Computer = rollADice() ;
                int dice3Computer = rollADice() ;
                int dice4Computer = rollADice() ;
                int dice5Computer = rollADice() ;

                System.out.printf("--> [Dice 1]: %d [Dice 2]: %d [Dice 3]: %d [Dice 4]: %d [Dice 5]: %d%n" ,dice1Computer , dice2Computer , dice3Computer , dice4Computer , dice5Computer );
                
                score = calculateScore(dice1Computer, dice2Computer, dice3Computer, dice4Computer, dice5Computer) ;
                int say = 0 ;
                while (score== 40 && say < 2) {

                    if (dice1Computer != dice2Computer && dice1Computer != dice4Computer) {
                        dice1Computer = rollADice() ;
                        System.out.println("Rolled dice 1"  );
                    }
                    if (dice2Computer != dice3Computer && dice2Computer != dice4Computer) {
                        dice2Computer = rollADice() ;
                        System.out.println("Rolled dice 2"  );

                    }
                    if (dice3Computer != dice2Computer && dice3Computer != dice4Computer) {
                        dice2Computer = rollADice() ;
                        System.out.println("Rolled dice 3"  );

                    }
                    if (dice4Computer != dice2Computer && dice4Computer != dice5Computer) {
                        dice2Computer = rollADice() ;
                        System.out.println("Rolled dice 4"  );

                    }
                    if (dice5Computer != dice2Computer && dice5Computer != dice4Computer) {
                        dice2Computer = rollADice() ;
                        System.out.println("Rolled dice 5"  );

                    }
                    System.out.printf("--> [Dice 1]: %d [Dice 2]: %d [Dice 3]: %d [Dice 4]: %d [Dice 5]: %d%n" ,dice1Computer , dice2Computer , dice3Computer , dice4Computer , dice5Computer );

                    score = calculateScore(dice1Computer, dice2Computer, dice3Computer, dice4Computer, dice5Computer) ;
                    say++;
                }

                

                totalComputerScore += score ;
                
                if (score == 50) {
                    roundfrom1 = roundNumber + 2 ;
                    System.out.println("Generala!");
                    System.out.printf("My score: %d Total score: %d%n", score, totalComputerScore);

                    System.out.println("I AM THE WINNER!!");
                    scoreSheet(roundfrom1, totalComputerScore, totalUserScore);

                }
                else {
                System.out.printf("My score: %d Total score: %d%n", score, totalComputerScore);

                scoreSheet(roundfrom1, totalComputerScore, totalUserScore);
                }
                



            }
        }
        else {
            System.out.printf("Round %d -- My turn: %n" , roundfrom1);
                System.out.println("------------------------------------------");
                System.out.println("I rolled them and I got");
                int dice1Computer = rollADice() ;
                int dice2Computer = rollADice() ;
                int dice3Computer = rollADice() ;
                int dice4Computer = rollADice() ;
                int dice5Computer = rollADice() ;

                System.out.printf("--> [Dice 1]: %d [Dice 2]: %d [Dice 3]: %d [Dice 4]: %d [Dice 5]: %d%n" ,dice1Computer , dice2Computer , dice3Computer , dice4Computer , dice5Computer );
                
                score = calculateScore(dice1Computer, dice2Computer, dice3Computer, dice4Computer, dice5Computer) ;
                int say = 0 ;
                while (score== 40 && say < 2) {

                    if (dice1Computer != dice2Computer && dice1Computer != dice4Computer) {
                        dice1Computer = rollADice() ;
                        System.out.println("Rolled dice 1"  );
                    }
                    if (dice2Computer != dice3Computer && dice2Computer != dice4Computer) {
                        dice2Computer = rollADice() ;
                        System.out.println("Rolled dice 2"  );

                    }
                    if (dice3Computer != dice2Computer && dice3Computer != dice4Computer) {
                        dice2Computer = rollADice() ;
                        System.out.println("Rolled dice 3"  );

                    }
                    if (dice4Computer != dice2Computer && dice4Computer != dice5Computer) {
                        dice2Computer = rollADice() ;
                        System.out.println("Rolled dice 4"  );

                    }
                    if (dice5Computer != dice2Computer && dice5Computer != dice4Computer) {
                        dice2Computer = rollADice() ;
                        System.out.println("Rolled dice 5"  );

                    }
                    System.out.printf("--> [Dice 1]: %d [Dice 2]: %d [Dice 3]: %d [Dice 4]: %d [Dice 5]: %d%n" ,dice1Computer , dice2Computer , dice3Computer , dice4Computer , dice5Computer );

                    score = calculateScore(dice1Computer, dice2Computer, dice3Computer, dice4Computer, dice5Computer) ;
                    say++;
                }

                

                totalComputerScore += score ;
                if (score == 50) {
                    roundfrom1 = roundNumber + 2 ;
                    System.out.println("Generala!");
                    System.out.printf("My score: %d Total score: %d%n", score, totalComputerScore);

                    System.out.println("I AM THE WINNER!!");
                    scoreSheet(roundfrom1, totalComputerScore, totalUserScore);

                }
                else {
                System.out.printf("My score: %d Total score: %d%n", score, totalComputerScore);

                scoreSheet(roundfrom1, totalComputerScore, totalUserScore);
                }

                
                if (score != 50)  {
                System.out.printf("Round %d -- Your turn: %n" , roundfrom1);
                System.out.println("------------------------------------------");
                int dice1User = rollADice() ;
                int dice2User = rollADice() ;
                int dice3User = rollADice() ;
                int dice4User = rollADice() ;
                int dice5User = rollADice() ;
                System.out.printf("You got --> [Dice 1]: %d [Dice 2]: %d [Dice 3]: %d [Dice 4]: %d [Dice 5]: %d%n" , dice1User, dice2User , dice3User , dice4User , dice5User);
                int userScore = calculateScore(dice1User, dice2User, dice3User, dice4User, dice5User) ;
                totalUserScore += userScore ;
                System.out.printf("Your score: %d Total score: %d%n ", userScore , totalUserScore);
                System.out.print("Shall I roll for you (Y/N)? ");
                int sayac = 0 ;
                while (sayac < 2 && scan.next().equalsIgnoreCase("Y") ) {// ÖNCE SAYAC OLMALI ÖNEMLİ
                    System.out.print("Which ones do you want to keep? ");
                    int firstKeep = scan.nextInt() ;
                    int secondKeep = scan.nextInt() ;

                    if (firstKeep != 1 && secondKeep != 1) {
                        dice1User = rollADice() ;
                    }
                    if (firstKeep != 2 && secondKeep != 2) {
                        dice2User = rollADice() ;
                    }
                    if (firstKeep != 3 && secondKeep != 3) {
                        dice3User = rollADice() ;
                    }
                    if (firstKeep != 4 && secondKeep != 4) {
                        dice4User = rollADice() ;
                    }
                    if (firstKeep != 5 && secondKeep != 5) {
                        dice5User = rollADice() ;
                    }
                    
                    System.out.printf("You got --> [Dice 1]: %d [Dice 2]: %d [Dice 3]: %d [Dice 4]: %d [Dice 5]: %d%n" , dice1User , dice2User ,dice3User , dice4User, dice5User);
                    score = calculateScore(dice1User, dice2User, dice3User, dice4User, dice5User) ;
                    totalUserScore += score ;

                    System.out.printf("Your score: %d Total score: %d%n " , score , totalUserScore);
                    if (sayac == 0) {
                    System.out.print("Shall I roll for you (Y/N)? ");
                    }
                    sayac++ ;
                }

                if (score == 50) {
                    roundfrom1 = roundNumber + 2 ;
                    System.out.println("Generala!");
                    System.out.println("YOU ARE THE WINNER!!");

                }

                



            }

            
        }
                // if (totalComputerScore >= 50) {
                //             scoreSheet(roundfrom1, totalComputerScore, totalUserScore);

                //     System.out.println("I AM THE WINNER!!");
                // }

                // if (totalUserScore >= 50) {
                //     scoreSheet(roundfrom1, totalComputerScore, totalUserScore);

                //     System.out.println("YOU ARE THE WINNER!!");
                // }
            roundfrom1++;
        }

        if (roundfrom1 == roundNumber + 1) {
            if (totalComputerScore > totalUserScore) {
                scoreSheet(roundfrom1, totalComputerScore, totalUserScore);

                    System.out.println("I AM THE WINNER!!");
            }

            if (totalComputerScore < totalUserScore) {
                scoreSheet(roundfrom1, totalComputerScore, totalUserScore);

                    System.out.println("YOU ARE THE WINNER!!");
            }

            else {
                System.out.println("DRAW!!!");
            }
        }


        
        

    }
}
