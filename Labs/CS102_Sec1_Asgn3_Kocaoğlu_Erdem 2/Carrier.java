import java.util.Random;

public class Carrier extends Staff {
    private int priceBoost ;
    private int deliveryCapacity ;
    public Carrier(String name , String surname  ) {
        Random ran = new Random() ;
        priceBoost = ran.nextInt(5) + 10 ;
        deliveryCapacity = ran.nextInt(20) + 5 ;
        skill = "carrier" ;
        this.name = name ;
        this.surname = surname ;
        salary = priceBoost + (deliveryCapacity / 5) ;
        
    }
    public int getPriceBoost() {
        return priceBoost;
    }
    public void setPriceBoost(int priceBoost) {
        this.priceBoost = priceBoost;
    }
    public int getDeliveryCapacity() {
        return deliveryCapacity;
    }
    public void setDeliveryCapacity(int deliveryCapacity) {
        this.deliveryCapacity = deliveryCapacity;
    }
    
}
