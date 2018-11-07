import java.util.ArrayList;
import java.util.List;

public class Amazon2
{
    public static void main(String args[])
    {
        int arr[][] = { {1, 0, 1},
                        {1, 0, 1},
                        {0, 1, 1}};

        int rows =3, columns =3;
        int result = -1;
        outer:
        for (int i = 0 ;  i < rows; i++) {
            for( int j = 0; j < columns ; j++) {
                if( arr[i][j] == 9) {
                    result = i + j;
                    break outer;
                }
            }
        }

        System.out.println(result);
    }


}
