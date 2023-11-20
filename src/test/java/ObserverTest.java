import Birds.Goose;
import Ducks.*;
import Observer.FileObserver;
import Wrappers.QuackSubjectDecorator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
public class ObserverTest {
    private FileObserver quackListenerFile;
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
        quackListenerFile=new FileObserver(filename);
    }

    @AfterEach
    public void close(){
        quackListenerFile.closeFile();
    }
    @Test
    @Order(1)
    public void testMarbledQuackConsole(){
        QuackSubjectDecorator marbledDuck=new QuackSubjectDecorator(new MarbledDuck("Donald"));
        marbledDuck.subscribe(quackListenerFile);
        marbledDuck.quack();
    }

    @Test
    @Order(2)
    public void testWoodenQuackConsole(){
        QuackSubjectDecorator woodenDuck=new QuackSubjectDecorator(new WoodenDuck("Donald"));
        woodenDuck.subscribe(quackListenerFile);
        woodenDuck.quack();
    }

    @Test
    @Order(3)
    public void testRubberQuackConsole(){
        QuackSubjectDecorator rubberDuck=new QuackSubjectDecorator(new RubberDuck("Donald"));
        rubberDuck.subscribe(quackListenerFile);
        rubberDuck.quack();
    }

    @Test
    @Order(4)
    public void testAlabioQuackConsole(){
        QuackSubjectDecorator alabioDuck=new QuackSubjectDecorator(new AlabioDuck("Donald"));
        alabioDuck.subscribe(quackListenerFile);
        alabioDuck.quack();
    }

    @Test
    @Order(5)
    public void testMallardQuackConsole(){
        QuackSubjectDecorator mallardDuck=new QuackSubjectDecorator(new MallardDuck("Donald"));
        mallardDuck.subscribe(quackListenerFile);
        mallardDuck.quack();
    }

    @Test
    @Order(6)
    public void testGooseQuackConsole(){
        Goose goose=new Goose("Goose McLaughin");
        QuackSubjectDecorator duckAdapter=new QuackSubjectDecorator(new DuckAdapter(goose));
        duckAdapter.subscribe(quackListenerFile);
        duckAdapter.quack();
    }

    @Test
    @Order(7)
    public void testMultiplePublishers(){
        Goose goose=new Goose("Goose McLaughin");
        QuackSubjectDecorator mallardDuck=new QuackSubjectDecorator(new MallardDuck("Donald"));
        QuackSubjectDecorator rubberDuck=new QuackSubjectDecorator(new RubberDuck("Ronald"));
        QuackSubjectDecorator duckAdapter=new QuackSubjectDecorator(new DuckAdapter(goose));
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
        QuackSubjectDecorator mallard=new QuackSubjectDecorator(new MallardDuck("Vivi"));
        QuackSubjectDecorator marbled=new QuackSubjectDecorator(new MarbledDuck("Sanji"));
        QuackSubjectDecorator alabian=new QuackSubjectDecorator(new AlabioDuck("Donald"));
        QuackSubjectDecorator rubber=new QuackSubjectDecorator(new RubberDuck("Ronald"));
        QuackSubjectDecorator wooden=new QuackSubjectDecorator(new WoodenDuck("Duckling"));
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
