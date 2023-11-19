import Ducks.IQuackable;
import Ducks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class CompositeTest {
    private Flock flock;
    private List<String> duck_names;

    @BeforeEach
    public void init() {
        flock = new Flock();
        this.duck_names = new ArrayList<String>();
        this.duck_names.add("Donald");
        this.duck_names.add("Ronald");
        this.duck_names.add("Vivi");
        this.duck_names.add("Ducky");
        this.duck_names.add("Bad Ducky");
        IQuackable mallard = new MallardDuck(duck_names.get(0));
        IQuackable marbled = new MarbledDuck(duck_names.get(1));
        IQuackable alabian = new AlabioDuck(duck_names.get(2));
        IQuackable rubber = new RubberDuck(duck_names.get(3));
        IQuackable wooden = new WoodenDuck(duck_names.get(4));
        flock.add(mallard);
        flock.add(marbled);
        flock.add(alabian);
        flock.add(rubber);
        flock.add(wooden);
    }

    @Test
    public void TestQuack() {
        assertEquals("Quack\n" +
                "Quack\n" +
                "Quack\n" +
                "Squeak\n\n", flock.quack());
    }

    @Test
    public void TestGetName() {
        String expected = "";
        Integer i = 1;
        for (String dummy_duck : duck_names) {
            expected += i.toString() + ". " + dummy_duck + "\n";
            i += 1;
        }
        assertEquals(expected, flock.getName());
    }

}
