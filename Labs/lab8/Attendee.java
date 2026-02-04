public class Attendee {
    
    private String id ;
    private String name ;
    private String organization ;

    public Attendee(String id, String name,String organization) {
        this.id = id ;
        this.name = name ;
        this.organization = organization ;
    }
    public Attendee(String id, String name) {
        this.id = id ;
        this.name = name ;
    }

    public String getId() {
        return id ;
    }

    public String getName( ) {
        return name ;
    }

    public String getOrganization() {
        return organization;
    }

    public void setName(String newName ) {
        name = newName ;
    }

    public void setOrganization(String newOrganization ) {
        organization = newOrganization;
    }

}
