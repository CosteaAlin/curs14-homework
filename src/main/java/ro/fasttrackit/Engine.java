package ro.fasttrackit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Engine {


    public static List<Quote> readData(String path){
        List<Quote> result=new ArrayList<>();
        try (BufferedReader reader  = new BufferedReader(new FileReader(path))){
            String line;
            int id=0;
            while((line = reader.readLine()) != null){
                result.add(getAuthorAndgrade(id++,line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static Quote getAuthorAndgrade(int id,String line) {
        String []tokens=line.split("~");
        Random rnd = new Random();
        boolean favourite = rnd.nextBoolean();
        return new Quote(id, tokens[0],tokens[1],favourite);
    }
}
