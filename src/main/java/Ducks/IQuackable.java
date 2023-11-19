package Ducks;

import Observer.IQuackListener;

public interface IQuackable {
    String quack();
    String getName();
    void addSubscriber(IQuackListener quackListener);
}
