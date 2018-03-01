import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    private static int counter = 0;

    public static void main(String[] args) throws FileNotFoundException{
        InputParser parser = new InputParser(new File("a_example.in"));
        //parser.printParameters();
        //parser.printRides();
        RoadMap map = new RoadMap(parser);
        map.populate();
        map.printMap();

        map.move(0,0,1,3);

        System.out.println();
        map.printMap();


    }


}
