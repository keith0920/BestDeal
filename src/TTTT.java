
import java.io.*;
public class TTTT {
    public static void main(String[] args) {
        try {

            BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
            out.write("asfasdf");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
