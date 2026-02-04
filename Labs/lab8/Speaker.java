public class Speaker {
    
    private String id ;
    private String name ;
    private String expertise ;

    public Speaker (String id, String name,String expertise ) {
        this.id = id ;
        this.name = name ;
        this.expertise = expertise ;
    }
    public Speaker (String id, String name) {
        this.id = id ;
        this.name = name ;
    }

    public String getId() {
        return id ;
    }

    public String getName() {
        return name ;
    }
    public String getExpertise() {
        return expertise ;
    }

    public void setName(String newName ) {
        name = newName ;
    }

    public void setExpertise(String newExpertise) {
        expertise = newExpertise ;
    }



}
