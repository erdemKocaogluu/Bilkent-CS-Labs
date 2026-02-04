import java.util.Scanner;
import java.util.ArrayList; 
public class Lab07_Q3 {
static ArrayList<String> items = new ArrayList<String> () ;
static int addedLaptop = 0 ;
static int addedPhone = 0 ;
static int addedHeadset = 0 ;
static int addedMouse = 0 ;
static int addedKeyboard = 0 ;
static int fraddedLaptop = 0 ;
static int fraddedPhone = 0 ;
static int fraddedHeadset = 0 ;
static int fraddedMouse = 0 ;
static int fraddedKeyboard = 0 ;
static ArrayList<String> chart = new ArrayList<>() ;
static ArrayList<Integer> frequentsInt = new ArrayList<>() ;
static ArrayList<String> frequentsString = new ArrayList<>() ;



static Scanner in = new Scanner(System.in) ;
public static void printMenu() {
    System.out.println("Welcome to the Online Shopping Cart System!\n" + 
                        "1. Add an item to the cart\n" + 
                        "2. Remove an item from the cart\n" + 
                        "3. View the cart\n" + 
                        "4. Find the most frequently added item\n" + 
                        "5. Apply discount and calculate total cost\n" + 
                        "6. Exit");
}

public static int choice() {
    System.out.print("Enter your choice: ");
    int choice = in.nextInt() ;
    return choice ;
}

public static void addItem() {
    System.out.print("Enter the item to add: ");
    in.nextLine();
    String add = in.nextLine();
    if (items.contains(add)) {
        System.out.printf("%s added to the cart.%n", add);
    }
    else {
        System.out.println("Item is not in the cart");
    }
    if (add.equals("Phone")) {
        fraddedPhone++;
        addedPhone++;
    }
    if (add.equals("Headset")) {
        fraddedHeadset++;
        addedHeadset++;
    }
    if (add.equals("Keyboard")) {
        fraddedKeyboard++;
        addedKeyboard++;
    }
    if (add.equals("Laptop")) {
        fraddedLaptop++;
        addedLaptop++;
    }
    if (add.equals("Mouse")) {
        fraddedMouse++;
        addedMouse++;
    }
    chart.add(add) ;
}


public static void removeItem() {
    System.out.print("Enter the item to remove: ");
    in.nextLine(); // bunu koymazsam addledikten sonra sıkıntı çıkıyor neden ama add zaten nextlinedı neden burada
    //tekrar nextlinelarken bir tane daha in.nextline eklemem gerekiyor
    String remove = in.nextLine();
    if (chart.contains(remove)) {
        chart.remove(remove) ;
        System.out.printf("%s removed from the cart.%n", remove);
    }
    else {
        System.out.printf("Error: %s is not in the cart.%n", remove);
    }
    if (remove.equals("Phone")) {
        addedPhone--;
    }
    if (remove.equals("Headset")) {
        addedHeadset--;
    }
    if (remove.equals("Keyboard")) {
        addedKeyboard--;
    }
    if (remove.equals("Laptop")) {
        addedLaptop--;
    }
    if (remove.equals("Mouse")) {
        addedMouse--;
    }
}


    public static void viewCart () {
        System.out.println("Your Cart:");
        if (addedLaptop > 0 ) {
        System.out.printf("- Laptop: %d%n", addedLaptop);
        }
        if (addedPhone > 0 ) {
        System.out.printf("- Phone: %d%n", addedPhone);
        }
        if (addedHeadset > 0 ) {
        System.out.printf("- Headset: %d%n", addedHeadset);
        }
        if (addedMouse > 0 ) {
        System.out.printf("- Mouse: %d%n", addedMouse);
        }
        if (addedKeyboard > 0 ) {
        System.out.printf("- Keyboard: %d%n", addedKeyboard);
        }
        double totalCost = addedLaptop*1200 + addedPhone*800 + addedHeadset*100 + addedMouse*50 + addedKeyboard*70 ;

        System.out.printf("Total Cost: $%.1f%n", totalCost);
        }

        public static void frequentItem() { // METODA ARAYLİST BÖYLE YAZILIR
            int[] array = {addedLaptop,addedPhone,addedHeadset,addedMouse,addedKeyboard} ;
            int biggest = 0 ;
            for (int val : array ) {
                if (val > biggest ) {
                    biggest = val ;
                }
            }
            for (int i = 0 ; i < array.length ; i++ ) {
                if (biggest == array[i]) {
                    frequentsInt.add(i) ;
                }
            }
            for (int a : frequentsInt) {
                frequentsString.add(items.get(a)) ; // FOR EACH VAR AMA ÇALIŞIR MI BİLEMEDİM
            }
            
            System.out.println("Most frequently added item(s):");
            for (String item : frequentsString ) {
                System.out.printf("- %s%n", item);
            }

        }


        public static void discount() {
            double totalCost = addedLaptop*1200 + addedPhone*800 + addedHeadset*100 + addedMouse*50 + addedKeyboard*70 ;
            System.out.printf("Total Cost before discount: $%.1f%n", totalCost);
            totalCost = totalCost* (9.0 / 10);//.0 KOYMAYI UNUTMA YOKSA 0 ÇIKAR PARANTEZE ALDIM
            System.out.print("Total Cost after 10% discount: $"); 
            System.out.printf("%.1f%n", totalCost);
            // FARKLI ŞEKİLDE YÜZDE 10 YAZMALISIN PRİNTF OLUNCA ONU BAŞKA SANIYOR
        }

        public static boolean exit(boolean done) {
            done = false ;
            System.out.println("Exiting the program. Goodbye!");
            return done ;
        }
    public static void main(String[] args) {
        items.add("Laptop") ;
        items.add("Phone") ;
        items.add("Headset") ;
        items.add("Mouse") ;
        items.add("Keyboard") ;
        boolean done = true ;
        while (done) {
        printMenu();
        int choice = choice();
        if (choice == 1) {
            addItem();
        }
        if (choice == 2) {
            removeItem();
        }
        if (choice == 3) {
            viewCart();
        }
        if (choice == 4) {
            frequentItem() ;
        }
        if (choice == 5) {
            discount();
        }
        if (choice == 6) {
            done = exit(done) ;
        }
System.out.println();

    }
    }
}
