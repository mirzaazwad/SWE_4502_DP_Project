package Observer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class QuackListenerFile implements IQuackListener{
    private FileWriter quackWriter;
    public QuackListenerFile(String filename){
        try {
            quackWriter = new FileWriter(filename,true);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void update(String event){
        try{
            quackWriter.append(event+"\n");
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
