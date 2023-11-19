package Observer;

public class QuackListenerConsole implements IQuackListener{
    public void update(String event){
        System.out.println(event);
    }
}
