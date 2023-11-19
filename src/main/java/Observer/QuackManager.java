package Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class QuackManager {
    protected List<IQuackListener> listeners;

    public void subscribe(IQuackListener quackListener){
        listeners.add(quackListener);
    }

    public void unsubscribe(IQuackListener quackListener){
        listeners.remove(quackListener);
    }

    public void notify(String event){
        for(IQuackListener listener:listeners){
            listener.update(event);
        }
    }
}
