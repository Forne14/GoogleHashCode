import java.io.File;
import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) throws FileNotFoundException{
        InputParser parser = new InputParser(new File("a_example.in"));
        //parser.printParameters();
        //parser.printRides();
        RoadMap map = new RoadMap(parser);
        map.populate();
        map.printMap();



    }

    //evaluate current position
//evaluate horizontal position, if less, move right, if more, move left
//evaluate vertical position, move down/move up
    public void move(){

    }

    public void populate(){

    }

}
