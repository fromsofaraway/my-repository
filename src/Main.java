import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String directory = new File("./data").getCanonicalPath();
        System.out.println(directory);
    }
}