import java.util.Random ;
import java.util.Scanner ; 
public class uno {
    public static void main(String[] args) {
        Scanner in = new Scanner ( System.in) ;
        String firstNumbersList = "0123456789012345678901234567890123456789CCCC" ;
        String firstColorsList  = "RRRRRRRRRRGGGGGGGGGGPPPPPPPPPPYYYYYYYYYYBBBB" ;
        String shuffledNumbersList = "";
        String shuffledColorsList = "";

        System.out.println("Starting the game!\n" + 
                        "The initial deck:\n" +
                        "numbers: 0123456789012345678901234567890123456789CCCC\n" + 
                        "colors : RRRRRRRRRRGGGGGGGGGGPPPPPPPPPPYYYYYYYYYYBBBB");
                    
        Random random = new Random();
        int bound = 44 ;
        while (bound > 0 ) {
        int indexOfAdding = random.nextInt(bound) ; 
        shuffledNumbersList += firstNumbersList.charAt(indexOfAdding) + "" ;
        shuffledColorsList += firstColorsList.charAt(indexOfAdding) + "" ;
        firstNumbersList = firstNumbersList.substring(0, indexOfAdding) + firstNumbersList.substring(indexOfAdding+1) ; // İNDEX OF +1 LEME HATA OLABİLİE
        firstColorsList = firstColorsList.substring(0, indexOfAdding) + firstColorsList.substring(indexOfAdding+1) ;
        
        bound--;
        }
        System.out.println("\nShuffled deck: ");
        System.out.println("numbers: " + shuffledNumbersList);
        System.out.println("colors : " + shuffledColorsList);

        String player1Numbers = shuffledNumbersList.substring(0,7) ;
        String player1Colors = shuffledColorsList.substring(0, 7) ;
        String player2Numbers = shuffledNumbersList.substring(7,14) ;
        String player2Colors = shuffledColorsList.substring(7, 14) ;
        String DeckAfterDealingNumbers = shuffledNumbersList.substring(14) ;
        String DeckAfterDealingColors = shuffledColorsList.substring(14) ;
        String topCardNumber = "" +DeckAfterDealingNumbers.charAt(0) ;
        String topCardColor = "" + DeckAfterDealingColors.charAt(0) ;
        String topCard = topCardNumber + topCardColor ;
        System.out.println("\nDealing the initial cards: ");
        String player1DeckShow = "Player1 numbers: " + player1Numbers + "\n" + "Player1 colors : " + player1Colors ;
        String player2DeckShow = "Player2 numbers: " + player2Numbers + "\n" + "Player2 colors : " + player2Colors ;
        System.out.println(player1DeckShow);
        System.out.println(player2DeckShow);
        System.out.println("Deck after dealing player cards:");
        if ( !topCard.contains("BC") ) {
        System.out.println("numbers: " + DeckAfterDealingNumbers);
        System.out.println("colors : " + DeckAfterDealingColors);
        
        }
        DeckAfterDealingNumbers = DeckAfterDealingNumbers.substring(1) ;
        DeckAfterDealingColors = DeckAfterDealingColors.substring(1) ;
        boolean done = true ;
        if (topCard.contains("BC")) {  // BURAYA BAAAK
            while (done) {
            
            String topCardNew = "" + DeckAfterDealingColors.charAt(0) + DeckAfterDealingNumbers.charAt(0) ;
            DeckAfterDealingNumbers = DeckAfterDealingNumbers.substring(1) + "C" ;
            DeckAfterDealingColors = DeckAfterDealingColors.substring(1) + "B" ;
            if (!topCardNew.contains("BC")) {
                topCard = topCardNew ;
                System.out.println("numbers: " + DeckAfterDealingNumbers);
                System.out.println("colors : " + DeckAfterDealingColors);
                done = false ;
            }



            }
        }

        // -------------------------------------------------------------------------------------------------------------------
        String deckLastVersionNumbers = DeckAfterDealingNumbers.substring(1) ;
        String deckLastVersionColors = DeckAfterDealingColors.substring(1) ;
        System.out.println("Top card: " + topCard);
        int count = 1 ;
        boolean bool = true ;
        int indexOfTheThrowingCart = 1 ;
        while ( bool ) {
            if (deckLastVersionColors.equals("")) {
                bool = false ;
                int lengthOf1 = player1Colors.length() ;
                int lengthOf2 = player2Colors.length() ;
                int n1 = 0 ;
                int n2 = 0 ;
                int sumOf1 = 0 ;
                int sumOf2 = 0 ;
                int number = 0 ;
                String numberString ;

                while (n1 < lengthOf1) {
                    if (!(player1Numbers.charAt(n1) + "").equals("C")) {
                    numberString = player1Numbers.charAt(n1) + "" ;
                    number = Integer.parseInt(numberString) ;  
                    sumOf1 += number ;


                    } 

                    n1++; 
                }
                while (n2 < lengthOf2) {
                    if (!(player2Numbers.charAt(n2) + "").equals("C")) {
                    numberString = player2Numbers.charAt(n2) + "" ;
                    number = Integer.parseInt(numberString) ;  
                    sumOf2 += number ;


                    } 

                    n2++; 
                }

                if ( sumOf1 < sumOf2) {
                    System.out.println("Player 1 won!");

                }
                if ( sumOf2 < sumOf1 ) {
                    System.out.println("Player 2 won!");
                }
                if ( sumOf1 == sumOf2) {
                    System.out.println("It's a tie!");
                }

            }
            else {
            if ( count % 2 != 0 && !player1Colors.equals("")) {
                System.out.println("Player1's turn");
                System.err.print("kart seçiniz:");
                if ( player1Colors.contains(topCardColor) && !player1Numbers.contains(topCardNumber)) {

                    indexOfTheThrowingCart = in.nextInt() ;
                    topCardNumber = player1Numbers.charAt(indexOfTheThrowingCart) + "" ;
                    player1Numbers = player1Numbers.substring(0, indexOfTheThrowingCart) + player1Numbers.substring(indexOfTheThrowingCart+1) ;
                    player1Colors = player1Colors.substring(0, indexOfTheThrowingCart) + player1Colors.substring(indexOfTheThrowingCart+1)  ; 
                                  
                }
                else if ( player1Numbers.contains(topCardNumber) &&  !player1Colors.contains(topCardColor)) { 

                    indexOfTheThrowingCart = in.nextInt()  ;
                    topCardColor = player1Colors.charAt(indexOfTheThrowingCart) + "" ;

                    player1Numbers = player1Numbers.substring(0, indexOfTheThrowingCart) + player1Numbers.substring(indexOfTheThrowingCart+1) ;
                    player1Colors = player1Colors.substring(0, indexOfTheThrowingCart) + player1Colors.substring(indexOfTheThrowingCart+1) ;
                }

                
                else if ( player1Colors.contains(topCardColor) && player1Numbers.contains(topCardNumber)) {

                    if ( player1Colors.indexOf(topCardColor) <= player1Numbers.indexOf(topCardNumber)) {
                       
                        
                        indexOfTheThrowingCart = in.nextInt() ;
                        topCardColor = player1Colors.charAt(indexOfTheThrowingCart) + "" ;
                        topCardNumber = player1Numbers.charAt(indexOfTheThrowingCart) + "" ;
                        player1Numbers = player1Numbers.substring(0, indexOfTheThrowingCart) + player1Numbers.substring(indexOfTheThrowingCart+1) ;
                        player1Colors = player1Colors.substring(0, indexOfTheThrowingCart) + player1Colors.substring(indexOfTheThrowingCart+1)  ;  
                                     

                    }

                    else {
                        indexOfTheThrowingCart = in.nextInt() ;
                        topCardColor = player1Colors.charAt(indexOfTheThrowingCart) + "" ;
                        topCardNumber = player1Numbers.charAt(indexOfTheThrowingCart) + "" ;
                        player1Numbers = player1Numbers.substring(0, indexOfTheThrowingCart) + player1Numbers.substring(indexOfTheThrowingCart+1) ; ;
                        player1Colors = player1Colors.substring(0, indexOfTheThrowingCart) + player1Colors.substring(indexOfTheThrowingCart+1)  ;  
                                      

                    }

                }

                else if ( (!player1Colors.contains(topCardColor) && !player1Numbers.contains(topCardNumber)) || topCardNumber.equals("C")) {  

                    if ( player1Colors.contains("B")) {

                        int lengthOff = player1Numbers.length() ;
                        
                        if ( lengthOff == 1) {
                            player1Numbers = player1Numbers.substring(0, 0)  ; 
                            player1Colors = player1Colors.substring(0, 0)  ;

                        }

                        else {
                        indexOfTheThrowingCart = in.nextInt() ;
                        player1Numbers = player1Numbers.substring(0, indexOfTheThrowingCart) + player1Numbers.substring(indexOfTheThrowingCart+1) ; 
                        player1Colors = player1Colors.substring(0, indexOfTheThrowingCart) + player1Colors.substring(indexOfTheThrowingCart+1)  ;
                        topCardNumber = "C" ;
                        topCardColor = player1Colors.charAt(0) + "";
                        
                        int n = 0 ;
                        while ( topCardColor.equals("B")) {
                        topCardColor = player1Colors.charAt(n) + "";
                        n++;
                        }
                        }

                    }
                    else {  

                        System.out.println("Current player has no card to play, drawing one from the deck.");
                        if ( (deckLastVersionColors.charAt(0)+ "").equals("B")) {
                            topCardNumber = "C" ;
                            topCardColor = player1Colors.charAt(0) + "" ;
                        } 
                        
                        else if ( topCardNumber.equals(deckLastVersionNumbers.charAt(0) + "") || topCardColor.equals(deckLastVersionColors.charAt(0)+ "")) { 
                            topCardNumber = deckLastVersionNumbers.charAt(0) + "" ;
                            topCardColor = deckLastVersionColors.charAt(0)+ "" ;
                        }

                        else {
                        player1Numbers = player1Numbers + deckLastVersionNumbers.charAt(0) ;
                        player1Colors = player1Colors + deckLastVersionColors.charAt(0) ;
                        }

                        
                        deckLastVersionNumbers = deckLastVersionNumbers.substring(1) ;
                        deckLastVersionColors = deckLastVersionColors.substring(1) ;
                        }
                        
                        }
                        
                        if ( player1Colors.equals("")) {
                            System.out.printf("%n Player1 numbers: %s %n Player1 colors : %s %n Player2 numbers: %s %n Player2 colors : %s %n Deck after this round: %n numbers: %s %n colors : %s %n Top card: %s%s %n", player1Numbers, player1Colors, player2Numbers, player2Colors, deckLastVersionNumbers, deckLastVersionColors, topCardColor, topCardNumber);
                        System.out.println("Player 1 won!");
                        bool = false ;
                    


                }

// OYUNCULARIN KARTLARIN BİTMESİ VE DESTENİN BİTMESİ 

                    

            }
            if (!deckLastVersionColors.equals("")) {
            if ( count % 2 == 0 && !player2Colors.equals("") && done) { // "123" bu string CONTAİNS "" --> TRUE SAYIYOR PC
                System.out.println("Player2's turn");


                 if ( player2Colors.contains(topCardColor) && !player2Numbers.contains(topCardNumber)) {

                    indexOfTheThrowingCart = in.nextInt() ;
                    topCardNumber = player2Numbers.charAt(indexOfTheThrowingCart) + "" ;              
                    player2Numbers = player2Numbers.substring(0, indexOfTheThrowingCart) + player2Numbers.substring(indexOfTheThrowingCart+1) ;
                    player2Colors = player2Colors.substring(0, indexOfTheThrowingCart) + player2Colors.substring(indexOfTheThrowingCart+1) ; }

                else if ( player2Numbers.contains(topCardNumber ) &&  !player2Colors.contains(topCardColor)) { 
                    if ( !topCardNumber.equals("C")) {
                        indexOfTheThrowingCart = in.nextInt() ;
                        topCardColor = player2Colors.charAt(indexOfTheThrowingCart) + "" ;

                    player2Numbers = player2Numbers.substring(0, indexOfTheThrowingCart) + player2Numbers.substring(indexOfTheThrowingCart+1) ;
                    player2Colors = player2Colors.substring(0, indexOfTheThrowingCart) + player2Colors.substring(indexOfTheThrowingCart+1) ;
                    }
                }

                
                else if ( player2Colors.contains(topCardColor) && player2Numbers.contains(topCardNumber)) {

                    if ( player2Colors.indexOf(topCardColor) <= player2Numbers.indexOf(topCardNumber)) {  // KONTROL ET BURADA HERHANGİ BİRİNİ 2 YERİNE 1 YAZMIŞ OLABİLİRİM
                        indexOfTheThrowingCart = in.nextInt() ;
                        topCardColor = player2Colors.charAt(indexOfTheThrowingCart) + "" ;
                        topCardNumber = player2Numbers.charAt(indexOfTheThrowingCart) + "" ; 
                        
                        player2Numbers = player2Numbers.substring(0, indexOfTheThrowingCart) + player2Numbers.substring(indexOfTheThrowingCart+1) ;
                        player2Colors = player2Colors.substring(0, indexOfTheThrowingCart) + player2Colors.substring(indexOfTheThrowingCart+1) ;  
                                     

                    }

                    else {
                        indexOfTheThrowingCart = in.nextInt() ;
                        topCardColor = player2Colors.charAt(indexOfTheThrowingCart) + "" ;
                        topCardNumber = player2Numbers.charAt(indexOfTheThrowingCart) + "" ; 

                        player2Numbers = player2Numbers.substring(0, indexOfTheThrowingCart) + player2Numbers.substring(indexOfTheThrowingCart+1) ;
                        player2Colors = player2Colors.substring(0, indexOfTheThrowingCart) + player2Colors.substring(indexOfTheThrowingCart+1) ;  
                                     

                    }

                } // ORTADA CY VARSA VE SENDE ÖNCE C SONRA Y VARSA?
                //ELSE İFDEKİ || NE YAPIYOR İYİ ANLA


                else if ( (!player2Colors.contains(topCardColor) && !player2Numbers.contains(topCardNumber)) || topCardNumber.equals("C")) {  

                    if ( player2Colors.contains("B")) {
                        int lengthOfffPlayer2 = player2Colors.length() ;
                        if ( lengthOfffPlayer2 == 1 ) {
                            player2Numbers = player2Numbers.substring(0, 0)  ;
                            player2Colors = player2Colors.substring(0, 0) ;

                        }
                        else {
                            indexOfTheThrowingCart = in.nextInt() ;
                            player2Numbers = player2Numbers.substring(0, indexOfTheThrowingCart) + player2Numbers.substring(indexOfTheThrowingCart+1) ;
                        player2Colors = player2Colors.substring(0, indexOfTheThrowingCart) + player2Colors.substring(indexOfTheThrowingCart+1) ;
                        topCardNumber = "C" ;
                        topCardColor = player2Colors.charAt(0) + "";
                        int n = 0 ;
                        while ( topCardColor.equals("B")) {
                        topCardColor = player2Colors.charAt(n) + "";
                        n++;
                        }
                        }

                    }
                    else {  

                        System.out.println("Current player has no card to play, drawing one from the deck.");
                        if ( (deckLastVersionColors.charAt(0)+ "").equals("B")) {
                            topCardNumber = "C" ;
                            topCardColor = player2Colors.charAt(0) + "" ;
                        }
                        else if ( topCardNumber.equals(deckLastVersionNumbers.charAt(0) + "") || topCardColor.equals(deckLastVersionColors.charAt(0)+ "")) { 
                            topCardNumber = deckLastVersionNumbers.charAt(0) + "" ;
                            topCardColor = deckLastVersionColors.charAt(0)+ "" ;
                        }

                        else {
                        player2Numbers = player2Numbers + deckLastVersionNumbers.charAt(0) ;
                        player2Colors = player2Colors + deckLastVersionColors.charAt(0) ;
                        }


                        deckLastVersionNumbers = deckLastVersionNumbers.substring(1) ;
                        deckLastVersionColors = deckLastVersionColors.substring(1) ;


                        
                        
                        }
                        }


                    }

                    if (bool) {
                    System.out.printf("%n Player1 numbers: %s %n Player1 colors : %s %n Player2 numbers: %s %n Player2 colors : %s %n Deck after this round: %n numbers: %s %n colors : %s %n Top card: %s%s %n", player1Numbers, player1Colors, player2Numbers, player2Colors, deckLastVersionNumbers, deckLastVersionColors, topCardColor, topCardNumber);
                    }
                    if ( player2Colors.equals("")) {
                        System.out.println("Player 2 won!");
                        bool = false ;
                    }


                }
        



            
        }
        
        


    count++;


        
        
    }
}
}