import java.util.Random;

public class Receiver extends Staff {

    private int receivingCapacity ;

    public Receiver (String name , String surname  ) {
        Random ran = new Random() ;
        receivingCapacity = ran.nextInt(10) + 10 ;
        skill = "receiver" ;
        this.name = name ;
        this.surname = surname ;
        salary = receivingCapacity / 2 ;
    }

    public int getReceivingCapacity() {
        return receivingCapacity;
    }

    public void setReceivingCapacity(int receivingCapacity) {
        this.receivingCapacity = receivingCapacity;
    }


    
    
}
