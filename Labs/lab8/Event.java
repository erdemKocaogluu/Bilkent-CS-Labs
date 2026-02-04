import java.util.ArrayList;

public class Event {
    
    private String id ;
    private String title;
    private String date;
    private ArrayList<Speaker> speakers;
    private ArrayList <Attendee> attendees;

    public Event(String id, String title, String date) {
        speakers = new ArrayList<>() ;
        attendees = new ArrayList<>() ;
        this.id = id ;
        this.title = title ;
        this.date = date ;
    }
    
    public void registerSpeaker(Speaker speaker) {
        speakers.add(speaker) ;
    }

    public void registerAttendee(Attendee attendee) {
        attendees.add(attendee) ;
    }

    public ArrayList<Speaker> getSpeakers() {
        return speakers ;
    }

}
