package Observer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleObserver implements IQuackObserver {
    public void update(String event){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(date)+": "+event);
    }
}
