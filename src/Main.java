package src;

public class Main
{
    public static void main(String[] args)
    {
        int[][] numbers;
        int[][][] options;

        ReadFile file = new ReadFile();
        numbers = file.gettingNumArray();

        FindOptionsForSquares choice = new FindOptionsForSquares();
        options = choice.findOptions(numbers);

        for(int i = 0; i  < 9; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                System.out.println("Coordinates: [" + (i+1) + ", " + (j+1) + "]");
                for (int k = 0; k < 3; ++k)
                {
                    System.out.print(options[i][j][k] + " ");
                }
                System.out.println();
                for (int k = 3; k < 6; ++k)
                {
                    System.out.print(options[i][j][k] + " ");
                }
                System.out.println( );
                for (int k = 6; k < 9; ++k)
                {
                    System.out.print(options[i][j][k] + " ");
                }
                System.out.println();
                System.out.println();
            }
        }
    }
}