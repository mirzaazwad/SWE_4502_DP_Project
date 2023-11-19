package DuckTracker;

import Ducks.IQuackable;

import java.util.ArrayList;
import java.util.List;

public class DuckLocator {
    private List<ILocator> locator_subscriber;
    public DuckLocator(){
        this.locator_subscriber=new ArrayList<ILocator>();
    }

    public void subscribe(ILocator duck){
        locator_subscriber.add(duck);
    }

    public void unsubscribe(ILocator duck){
        locator_subscriber.remove(duck);
    }

    public String notifyQyack(){
        String locations="";
        for (ILocator dummy_locator:
             locator_subscriber) {
            locations+= dummy_locator.getLocation();
        }
        return locations;
    }


}
