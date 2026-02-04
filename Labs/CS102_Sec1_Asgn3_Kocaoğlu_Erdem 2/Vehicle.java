import java.util.ArrayList;
import java.util.Random;

public class Vehicle {
    protected int cargoCapacity ;
    protected int staffCapacity ;
    protected int cost ;
    protected int speed ;
    protected int plateNumber ;
    protected ArrayList<Staff> assignedStaffList ;
    protected int profit ;
    protected String type ;

    public Vehicle () {
        profit = 0 ;
        assignedStaffList = new ArrayList<>() ;
        do {
        Random ran = new Random() ;
        plateNumber = ran.nextInt(100) ;
        } while (App.plateNumbersList.contains(plateNumber)) ;
        App.plateNumbersList.add(plateNumber) ;

    }

    public int getStaffCapacity() {
        return staffCapacity;
    }

    public void setStaffCapacity(int staffCapacity) {
        this.staffCapacity = staffCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public int getCost() {
        return cost;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public ArrayList<Staff> getAssignedStaffList() {
        return assignedStaffList;
    }

    public void addToAssignedStaffList(Staff staff) {
        assignedStaffList.add(staff);
    }

    public void removeFromAssignedStaffList(Staff staff) {
        assignedStaffList.remove(staff);
    }

    public int getProfit() {
        return profit;
    }

    public String getType() {
        return type;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false ;
        if (obj.getClass() != getClass()) return false ;

        Vehicle x = (Vehicle) obj ;
        if (x.getPlateNumber() == plateNumber ) return true ;
        return false ;
    }

    public boolean doesThisVehicleHaveDriver() {
        for (int n = 0 ; n < this.getAssignedStaffList().size() ; n++ ) {
            Staff staff = getAssignedStaffList().get(n) ;

            if (staff.getSkill().equals("driver")) {
                return true ;
            }
        }

        return false ;
    }


    public ArrayList<Staff> getDriversOfTheVehicle() {
        ArrayList<Staff> list = new ArrayList<>() ; 
        for (int n = 0 ; n < assignedStaffList.size() ; n++ ) {
            Staff staff = assignedStaffList.get(n) ;
            if (staff.getSkill().equals("driver")) {
                list.add(staff) ;
            }
        }

        return list ;
    }

    public ArrayList<Staff> getCarriersOfTheVehicle() {
        ArrayList<Staff> list = new ArrayList<>() ; 
        for (int n = 0 ; n < assignedStaffList.size() ; n++ ) {
            Staff staff = assignedStaffList.get(n) ;
            if (staff.getSkill().equals("carrier")) {
                list.add(staff) ;
            }
        }

        return list ;
    }

    public Staff getTheRealDriverOfTheVehicle(){
        ArrayList<Staff> list = getDriversOfTheVehicle();
        int maxSpeed = 0 ;
        Staff s = new Staff() ;
        for (int n = 0 ; n < list.size() ; n++ ) {
            Driver driver = (Driver) list.get(n) ;
            if (driver.getDrivingSpeedLimit() >= maxSpeed) {
                maxSpeed = driver.getDrivingSpeedLimit() ;
                s = driver ;
            }
        }
        return s ;
        
    }

    public String toString() {
        return "staff capacity : " + staffCapacity + " plate number:   " + plateNumber ;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    


}
