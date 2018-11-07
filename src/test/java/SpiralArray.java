import java.util.ArrayList;
import java.util.List;

public class SpiralArray {


    public static void main(String a[]) {

        List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        Integer[][] array = new Integer[A.size()][];
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> row = A.get(i);
            array[i] = row.toArray(new Integer[row.size()]);
        }


        //int arr[][] = {{1, 2}, {3, 4}, {5, 6}, {7,8}};
      //  int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int arr[][] = {{1, 2 , 3, 4}, {5,6,7,8}, {9,10,11,12}};
           // int arr[][] = {{1, 2 , 3, 4,5,6}, {7,8,9,10,11,12}, {13,14,15,16,17,18}, {19,20,21,22,23,24}};
        //int arr[][] = {{1}, {2}, {3}};

        int arr[][] = {
                {150, 6, 240, 129, 168, 346, 218, 168, 309, 242, 26, 327},
                {98, 275, 315, 389, 270, 2, 172, 100, 151, 41, 217, 176},
                {267, 5, 324, 344, 134, 122, 229, 196, 225, 280, 200, 274},
                {155, 320, 8, 215, 273, 291, 174, 165, 279, 26, 327, 214},
                {207, 91, 121, 46, 125, 247, 303, 387, 214, 249, 97, 316}
        };
        int rows = arr.length, columns = arr[0].length;
        System.out.println("Rows:" + rows);
        System.out.println("Columns:" + columns);
        List<Integer> spiralList = new ArrayList<>();
        int rowIndex = 0, columnIndex = 0, maxRowIndex = rows, maxColIndex = columns;
        int startColumnIndex = 0;
        int startRowIndex = 0;
        while (spiralList.size() < rows * columns) {

                System.out.println("startRowIndex:" + startRowIndex);
                System.out.println("startColumnIndex:" + startColumnIndex);
                System.out.println("maxColIndex:" + maxColIndex);
                System.out.println("maxRowIndex:" + maxRowIndex);

            if (startRowIndex == maxRowIndex - 1 && startColumnIndex == maxColIndex - 1) {
                spiralList.add(arr[startRowIndex][startColumnIndex]);
                break;
            }
            //1st Pass
            for (int j = startColumnIndex; j < maxColIndex; j++) {
                spiralList.add(arr[startRowIndex][j]);
            }

            columnIndex = maxColIndex - 1;
            rowIndex = startRowIndex;
            if (rowIndex != maxRowIndex - 1) {
                //2nd Pass
                if(spiralList.size() >= rows * columns)
                    break;
                for (int i = rowIndex + 1; i < maxRowIndex; i++) {
                    spiralList.add(arr[i][columnIndex]);
                }

                rowIndex = maxRowIndex - 1;
                //3rd Pass
                if(spiralList.size() >= rows * columns)
                    break;
                for (int k = columnIndex - 1; k >= startColumnIndex; k--) {
                    spiralList.add(arr[rowIndex][k]);
                }
                columnIndex = startColumnIndex;
                //4th Pass
                if(spiralList.size() >= rows * columns)
                    break;
                for (int p = maxRowIndex - 2; p > startRowIndex; p--) {
                    spiralList.add(arr[p][columnIndex]);
                }
            }
            startRowIndex++;
            startColumnIndex++;
            maxColIndex--;
            maxRowIndex--;
        }
        System.out.println(spiralList);
    }
}
