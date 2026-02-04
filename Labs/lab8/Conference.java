import java.util.ArrayList;

public class Conference {
    private String name ; // CONSTRUCTOR
    private ArrayList<Event> events  ;

    public Conference() {
        events = new ArrayList<>() ;
    }
    
    public Conference(String name ) {
        this.name = name ;
        events = new ArrayList<>() ;
    }

    public void addEvent(Event event) {
        events.add(event) ;
    }

    public ArrayList<Event> getEventsBySpeaker(String speakerId) {
        ArrayList<Event> eventsOfSpeaker = new ArrayList<Event>() ;
        for (Event event : events ) {
            
            for (Speaker speaker : event.getSpeakers()) {
                if (speaker.getId() == speakerId) {
                    eventsOfSpeaker.add(event) ;
                }
            }
        }

        return eventsOfSpeaker ;
    }
}
