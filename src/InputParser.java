import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class InputParser {
    private Scanner scanner;
    private File input;
    private String[] inputArray;
    private String[] parameters;


    public InputParser(File input) throws FileNotFoundException {
        this.input = input;
        scanner = new Scanner(input);
        storeInput();
    }

    private void storeInput(){
        //first line specifies rows, columns, vehicles, rides, bonus, steps
        String line = scanner.nextLine();
        String[] commands = line.split(" ");
        parameters = commands;
        ArrayList<String> resultRides = new ArrayList<>();


        while(scanner.hasNext()) {
            line = scanner.nextLine();
            String[] rides = line.split(" ");
            Collections.addAll(resultRides, rides);
        }

        String[] resultArray = new String[resultRides.size()];
        resultArray = resultRides.toArray(resultArray);
        inputArray = resultArray;

    }

    public int getRows(){
        return Integer.parseInt(parameters[0]) ;
    }

    public int getColumns() {
        return Integer.parseInt(parameters[1]);
    }

    public int getNumVehicles(){
        return Integer.parseInt(parameters[2]);
    }

    public int getNumRides(){
        return Integer.parseInt(parameters[3]);
    }

    public int getBonus(){
        return Integer.parseInt(parameters[4]);
    }

    public int getSteps(){
        return Integer.parseInt(parameters[5]);
    }

    public String[] getInput(){
        return inputArray;
    }

    public void printParameters(){
        for(int i = 0; i < parameters.length; i++){
            System.out.print(parameters[i] + " ");
        }
    }

    public void printRides(){
        System.out.println();

        for(int i = 0; i < inputArray.length; i++){
            System.out.print(inputArray[i] + " ");
    }
    }

}
