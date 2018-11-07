public class SubArray {

    public static void main(String a[]) {
        int arr[] = new int[]{1,2,4,5,7,8,2,6,4,7,2,5,4,6,8,2,8,2,6,4};

        int subArary[] = new int[]{8,2,6,4};

        int i = 0;
        int matchingIndex= 0;
        while(i <= arr.length-subArary.length) {
            int temp = i;
            boolean same = true;
            for( int j =0; j < subArary.length; j++) {
                if( subArary[j] != arr[temp]) {
                    same = false;
                }
                temp++;
            }
            if(same) {
                matchingIndex = i;
            }
            i++;
        }

        System.out.println("final index:"+matchingIndex);
    }


}
