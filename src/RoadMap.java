public class RoadMap {

    private int[][] map;
    private int rows;
    private int columns;
    private InputParser inputParser;


    private static int counter;
    private static int points;


    public RoadMap(InputParser inputParser){
       this.inputParser = inputParser;
       rows = inputParser.getRows();
       columns = inputParser.getColumns();
       map = new int[rows][columns];

       counter = 0;
    }


    public void populate(){
        int i = 0;

            for(int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    map[r][c] = 0;
                    i++;
                }
            }

        map[0][0] = inputParser.getNumRides();

        }


    public void printMap(){
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                System.out.printf("%5d ", map[i][j]);
            }
            System.out.println();
        }
    }


    //evaluate current position
    //evaluate horizontal position, if less, move right, if more, move left
    //evaluate vertical position, move down/move up
    //return the number of steps
    public void move(int startr, int startc, int destr, int destc){
        int counter = 0;
        boolean finished = false;

        //increment destination
        //decrement start
        int curr = map[destr][destc];
        map[destr][destc] = curr+1;

        curr = map[startr][startc];
        map[startr][startc] = curr-1;

    }

    private int evaluateDistance(int startr, int startc, int destr, int destc){
        int counter = 0;

        if(startr > destr){
            counter += (startr - destr);
        }

        if(destr > startr){
            counter += (destr - startr);
        }

        if(destc > startc){
            counter += (destc - startc);
        }

        if(startc > destc){
            counter += (startc - destc);
        }

        return counter;

    }

    public int pickCar(int destr, int destc) {

        int distance = 100000;
        int smallestr = 0;
        int smallestc = 0;


        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (map[r][c] != 0) { //if the intersection is currently occupied by a car

                    int newDistance = evaluateDistance(r,c,destr,destc);

                    if (newDistance < distance){
                        distance = newDistance;
                    }

                    smallestc = c;
                    smallestr = r;


                }
            }
        }

        move(smallestr,smallestc,destr,destc);
        incrementSteps(evaluateDistance(smallestr,smallestc,destr,destc));

        return distance;
    }

    public void incrementSteps(int steps){
        counter += steps;
    }

    public int getSteps(){
        return counter;
    }

    public void ride(String[] rides){
        for(int i = 0; i < rides.length; i=i+6){
            if(counter > Integer.parseInt(rides[i+4])){
            pickCar(Integer.parseInt(rides[i]), Integer.parseInt(rides[i+1]));
            pickCar(Integer.parseInt(rides[i+2]), Integer.parseInt(rides[i+3]));
            }
        }

    }
}
