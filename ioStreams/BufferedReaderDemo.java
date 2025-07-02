package ioStreams;

import java.io.*;
import java.util.StringTokenizer;

/**
 * The type Buffered reader demo.
 */
public class BufferedReaderDemo {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("D:/PersonalProjects/ioStreams.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        int count = 0;
        String line;
        try{
            while((line = br.readLine()) !=null){
                StringTokenizer st = new StringTokenizer(line," ");
                while(st.hasMoreTokens()){
                    System.out.println(st.nextToken());
                    count++;
                }
            }
            System.out.println("Number of words = "+count);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
