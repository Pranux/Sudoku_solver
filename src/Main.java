package src;

public class Main
{
    private static boolean isSolved(int[][] board)
    {
        for(int i = 0; i  < 9; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                if(board[i][j]== 0)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        int[][] numbers;
        int[][][] options;

        ReadFile file = new ReadFile();
        FindOptionsForSquares choice = new FindOptionsForSquares();
        AddNumberToBoard add = new AddNumberToBoard();

        numbers = file.gettingNumArray();

        /*while(!isSolved(numbers))
        {
            options = choice.findOptions(numbers);
            numbers = add.addNum(numbers, options);

            if(!add.changed)
            {
                System.out.println("Unsolvable (for now)");
                break;
            }
        }*/

        options = choice.findOptions(numbers);
        for(int i = 0; i < 100; ++i)
        {
            options = choice.findOptions(numbers);
            numbers = add.addNum(numbers, options);

            if(!add.changed)
            {
                System.out.println("Unsolvable (for now)");
                break;
            }
        }


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
                //System.out.print(numbers[i][j] + " ");
            }
            //System.out.println();
        }
    }
}