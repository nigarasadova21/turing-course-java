package algorithms;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderr {
    public static void main(String[] args) throws IOException,InterruptedException {
        File file = new  File("file.text");
//        Path file= Path.get("file.txt");
//        Files.readAllLines(file);
//        List<String> strings= Files.readAllLines(file);
//        strings.forEach(System.out::println);

            FileWriter writer = new FileWriter("file.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            
            bufferedWriter.write("\nHello World");
            writer.close();

        System.out.println("Done");

            FileReader reader = new FileReader("file.txt");
            BufferedReader bufferedReader=new BufferedReader(reader,5);
            char[] buf=new char[50];
            int read=bufferedReader.read(buf);
        System.out.println("Read "+read);
        for(int i=0;i<read;i++){
            System.out.println(buf[i]);
        };
            String c;
            while((c=bufferedReader.readLine()) !=null){
                System.out.print(c);
                Thread.sleep(500);

            }

        reader.close();
    }

}
