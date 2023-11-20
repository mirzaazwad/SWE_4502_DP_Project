package Observer;

import java.util.List;

public abstract class QuackSubject {
    protected List<IQuackObserver> listeners;

    public void subscribe(IQuackObserver quackListener){
        listeners.add(quackListener);
    }

    public void unsubscribe(IQuackObserver quackListener){
        listeners.remove(quackListener);
    }

    public void notify(String event){
        for(IQuackObserver listener:listeners){
            listener.update(event);
        }
    }
}
