package InputOutputDemo;

import java.io.*;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        FileWriter writer = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);


    }
}















