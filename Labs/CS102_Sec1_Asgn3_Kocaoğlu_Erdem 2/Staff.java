public class Staff {
    protected String name ;
    protected String surname ;
    protected int salary ;
    protected String skill ;
    protected Vehicle assignedVehicle ;
    // protected boolean isWorking ;

    public Staff(){
        assignedVehicle = new Vehicle() ;
    }


    public void assingStaffToVehicle(Vehicle vehicle ) { // assignlıyosan staffı userın workingine eklemen lazım
        assignedVehicle = vehicle ;
        if (vehicle.getStaffCapacity() >= 1){
        vehicle.setStaffCapacity(vehicle.getStaffCapacity()-1) ;
        vehicle.addToAssignedStaffList(this);
        
        }
        else {
            System.out.println("cannot assign staff since vehicle capacity is full");
        }
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }


    public int getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }


    public String getSkill() {
        return skill;
    }


    public void setSkill(String skill) {
        this.skill = skill;
    }


    public Vehicle getAssignedVehicle() {
        return assignedVehicle;
    }


    public void setAssignedVehicle(Vehicle newAssignedVehicle) {
        
        if (newAssignedVehicle.getStaffCapacity() >= 1) {
        assignedVehicle.setStaffCapacity(assignedVehicle.getStaffCapacity()+1);
        assignedVehicle.removeFromAssignedStaffList(this);
        this.assignedVehicle = newAssignedVehicle;
        assignedVehicle.setStaffCapacity(assignedVehicle.getStaffCapacity()-1) ;
        assignedVehicle.addToAssignedStaffList(this); 
        }
        else {
            System.out.println("cannot set assigned vehicle since the vehicle capacity is full");
        }
        
    }

    public String toString() {
        return name + " " + surname + " " + skill + " salary " + salary ;
    }

    public void setAssignedVehicleToZero(){
        this.assignedVehicle = new Vehicle() ;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false ;
        if (obj.getClass() != getClass()) return false ;

        Staff x = (Staff) obj ;
        if (x.getName().equals(getName()) && x.getSalary()== getSalary() && x.getSkill().equals(getSkill())) return true ;
        return false ;
    }

    // public boolean isWorking() {
    //     return isWorking;
    // }


    // public void setWorking(boolean isWorking) {
    //     this.isWorking = isWorking;
    // }




}


/*
 * Staff x = new Driver() ;
 * 
 * Driver x = new Driver() ;
 * 
 * 
 * 
 * Driver x = new Staff() ;
 * 
 */