import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JustifiedText {


    public static void main(String args[]) throws Exception {
        String line = "";
        StringBuilder paragraph = new StringBuilder();

        System.out.println("Enter the text: ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        do
        {
            line = bufferedReader.readLine();
            paragraph.append(line).append("\n");
        } while(!line.equals("EOF"));
        isr.close();
        bufferedReader.close();
        String inputString = paragraph.substring(0, paragraph.length()-4);
        System.out.println(inputString);
    }
}
