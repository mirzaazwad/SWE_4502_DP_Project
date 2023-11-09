package Factory;

import Abstractions.IQuackable;
import Wrappers.CounterDecorator;

public class CountingDuckFactory extends DuckFactory {
    public CounterDecorator createCountingDuck(String type, String name) throws Exception{
        CounterDecorator counterDecorator=new CounterDecorator(super.createDuck(type,name));
        return counterDecorator;
    }
}
