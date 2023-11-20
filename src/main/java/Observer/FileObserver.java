package Observer;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileObserver implements IQuackObserver {
    private FileWriter quackWriter;
    public FileObserver(String filename){
        try {
            quackWriter = new FileWriter(filename,true);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void update(String event){
        try{
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            quackWriter.append(dtf.format(date)+": "+event+"\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void closeFile(){
        try{
            quackWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
