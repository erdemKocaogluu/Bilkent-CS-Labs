import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class App {
    public static ArrayList<Integer> plateNumbersList = new ArrayList<>();
    public static Scanner in = new Scanner (System.in) ;
    public static boolean bool = true ;
    public static ArrayList<Staff> staffListCreatedFor5 = new ArrayList<>() ;


    public static void main(String[] args) {
        boolean done = true ;
        User user = new User() ;

        while (done) {

            int option = listOptions() ;

            if (option == 1) {
                buyAVehicle(user);
            }
            if (option == 2) {
                listOwnedVehicles(user);
            }
            if (option == 3) {
                sellAVehicle(user);
            }
            
            if (option == 4) {
                hireStaff(user);
            }
            if (option == 5) {
                assignStaff(user);
            }
            if (option == 6) {
                distributeStaff(user);
            }
            if (option == 7 ) {
                fireStaff(user);
            }
            if (option == 8) {
                endTurn(user);
            }



            
            System.out.println(user.getMoney());






        }



    }


    public static void buyAVehicle(User user) {
        System.out.printf("%15s %15s %15s %15s %15s%n ", "Type", "Cargo Capacity", "Staff Capacity" 
        , "Cost" , "Speed");
        System.out.printf("%15s %15s %15s %15s %15s%n ", "1)Bicycle", "5", "1" 
        , "100" , "10");    
        System.out.printf("%15s %15s %15s %15s %15s%n ", "2)Car", "20", "2" 
        , "2000" , "50");  
        System.out.printf("%15s %15s %15s %15s %15s%n ", "3)Van", "100", "4" 
        , "4000" , "25");    
        System.out.printf("%15s %15s %15s %15s %15s%n ", "4)Truck", "200", "5" 
        , "7000" , "20");    
        System.out.printf("%15s %15s %15s %15s %15s%n ", "5)Helicopter", "50", "20" 
        , "15000" , "100");

        System.out.print("Which one do you want to buy? ");
        int option = in.nextInt() ;
        
        if (option ==1 ) {
            Vehicle x = new Bicycle() ;
            user.buyVehicle(x);
        }
        if (option == 2 ) {
            Vehicle x = new Car() ;
            user.buyVehicle(x);
        }
        if (option ==3 ) {
            Vehicle x = new Van() ;
            user.buyVehicle(x);
        }
        if (option ==4 ) {
            Vehicle x = new Truck() ;
            user.buyVehicle(x);
        }
        if (option ==5 ) {
            Vehicle x = new Helicopter() ;
            user.buyVehicle(x);
        }
    }

    public static void listOwnedVehicles(User user ) {
        ArrayList<Vehicle> list = user.getUsersVehicleList() ;
        for (int n = 0 ; n < list.size() ; n++ ) {
            Vehicle vehicle = list.get(n) ;
            int c = n+1 ;
            System.out.print(c + ") ");
            System.out.println("vehicle type: " + vehicle.getType());
            System.out.println("plate number: " + vehicle.getPlateNumber());
            System.out.println("profit: " + vehicle.getProfit() );
            System.out.println("Staff assigned to the vehicle: ");
            for (Staff staff : vehicle.getAssignedStaffList() ) {
                System.out.println(staff);
            }
        }

    }

    public static void sellAVehicle(User user ) {
        listOwnedVehicles(user);
        System.out.print("Which vehicle you want to sell? ");
        int option = in.nextInt() ;
        Vehicle vehicle = user.getUsersVehicleList().get(option-1) ; // get(option--) noluyor böyle olursa
        user.sellVehicle(vehicle);
        System.out.println("You sold the vehicle");

    }


    public static int listOptions(){
        System.out.println("1) Buy a vehicle");
        System.out.println("2) List owned vehicles");
        System.out.println("3) Sell a vehicle ");
        System.out.println("4) Hire staff ");
        System.out.println("5) Assign staff ");
        System.out.println("6) Distribute staff ");
        System.out.println("7) Fire staff");
        System.out.println("8) End turn ");
        System.out.print("Which one do you choose? ");
        int option = in.nextInt() ;
        return option ;
    }


    public static void hireStaff(User user) {



ArrayList<Vehicle> ownedVehicles = new ArrayList<>() ;
        ArrayList<Staff> staffWorking = new ArrayList<>() ;
        Random ran = new Random() ;
        if (bool) {
        String[] nameListForStaff =
        {"Erdem", "Emirhan" , "Alperen", "Ahmet", "Efe" , "Ege" , "Bilgehan" , "Nazlı", "Arda", "Mario"} ;

        String[] surnameListForStaff = 
        {"Kocaoğlu", "Dönmez", "Başar", "Canpolat", "Yıldız", "Karaca", "Fırat", "Kök","Guler", "Gomez"} ;

        String[] skills =
        {"driver", "carrier", "receiver"} ;

            for (int i = 0 ; i < 5 ; i++ ) {
                int randomForSkills = ran.nextInt(3) ;
                int randomForName = ran.nextInt(10) ;
                String name = nameListForStaff[randomForName] ;
                String surname = surnameListForStaff[randomForName] ;
                String skill = skills[randomForSkills] ;

                if (skill.equals("driver")) {
                    Staff staff = new Driver(name, surname) ;
                    staffListCreatedFor5.add(staff) ;
                }
                if (skill.equals("carrier")) {
                    Staff staff = new Carrier(name, surname) ;
                    staffListCreatedFor5.add(staff) ;
                }
                if (skill.equals("receiver")) {
                    Staff staff = new Receiver(name, surname) ;
                    staffListCreatedFor5.add(staff) ;
                }
                
            }
            bool = false ;
        }

            for (int n = 0 ; n < staffListCreatedFor5.size() ; n++ ) {
                Staff staff = staffListCreatedFor5.get(n) ;
                int c = n+1 ;
                System.out.print(c  + ") ");
                System.out.println(staff);
            }

            System.out.println("Which one do you want to hire? "); // bunun sonucu string olsa in.nextline
            // in.next dengesini nasıl kurcaz???

            int option = in.nextInt() ;

            int i  = option -1 ;
            Staff staff = staffListCreatedFor5.get(i) ;

            staffListCreatedFor5.remove(staff ) ;
            user.addToUsersStaffList(staff);
            
    }
        

    public static void assignStaff(User user ) {
        ArrayList<Staff> notWorking = user.getNotWorkingStaffListWithoutReceivers() ;


        for (int n = 0 ; n < notWorking.size() ; n++ ) {
            Staff staff = notWorking.get(n) ;
            int c = n+1 ;
            System.out.print(c + ") ");
            System.out.println(staff);
            
            
        }



        


        System.out.println("Which one do you want to assign? ");
        int option = in.nextInt() ;
        Staff staff = notWorking.get(option-1 ) ;

        if (staff.getSkill().equals("driver")) {  // BURAYI DZELT BİRDEN FAZLA DRİVER OLABİLİR
            listOwnedVehicles(user);
            System.out.print("Choose a vehicle to assign this driver to the vehicle: ");
            int n = in.nextInt() ;
            ArrayList<Vehicle> listOfVehicles = user.getUsersVehicleList() ;
            for (int a = 0 ; a < listOfVehicles.size() ; a++  ) {
                Vehicle vehicle = listOfVehicles.get(a) ;
                int k = a+1 ;
                System.out.print(k + ")  ");
                System.out.println(vehicle);
            }
            Vehicle vehicle = listOfVehicles.get(n-1) ;
            if (vehicle.getStaffCapacity() >= 1) {
            staff.assingStaffToVehicle(user.getUsersVehicleList().get(n-1)) ;
            user.getWorkingStaffList().add(staff) ;
            Vehicle vehicles = user.getUsersVehicleList().get(n-1) ;
            if (!user.getWorkingVehicleList().contains(vehicles))
            user.getWorkingVehicleList().add(vehicle) ;            
            }
            else {
            System.out.println("Cannot choose that.");
            }

        }


        else if (staff.getSkill().equals("carrier")) {
            listOwnedVehicles(user);
            System.out.println("Choose a vehicle with an open capacity for carrier ");
            int n = in.nextInt() ;
            if (user.getUsersVehicleList().get(n-1).getStaffCapacity() >= 1 ) {
                staff.assingStaffToVehicle(user.getUsersVehicleList().get(n-1)) ;
                user.getWorkingStaffList().add(staff) ;
                Vehicle vehicle = user.getUsersVehicleList().get(n-1) ;
                if (!user.getWorkingVehicleList().contains(vehicle))
                user.getWorkingVehicleList().add(vehicle) ;
            }
            else {
                System.out.println("You cannot assign this carrier to this vehicle ");
            }

        }






        //EN AZ BİR YERİ MÜSAİAT OLAN ARABALRI SOR AMA MANTIKEN İKİ TANE DRİVER AYNI ARABAYA GİREMEZ 
        // SONRA O ARABALARI LİSTELE ADAM İSTEDİĞİNİ SEÇSİN SONRAONA ASSİGNLA 
        // AMA ASSİGNLADIKTAN SONRA O METHOD STAFFI USERIN WOKRİNGİNE EKLEYEMİYO
        // ONU AYRICA BURDA EKLE 
        /*
         * BU İSWORKİNGİ YORUMA KOYDUM ŞUAN ÇALIŞMIYOR AMA BU İSWORKİNG VE WORKİNGLİST ARRAYLİSTİ 
         * TRACİNGİ ÖNEMLİ BİR YERDE ONA EKLEMEYİ UNUTURSAN KOD YANLIŞ İLERLEYEBİLİR ONA GÖRE YAZ KODU 
         * YORUMLARI UNUTMA 
         */
    }

    public static void distributeStaff(User user ) {
        ArrayList<Staff> notWorkingWithoutReceivers = user.getNotWorkingStaffListWithoutReceivers() ;
        ArrayList<Staff> drivers = new ArrayList<>() ;
        ArrayList<Staff> carriers = new ArrayList<>() ;


        for (int n = 0 ; n < notWorkingWithoutReceivers.size() ; n++ ) {
            Staff staff = notWorkingWithoutReceivers.get(n) ;
            if (staff.getSkill().equals("driver")) {
                drivers.add(staff) ;
            }
            else if (staff.getSkill().equals("carrier")) {
                carriers.add(staff) ;
            }
        }
        ArrayList<Vehicle> vehicleList = user.getUsersVehicleList() ;
        int c = 0 ;
        int b = 0 ;
        while (c < drivers.size() )  {
            Staff staff = drivers.get(c) ;
            boolean d = true ;

            for (int a = 0 ; a < vehicleList.size() && d ; a++ ) {
                Vehicle vehicle = vehicleList.get(a) ;
                if (!vehicle.doesThisVehicleHaveDriver() && vehicle.getStaffCapacity() >= 1) {
                    staff.assingStaffToVehicle(vehicle) ;
                    user.getWorkingStaffList().add(staff) ;
                    d = false ;
                    b = c;
                }

                


            }

            c++  ;

        }

        if (b < drivers.size() - 1) {
            while (b < drivers.size()) {
                Staff staff = drivers.get(b) ;
                boolean d = true ;
                for (int a = 0 ; a < vehicleList.size() && d ; a++ ) {
                    Vehicle vehicle = vehicleList.get(a) ;
                    if (vehicle.getStaffCapacity() >= 1) {
                        staff.assingStaffToVehicle(vehicle) ;
                        user.getWorkingStaffList().add(staff) ;
                        d = false ;
                    }

                    


                }
                b++;
            }
        }




        for (int n = 0 ; n < carriers.size() ; n++ )  {
            Staff staff = carriers.get(n) ;
            boolean d = true ;

            for (int a = 0 ; a < vehicleList.size() && d ; a++ ) {
                Vehicle vehicle = vehicleList.get(a) ;
                if (vehicle.getStaffCapacity() >= 1) {
                    staff.assingStaffToVehicle(vehicle) ;
                    user.getWorkingStaffList().add(staff) ;
                    d  = false ;
                }


            }
        }









    }

    public static void fireStaff(User user) {
        ArrayList<Staff> working = user.getUsersStaffList() ;


        for (int n = 0 ; n < working.size() ; n++) {
            Staff staff = working.get(n) ;
            int c = n+1 ;
            System.out.print(c + ") ");
            System.out.println(staff);
            System.out.println("The vehicle that staff assigned to: " + staff.getAssignedVehicle());
        }

        System.out.print("Which one do you choose to fire? ");

        int option = in.nextInt() ;

        Staff staff = working.get(option-1) ;

        staff.getAssignedVehicle().getAssignedStaffList().remove(staff) ;
        staff.getAssignedVehicle().setStaffCapacity(staff.getAssignedVehicle().getStaffCapacity()-1);
        user.getUsersStaffList().remove(staff ) ;
        user.getWorkingStaffList().remove(staff ) ;
        System.out.println(staff + "   fired ");


    } 


    public static void endTurn(User user) {
        bool = true ;
        int totalPackage = 0 ;  

        ArrayList<Staff> receivers = new ArrayList<>() ;

            for (int n = 0 ; n< user.getUsersStaffList().size() ; n++) {
                Staff staff = user.getUsersStaffList().get(n) ;
                if (staff.getSkill().equals("receiver")) {
                    receivers.add(staff) ;
                    Receiver x = (Receiver) staff ;
                    int a = x.getReceivingCapacity() ;
                    totalPackage += a ;
                }
            }
        
        ArrayList<Vehicle> vehicles = user.getUsersVehicleList() ;
        for (int b = 0 ; b < vehicles.size() ; b++  ) {
            Vehicle vehicle = vehicles.get(b ) ;

            if (vehicle.getDriversOfTheVehicle().size() >= 1) {
        
                int effectiveSpeed = 0 ;
    
                // eğer araÇTAN FAZLA DRİVER VARSA SONRA TEKRAR DRİVERLARI ARACA DAĞITMASI LAZIM UNUTMA
    
            
                if (vehicle.doesThisVehicleHaveDriver() ) {
                    
                    Driver driver = (Driver) vehicle.getTheRealDriverOfTheVehicle() ;
    
                    effectiveSpeed = Math.min(driver.getDrivingSpeedLimit(), vehicle.getSpeed()) ;
                }
    
    
    
            
    
            int effectiveDeliveryCapacity = 0 ; // ENHANCED FOR LOOPDA İNT DEĞİŞMEZ


            for (int n = 0 ; n < vehicle.getDriversOfTheVehicle().size() ; n++ ) {
                

                Driver driver = (Driver) vehicle.getDriversOfTheVehicle().get(n) ;
                    effectiveDeliveryCapacity += driver.getDeliveryCapacity() ;
            }
    

            for (int n = 0 ; n < vehicle.getCarriersOfTheVehicle().size() ; n++ ) {
                

                Carrier carrier = (Carrier) vehicle.getCarriersOfTheVehicle().get(n) ;
                    effectiveDeliveryCapacity += carrier.getDeliveryCapacity() ;


            }


    
            if (effectiveDeliveryCapacity > 0 ) {
                effectiveDeliveryCapacity = Math.min(vehicle.getCargoCapacity(), effectiveDeliveryCapacity) ;
            }

            int currentDeliveryCount = Math.min(totalPackage, effectiveDeliveryCapacity) ;

            totalPackage -= currentDeliveryCount ;


            int effectivePriceBoost = 0 ;


            for (int n = 0 ; n < vehicle.getCarriersOfTheVehicle().size() ; n++ ) {
                Staff staff = vehicle.getCarriersOfTheVehicle().get(n) ;
                Carrier carrier = (Carrier) staff ;
                effectivePriceBoost += carrier.getPriceBoost() ;

            }

            if (effectivePriceBoost == 0 ) {
                effectivePriceBoost = 1 ;
            }

            int profit = effectivePriceBoost * effectiveDeliveryCapacity * (effectiveSpeed / 10 ) ;
            int k = user.getMoney() + profit ;
            vehicle.setProfit(vehicle.getProfit() + profit);

            user.setMoney(k) ;










        }

        }
        int salaryOfAll = 0 ;
        for (int n = 0 ; n < user.getUsersStaffList().size() ; n++ ) {
            Staff staff = user.getUsersStaffList().get(n) ;
            salaryOfAll += staff.getSalary() ;
        }

        user.setMoney(user.getMoney()-salaryOfAll);


        Random ran = new Random() ;

        int length = user.getUsersStaffList().size() ;

        int random = ran.nextInt(length) ;

        Staff staff = user.getUsersStaffList().get(random) ;

        staff.setSalary(staff.getSalary()+5);



        





    } 


}