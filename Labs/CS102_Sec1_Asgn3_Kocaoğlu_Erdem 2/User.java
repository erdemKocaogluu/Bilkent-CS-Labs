import java.util.ArrayList;

public class User {
    private int money ;
    private ArrayList<Staff> usersStaffList ;
    private ArrayList<Vehicle> usersVehicleList ;
    private ArrayList<Staff> workingStaffList ; // WORKİNG STAFAFFI DÜZENLE ADAMLARI WORKİNG YAP
    private ArrayList<Vehicle> workingVehicleList ;

    public User() {
        usersStaffList = new ArrayList<>() ;
        usersVehicleList = new ArrayList<>() ;
        workingStaffList = new ArrayList<>() ;
        workingVehicleList = new ArrayList<>() ;
        money = 500 ;
    }

    public void buyVehicle(Vehicle vehicle ) {
        if (money >= vehicle.getCost()) {
        money -= vehicle.getCost() ;
        usersVehicleList.add(vehicle) ;
        System.out.println("You bought the vehicle");
        }
        else {
            System.out.println("Money is not enough to buy the vehicle ");
        }


    }

    public void sellVehicle(Vehicle vehicle) {
        usersVehicleList.remove(vehicle) ;
        money += vehicle.getCost() / 2 ; // ŞU DOUBLE MI DEĞİL Mİ BURADA PARA DİFFİ ÇIKABİLİR İNT YA

        ArrayList<Staff> list = vehicle.getAssignedStaffList() ;
        for (int n = 0 ; n < list.size() ; n++ ) {
            Staff staff = list.get(n) ;
            staff.setAssignedVehicleToZero();
            this.getWorkingStaffList().remove(staff) ;
        }

    }



    public void hireStaff(Staff staff ) {
        int toplam = 0 ;
        for (Staff staffs : usersStaffList ) {
            toplam += staffs.getSalary() ;
        }        
        if (toplam + staff.getSalary() <= money) {
        usersStaffList.add(staff) ;
        }
        else {
            System.out.println("Money is not enough to add the staff, you need to fire someone first");
        }
        

    }

    public void fireStaff(Staff staff) {
        staff.getAssignedVehicle().setStaffCapacity(staff.getAssignedVehicle().getStaffCapacity()+1);
        usersStaffList.remove(staff) ;
        if (workingStaffList.contains(staff)) {
            workingStaffList.remove(staff) ;
        }
        Vehicle vehicle = staff.getAssignedVehicle() ;
        vehicle.getAssignedStaffList().remove(staff) ;
                
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Staff> getUsersStaffList() {
        return usersStaffList;
    }

    public void setUsersStaffList(ArrayList<Staff> usersStaffList) {
        this.usersStaffList = usersStaffList;
    }

    public void addToUsersStaffList(Staff staff) {
        usersStaffList.add(staff) ;
    }

    public void removeFromUsersStaffList(Staff staff) {
        usersStaffList.remove(staff) ;
    }

    public void addToUsersWorkingStaffList(Staff staff) {
        workingStaffList.add(staff) ;
    }

    public void removeFromUsersWorkingStaffList(Staff staff) {
        workingStaffList.remove(staff) ;
    }

    public ArrayList<Vehicle> getUsersVehicleList() {
        return usersVehicleList;
    }

    public void setUsersVehicleList(ArrayList<Vehicle> usersVehicleList) {
        this.usersVehicleList = usersVehicleList;
    }

    public ArrayList<Staff> getWorkingStaffList() {
        return workingStaffList;
    }

    public void setWorkingStaffList(ArrayList<Staff> workingStaffList) {
        this.workingStaffList = workingStaffList;
    }

    public ArrayList<Vehicle> getWorkingVehicleList() {
        return workingVehicleList;
    }

    public void setWorkingVehicleList(ArrayList<Vehicle> workingVehicleList) {
        this.workingVehicleList = workingVehicleList;
    }

    public ArrayList<Staff> getNotWorkingStaffListWithoutReceivers() {
        ArrayList<Staff> listOfAllStaff = this.getUsersStaffList() ;
        ArrayList<Staff> notWorking = new ArrayList<>() ;

        for (int n = 0 ; n < listOfAllStaff.size() ; n++ ) {
            Staff staff = listOfAllStaff.get(n) ;
            if (!this.getWorkingStaffList().contains(staff) && !staff.getSkill().equals("receiver")) {
                notWorking.add(staff) ;
                }
        }
        return notWorking ;
    }

    
    

}
