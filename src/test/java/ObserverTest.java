import Birds.Goose;
import Ducks.*;
import Observer.QuackListenerFile;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
public class ObserverTest {
    private QuackListenerFile qlc;
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
        qlc=new QuackListenerFile(filename);
    }

    @AfterEach
    public void close(){
        qlc.closeFile();
    }
    @Test
    @Order(1)
    public void testMarbledQuackConsole(){
        MarbledDuck marbledDuck=new MarbledDuck("Donald");
        marbledDuck.addSubscriber(qlc);
        marbledDuck.quack();
    }

    @Test
    @Order(2)
    public void testWoodenQuackConsole(){
        WoodenDuck woodenDuck=new WoodenDuck("Donald");
        woodenDuck.addSubscriber(qlc);
        woodenDuck.quack();
    }

    @Test
    @Order(3)
    public void testRubberQuackConsole(){
        RubberDuck rubberDuck=new RubberDuck("Donald");
        rubberDuck.addSubscriber(qlc);
        rubberDuck.quack();
    }

    @Test
    @Order(4)
    public void testAlabioQuackConsole(){
        AlabioDuck alabioDuck=new AlabioDuck("Donald");
        alabioDuck.addSubscriber(qlc);
        alabioDuck.quack();
    }

    @Test
    @Order(5)
    public void testMallardQuackConsole(){
        MallardDuck mallardDuck=new MallardDuck("Donald");
        mallardDuck.addSubscriber(qlc);
        mallardDuck.quack();
    }

    @Test
    @Order(6)
    public void testGooseQuackConsole(){
        Goose goose=new Goose("Goose McLaughin");
        DuckAdapter duckAdapter=new DuckAdapter(goose);
        duckAdapter.addSubscriber(qlc);
        duckAdapter.quack();
    }

    @Test
    @Order(7)
    public void testMultiplePublishers(){
        Goose goose=new Goose("Goose McLaughin");
        MallardDuck mallardDuck=new MallardDuck("Donald");
        RubberDuck rubberDuck=new RubberDuck("Ronald");
        DuckAdapter duckAdapter=new DuckAdapter(goose);
        duckAdapter.addSubscriber(qlc);
        mallardDuck.addSubscriber(qlc);
        rubberDuck.addSubscriber(qlc);
        duckAdapter.quack();
        mallardDuck.quack();
        rubberDuck.quack();

    }

    @Test
    @Order(8)
    public void testFlock(){
        Flock flock=new Flock();
        IQuackable mallard=new MallardDuck("Vivi");
        IQuackable marbled=new MarbledDuck("Sanji");
        IQuackable alabian=new AlabioDuck("Donald");
        IQuackable rubber=new RubberDuck("Ronald");
        IQuackable wooden=new WoodenDuck("Duckling");
        flock.add(mallard);
        flock.add(marbled);
        flock.add(alabian);
        flock.add(rubber);
        flock.add(wooden);
        flock.addSubscriber(qlc);
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
                String actual=expectedLog.nextLine();
                assertEquals(actual,expected);
            }
            log.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
