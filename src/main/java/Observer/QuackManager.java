package Observer;

import java.util.ArrayList;
import java.util.List;

public class QuackManager {
    private List<IQuackListener> listeners;
    public QuackManager(){
        listeners=new ArrayList<IQuackListener>();
    }

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
