import Birds.Goose;
import Ducks.*;
import Observer.QuackListenerFile;
import Wrappers.QuackManagerDecorator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
public class ObserverTest {
    private QuackListenerFile quackListenerFile;
    private static String filename;
    @BeforeAll
    public static void file_init(){
        try{
            filename="logs.txt";
            File outputFile = new File(filename);
            if (!outputFile.createNewFile()) {
                outputFile.delete();
                outputFile.createNewFile();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    @BeforeEach
    public void file(){
        quackListenerFile=new QuackListenerFile(filename);
    }

    @AfterEach
    public void close(){
        quackListenerFile.closeFile();
    }
    @Test
    @Order(1)
    public void testMarbledQuackConsole(){
        QuackManagerDecorator marbledDuck=new QuackManagerDecorator(new MarbledDuck("Donald"));
        marbledDuck.subscribe(quackListenerFile);
        marbledDuck.quack();
    }

    @Test
    @Order(2)
    public void testWoodenQuackConsole(){
        QuackManagerDecorator woodenDuck=new QuackManagerDecorator(new WoodenDuck("Donald"));
        woodenDuck.subscribe(quackListenerFile);
        woodenDuck.quack();
    }

    @Test
    @Order(3)
    public void testRubberQuackConsole(){
        QuackManagerDecorator rubberDuck=new QuackManagerDecorator(new RubberDuck("Donald"));
        rubberDuck.subscribe(quackListenerFile);
        rubberDuck.quack();
    }

    @Test
    @Order(4)
    public void testAlabioQuackConsole(){
        QuackManagerDecorator alabioDuck=new QuackManagerDecorator(new AlabioDuck("Donald"));
        alabioDuck.subscribe(quackListenerFile);
        alabioDuck.quack();
    }

    @Test
    @Order(5)
    public void testMallardQuackConsole(){
        QuackManagerDecorator mallardDuck=new QuackManagerDecorator(new MallardDuck("Donald"));
        mallardDuck.subscribe(quackListenerFile);
        mallardDuck.quack();
    }

    @Test
    @Order(6)
    public void testGooseQuackConsole(){
        Goose goose=new Goose("Goose McLaughin");
        QuackManagerDecorator duckAdapter=new QuackManagerDecorator(new DuckAdapter(goose));
        duckAdapter.subscribe(quackListenerFile);
        duckAdapter.quack();
    }

    @Test
    @Order(7)
    public void testMultiplePublishers(){
        Goose goose=new Goose("Goose McLaughin");
        QuackManagerDecorator mallardDuck=new QuackManagerDecorator(new MallardDuck("Donald"));
        QuackManagerDecorator rubberDuck=new QuackManagerDecorator(new RubberDuck("Ronald"));
        QuackManagerDecorator duckAdapter=new QuackManagerDecorator(new DuckAdapter(goose));
        mallardDuck.subscribe(quackListenerFile);
        duckAdapter.subscribe(quackListenerFile);
        rubberDuck.subscribe(quackListenerFile);
        duckAdapter.quack();
        mallardDuck.quack();
        rubberDuck.quack();

    }

    @Test
    @Order(8)
    public void testFlock(){
        Flock flock=new Flock();
        QuackManagerDecorator mallard=new QuackManagerDecorator(new MallardDuck("Vivi"));
        QuackManagerDecorator marbled=new QuackManagerDecorator(new MarbledDuck("Sanji"));
        QuackManagerDecorator alabian=new QuackManagerDecorator(new AlabioDuck("Donald"));
        QuackManagerDecorator rubber=new QuackManagerDecorator(new RubberDuck("Ronald"));
        QuackManagerDecorator wooden=new QuackManagerDecorator(new WoodenDuck("Duckling"));
        mallard.subscribe(quackListenerFile);
        marbled.subscribe(quackListenerFile);
        alabian.subscribe(quackListenerFile);
        rubber.subscribe(quackListenerFile);
        wooden.subscribe(quackListenerFile);
        flock.add(mallard);
        flock.add(marbled);
        flock.add(alabian);
        flock.add(rubber);
        flock.add(wooden);
        flock.quack();
    }

    @Test
    @Order(9)
    public void testLogs(){
        try {
            File logFile = new File(filename);
            File expectedLogFile=new File("expected_logs.txt");
            Scanner log = new Scanner(logFile);
            Scanner expectedLog=new Scanner(expectedLogFile);
            while (log.hasNextLine() && expectedLog.hasNextLine()) {
                String expected = log.nextLine();
                String expectedCheck=expected.split(": ")[1];
                String actual=expectedLog.nextLine();
                String actualCheck=actual.split(": ")[1];
                assertEquals(expectedCheck,actualCheck);
            }
            log.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
