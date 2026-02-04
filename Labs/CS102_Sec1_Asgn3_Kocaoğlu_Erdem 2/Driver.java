import java.util.Random;

public class Driver extends Staff {

    private int drivingSpeedLimit ;
    private int deliveryCapacity ;
    

    public Driver(String name , String surname ) {
        Random ran = new Random() ;
        drivingSpeedLimit = ran.nextInt(90) + 10 ;
        deliveryCapacity = ran.nextInt(7) + 3 ;
        skill = "driver" ;
        this.name = name ;
        this.surname = surname ;
        salary = drivingSpeedLimit / 10 + (deliveryCapacity / 2) ;

    }


    public int getDrivingSpeedLimit() {
        return drivingSpeedLimit;
    }


    public void setDrivingSpeedLimit(int drivingSpeedLimit) {
        this.drivingSpeedLimit = drivingSpeedLimit;
    }


    public int getDeliveryCapacity() {
        return deliveryCapacity;
    }


    public void setDeliveryCapacity(int deliveryCapacity) {
        this.deliveryCapacity = deliveryCapacity;
    }
    

}
